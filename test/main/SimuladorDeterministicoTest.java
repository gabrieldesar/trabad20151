package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimuladorDeterministicoTest {

	@Test
	public void testEntradaCliente() {
		SimuladorDeterministico sd = new SimuladorDeterministico(0.5f, 0.5f, 0);
		System.out.println(sd.entradaCliente()+"");
	}

}
