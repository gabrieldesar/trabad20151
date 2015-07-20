package main;

public class SimuladorPoisson extends Simulador {
	
	
	public SimuladorPoisson(float lambda, float mi, float p) {
		super(lambda, mi, p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int entradaCliente() {
		double proximaChegada;
		proximaChegada = -Math.log(1 - (1 - Math.exp(-lambda)) * Math.random()) / lambda;
		return (int) Math.round(proximaChegada * FATOR_TRUNCAMENTO_TEMPO);
	}


}
