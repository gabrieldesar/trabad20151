package simulador;

public class Cliente {

	long tempoChegada;
	long tempoServico;
	long tempoSaida;
	boolean reentrou = false;
	
	public Cliente (long tempoChegada) {
		this.tempoChegada = tempoChegada;
	}
}
