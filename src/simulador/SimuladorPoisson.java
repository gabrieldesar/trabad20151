package simulador;

import java.util.Random;

import org.uncommons.maths.random.ExponentialGenerator;

import experimento.Experimento;

public class SimuladorPoisson extends Simulador {
	public static int ID_POISSON = 0;
	public SimuladorPoisson(float lambda, float mi, float p) {
		super(lambda, mi, p);
		ID_POISSON++;
		setNomeSimulador();
		//System.out.println("Criado Simulador " + nomeSimulador+ID_POISSON);	
	}

	@Override
	public int entradaCliente() {
		double proximaChegada;
		//proximaChegada = -Math.log(1 - (1 - Math.exp(-lambda)) * Math.random()) / lambda;
		//proximaChegada = -Math.log(Math.exp(- lambda * rangeLower) - (Math.exp(- lambda * rangeLower) - Math.exp(-lambda*rangeUpper)) * Math.random()) / lambda;
		ExponentialGenerator exp = new ExponentialGenerator(lambda, Experimento.range);
		//System.out.println(exp.nextValue());
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
