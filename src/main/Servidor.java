package main;

public class Servidor
{

	private static final double FATOR_TRUNCAMENTO_TEMPO = 10;

	public static long geraTempoDeServico(float mi)
	{
		if (mi > 0)
		{
			double tempoServico = -Math.log(1 - (1 - Math.exp(-mi)) * Math.random()) / mi;
			return (int) Math.round(tempoServico * FATOR_TRUNCAMENTO_TEMPO);
		}
		return 0;
	}
}
