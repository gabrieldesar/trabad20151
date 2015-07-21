package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class SimulationLogger
{
	String fileName;
	PrintWriter fileWriter;
	
	public SimulationLogger(String fileName) throws IOException {
		this.fileName = fileName;
		
		File file = new File(fileName);
		 
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}
		
		fileWriter = new PrintWriter(file);
	}
	
	public void logLine(long iterationNumber, Boolean servidorOcupado, long clientesNoSistema) {
		
	}
}
