package testmodelo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import modelo.Habitacion;
import modelo.HabitacionHotel;

public class testHabitacionHotel {
	private float precio=39;
	private boolean ocupada=false;
	private int nCamas=3;
	private  int codHabitacion=1;
	private int tamano=234;
	private String tipo="SUITE";

	HabitacionHotel testHabit=new HabitacionHotel(codHabitacion, tamano, tipo, precio,  ocupada,nCamas);
	

	@Test
	public void testConstructor1() {
		assertEquals(testHabit.getCodHabitacion(),codHabitacion);
		assertEquals(testHabit.getTamano(),tamano);
		assertEquals(testHabit.getTipo(),tipo);
		assertEquals(testHabit.getPrecio(),precio,0);
		assertEquals(testHabit.getnCamas(),nCamas);
		assertEquals(testHabit.isOcupada(),ocupada);
	
		
	}
	
	@Test
	public void testConstructor2() {
		HabitacionHotel testHabi=new HabitacionHotel();
		assertEquals(testHabi.getCodHabitacion(),0);
		assertEquals(testHabi.getTamano(),0);
		assertEquals(testHabi.getTipo(),null);
	}
	
	@Test
	public void testPrecio() {
		HabitacionHotel testHabi=new HabitacionHotel();
		testHabi.setCodHabitacion(codHabitacion);
		assertEquals(testHabit.getCodHabitacion(),codHabitacion);
		
	}
	@Test
	public void testOcupada() {
		HabitacionHotel testHabi=new HabitacionHotel();
		testHabi.setOcupada(ocupada);
		assertEquals(testHabit.isOcupada(),ocupada);
		
	}
	@Test
	public void testNcamas() {
		HabitacionHotel testHabi=new HabitacionHotel();
		testHabi.setnCamas(nCamas);
		assertEquals(testHabit.getnCamas(),nCamas);
		
	}
	@Test
	public void testToString() {
		String result;
		String esperado;
		StringBuilder builder = new StringBuilder();
		builder.append("Tipo: "+tipo+"\n");
		builder.append("Nº Camas: "+nCamas+"\n");
		builder.append("Tamaño: "+tamano+"\n");
		builder.append("Precio: "+precio+"\n");
		builder.append("\n");
		
		esperado=builder.toString();
		result=testHabit.toString();
		assertEquals(result,esperado);
		
	}
}
