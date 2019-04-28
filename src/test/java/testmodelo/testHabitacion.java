package testmodelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Habitacion;
import modelo.HabitacionHotel;

public class testHabitacion {
	private  int codHabitacion=1;
	private int tamano=234;
	private String tipo="SUITE";
	Habitacion testHabit=new Habitacion(codHabitacion, tamano, tipo);

	@Test
	public void testConstructor1() {
		assertEquals(testHabit.getCodHabitacion(),codHabitacion);
		assertEquals(testHabit.getTamano(),tamano);
		assertEquals(testHabit.getTipo(),tipo);
	
		
	}
	
	@Test
	public void testConstructor2() {
		Habitacion testHabi=new Habitacion();
		assertEquals(testHabi.getCodHabitacion(),0);
		assertEquals(testHabi.getTamano(),0);
		assertEquals(testHabi.getTipo(),null);

	}
	@Test
	public void testCod() {
		Habitacion testHabi=new Habitacion();
		testHabi.setCodHabitacion(codHabitacion);
		assertEquals(testHabit.getCodHabitacion(),codHabitacion);
		
	}
	@Test
	public void testTamano() {
		Habitacion testHabi=new Habitacion();
		testHabi.setTamano(tamano);
		assertEquals(testHabit.getTamano(),tamano);
		
	}
	@Test
	public void testTipo() {
		Habitacion testHabi=new Habitacion();
		testHabi.setTipo(tipo);
		assertEquals(testHabit.getTipo(),tipo);
		
	}

}
