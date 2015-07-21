package main;

public class SimuladorDeterministico extends Simulador {

	public SimuladorDeterministico(float lambda, float mi, float p, long tempoSimulacao) {
		super(lambda, mi, p,tempoSimulacao);
	}

	@Override
	public int entradaCliente() {
		return Math.round(lambda * FATOR_TRUNCAMENTO_TEMPO);
	}

}
