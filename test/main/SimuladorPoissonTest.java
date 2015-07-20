package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimuladorPoissonTest {

	@Test
	public void testEntradaCliente() {
		SimuladorPoisson sp = new SimuladorPoisson(0.5f, 0.5f, 0);
		System.out.println(sp.entradaCliente()+"");
	}

}
