package simulador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import experimento.Experimento;

public abstract class Simulador {
	public final int FATOR_TRUNCAMENTO_TEMPO = 10;
	public static int rangeLower = 1;
	public static int rangeUpper = 300;
	//public static int ID_SIMULADOR = 0;
	public float lambda;
	public float mi;
	public float p;
	public String nomeSimulador;
	public List<Long> instantesOciosos = new ArrayList<Long>();
	public double numeroMedioDeClientes;
	public Servidor servidor;
	public Cliente proximaChegada = null;
	public List<Cliente> clientesNoSistema = new ArrayList<Cliente>();
	
	public Simulador(float lambda, float mi, float p){
		//ID_SIMULADOR++;
		this.lambda = lambda;
		this.mi = mi;
		this.p = p;		
	}
	
	//Gerar um cliente novo que entra no sistema
	public abstract int entradaCliente();
	
	
	public void gerarClientes(){
		for (long i=0; i<= Experimento.TEMPO_SIMULACAO; i++){
			int tempoProximaChegada = entradaCliente();
			if (i + tempoProximaChegada < Experimento.TEMPO_SIMULACAO){
				clientesNoSistema.add(new Cliente(i+tempoProximaChegada));
				i = i + tempoProximaChegada; //- 1;
				//OBS: Estamos perdendo 1 tempo?
			}	
		}		
	}
	
	public void servirClientes() {
		int numClientesServidos = 0;
		for (long i=0; i<= Experimento.TEMPO_SIMULACAO; i++){
			if (numClientesServidos == clientesNoSistema.size()){
				while (i<= Experimento.TEMPO_SIMULACAO){
					instantesOciosos.add(i);
					i++;
				}
				return;
			}
			if (i >= clientesNoSistema.get(numClientesServidos).tempoChegada){
				
				long tempoServico = Servidor.geraTempoDeServico(mi,rangeLower, rangeUpper);
				if (i + tempoServico <= Experimento.TEMPO_SIMULACAO){
					clientesNoSistema.get(numClientesServidos).tempoServico= tempoServico;
					clientesNoSistema.get(numClientesServidos).tempoSaida= i+tempoServico;
					
					
					//Prob reentrada
					if (Math.random() < p){
						clientesNoSistema.get(numClientesServidos).reentrou= true;
						clientesNoSistema.add(new Cliente(i+tempoServico));
						Collections.sort(clientesNoSistema, new ClienteComparator());
					}
					numClientesServidos++;
					
					i = i + tempoServico; //- 1; 
					//OBS: Estamos perdendo 1 tempo?
					
				}
			}else{
				instantesOciosos.add(i);
			}
		}
	}
	
	//Loop do processamento da rede de filas
	public void simula(){
		//System.out.println(nomeSimulador+Simulador.ID_SIMULADOR + " gerar clientes");
		gerarClientes();
		//System.out.println(nomeSimulador+Simulador.ID_SIMULADOR + " servir clientes");
		servirClientes();	
		//System.out.println(nomeSimulador+Simulador.ID_SIMULADOR + " vai imprimir clientes");
		calculoMetricas();
		//log();
		
	}
	
	public abstract void setNomeSimulador();
	public abstract int getIdSimulador();
	
	public void calculoMetricas(){
		int numeroClientes = clientesNoSistema.size();
		long tempoTotalNoSistema=0;
		for (int i=0; i<numeroClientes; i++){
			tempoTotalNoSistema+= Math.max(clientesNoSistema.get(i).tempoSaida, Experimento.TEMPO_SIMULACAO) - clientesNoSistema.get(i).tempoChegada;
		}
		long tempoMedioNoSistema;
		if (numeroClientes==0){
			tempoMedioNoSistema = 0;
		}else{
			tempoMedioNoSistema = tempoTotalNoSistema/numeroClientes;
		}
		
		numeroMedioDeClientes = lambda * tempoMedioNoSistema; 
	}
	//Saída da simulação 
	public void log(){
		SimulationLogger sl = new SimulationLogger(nomeSimulador+getIdSimulador());
		sl.printSimulationMetrics(nomeSimulador+getIdSimulador(), lambda, mi, p, numeroMedioDeClientes,clientesNoSistema.size(), instantesOciosos, Experimento.TEMPO_SIMULACAO);
	}
	
	
}
