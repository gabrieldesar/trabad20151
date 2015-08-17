package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ConjuntoCenarios
{
	List<Cenario> cenarios;
	Map <Float, Double> mediaCenario;
	MapasSimulacao mapasValoresCenario;
	
	public ConjuntoCenarios(){
		cenarios = new ArrayList<Cenario>();
		mediaCenario = new TreeMap<Float,Double>();
		mapasValoresCenario = new MapasSimulacao();
	}
}
