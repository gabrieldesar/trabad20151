package main;

public class Servidor
{

	private static final double FATOR_TRUNCAMENTO_TEMPO = 10;

	
	public static long geraTempoDeServico(float mi,int rangeLower, int rangeUpper)
	{
		if(rangeLower > rangeUpper) {
			return -1;
		}
		if (mi > 0)
		{
			//double tempoServico = -Math.log(1 - (1 - Math.exp(-mi)) * Math.random()) / mi;
			double tempoServico = -Math.log(Math.exp(- mi * rangeLower) - (Math.exp(- mi * rangeLower) - Math.exp(-mi*rangeUpper)) * Math.random()) / mi;
			//System.out.println("tempo de serviço antes de arredondar -> "+tempoServico);
			return (int) Math.round(tempoServico );
		}
		return 0;
	}
}
