package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapasSimulacao {
	public List<Map<Float, Double>> mapas;
	
	public MapasSimulacao(){
		mapas = new ArrayList<Map<Float, Double>>();
	}
	
	public void add(Map<Float, Double> mapa){
		mapas.add(mapa);
	}
	
	public int size(){
		return mapas.size();
	}
	
	public Map<Float, Double> get(int position){
		return mapas.get(position);
	}
	
	public List<Double> valuesAsList(Float key){
		List<Double> lista = new ArrayList<Double>();
		
		for (int i=0; i<mapas.size(); i++){
			lista.add(mapas.get(i).get(key));
		}
		return lista;
			

	}
	

}
