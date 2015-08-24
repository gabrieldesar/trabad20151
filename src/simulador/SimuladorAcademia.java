package simulador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.uncommons.maths.random.ExponentialGenerator;

import experimento.Experimento;

public class SimuladorAcademia {
	public float lambda;
	public float probBicicleta_Esteira;
	public float probEsteira_Bicicleta;
	public float miEsteira;
	public float miBicicleta;
	public List<Cliente> clientesNaEsteira;
	public List<Cliente> clientesNaBicicleta;
	public List<Cliente> clientesServidos;
 	public int numClientesServidosBicicleta;
	public int numClientesServidosEsteira;
	public double proximoAtendimentoBicicleta;
	public double proximoAtendimentoEsteira;
	public final double PROB_INICIO_ESTEIRA = 1;
	
	
	public SimuladorAcademia(float lambda, float probBicicleta_Esteira, float probEsteira_Bicicleta, float miEsteira, float miBicicleta){
		this.lambda = lambda;
		this.probBicicleta_Esteira = probBicicleta_Esteira;
		this.probEsteira_Bicicleta = probEsteira_Bicicleta;
		this.miBicicleta = miBicicleta;
		this.miEsteira = miEsteira;	
		clientesNaEsteira = new ArrayList<Cliente>();
		clientesNaBicicleta = new ArrayList<Cliente>();
		clientesServidos = new ArrayList<Cliente>();
		
		numClientesServidosBicicleta = 0;
		numClientesServidosEsteira = 0;
		proximoAtendimentoBicicleta=0;
		proximoAtendimentoEsteira=0;
	}
	
	public double entradaCliente(){
		double proximaChegada;
		ExponentialGenerator exp = new ExponentialGenerator(lambda, Experimento.range);
		proximaChegada = exp.nextValue();
		return proximaChegada;
	};
	
	public void gerarClientes(){
		for (double i=0; i<= Experimento.TEMPO_SIMULACAO; i+=Experimento.INCREMENTO){
			double tempoProximaChegada = entradaCliente();
			if (i + tempoProximaChegada < Experimento.TEMPO_SIMULACAO){
				if (Math.random()<=PROB_INICIO_ESTEIRA){
					clientesNaEsteira.add(new Cliente(i+tempoProximaChegada));
				}else{
					clientesNaBicicleta.add(new Cliente(i+tempoProximaChegada));
				}
				i = i + tempoProximaChegada; //- 1;
				//OBS: Estamos perdendo 1 tempo?
			}	
		}
		if (clientesNaBicicleta.size()!=0){
			proximoAtendimentoBicicleta = clientesNaBicicleta.get(0).tempoChegada;
		}
		if (clientesNaEsteira.size()!=0){
			proximoAtendimentoEsteira = clientesNaEsteira.get(0).tempoChegada;
		}
		
	};
	
	public void servirClientes(double i, double proximoAtendimento, List<Cliente> filaServidor, List<Cliente> filaOutroServidor, float mi, float probTrocarAparelho, long numServidos){
		if (filaServidor.size()==0){
			return;
		}
		if (i<proximoAtendimento){
			return;
		}
		if (i >= filaServidor.get(0).tempoChegada){

			double tempoServico = Servidor.geraTempoDeServico(mi);
			if (i + tempoServico <= Experimento.TEMPO_SIMULACAO){
				filaServidor.get(0).tempoServico= tempoServico;
				filaServidor.get(0).tempoSaida= i+tempoServico;
				
				
				//Prob reentrada
				//TODO RETIRO DA ESTEIRA E PONHO NA BICICLETA? OU CRIO NOVO E MARCO O ANTIGO COMO REENTRADA?
				if (Math.random() < probTrocarAparelho){
					Cliente c = new Cliente(i+tempoServico);
					c.tempoSistema += filaServidor.get(0).tempoSaida - i;
					filaOutroServidor.add(c);
					filaServidor.remove(0);					
					Collections.sort(filaOutroServidor, new ClienteComparator()); //TODO ORDENAÇÃO ESTÁ CERTA?
				}else{
					Cliente c = new Cliente(i+tempoServico);
					c.tempoSistema += filaServidor.get(0).tempoSaida - i;
					clientesServidos.add(c);
					numServidos++;
					filaServidor.remove(0);
				}
				
				proximoAtendimento = i + tempoServico; //- 1; 
				//OBS: Estamos perdendo 1 tempo?
				
			}
		}else{
			//instantesOciosos.add(i);
		}
	}
	
	public void simula(){
		gerarClientes();
		
		for (double i=0; i<Experimento.TEMPO_SIMULACAO; i+=Experimento.INCREMENTO){
			servirClientes(i, proximoAtendimentoEsteira, clientesNaEsteira, clientesNaBicicleta, miEsteira, probEsteira_Bicicleta, numClientesServidosEsteira);
			servirClientes(i, proximoAtendimentoBicicleta, clientesNaBicicleta, clientesNaEsteira, miBicicleta, probBicicleta_Esteira, numClientesServidosBicicleta);
		}
			
		calculoMetricas();
		
	};
	
	public void calculoMetricas(){
		//TODO
		
	};
	
	public double tempoMedioSistema(){
		long tempoTotalSistema = 0;
		
		for (int i=0; i<clientesServidos.size(); i++){
			tempoTotalSistema +=tempoSistemaPorCliente(clientesServidos.get(i));
		}
		return tempoTotalSistema/numeroClientesSistema();
	}
	
	

	public double tempoSistemaPorCliente(Cliente c){
		if (c.tempoSaida==0 && c.tempoChegada!=0){
			return Experimento.TEMPO_SIMULACAO - c.tempoChegada;
		}else{
			return c.tempoSistema;
		}		
	}
	
	//QUANDO HOUVER REENTRADA, NÃO CONTAR COMO MAIS UM CLIENTE, MAS CONTAR O SEU TEMPO
	//NO SISTEMA, PORQUE ESTA FATIADO ENTRE AS FILAS
	public long numeroClientesSistema(){
		return clientesServidos.size();
	}
}