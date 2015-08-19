package experimento;

import simulador.SimulatorType;

public class Properties
{
	String name;
	float taxaEntrada;
	float taxaServico;
	float probReentrada;
	int intervaloMin;
	int intervaloMax;
	IterateValue iterateValue;
	SimulatorType simulatorType;
	
	
	public Properties(String name, float taxaEntrada, float taxaServico, float probReentrada, IterateValue iv, SimulatorType st){
		this.name = name;
		this.taxaEntrada = taxaEntrada;
		this.taxaServico = taxaServico;
		this.probReentrada = probReentrada;
		this.iterateValue = iv;
		this.simulatorType = st;
	}
	
	public Properties(String name, float taxaEntrada, float taxaServico, float probReentrada, int intervaloMin, int intervaloMax, IterateValue iv, SimulatorType st){
		this.name = name;
		this.taxaEntrada = taxaEntrada;
		this.taxaServico = taxaServico;
		this.probReentrada = probReentrada;
		this.intervaloMin = intervaloMin;
		this.intervaloMax = intervaloMax;
		this.iterateValue = iv;
		this.simulatorType = st;
	}
}