package main;

import java.util.Random;

import org.uncommons.maths.random.ExponentialGenerator;

public class Servidor
{
	private static final Random range = new Random();
	private static final double FATOR_TRUNCAMENTO_TEMPO = 10;	
	public static long geraTempoDeServico(float mi,int rangeLower, int rangeUpper)
	{
		if(rangeLower > rangeUpper) {
			return -1;
		}
		if (mi > 0)
		{
			ExponentialGenerator exp = new ExponentialGenerator(1/mi, range);
			
			//double tempoServico = -Math.log(1 - (1 - Math.exp(-mi)) * Math.random()) / mi;
			double tempoServico = exp.nextValue();
			//System.out.println(tempoServico+"");
					
					//-Math.log(Math.exp(- mi * rangeLower) - (Math.exp(- mi * rangeLower) - Math.exp(-mi*rangeUpper)) * Math.random()) / mi;
			//System.out.println("tempo de serviço antes de arredondar -> "+tempoServico);
			return (int) Math.round(tempoServico);
		}
		return 0;
	}
}
