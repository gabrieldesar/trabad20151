package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico extends JFrame {

	public Grafico() {
		
	}

	public void printCenario() {
		String chartTitle = "";
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "", "",
				createDataset(), PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		JPanel painel = new JPanel();
		painel.add(chartPanel);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));
		this.add(painel);
		
		this.setTitle("Grafico");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(painel, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(500, 500));
		this.pack();
		this.setVisible(true);
	}

		
	public DefaultCategoryDataset createDataset(){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		MainClass main = new MainClass();
		
		Map <Float, Double> mapCenario = main.mapCenario;
		for (Float key : mapCenario.keySet()){
			Double value = mapCenario.get(key);
			dataset.addValue(value, "número medio de clientes no sistema", key+"");
		}
		return dataset;
	}
	
	public static void main(String[] args) {
		// TODO LER DE ARQUIVOS
		new Grafico().printCenario();;
		
	}
}
