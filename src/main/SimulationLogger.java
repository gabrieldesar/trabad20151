package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SimulationLogger
{
	String fileName;
	PrintWriter fileWriter;
	
	public SimulationLogger(String fileName){
		this.fileName = fileName;
		
		File file = new File(fileName);
		 
		// if file doesnt exists, then create it
		try{
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fileWriter = new PrintWriter(file);
		}catch (IOException e){
			
		}
		
	}

	public void printSimulationMetrics(String simulationName, float lambda, float mi, float p, float numeroMedioDeClientes){
		 
		try {
				BufferedWriter out = new BufferedWriter( fileWriter );
		        out.write("Lambda: " + lambda+"\n");
		        out.write("Mi: " + mi+"\n");
		        out.write("Prob. Reentrada: " + p+"\n");
		        out.write("Num Médio de Clientes no Sistema: "+numeroMedioDeClientes+"\n");
		        out.close();
		        System.out.println(simulationName + " escrito!");
		    } catch (IOException e) {
		    	System.out.println("Erro no "+simulationName);
		    }
		
	}
	
	
	public void logLine(long iterationNumber, Boolean servidorOcupado, long clientesNoSistema) {
		
	}
}
