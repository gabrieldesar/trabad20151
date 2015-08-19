package simulador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

	public void printSimulationMetrics(String simulationName, float lambda, float mi, float p, double numeroMedioDeClientes, int clientesSize, List<Long> instantesOciosos, long tempoSimulacao){
		 
		try {
				BufferedWriter out = new BufferedWriter( fileWriter );
		        out.write("Lambda: " + lambda+"\n");
		        out.write("Mi: " + mi+"\n");
		        out.write("Prob. Reentrada: " + p+"\n");
		        out.write("Num Médio de Clientes no Sistema: "+numeroMedioDeClientes+"\n");
		        out.write("Numero total de Clientes no sistema no periodo de simulação: " + clientesSize+"\n");
		        out.write("Tempo ocioso no sistema: " +instantesOciosos.size()+"\n");
		        long tempoOcupado = tempoSimulacao-instantesOciosos.size();
		        out.write("Tempo Ocupado do sistema: "+ tempoOcupado+"\n" );
		        out.close();
		        System.out.println(simulationName + " escrito!");
		    } catch (IOException e) {
		    	System.out.println("Erro no "+simulationName);
		    }
		
	}
	
	
	public void logLine(long iterationNumber, Boolean servidorOcupado, long clientesNoSistema) {
		
	}
}
