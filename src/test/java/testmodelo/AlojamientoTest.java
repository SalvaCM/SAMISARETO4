package testmodelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Alojamiento;

public class AlojamientoTest {

	
	private  int codAlojamiento=001;
	private  int habDisponibles=2;
	private int habTotales=300;
	private String nombre="CAMINO";
	private String ubicacion="MADRID";
	private float tarifa=123;
	private Alojamiento alojTest=new Alojamiento();

	

	@Test
	public void testConstructor1() {
		Alojamiento alojTest=new Alojamiento(codAlojamiento,habDisponibles,habTotales,nombre,ubicacion,tarifa);
		assertEquals(alojTest.getCodAlojamiento(),001);
		assertEquals(alojTest.getHabDisponibles(),2);
		assertEquals(alojTest.getHabTotales(),300);
		assertEquals(alojTest.getNombre(),"CAMINO");
		assertEquals(alojTest.getUbicacion(),"MADRID");
		assertEquals(alojTest.getTarifa(),123,0);
		
	}
	@Test
	public void testConstructor2() {
		Alojamiento alojTest=new Alojamiento();
		assertEquals(alojTest.getCodAlojamiento(),0);
		assertEquals(alojTest.getHabDisponibles(),0);
		assertEquals(alojTest.getHabTotales(),0);
		assertEquals(alojTest.getNombre(),null);
		assertEquals(alojTest.getUbicacion(),null);
		assertEquals(alojTest.getTarifa(),0f, 0);
		
	}
	@Test
	public void testCodAloj() {
		
		alojTest.setCodAlojamiento(codAlojamiento);
		assertEquals(alojTest.getCodAlojamiento(),codAlojamiento);
		
		
	}
	@Test
	public void testHabDisp() {
		
		alojTest.setHabDisponibles(habDisponibles);
		assertEquals(alojTest.getHabDisponibles(),habDisponibles);
		
		
	}
	@Test
	public void testHabTo() {
		
		alojTest.setHabTotales(habTotales);
		assertEquals(alojTest.getHabTotales(),habTotales);
		
		
	}
	@Test
	public void testNombre() {
		
		alojTest.setNombre(nombre);
		assertEquals(alojTest.getNombre(),nombre);
		
		
	}
	@Test
	public void testUbicacion() {
		
		alojTest.setUbicacion(ubicacion);
		assertEquals(alojTest.getUbicacion(),ubicacion);
		
		
	}
	@Test
	public void testTarifa() {
		
		alojTest.setTarifa(tarifa);;
		assertEquals(alojTest.getTarifa(),tarifa,0);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
