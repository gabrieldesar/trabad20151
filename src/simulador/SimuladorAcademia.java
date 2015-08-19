package simulador;

import java.util.ArrayList;
import java.util.List;

import org.uncommons.maths.random.ExponentialGenerator;

import experimento.Experimento;

public class SimuladorAcademia {
	public float lambda;
	public float probBicicleta_Esteira;
	public float probEsteira_Bicicleta;
	public float miEsteira;
	public float miBicicleta;
	public List<Cliente> clientesNoSistema;
	public List<Long> tempoMedioSistema;
	
	
	
	public SimuladorAcademia(float lambda, float probBicicleta_Esteira, float probEsteira_Bicicleta, float miEsteira, float miBicicleta){
		this.lambda = lambda;
		this.probBicicleta_Esteira = probBicicleta_Esteira;
		this.probEsteira_Bicicleta = probEsteira_Bicicleta;
		this.miBicicleta = miBicicleta;
		this.miEsteira = miEsteira;	
		clientesNoSistema = new ArrayList<Cliente>();
		tempoMedioSistema = new ArrayList<Long>();
	}
	
	public int entradaCliente(){
		double proximaChegada;
		ExponentialGenerator exp = new ExponentialGenerator(lambda, Experimento.range);
		proximaChegada = exp.nextValue();
		return (int) Math.round(proximaChegada);
	};
	
	public void gerarClientes(){
		for (long i=0; i<= Experimento.TEMPO_SIMULACAO; i++){
			int tempoProximaChegada = entradaCliente();
			if (i + tempoProximaChegada < Experimento.TEMPO_SIMULACAO){
				clientesNoSistema.add(new Cliente(i+tempoProximaChegada)); //TODO ANOTAR AONDE O CLIENTE ESTA (ACADEMIA)
				i = i + tempoProximaChegada; //- 1;
				//OBS: Estamos perdendo 1 tempo?
			}	
		}
	};
	
	public void servirClientes() {
		//TODO
		
	};
	
	public void simula(){
		gerarClientes();
		servirClientes();	
		calculoMetricas();
		
	};
	
	public void calculoMetricas(){
		//TODO
		
	};
	
	

}
