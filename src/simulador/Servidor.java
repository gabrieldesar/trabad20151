package simulador;

import org.uncommons.maths.random.ExponentialGenerator;

import experimento.Experimento;

public class Servidor
{	
	public static double geraTempoDeServico(float mi)
	{
		if (mi > 0)
		{
			ExponentialGenerator exp = new ExponentialGenerator(mi, Experimento.range);
			double tempoServico = exp.nextValue(); //TODO ESTA RETORNANDO 0 TBM
			return tempoServico;
		}
		return 0;
	}
	
}
