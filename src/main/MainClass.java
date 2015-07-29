package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	Scanner scan;
	public long tempoSimulacao;
	
	public MainClass(){
		float taxaEntrada;
		float taxaServico;
		float probReentrada;
		
		List<SimuladorPoisson> cenario1 = new ArrayList<SimuladorPoisson>();
		List<SimuladorDeterministico> cenario2 = new ArrayList<SimuladorDeterministico>();
		List<SimuladorUniforme> cenario3 = new ArrayList<SimuladorUniforme>();
		List<SimuladorPoisson> cenario4 = new ArrayList<SimuladorPoisson>();
		List<SimuladorDeterministico> cenario5 = new ArrayList<SimuladorDeterministico>();
		List<SimuladorUniforme> cenario6 = new ArrayList<SimuladorUniforme>();
		
		scan = new Scanner(System.in);
		System.out.println("----SIMULAÇÃO DE REDE DE FILAS----");
		System.out.println("");
		System.out.println("----Informe o tempo considerado para simulação----");
		
		//TODO - CAPTURAR INPUT DO TEMPO DE SIMULACAO
		boolean quitWhile=false;
		do{
			try{
				tempoSimulacao = Long.parseLong(scan.nextLine());
				quitWhile = true;
			}catch (Exception e){
				System.out.println("Valor inválido. Digite um número inteiro");
			}				
		}while(!quitWhile);
		
		
		//Cenários 1 e 2
		
		taxaEntrada = 0.05f;
		taxaServico = 1;
		probReentrada = 0;
		
		while (taxaEntrada <= 0.9){
			cenario1.add(new SimuladorPoisson(taxaEntrada, taxaServico, probReentrada, tempoSimulacao));
			cenario2.add(new SimuladorDeterministico(taxaEntrada, taxaServico, probReentrada, tempoSimulacao));
			taxaEntrada += 0.05;
		}
		
		//Cenários 3, 4, 5 e 6
		float taxaEntradaCenario3 = 0.1f;
		float probReentradaCenario3 = 0;
		int intervaloMinCenario3 = 5;
		int intervaloMaxCenario3 = 15;
		int intervaloMinCenario6 = 50;
		int intervaloMaxCenario6 = 150;
		taxaEntrada = 0.01f;
		taxaServico = 1;
		probReentrada = 0.9f;
		
		while (taxaEntrada <= 10){
			cenario3.add(new SimuladorUniforme(taxaEntradaCenario3, taxaServico, probReentradaCenario3, intervaloMinCenario3, intervaloMaxCenario3, tempoSimulacao));
			cenario4.add(new SimuladorPoisson(taxaEntrada, taxaServico, probReentrada, tempoSimulacao));
			cenario5.add(new SimuladorDeterministico(taxaEntrada, taxaServico, probReentrada, tempoSimulacao));
			cenario6.add(new SimuladorUniforme(taxaEntrada, taxaServico, probReentrada, intervaloMinCenario6, intervaloMaxCenario6, tempoSimulacao));
			taxaServico += 0.05;
		}
		
		
		
	}
	public static void main(String[] args) {
		new MainClass();
	}

}
