package main;

import java.util.ArrayList;
import java.util.List;

public abstract class Simulador {
	public final int FATOR_TRUNCAMENTO_TEMPO = 10;
	
	float lambda;
	float mi;
	float p;
	
	Servidor servidor;
	List<Cliente> clientes = new ArrayList<Cliente>();
	
	public Simulador(float lambda, float mi, float p){
		this.lambda = lambda;
		this.mi = mi;
		this.p = p;		
		
	}
	
	//Gerar um cliente novo que entra no sistema
	public abstract int entradaCliente();
	
	//Loop do processamento da rede de filas
	public void simula(){
		
	}
	
	//Saída da simulação 
	public void log(){
		//TO-DO
	}
	
}
