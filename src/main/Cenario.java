package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Cenario
{
	long tempoSimulacao;
	List<SimuladorPoisson> cenario;
	Map <Float, Double> mapCenario;
	Properties properties;
	
	public Cenario(Properties properties){
		cenario = new ArrayList<SimuladorPoisson>();
		mapCenario = new TreeMap<Float, Double>();
		tempoSimulacao = 1000;
		this.properties = properties;
	}
	
	public void runCenario(){
		int count = 0;
		boolean condicao = false;
		
		do{
			cenario.add(new SimuladorPoisson(properties.taxaEntrada, properties.taxaServico, properties.probReentrada, tempoSimulacao));
			mapCenario.put(properties.taxaEntrada, cenario.get(count).numeroMedioDeClientes);
			count++;
			if (properties.iv == IterateValue.LAMBDA){
				properties.taxaEntrada += 0.05f;
				condicao = properties.taxaEntrada < 0.95;
			}else if (properties.iv == IterateValue.MI){
				properties.taxaServico += 0.5f;
				condicao = properties.taxaServico < 10.5f;
			}
		}while(condicao);
	}
}
