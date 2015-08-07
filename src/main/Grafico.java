package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico extends JFrame {
	public static final int MULTI_X_AXIX = 100;
	
	public Grafico() {
		
	}

	public void printCenario() {
		String chartTitle = "";
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "", "",
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

		
	public DefaultCategoryDataset createDataset(){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<Double> valores = new ArrayList<Double>();
		int numSimulacoes = 100;
		Map <Integer, Double> mediaCenario = new TreeMap<Integer, Double>();
		for (int i=0; i< numSimulacoes; i++){
			System.out.println("Simulação "+(i+1));
			MainClass main = new MainClass();
			Map <Float, Double> mapCenario = main.mapCenario;
			for (Float key : mapCenario.keySet()){
				valores.add(mapCenario.get(key));
				if (i==0){
					mediaCenario.put(Math.round(key*MULTI_X_AXIX), (mapCenario.get(key)/numSimulacoes));
				}else{
					mediaCenario.put(Math.round(key*MULTI_X_AXIX), mediaCenario.get(Math.round(key*MULTI_X_AXIX))+(mapCenario.get(key)/numSimulacoes));
				}
				
			}
		}
		dentroIntervaloConfianca(valores);
		//MainClass main = new MainClass();
		
		//Map <Float, Double> mapCenario = main.mapCenario;
		
		
		
		for (Integer key : mediaCenario.keySet()){
			Double value = mediaCenario.get(key);
			dataset.addValue(value, "número medio de clientes no sistema", key+"");
		}
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
	
	public boolean dentroIntervaloConfianca(List<Double> valores){
		double mediaAmostral = getMediaAmostral(valores);
		double min = (mediaAmostral - 1.96 * getDesvioPadrao(valores)) / Math.sqrt(valores.size());
		double max = (mediaAmostral + 1.96 * getDesvioPadrao(valores)) / Math.sqrt(valores.size());
		System.out.println("Intervalo de confiança: "+ min + " - "+ max);
		System.out.println("Média amostral: "+mediaAmostral);
		if (mediaAmostral > max || mediaAmostral < min){
			return false;
		}
		return true;
		
	}
	public static void main(String[] args) {
		// TODO LER DE ARQUIVOS
		new Grafico().printCenario();;
		
	}
}
