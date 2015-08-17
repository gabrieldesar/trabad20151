package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Experimento {
	List<Properties> propertiesList;
	private final int NUM_CENARIOS = 6;
	List<ConjuntoCenarios> conjCenariosList;
	
	public Experimento(){			
		conjCenariosList = new ArrayList<ConjuntoCenarios>();
		initProperties();
	}

	public void initProperties(){
		propertiesList = new ArrayList<Properties>();
		propertiesList.add(new Properties("Cenario1", 0.05f, 1f, 0f, IterateValue.LAMBDA));
		propertiesList.add(new Properties("Cenario2", 0.05f, 1f, 0f, IterateValue.LAMBDA));
		propertiesList.add(new Properties("Cenario3", 0.1f, 1f, 0f, 5, 15, IterateValue.MI));
		propertiesList.add(new Properties("Cenario4", 0.01f, 1f, 0.9f, IterateValue.MI));
		propertiesList.add(new Properties("Cenario5", 0.01f, 1f, 0.9f, IterateValue.MI));
		propertiesList.add(new Properties("Cenario6", 0.01f, 1f, 0.9f, 50, 150, IterateValue.MI));
		
	}
	
	public void runExperimento(){
		int numSimulacoes = 5;
		for (int i=0; i< numSimulacoes; i++){
			System.out.println("Simulação "+(i+1));
			
			for (int j=0; j<NUM_CENARIOS; j++){
				ConjuntoCenarios conjCenarios = new ConjuntoCenarios();
				Cenario cenario = new Cenario(propertiesList.get(j));
				cenario.runCenario();
				conjCenarios.mapasValoresCenario.add(cenario.mapCenario);
				for (Float key : conjCenarios.mapasValoresCenario.get(i).keySet()){
					System.out.println(i + " --- " + key);
					if (i==0){
						conjCenarios.mediaCenario.put(key, (conjCenarios.mapasValoresCenario.get(i).get(key)/numSimulacoes));
					}else{
						conjCenarios.mediaCenario.put(key, conjCenarios.mediaCenario.get(key)+(conjCenarios.mapasValoresCenario.get(i).get(key)/numSimulacoes));
					}
					
				}
				conjCenariosList.add(conjCenarios);
			}
		}
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

}
