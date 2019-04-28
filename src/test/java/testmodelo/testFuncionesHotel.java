package testmodelo;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import modelo.FuncionesHotel;
import modelo.HabitacionHotel;
import modelo.Hotel;


public class testFuncionesHotel {

    private FuncionesHotel testFuncionesHotel=new FuncionesHotel();
	private ArrayList<Hotel> hoteles =new ArrayList<Hotel>();
	private ArrayList<HabitacionHotel> habitHotel =new ArrayList<HabitacionHotel>();
	private HabitacionHotel habitacionHotel =new HabitacionHotel();
	ArrayList<String> ubicaciones =new ArrayList<String>();
	
	
	@Test
	public void testLeerHoteles() throws SQLException {
		
			
				hoteles=testFuncionesHotel.leerHoteles();
			
		
		
		assertEquals(hoteles.get(0).getNombre(),"LO LEJANO");
		assertEquals(hoteles.get(1).getNombre(),"HOTEL LO");
		assertEquals(hoteles.get(2).getNombre(),"HOTEL LA");
		assertEquals(hoteles.get(3).getNombre(),"HOTEL LI");
		assertEquals(hoteles.get(4).getNombre(),"HOTEL LE");
		assertEquals(hoteles.get(5).getNombre(),"HOTEL BLOOM");
		assertEquals(hoteles.get(6).getNombre(),"HOTEL NT");
	
		
	}
	@Test
	public void testBuscarPorUbicacionHotel() throws SQLException {
		
			hoteles=testFuncionesHotel.buscarUbicacion("VALENCIA");
	
		
		
		//System.out.println("aqui:  "+hoteles.get(4).getNombre());
		assertEquals(hoteles.get(0).getNombre(),"HOTEL LE");
		assertEquals(hoteles.get(1).getNombre(),"HOTEL BLOOM");
		
	}
	@Test
	public void testLeerHabitaciones() throws SQLException {
		
			habitHotel=testFuncionesHotel.leerHabitaciones(001);
			
			assertEquals(habitHotel.get(0).getCodHabitacion(),001);
	}
	@Test
	public void testReservarHabitacion() throws SQLException {
		
			habitacionHotel=testFuncionesHotel.reservarHabitacion(003);
			
			assertEquals(habitacionHotel.getCodHabitacion(),003);
	}
	@Test
	public void testMostrarUbicaciones() throws SQLException {
		
			ubicaciones=testFuncionesHotel.mostrarUbicaciones();
			
			assertEquals(ubicaciones.get(0),"PARÍS");
			assertEquals(ubicaciones.get(1),"MADRID");
			assertEquals(ubicaciones.get(2),"BARCELONA");
			assertEquals(ubicaciones.get(3),"NUEVA YORK");
			assertEquals(ubicaciones.get(4),"VALENCIA");
			assertEquals(ubicaciones.get(5),"SEVILLA");
			assertEquals(ubicaciones.get(6),"ROMA");

}
	
	
	
	

}
