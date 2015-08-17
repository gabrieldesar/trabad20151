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

public class Grafico extends JFrame {
	public static final int MULTI_X_AXIX = 100;
	Experimento exp;
	public Grafico(Experimento exp) {
		this.exp = exp;
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
	 
		
		
		for (Float key : exp.conjCenariosList.get(0).mediaCenario.keySet()){
			Double value = exp.conjCenariosList.get(0).mediaCenario.get(key);
			series1.add(key, value);
			Double min = exp.getMin(exp.conjCenariosList.get(0).mapasValoresCenario.valuesAsList(key));
			Double max = exp.getMax(exp.conjCenariosList.get(0).mapasValoresCenario.valuesAsList(key));
			series2.add(key, min);
			series3.add(key, max);
		}
	 
	    dataset.addSeries(series1);
	    dataset.addSeries(series2);
	    dataset.addSeries(series3);
	    return dataset;
	}



	//PLOTAR GRAFICO NUM CLIENTES ESPERADO POR TEMPO(MEDIA OLHANDO PARA TRAS) E INSTANTANEO
}
