package main;

public class SimuladorPoisson extends Simulador {
	public static int ID_POISSON = 0;
	
	public SimuladorPoisson(float lambda, float mi, float p, long tempoSimulacao) {
		super(lambda, mi, p, tempoSimulacao);
		ID_POISSON++;
		setNomeSimulador();
		System.out.println("Criado Simulador " + nomeSimulador+ID_POISSON);	
		simula();
	}

	@Override
	public int entradaCliente() {
		double proximaChegada;
		proximaChegada = -Math.log(1 - (1 - Math.exp(-lambda)) * Math.random()) / lambda;
		return (int) Math.round(proximaChegada * FATOR_TRUNCAMENTO_TEMPO);
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
