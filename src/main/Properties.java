package main;

public class Properties
{
	String name;
	float taxaEntrada;
	float taxaServico;
	float probReentrada;
	int intervaloMin;
	int intervaloMax;
	IterateValue iv;
	
	public Properties(String name, float taxaEntrada, float taxaServico, float probReentrada, IterateValue iv){
		this.name = name;
		this.taxaEntrada = taxaEntrada;
		this.taxaServico = taxaServico;
		this.probReentrada = probReentrada;
		this.iv = iv;
	}
	
	public Properties(String name, float taxaEntrada, float taxaServico, float probReentrada, int intervaloMin, int intervaloMax, IterateValue iv){
		this.name = name;
		this.taxaEntrada = taxaEntrada;
		this.taxaServico = taxaServico;
		this.probReentrada = probReentrada;
		this.intervaloMin = intervaloMin;
		this.intervaloMax = intervaloMax;
		this.iv = iv;
	}
}
