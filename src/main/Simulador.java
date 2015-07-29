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
	List<Long> instantesOciosos = new ArrayList<Long>();
	
	
	Servidor servidor;
	Cliente proximaChegada = null;
	List<Cliente> clientesNoSistema = new ArrayList<Cliente>();
	
	public Simulador(float lambda, float mi, float p, long tempoSimulacao){
		this.lambda = lambda;
		this.mi = mi;
		this.p = p;		
		this.tempoSimulacao = tempoSimulacao;
	}
	
	//Gerar um cliente novo que entra no sistema
	public abstract int entradaCliente();
	
	
	public void gerarClientes(long tempoSimulacao){
		for (long i=0; i<= tempoSimulacao; i++){
			int tempoProximaChegada = entradaCliente();
			if (i + tempoProximaChegada < tempoSimulacao){
				clientesNoSistema.add(new Cliente(i+tempoProximaChegada));
				i = i + tempoProximaChegada;
				//OBS: Estamos perdendo 1 tempo?
			}	
		}		
	}
	
	public void servirClientes(long tempoSimulacao){
		for (long i=0; i<= tempoSimulacao; i++){
			int numClientesServidos =0;
			
			if (i >= clientesNoSistema.get(numClientesServidos).tempoChegada){
				
				long tempoServico = Servidor.geraTempoDeServico(mi);
				if (i + tempoServico <= tempoSimulacao){
					clientesNoSistema.get(numClientesServidos).tempoServico= tempoServico;
					clientesNoSistema.get(numClientesServidos).tempoSaida= i+tempoServico;
					numClientesServidos++;
					
					//Prob reentrada
					if (Math.random() < p){
						clientesNoSistema.get(numClientesServidos).reentrou= true;
						clientesNoSistema.add(new Cliente(i+tempoServico));
						Collections.sort(clientesNoSistema, new ClienteComparator());
					}
					
					i = i + tempoServico; 
					//OBS: Estamos perdendo 1 tempo?
					
				}
			}else{
				instantesOciosos.add(i);
			}
		}
	}
	
	//Loop do processamento da rede de filas
	public void simula(){
		gerarClientes(tempoSimulacao);
		servirClientes(tempoSimulacao);	
		log();
		
	}
	
	//Saída da simulação 
	public void log(){
		int numeroClientes = clientesNoSistema.size();
		long tempoTotalNoSistema=0;
		for (int i=0; i<numeroClientes; i++){
			tempoTotalNoSistema+= clientesNoSistema.get(i).tempoSaida - clientesNoSistema.get(i).tempoChegada;
		}
		
		long tempoMedioNoSistema = tempoTotalNoSistema/numeroClientes;
		float numeroMedioDeClientes = lambda * tempoMedioNoSistema;  
		//TODO Imprimir Lambda, Mi, Simulador(Tipo), p, numeroMedioDeClientes 
		
		
	}
	
	
}
