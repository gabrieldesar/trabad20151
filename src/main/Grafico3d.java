package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grafico3d extends JFrame {
	public static final int MULTI_X_AXIX = 100;
	
	public Grafico3d() {
		
	}

	public void printCenario() {
		String chartTitle = "";
		JFreeChart lineChart = ChartFactory.createXYLineChart(chartTitle, "", "",
				createDataset(), PlotOrientation.VERTICAL, true, true, false);

		
		ChartPanel chartPanel = new ChartPanel(lineChart);
		JPanel painel = new JPanel();
		painel.add(chartPanel);
		chartPanel.setPreferredSize(new java.awt.Dimension(1024, 600));
		this.add(painel);
		
		this.setTitle("Grafico");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(painel, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(1024, 650));
		this.pack();
		this.setVisible(true);
	}

		
	private XYDataset createDataset() {
	    XYSeriesCollection dataset = new XYSeriesCollection();
	    XYSeries series1 = new XYSeries("Média Amostral");
	    XYSeries series2 = new XYSeries("Min");
	    XYSeries series3 = new XYSeries("Max");
	 
		int numSimulacoes = 5;
		Map <Float, Double> mediaCenario = new TreeMap<Float, Double>();
		MapasSimulacao mapas = new MapasSimulacao();
		for (int i=0; i< numSimulacoes; i++){
			System.out.println("Simulação "+(i+1));
			MainClass main = new MainClass();
			mapas.add(main.mapCenario4);
			for (Float key : mapas.get(i).keySet()){
				if (i==0){
					mediaCenario.put(key, (mapas.get(i).get(key)/numSimulacoes));
				}else{
					mediaCenario.put(key, mediaCenario.get(key)+(mapas.get(i).get(key)/numSimulacoes));
				}
			}
		}
		
		for (Float key : mediaCenario.keySet()){
			Double value = mediaCenario.get(key);
			series1.add(key, value);
			Double min = getMin(mapas.valuesAsList(key));
			Double max = getMax(mapas.valuesAsList(key));
			series2.add(key, min);
			series3.add(key, max);
		}
	 
	    dataset.addSeries(series1);
	    dataset.addSeries(series2);
	    dataset.addSeries(series3);
	    return dataset;
	}

	public double getMediaAmostral(List<Double> valores){
		double mediaAmostral=0;
		for (int i=0; i<valores.size(); i++){
			mediaAmostral += valores.get(i)/valores.size();
		}
		return mediaAmostral;
	}
	
	public double getDesvioPadrao(List<Double> valores){
		int numSimulacoes = valores.size();
		double mediaAmostral = getMediaAmostral(valores);
		
		double somatorioValores=0;
		for (int i=0; i<valores.size(); i++){
			somatorioValores+= Math.pow(valores.get(i) - mediaAmostral, 2);
		}
		
		double desvioPadrao = Math.sqrt(somatorioValores/(numSimulacoes-1));
		
		return desvioPadrao;
	}

	public double getMin(List<Double> valores){
		double mediaAmostral = getMediaAmostral(valores);
		double min = mediaAmostral - (1.96 * getDesvioPadrao(valores)) / Math.sqrt(valores.size());
		return min;
	}
	public double getMax(List<Double> valores){
		double mediaAmostral = getMediaAmostral(valores);
		double max = mediaAmostral + (1.96 * getDesvioPadrao(valores)) / Math.sqrt(valores.size());
		return max;
	}

	public static void main(String[] args) {
		new Grafico3d().printCenario();;
		
	}
	//PLOTAR GRAFICO NUM CLIENTES ESPERADO POR TEMPO(MEDIA OLHANDO PARA TRAS) E INSTANTANEO
}
