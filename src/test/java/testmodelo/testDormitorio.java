package testmodelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Dormitorio;

public class testDormitorio {
	private int nCamas=2;
	private int codHabitacion=01;
	private int taman=300;
	private String tipo="FAMILIAR";
	Dormitorio testDormitorio=new Dormitorio( codHabitacion,  taman,tipo,nCamas);
	@Test
	public void testConstructor() {
		assertEquals(testDormitorio.getnCamas(),nCamas);
		assertEquals(testDormitorio.getCodHabitacion(),codHabitacion);
		assertEquals(testDormitorio.getTamano(),taman);
		assertEquals(testDormitorio.getTipo(),tipo);
		
	}
	@Test
	public void testCod() {
		
		testDormitorio.setCodHabitacion(codHabitacion);
		assertEquals(testDormitorio.getCodHabitacion(),codHabitacion);
		
		
	}
	@Test
	public void testCama() {
		
		testDormitorio.setnCamas(nCamas);
		assertEquals(testDormitorio.getnCamas(),nCamas);
		
		
		
	}
	@Test
	public void testTaman() {
		
		testDormitorio.setTamano(taman);
		assertEquals(testDormitorio.getTamano(),taman);
		
		
		
	}
	@Test
	public void testTipo() {
		
		testDormitorio.setTipo(tipo);
		assertEquals(testDormitorio.getTipo(),tipo);
		
		
		
	}

}
