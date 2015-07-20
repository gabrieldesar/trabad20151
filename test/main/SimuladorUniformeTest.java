package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimuladorUniformeTest {

	@Test
	public void test() {
		SimuladorUniforme su = new SimuladorUniforme(0.5f, 0.5f, 0, 5, 15);
		System.out.println(su.entradaCliente()+"");
	}

}
