package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico extends JFrame{
	
	public Grafico(){
		this.setTitle("Grafico");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JPanel(), BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(500, 500));
		this.pack();
		this.setVisible(true);
	}
	public void printCenario(DefaultCategoryDataset dataset){
		String chartTitle = "";
	      JFreeChart lineChart = ChartFactory.createLineChart(
	         chartTitle,
	         "","",
	         dataset,
	         PlotOrientation.VERTICAL,
	         true,true,false);
	         
	      ChartPanel chartPanel = new ChartPanel( lineChart );
	      JPanel painel = new JPanel();
	      painel.add(chartPanel);
	      chartPanel.setPreferredSize( new java.awt.Dimension( 100 ,100 ) );
	      this.add(painel);
	}
	
	public static void main(String[] args) {
		//TODO LER DE ARQUIVOS
		new Grafico();
	}
}
