package main;

import java.util.Scanner;

public class MainClass {
	Scanner scan;
	
	public MainClass(){
		double taxaEntrada=0;
		double taxaServico=0;
		
		scan = new Scanner(System.in);
		System.out.println("----SIMULAÇÃO DE REDE DE FILAS----");
		System.out.println("");
		System.out.println("----Cenário1: Simulador Poisson Sem Reentrada----");
		
		boolean quitWhile;
		
		do{
			System.out.println("Informe a taxa de entrada: [0.05-0.9]");
			try {
				taxaEntrada = Double.parseDouble(scan.nextLine());
				if (taxaEntrada < 0.05 || taxaEntrada > 0.9){
					quitWhile = false;
					System.out.println("Valor inválido");
				}else{
					quitWhile = true;
				}
			} catch (Exception e) {
				System.out.println("Valor inválido");
				taxaEntrada = 0;
				quitWhile = false;
			}
		}while (!quitWhile);
		
		taxaServico = 1;
		
		System.out.println("Taxa de entrada: " + taxaEntrada);
		System.out.println("Probabilidade de reentrada: 0");
		System.out.println("Taxa de serviço: " + taxaServico);
		
		System.out.println("Processando...");
		//Todo Chamar simulador
		
		//Fazer para outros simuladores
		
		//Imprimir log
		
		
	}
	public static void main(String[] args) {
		new MainClass();
	}

}
