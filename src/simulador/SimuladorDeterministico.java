package simulador;

public class SimuladorDeterministico extends Simulador {
	public static int ID_DETERMINISTICO = 0;

	public SimuladorDeterministico(float lambda, float mi, float p) {
		super(lambda, mi, p);
		ID_DETERMINISTICO++;
		setNomeSimulador();
		//System.out.println("Criado Simulador " + nomeSimulador+ID_DETERMINISTICO);		
	}

	@Override
	public int entradaCliente() {
		return Math.round(lambda * FATOR_TRUNCAMENTO_TEMPO);
	}
	
	public void setNomeSimulador(){
		this.nomeSimulador = "Deterministico";
	}

	@Override
	public int getIdSimulador() {
		return ID_DETERMINISTICO;
		
	}

}
