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
	    //dataset.addSeries(series2);
	    //dataset.addSeries(series3);
	    return dataset;
	}
	public XYDataset cenario1CDF(List<Double> temposEntreSaidas){
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("CDF");
		Collections.sort(temposEntreSaidas);
		Map<Double, Double> mapaUnico = new TreeMap<Double, Double>();
		double probabilidade = 1.0/temposEntreSaidas.size();
		while (temposEntreSaidas.size()!=0){
		
			if (mapaUnico.containsKey(temposEntreSaidas.get(0))){
				mapaUnico.put(temposEntreSaidas.get(0), mapaUnico.get(temposEntreSaidas.get(0))+probabilidade);
			}else{
				mapaUnico.put(temposEntreSaidas.get(0), probabilidade);
			}
			temposEntreSaidas.remove(0);
		}
		
		Double value = 0.0;
		for (Double key : mapaUnico.keySet()){
			value += mapaUnico.get(key);
			series1.add(key, value);
		}
		
		dataset.addSeries(series1);
		return dataset;
		
	}
	public XYDataset cenario4SaidasExogenasCDF(List<Double> temposEntreSaidas){
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("CDF");
		Collections.sort(temposEntreSaidas);
		Map<Double, Double> mapaUnico = new TreeMap<Double, Double>();
		double probabilidade = 1.0/temposEntreSaidas.size();
		while (temposEntreSaidas.size()!=0){
		
			if (mapaUnico.containsKey(temposEntreSaidas.get(0))){
				mapaUnico.put(temposEntreSaidas.get(0), mapaUnico.get(temposEntreSaidas.get(0))+probabilidade);
			}else{
				mapaUnico.put(temposEntreSaidas.get(0), probabilidade);
			}
			temposEntreSaidas.remove(0);
		}
		
		Double value = 0.0;
		for (Double key : mapaUnico.keySet()){
			value += mapaUnico.get(key);
			series1.add(key, value);
		}
		
		dataset.addSeries(series1);
		return dataset;
		
	}
	public XYDataset cenario4ChegadasCDF(List<Double> temposEntreChegadas){
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("CDF");
		Collections.sort(temposEntreChegadas);
		Map<Double, Double> mapaUnico = new TreeMap<Double, Double>();
		double probabilidade = 1.0/temposEntreChegadas.size();
		while (temposEntreChegadas.size()!=0){
		
			if (mapaUnico.containsKey(temposEntreChegadas.get(0))){
				mapaUnico.put(temposEntreChegadas.get(0), mapaUnico.get(temposEntreChegadas.get(0))+probabilidade);
			}else{
				mapaUnico.put(temposEntreChegadas.get(0), probabilidade);
			}
			temposEntreChegadas.remove(0);
		}
		
		Double value = 0.0;
		for (Double key : mapaUnico.keySet()){
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