package main;

public class TrabalhoAD
{
	public static void main(String[] args) {
		
		Experimento exp = new Experimento();
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
	}
}
