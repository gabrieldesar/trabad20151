package main;

public class SimuladorUniforme extends Simulador {
	public static int ID_UNIFORME = 0;
	float min;
	float max;
	
	public SimuladorUniforme(float lambda, float mi, float p, float min, float max,long tempoSimulacao) {
		super(lambda, mi, p,tempoSimulacao);
		ID_UNIFORME++;
		setNomeSimulador();
		//System.out.println("Criado Simulador " + nomeSimulador+ID_UNIFORME);	
		this.min = min;
		this.max = max;
		simula();
	
	}

	@Override
	public int entradaCliente() {
		int proximaChegada;
		proximaChegada = (int) Math.round(Math.random()*(max-min) + min);
		
		return proximaChegada;	
	}

	@Override
	public void setNomeSimulador() {
		this.nomeSimulador = "Uniforme";
		
	}

	@Override
	public int getIdSimulador() {
		return ID_UNIFORME;
	}


}
