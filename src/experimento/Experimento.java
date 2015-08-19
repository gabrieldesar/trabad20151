package experimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import simulador.SimulatorType;

public class Experimento {
	private int numCenarios;
	public static final int NUM_SIMULACOES = 1;
	public static final long TEMPO_SIMULACAO = 1000;
	public static final Random range = new Random();
	List<Cenario> cenarios;
	
	
	public Experimento(){			
		cenarios = new ArrayList<Cenario>();
		cenarios.add(new Cenario(new Properties("Cenario1", 0.05f, 1f, 0f, IterateValue.LAMBDA, SimulatorType.POISSON)));
		//cenarios.add(new Cenario(new Properties("Cenario2", 0.05f, 1f, 0f, IterateValue.LAMBDA, SimulatorType.DETERMINISTICO)));
		//cenarios.add(new Cenario(new Properties("Cenario3", 0.1f, 1f, 0f, 5, 15, IterateValue.MI, SimulatorType.UNIFORME)));
		//cenarios.add(new Cenario(new Properties("Cenario4", 0.01f, 1f, 0.9f, IterateValue.MI, SimulatorType.POISSON)));
		//cenarios.add(new Cenario(new Properties("Cenario5", 0.01f, 1f, 0.9f, IterateValue.MI, SimulatorType.DETERMINISTICO)));
		//cenarios.add(new Cenario(new Properties("Cenario6", 0.01f, 1f, 0.9f, 50, 150, IterateValue.MI, SimulatorType.UNIFORME)));
		numCenarios = cenarios.size();
	}


	
	public void runExperimento(){
		for (int i=0; i<numCenarios; i++){
			cenarios.get(i).executarCenario(NUM_SIMULACOES);
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