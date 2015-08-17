package main;

import java.util.Random;

import org.uncommons.maths.random.ExponentialGenerator;

public class SimuladorPoisson extends Simulador {
	public static int ID_POISSON = 0;
	private static final Random range = new Random();
	public SimuladorPoisson(float lambda, float mi, float p, long tempoSimulacao) {
		super(lambda, mi, p, tempoSimulacao);
		ID_POISSON++;
		setNomeSimulador();
		//System.out.println("Criado Simulador " + nomeSimulador+ID_POISSON);	
		simula();
	}

	@Override
	public int entradaCliente() {
		double proximaChegada;
		//proximaChegada = -Math.log(1 - (1 - Math.exp(-lambda)) * Math.random()) / lambda;
		//proximaChegada = -Math.log(Math.exp(- lambda * rangeLower) - (Math.exp(- lambda * rangeLower) - Math.exp(-lambda*rangeUpper)) * Math.random()) / lambda;
		ExponentialGenerator exp = new ExponentialGenerator(1/lambda, range);

		proximaChegada = exp.nextValue();
		
		
		//System.out.println("proxima chegada antes de arredondar -> "+proximaChegada);
		return (int) Math.round(proximaChegada);
	}

	@Override
	public void setNomeSimulador() {
		this.nomeSimulador = "Poisson";
		
	}

	@Override
	public int getIdSimulador() {
		return ID_POISSON;
	}


}
