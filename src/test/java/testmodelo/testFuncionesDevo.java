package testmodelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.FuncionesDevolucion;

public class testFuncionesDevo {
	FuncionesDevolucion testDevo=new FuncionesDevolucion();
	@Test
	public void test() {
		int[] esperado= {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] resultado= testDevo.cambios(100);
		assertArrayEquals(resultado,esperado);
	}
	@Test
	public void test2() {
		int[] esperado= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] resultado= testDevo.cambios(0);
		assertArrayEquals(resultado,esperado);
	}
	@Test
	public void test3() {
		int[] esperado= {0,0,0,1,0,0,0,0,0,0,0,0,0,0,1};
		int[] resultado= testDevo.cambios(50.01);
		assertArrayEquals(resultado,esperado);
	}
	
}
