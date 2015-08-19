package experimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import simulador.Simulador;
import simulador.SimuladorDeterministico;
import simulador.SimuladorPoisson;
import simulador.SimuladorUniforme;
import simulador.SimulatorType;

public class Rodada
{
	List<Simulador> simuladores;
	Map <Float, Double> numMedioClientesPorLambda;
	Properties properties;
	
	public Rodada(Properties properties){
		simuladores = new ArrayList<Simulador>();
		numMedioClientesPorLambda = new TreeMap<Float, Double>();
		this.properties = new Properties(properties.name, properties.taxaEntrada, properties.taxaServico, properties.probReentrada, properties.iterateValue, properties.simulatorType);

	}
	public void executarRodada(){
		int count = 0;
		boolean condicao = false;
		do{
			createSimulator();
			simuladores.get(count).simula();
			numMedioClientesPorLambda.put(properties.taxaEntrada, simuladores.get(count).numeroMedioDeClientes);
			count++;
			if (properties.iterateValue == IterateValue.LAMBDA){
				properties.taxaEntrada += 0.05f;
				condicao = properties.taxaEntrada < 0.95;
			}else if (properties.iterateValue == IterateValue.MI){
				properties.taxaServico += 0.5f;
				condicao = properties.taxaServico < 10.5f;
			}
		}while(condicao);
	}
	
	public void createSimulator(){
		if (properties.simulatorType==SimulatorType.POISSON){
			simuladores.add(new SimuladorPoisson(properties.taxaEntrada, properties.taxaServico, properties.probReentrada));
		}else if (properties.simulatorType==SimulatorType.DETERMINISTICO){
			simuladores.add(new SimuladorDeterministico(properties.taxaEntrada, properties.taxaServico, properties.probReentrada));
		}else{
			if (properties.probReentrada==0){
				simuladores.add(new SimuladorUniforme(properties.taxaEntrada, properties.taxaServico, properties.probReentrada, 5, 15));
			}else{
				simuladores.add(new SimuladorUniforme(properties.taxaEntrada, properties.taxaServico, properties.probReentrada, 50, 150));
			}
		}
	}
}