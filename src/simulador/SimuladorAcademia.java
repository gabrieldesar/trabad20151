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
	public int numClientesServidosBicicleta;
	public int numClientesServidosEsteira;
	public long proximoAtendimentoBicicleta;
	public long proximoAtendimentoEsteira;
	
	
	public SimuladorAcademia(float lambda, float probBicicleta_Esteira, float probEsteira_Bicicleta, float miEsteira, float miBicicleta){
		this.lambda = lambda;
		this.probBicicleta_Esteira = probBicicleta_Esteira;
		this.probEsteira_Bicicleta = probEsteira_Bicicleta;
		this.miBicicleta = miBicicleta;
		this.miEsteira = miEsteira;	
		clientesNaEsteira = new ArrayList<Cliente>();
		clientesNaBicicleta = new ArrayList<Cliente>();
		
		numClientesServidosBicicleta = 0;
		numClientesServidosEsteira = 0;
		proximoAtendimentoBicicleta=0;
		proximoAtendimentoEsteira=0;
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
				if (Math.random()<=0.5){
					clientesNaEsteira.add(new Cliente(i+tempoProximaChegada));
				}else{
					clientesNaBicicleta.add(new Cliente(i+tempoProximaChegada));
				}
				i = i + tempoProximaChegada; //- 1;
				//OBS: Estamos perdendo 1 tempo?
			}	
		}
	};
	
	public void servirClientesEsteira(long i) {
		if (numClientesServidosEsteira == clientesNaEsteira.size()){
			//	instantesOciosos.add(i);
			return;
		}
		if (i<proximoAtendimentoEsteira){
			//instantesOciosos.add(i)
			return;
		}
		if (i >= clientesNaEsteira.get(numClientesServidosEsteira).tempoChegada){

			long tempoServico = Servidor.geraTempoDeServico(miEsteira);
			if (i + tempoServico <= Experimento.TEMPO_SIMULACAO){
				clientesNaEsteira.get(numClientesServidosEsteira).tempoServico= tempoServico;
				clientesNaEsteira.get(numClientesServidosEsteira).tempoSaida= i+tempoServico;
				
				
				//Prob reentrada
				//TODO RETIRO DA ESTEIRA E PONHO NA BICICLETA? OU CRIO NOVO E MARCO O ANTIGO COMO REENTRADA?
				if (Math.random() < probEsteira_Bicicleta){
					clientesNaEsteira.get(numClientesServidosEsteira).reentrou= true;
					clientesNaBicicleta.add(new Cliente(i+tempoServico));
					Collections.sort(clientesNaBicicleta, new ClienteComparator()); //TODO ORDENAÇÃO ESTÁ CERTA?
				}else{
					numClientesServidosEsteira++;
				}
				
				proximoAtendimentoEsteira = i + tempoServico; //- 1; 
				//OBS: Estamos perdendo 1 tempo?
				
			}
		}else{
			//instantesOciosos.add(i);
		}
	}
	
	public void servirClientesBicicleta(long i) {
		if (numClientesServidosBicicleta == clientesNaBicicleta.size()){
			//	instantesOciosos.add(i);
			i++;
			return;
		}
		if (i<proximoAtendimentoBicicleta){
			//instantesOciosos.add(i)
			return;
		}
		if (i >= clientesNaBicicleta.get(numClientesServidosBicicleta).tempoChegada){

			long tempoServico = Servidor.geraTempoDeServico(miBicicleta);
			if (i + tempoServico <= Experimento.TEMPO_SIMULACAO){
				clientesNaBicicleta.get(numClientesServidosBicicleta).tempoServico= tempoServico;
				clientesNaBicicleta.get(numClientesServidosBicicleta).tempoSaida= i+tempoServico;
				
				//Prob reentrada
				if (Math.random() < probBicicleta_Esteira){
					clientesNaBicicleta.get(numClientesServidosBicicleta).reentrou= true;
					clientesNaEsteira.add(new Cliente(i+tempoServico));
					Collections.sort(clientesNaEsteira, new ClienteComparator());
				}else{
					numClientesServidosBicicleta++;
				}
				proximoAtendimentoBicicleta = i + tempoServico; //- 1;
				//OBS: Estamos perdendo 1 tempo?
				
			}
		}else{
			//instantesOciosos.add(i);
		}
	}
	
	public void simula(){
		gerarClientes();
		
		for (long i=0; i<Experimento.TEMPO_SIMULACAO; i++){
			servirClientesEsteira(i);
			servirClientesBicicleta(i);
		}
			
		
		calculoMetricas();
		
	};
	
	public void calculoMetricas(){
		//TODO
		
	};
	
	public long tempoMedioSistema(){
		long tempoTotalSistema = 0;
		
		for (int i=0; i<clientesNaEsteira.size(); i++){
			tempoTotalSistema +=tempoSistemaPorCliente(clientesNaEsteira.get(i));
		}
		for (int i=0; i<clientesNaBicicleta.size(); i++){
			tempoTotalSistema +=tempoSistemaPorCliente(clientesNaBicicleta.get(i));
		}
		if (numeroClientesSistema()==0){
			return 0;
		}
		return tempoTotalSistema/numeroClientesSistema();
	}
	
	

	public long tempoSistemaPorCliente(Cliente c){
		return c.tempoSaida - c.tempoChegada;
	}
	
	//QUANDO HOUVER REENTRADA, NÃO CONTAR COMO MAIS UM CLIENTE, MAS CONTAR O SEU TEMPO
	//NO SISTEMA, PORQUE ESTA FATIADO ENTRE AS FILAS
	public long numeroClientesSistema(){
		long count=0;
		for (int i=0; i<clientesNaEsteira.size(); i++){
			if (!clientesNaEsteira.get(i).reentrou){
				count++;
			}
		}
		for (int i=0; i<clientesNaBicicleta.size(); i++){
			if (!clientesNaBicicleta.get(i).reentrou){
				count++;
			}
		}
		
		return count;
	}
	
	
	
	

}
