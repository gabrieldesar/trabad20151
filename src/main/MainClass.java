package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainClass {
	Scanner scan;
	public long tempoSimulacao;
	List<SimuladorPoisson> cenario1 = new ArrayList<SimuladorPoisson>();
	List<SimuladorDeterministico> cenario2 = new ArrayList<SimuladorDeterministico>();
	List<SimuladorUniforme> cenario3 = new ArrayList<SimuladorUniforme>();
	List<SimuladorPoisson> cenario4 = new ArrayList<SimuladorPoisson>();
	List<SimuladorDeterministico> cenario5 = new ArrayList<SimuladorDeterministico>();
	List<SimuladorUniforme> cenario6 = new ArrayList<SimuladorUniforme>();
	Map <Float, Double> mapCenario1 = new TreeMap<Float, Double>();
	Map <Float, Double> mapCenario2 = new TreeMap<Float, Double>();
	Map <Float, Double> mapCenario3 = new TreeMap<Float, Double>();
	Map <Float, Double> mapCenario4 = new TreeMap<Float, Double>();
	Map <Float, Double> mapCenario5 = new TreeMap<Float, Double>();
	Map <Float, Double> mapCenario6 = new TreeMap<Float, Double>();
	public MainClass(){
		float taxaEntrada;
		float taxaServico;
		float probReentrada;
		
		
		
		//scan = new Scanner(System.in);
		//System.out.println("----SIMULAÇÃO DE REDE DE FILAS----");
		//System.out.println("");
		//System.out.println("----Informe o tempo considerado para simulação----");
		
		//TODO - CAPTURAR INPUT DO TEMPO DE SIMULACAO
		//boolean quitWhile=false;
		/*do{
			try{
				tempoSimulacao = Long.parseLong(scan.nextLine());
				quitWhile = true;
			}catch (Exception e){
				System.out.println("Valor inválido. Digite um número inteiro");
			}				
		}while(!quitWhile);
		*/
		tempoSimulacao = 300;
		//Cenários 1 e 2
		
		taxaEntrada = 0.05f;
		taxaServico = 1f;
		probReentrada = 0f;
		int count =0;
		while (taxaEntrada < 0.95){
			cenario1.add(new SimuladorPoisson(taxaEntrada, taxaServico, probReentrada, tempoSimulacao));
			cenario2.add(new SimuladorDeterministico(taxaEntrada, taxaServico, probReentrada, tempoSimulacao));
			mapCenario1.put(taxaEntrada, cenario1.get(count).numeroMedioDeClientes);
			mapCenario2.put(taxaEntrada, cenario2.get(count).numeroMedioDeClientes);
			count++;
			taxaEntrada += 0.05f;
			
		}
		
		//Cenários 3, 4, 5 e 6
		float taxaEntradaCenario3 = 0.1f;
		float probReentradaCenario3 = 0f;
		int intervaloMinCenario3 = 5;
		int intervaloMaxCenario3 = 15;
		int intervaloMinCenario6 = 50;
		int intervaloMaxCenario6 = 150;
		taxaEntrada = 0.01f;
		taxaServico = 1f;
		probReentrada = 0.9f;
		count =0;
		while (taxaServico < 10.5f){
			cenario3.add(new SimuladorUniforme(taxaEntradaCenario3, taxaServico, probReentradaCenario3, intervaloMinCenario3, intervaloMaxCenario3, tempoSimulacao));
			cenario4.add(new SimuladorPoisson(taxaEntrada, taxaServico, probReentrada, tempoSimulacao));
			cenario5.add(new SimuladorDeterministico(taxaEntrada, taxaServico, probReentrada, tempoSimulacao));
			cenario6.add(new SimuladorUniforme(taxaEntrada, taxaServico, probReentrada, intervaloMinCenario6, intervaloMaxCenario6, tempoSimulacao));
			mapCenario3.put(taxaServico, cenario3.get(count).numeroMedioDeClientes);
			mapCenario4.put(taxaServico, cenario4.get(count).numeroMedioDeClientes);
			mapCenario5.put(taxaServico, cenario5.get(count).numeroMedioDeClientes);
			mapCenario6.put(taxaServico, cenario6.get(count).numeroMedioDeClientes);
			count++;
			taxaServico += 0.5f;
		}
				
	}
	
	
	
	public static void main(String[] args) {
		new MainClass();
	}

}
