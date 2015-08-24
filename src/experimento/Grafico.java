package experimento;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Collections;
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

public class Grafico extends JFrame {
	public static final int MULTI_X_AXIX = 100;
	Experimento exp;
	public Grafico(Experimento exp) {
		this.exp = exp;
	}

	public void print(XYDataset dataset) {
		String chartTitle = "";
		JFreeChart lineChart = ChartFactory.createXYLineChart(chartTitle, "", "",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		
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

		
	public XYDataset cenario1NumClientesPorLambda() {
	    XYSeriesCollection dataset = new XYSeriesCollection();
	    XYSeries series1 = new XYSeries("Média Amostral");
	    XYSeries series2 = new XYSeries("Min");
	    XYSeries series3 = new XYSeries("Max");
	 
		
		
		for (Float key : exp.cenarios.get(0).mediaNumClientesPorLambda.keySet()){
			Double value = exp.cenarios.get(0).mediaNumClientesPorLambda.get(key);
			series1.add(key, value);
			Double min = exp.getMin(exp.cenarios.get(0).rodadas, exp.cenarios.get(0).mediaNumClientesPorLambda.get(key), key);
			Double max = exp.getMax(exp.cenarios.get(0).rodadas, exp.cenarios.get(0).mediaNumClientesPorLambda.get(key), key);
			series2.add(key, min);
			series3.add(key, max);
		}
	 
	    dataset.addSeries(series1);
	    dataset.addSeries(series2);
	    dataset.addSeries(series3);
	    return dataset;
	}
	public XYDataset cenario1CDF(List<Long> temposEntreChegadas){
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("CDF");
		Collections.sort(temposEntreChegadas);
		Map<Long, Long> mapaUnico = new TreeMap<Long, Long>();
		while (temposEntreChegadas.size()!=0){
			if (mapaUnico.containsKey(temposEntreChegadas.get(0))){
				mapaUnico.put(temposEntreChegadas.get(0), mapaUnico.get(temposEntreChegadas.get(0))+1);
			}else{
				mapaUnico.put(temposEntreChegadas.get(0), (long) 1);
			}
			temposEntreChegadas.remove(0);
		}
		
		Long value=(long) 0;
		for (Long key : mapaUnico.keySet()){
			value += mapaUnico.get(key);
			series1.add(key, value);
		}
		
		dataset.addSeries(series1);
		return dataset;
		
	}
	
	public XYDataset cenario2NumClientesPorLambda() {
	    XYSeriesCollection dataset = new XYSeriesCollection();
	    XYSeries series1 = new XYSeries("Média Amostral");
	 
		
		
		for (Float key : exp.cenarios.get(0).mediaNumClientesPorLambda.keySet()){
			Double value = exp.cenarios.get(0).mediaNumClientesPorLambda.get(key);
			series1.add(key, value);
		}
	 
	    dataset.addSeries(series1);
	    return dataset;
	}
	public XYDataset cenario3NumClientesPorMi() {
	    XYSeriesCollection dataset = new XYSeriesCollection();
	    XYSeries series1 = new XYSeries("Média Amostral");
	 
		for (Float key : exp.cenarios.get(0).mediaNumClientesPorMi.keySet()){
			Double value = exp.cenarios.get(0).mediaNumClientesPorMi.get(key);
			series1.add(key, value);
		}
	 
	    dataset.addSeries(series1);
	    return dataset;
	}
	
	public XYDataset cenario4NumClientesPorMi() {
	    XYSeriesCollection dataset = new XYSeriesCollection();
	    XYSeries series1 = new XYSeries("Média Amostral");
	 
		for (Float key : exp.cenarios.get(0).mediaNumClientesPorMi.keySet()){
			Double value = exp.cenarios.get(0).mediaNumClientesPorMi.get(key);
			series1.add(key, value);
		}
	 
	    dataset.addSeries(series1);
	    return dataset;
	}
	
	public XYDataset cenario5NumClientesPorMi() {
	    XYSeriesCollection dataset = new XYSeriesCollection();
	    XYSeries series1 = new XYSeries("Média Amostral");
	 
		for (Float key : exp.cenarios.get(0).mediaNumClientesPorMi.keySet()){
			Double value = exp.cenarios.get(0).mediaNumClientesPorMi.get(key);
			series1.add(key, value);
		}
	 
	    dataset.addSeries(series1);
	    return dataset;
	}
	
	public XYDataset cenario6NumClientesPorMi() {
	    XYSeriesCollection dataset = new XYSeriesCollection();
	    XYSeries series1 = new XYSeries("Média Amostral");
	 
		for (Float key : exp.cenarios.get(0).mediaNumClientesPorMi.keySet()){
			Double value = exp.cenarios.get(0).mediaNumClientesPorMi.get(key);
			series1.add(key, value);
		}
	 
	    dataset.addSeries(series1);
	    return dataset;
	}
	
	public XYDataset academiaTempoMedioSistemaPorCenario() {
	    XYSeriesCollection dataset = new XYSeriesCollection();
	    XYSeries series1 = new XYSeries("Média Amostral");
	 
	    series1.add(1, exp.academiaSims.get(0).tempoMedioSistema());
	    series1.add(2, exp.academiaSims.get(1).tempoMedioSistema());
	    series1.add(3, exp.academiaSims.get(2).tempoMedioSistema());	 
	    dataset.addSeries(series1);
	    return dataset;
	}



	//PLOTAR GRAFICO NUM CLIENTES ESPERADO POR TEMPO(MEDIA OLHANDO PARA TRAS) E INSTANTANEO
}