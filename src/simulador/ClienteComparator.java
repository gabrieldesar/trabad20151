package simulador;

import java.util.Comparator;

public class ClienteComparator implements Comparator<Cliente>
{

	@Override
	public int compare(Cliente c1, Cliente c2)
	{
		if(c1.tempoChegada < c2.tempoChegada)
			return -1;
		if(c1.tempoChegada == c2.tempoChegada)
			return 0;
		else
			return 1;
	}

}
