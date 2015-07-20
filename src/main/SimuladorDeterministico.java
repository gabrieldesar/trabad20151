package main;

public class SimuladorDeterministico extends Simulador {

	public SimuladorDeterministico(float lambda, float mi, float p) {
		super(lambda, mi, p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int entradaCliente() {
		return Math.round(lambda * FATOR_TRUNCAMENTO_TEMPO);
	}


}
