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
 	public Long numClientesServidosBicicleta;
	public Long numClientesServidosEsteira;
	public Double proximoAtendimentoBicicleta;
	public Double proximoAtendimentoEsteira;
	public final double PROB_INICIO_ESTEIRA = 1;
	public Double tempoOcupadoEsteira = 0.0;
	public Double tempoOcupadoBicicleta = 0.0;
	public Double tempoLivreEsteira = 0.0;
	public Double tempoLivreBicicleta = 0.0;
	
	
	
	
	public SimuladorAcademia(float lambda, float probBicicleta_Esteira, float probEsteira_Bicicleta, float miEsteira, float miBicicleta){
		this.lambda = lambda;
		this.probBicicleta_Esteira = probBicicleta_Esteira;
		this.probEsteira_Bicicleta = probEsteira_Bicicleta;
		this.miBicicleta = miBicicleta;
		this.miEsteira = miEsteira;	
		clientesNaEsteira = new ArrayList<Cliente>();
		clientesNaBicicleta = new ArrayList<Cliente>();
		clientesServidos = new ArrayList<Cliente>();
		
		numClientesServidosBicicleta = 0l;
		numClientesServidosEsteira = 0l;
		proximoAtendimentoBicicleta=0.0;
		proximoAtendimentoEsteira=0.0;
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
	
	public void servirClientesBicicleta(double i){	
		if (clientesNaBicicleta.size()==0){
			return;
		}
		if (i >= clientesNaBicicleta.get(0).tempoChegada && i>= proximoAtendimentoBicicleta){
			double tempoServico = Servidor.geraTempoDeServico(miBicicleta);
			if (i + tempoServico <= Experimento.TEMPO_SIMULACAO){
				clientesNaBicicleta.get(0).tempoServico= tempoServico;
				clientesNaBicicleta.get(0).tempoSaida= i+tempoServico;
				
				
				//Prob reentrada
				if (Math.random() < probBicicleta_Esteira){
					Cliente c = new Cliente(i+tempoServico);
					c.tempoSistema += clientesNaBicicleta.get(0).tempoSaida - i;
					clientesNaEsteira.add(c);
					clientesNaBicicleta.remove(0);					
					Collections.sort(clientesNaEsteira, new ClienteComparator()); //TODO ORDENAÇÃO ESTÁ CERTA?
				}else{
					Cliente c = new Cliente(i+tempoServico);
					c.tempoSistema += clientesNaBicicleta.get(0).tempoSaida - i;
					clientesServidos.add(c);
					numClientesServidosBicicleta++;
					clientesNaBicicleta.remove(0);
				}

				tempoOcupadoBicicleta += Experimento.INCREMENTO;
				proximoAtendimentoBicicleta = i + tempoServico;
				
				//proximoAtendimento = i + tempoServico; //- 1; 
				//OBS: Estamos perdendo 1 tempo?
				
			}
		}else{
			if (i<= proximoAtendimentoBicicleta){
				tempoLivreBicicleta += (Experimento.INCREMENTO);
			}
				
		}
	}
	
	public void servirClientesEsteira(double i){
		if (clientesNaEsteira.size()==0){
			return;
		}
		if (i >= clientesNaEsteira.get(0).tempoChegada && i>= proximoAtendimentoEsteira){
			
			double tempoServico = Servidor.geraTempoDeServico(miEsteira);
			if (i + tempoServico <= Experimento.TEMPO_SIMULACAO){
				clientesNaEsteira.get(0).tempoServico= tempoServico;
				clientesNaEsteira.get(0).tempoSaida= i+tempoServico;
				
				
				//Prob reentrada
				if (Math.random() < probEsteira_Bicicleta){
					Cliente c = new Cliente(i+tempoServico);
					c.tempoSistema += clientesNaEsteira.get(0).tempoSaida - i;
					clientesNaBicicleta.add(c);
					clientesNaEsteira.remove(0);					
					Collections.sort(clientesNaBicicleta, new ClienteComparator()); //TODO ORDENAÇÃO ESTÁ CERTA?
				}else{
					Cliente c = new Cliente(i+tempoServico);
					c.tempoSistema += clientesNaEsteira.get(0).tempoSaida - i;
					clientesServidos.add(c);
					numClientesServidosEsteira++;
					clientesNaEsteira.remove(0);
				}
				tempoOcupadoEsteira += Experimento.INCREMENTO;
				proximoAtendimentoEsteira = i + tempoServico;

				
				//proximoAtendimento = i + tempoServico; //- 1; 
				//OBS: Estamos perdendo 1 tempo?
				
			}
		}else{
			tempoLivreEsteira += (Experimento.INCREMENTO);
		}
	}
	
	public void simula(){
		gerarClientes();
		
		for (double i=0; i<Experimento.TEMPO_SIMULACAO; i+=Experimento.INCREMENTO){
			servirClientesEsteira(i);
			servirClientesBicicleta(i);
			
		}
			
		calculoMetricas();
		
	};
	
	public void calculoMetricas(){
		
	};
	
	public double tempoMedioSistema(){
		double tempoTotalSistema = 0;
		
		for (int i=0; i<clientesServidos.size(); i++){
			tempoTotalSistema +=tempoSistemaPorCliente(clientesServidos.get(i));
		}
		return tempoTotalSistema/numeroClientesSistema();
	}
	
	

	public double tempoSistemaPorCliente(Cliente c){
		if (c.tempoSaida==0 && c.tempoChegada!=0){
			double retorno = (double)Experimento.TEMPO_SIMULACAO - c.tempoChegada;
			return retorno;
		}else{
			return c.tempoSistema;
		}		
	}
	
	//QUANDO HOUVER REENTRADA, NÃO CONTAR COMO MAIS UM CLIENTE, MAS CONTAR O SEU TEMPO
	//NO SISTEMA, PORQUE ESTA FATIADO ENTRE AS FILAS
	public long numeroClientesSistema(){
		return clientesServidos.size() + clientesNaBicicleta.size()+clientesNaEsteira.size();
	}
}