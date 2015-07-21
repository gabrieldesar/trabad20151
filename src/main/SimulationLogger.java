package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SimulationLogger
{
	String fileName;
	PrintWriter fileWriter;
	
	public SimulationLogger(String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		
		fileWriter = new PrintWriter(fileName);
	}
	
	public void logLine(long iterationNumber, Boolean servidorOcupado, long clientesNoSistema) {
		
	}
}
