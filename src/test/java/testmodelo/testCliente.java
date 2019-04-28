package testmodelo;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import modelo.Cliente;

public class testCliente {
	private String dni="1609349R";
	private String nombre="Alberto";
	private String apellido="Gomez";
	private java.util.Date fechaNacimiento;
	private String contrasena="1234";
	Cliente testCliente=new Cliente(dni,nombre,apellido,fechaNacimiento,contrasena);
	@Test
	public void testConstructor() {
		assertEquals(testCliente.getDni(),dni);
		assertEquals(testCliente.getNombre(),nombre);
		assertEquals(testCliente.getApellido(),apellido);
		assertEquals(testCliente.getFechaNacimiento(),null);
		assertEquals(testCliente.getContrasena(),contrasena);
		
	}
	@Test
	public void testConstructor2() {
		Cliente testCliente=new Cliente();
		assertEquals(testCliente.getDni(),null);
		assertEquals(testCliente.getNombre(),null);
		assertEquals(testCliente.getApellido(),null);
		assertEquals(testCliente.getFechaNacimiento(),null);
		assertEquals(testCliente.getContrasena(),null);
		
	}
	@Test
	public void testDni() {
		
		testCliente.setDni(dni);
		assertEquals(testCliente.getDni(),dni);
		
		
		
	}
	@Test
	public void testNombre() {
		
		testCliente.setNombre(nombre);;
		assertEquals(testCliente.getNombre(),nombre);
		
	}
	@Test
	public void testApellido() {
		
		testCliente.setApellido(apellido);;
		assertEquals(testCliente.getApellido(),apellido);
		
		
		
	}
	@Test
	public void testFecha() {
		
		testCliente.setFechaNacimiento(fechaNacimiento);;
		assertEquals(testCliente.getFechaNacimiento(),null);
		
		
		
	}
	@Test
	public void testContrasena() {
		
		testCliente.setContrasena(contrasena);
		assertEquals(testCliente.getContrasena(),contrasena);
		
		
		
	}


}
