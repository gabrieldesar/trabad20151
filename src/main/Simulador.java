package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Simulador {
	public final int FATOR_TRUNCAMENTO_TEMPO = 10;
	
	float lambda;
	float mi;
	float p;
	
	long tempoSimulacao;
	
	
	Servidor servidor;
	Cliente proximaChegada = null;
	List<Cliente> clientesNoSitema = new ArrayList<Cliente>();
	
	public Simulador(float lambda, float mi, float p, long tempoSimulacao){
		this.lambda = lambda;
		this.mi = mi;
		this.p = p;		
		this.tempoSimulacao = tempoSimulacao;
	}
	
	//Gerar um cliente novo que entra no sistema
	public abstract int entradaCliente();
	
	//Loop do processamento da rede de filas
	public void simula(){
		long clientesNoSistema = 0;
		//Cliente
		
		for(long i = 1; i <= tempoSimulacao; i++) {
			if(proximaChegada == null) {
				proximaChegada = new Cliente(this.entradaCliente(),Servidor.geraTempoDeServico(mi));
			} else {
				if(proximaChegada.tempoChegada == i) {
					clientesNoSitema.add(proximaChegada);
					Collections.sort(clientesNoSitema, new ClienteComparator());
					proximaChegada = null;
				}
			}
		}
		
		
	}
	
	//Saída da simulação 
	public void log(){
		//TO-DO
	}
	
}
