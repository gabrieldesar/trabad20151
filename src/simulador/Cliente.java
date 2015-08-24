package simulador;

public class Cliente {

	double tempoChegada;
	double tempoServico;
	double tempoSaida;
	double tempoSistema;
	boolean reentrou = false;
	
	public Cliente (double tempoChegada) {
		this.tempoChegada = tempoChegada;
		this.tempoSistema = 0;
	}
}
