package main;

public class SimuladorUniforme extends Simulador {
	float min;
	float max;
	
	public SimuladorUniforme(float lambda, float mi, float p, float min, float max,long tempoSimulacao) {
		super(lambda, mi, p,tempoSimulacao);
		
		this.min = min;
		this.max = max;
	
	}

	@Override
	public int entradaCliente() {
		int proximaChegada;
		proximaChegada = (int) Math.round(Math.random()*(max-min) + min);
		
		return proximaChegada;	
	}


}
