package experimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Cenario
{
	List<Rodada> rodadas;	
	Map <Float, Double> mediaNumClientesPorLambda;
	Map <Float, Double> mediaNumClientesPorMi;
	Properties properties;
	
	//MapasSimulacao mapasValoresCenario;
	
	public Cenario(Properties properties){
		mediaNumClientesPorLambda = new TreeMap<Float, Double>();
		mediaNumClientesPorMi = new TreeMap<Float, Double>();
		rodadas = new ArrayList<Rodada>();
		this.properties = properties;
	}
	
	public void executarCenario(int numSimulacoes){
		Rodada rodada;
		for (int i=0; i< numSimulacoes; i++){
			rodada = new Rodada(properties);
			rodada.executarRodada();
			rodadas.add(rodada);
			
			if (properties.iterateValue==IterateValue.LAMBDA){
				for (Float key : rodada.numMedioClientesPorLambda.keySet()){
					if (i==0){
						
						mediaNumClientesPorLambda.put(key, (rodada.numMedioClientesPorLambda.get(key)/numSimulacoes));
					}else{
						mediaNumClientesPorLambda.put(key, mediaNumClientesPorLambda.get(key)+(rodada.numMedioClientesPorLambda.get(key)/numSimulacoes));
					}
				}
			}else{
				for (Float key : rodada.numMedioClientesPorMi.keySet()){
					if (i==0){
						
						mediaNumClientesPorMi.put(key, (rodada.numMedioClientesPorMi.get(key)/numSimulacoes));
					}else{
						mediaNumClientesPorMi.put(key, mediaNumClientesPorMi.get(key)+(rodada.numMedioClientesPorMi.get(key)/numSimulacoes));
					}
				}
			}
			
			

		}
	}
	
	
}