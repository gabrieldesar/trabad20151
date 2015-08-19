package experimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import simulador.SimulatorType;

public class Experimento {
	private int numCenarios;
	public static final int NUM_SIMULACOES = 200;
	public static final long TEMPO_SIMULACAO = 2000;
	public static final Random range = new Random();
	List<Cenario> cenarios;
	
	
	public Experimento(){			
		cenarios = new ArrayList<Cenario>();
		//cenarios.add(new Cenario(new Properties("Cenario1", 0.05f, 1f, 0f, IterateValue.LAMBDA, SimulatorType.POISSON)));
		//cenarios.add(new Cenario(new Properties("Cenario2", 0.05f, 1f, 0f, IterateValue.LAMBDA, SimulatorType.DETERMINISTICO)));
		//cenarios.add(new Cenario(new Properties("Cenario3", 0.1f, 1f, 0f, 5, 15, IterateValue.MI, SimulatorType.UNIFORME)));
		//cenarios.add(new Cenario(new Properties("Cenario4", 0.01f, 1f, 0.9f, IterateValue.MI, SimulatorType.POISSON)));
		//cenarios.add(new Cenario(new Properties("Cenario5", 0.01f, 1f, 0.9f, IterateValue.MI, SimulatorType.DETERMINISTICO)));
		cenarios.add(new Cenario(new Properties("Cenario6", 0.01f, 1f, 0.9f, 50, 150, IterateValue.MI, SimulatorType.UNIFORME)));
		numCenarios = cenarios.size();
	}


	
	public void runExperimento(){
		for (int i=0; i<numCenarios; i++){
			cenarios.get(i).executarCenario(NUM_SIMULACOES);
		}	
	}
	
	public double getDesvioPadrao(List<Rodada> rodadas, double mediaAmostral, float key){
		double somatorioValores=0;
		for (int i=0; i<rodadas.size(); i++){
			somatorioValores+= Math.pow(rodadas.get(i).numMedioClientesPorLambda.get(key) - mediaAmostral, 2);
		}		
		double desvioPadrao = Math.sqrt(somatorioValores/(Experimento.NUM_SIMULACOES-1));
		
		return desvioPadrao;
	}

	public double getMin(List<Rodada> rodadas, double mediaAmostral, float key){
		double min = mediaAmostral - (1.96 * getDesvioPadrao(rodadas, mediaAmostral, key)) / Math.sqrt(Experimento.NUM_SIMULACOES);
		return min;
	}
	public double getMax(List<Rodada> rodadas, double mediaAmostral, float key){
		double max = mediaAmostral + (1.96 * getDesvioPadrao(rodadas, mediaAmostral, key)) / Math.sqrt(Experimento.NUM_SIMULACOES);
		return max;
	}
	
	

}