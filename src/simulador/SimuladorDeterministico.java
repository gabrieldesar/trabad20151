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
	public double entradaCliente() {
		double proximoCliente = 1/lambda;
		return proximoCliente;
	}
	
	public void setNomeSimulador(){
		this.nomeSimulador = "Deterministico";
	}

	@Override
	public int getIdSimulador() {
		return ID_DETERMINISTICO;
		
	}

}
