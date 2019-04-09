package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexion.ConexionBD;
import conexion.ConsultaBD;


public class FuncionesHotel {
	
	public ArrayList<Alojamiento> alojamientos;
	public Alojamiento alojamiento=new Alojamiento();
	
	public int codhotel;
	public Hotel hotel;
	public estanciaHotel estancia;

	
	
	/**
	 * Metodo para mostrar los alojamientos disponibles en el JTABLE
	 */
	ConexionBD miConexion = new ConexionBD();
	ConsultaBD miConsulta = new ConsultaBD();
	Connection con = miConexion.ConectarBD();
	/**
	 * Metodo para buscar los hoteles en la DB, devuelve un array con todos los hoteles.
	 */
	public ArrayList<Hotel> leerHoteles() throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		String nombre="";	String ubicacion="";	int nEstrellas=0; int codhotel;
		ArrayList<Hotel> hoteles =new ArrayList<Hotel>();
		
		// Inicio
		
		String query="select cod_hotel,nombre, ubicacion, nestrellas from hotel;";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		while(rs.next()) {
				Hotel hotel=new Hotel();
				codhotel = rs.getInt("cod_hotel");
				nombre = rs.getString("nombre");
				ubicacion = rs.getString("ubicacion");
				nEstrellas = rs.getInt("nestrellas");
				hotel.setCod_hotel(codhotel);
				hotel.setNombre(nombre);
				hotel.setUbicacion(ubicacion);
				hotel.setnEstrellas(nEstrellas);
				hoteles.add(hotel);
			}
			
		return hoteles;

	}
	/**
	 * Metodo para buscar los hoteles  por su UBICACION en la DB, devuelve un array con todos los hoteles.
	 */

	public ArrayList<Hotel> buscarUbicacion(String ubicacion) throws SQLException{
		String nombre="";
		ArrayList<Hotel> hoteles =new ArrayList<Hotel>();
		
		String query="select cod_hotel,nombre,ubicacion,nestrellas from hotel where ubicacion='"+ubicacion+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);

		while(rs.next()) {
				codhotel=rs.getInt("cod_hotel");
				nombre = rs.getString("nombre");
				ubicacion = rs.getString("ubicacion");
				int nEstrellas = rs.getInt("nestrellas");
				hotel=new Hotel();
				hotel.setCod_hotel(codhotel);
				hotel.setNombre(nombre);
				hotel.setUbicacion(ubicacion);
				hotel.setnEstrellas(nEstrellas);
				hoteles.add(hotel);
		}
		return hoteles;
	}

	
	public ArrayList<estanciaHotel> leerEstancias(int codhotel) throws SQLException{
		String categoria="";
		float precio=0;
		int existencia;
		int codHabitacion;
		ArrayList<estanciaHotel> estancias =new ArrayList<estanciaHotel>();
		
		String query="select cod_aloj,categoria,existencias,tarifa from estanciaHotel where cod_hotel='"+codhotel+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			codHabitacion = rs.getInt("cod_aloj");
			categoria = rs.getString("categoria");
			precio = rs.getFloat("tarifa");
			existencia=rs.getInt("existencias");
			estancia=new estanciaHotel();
			estancia.setCodAlojamiento(codHabitacion);
			estancia.setCategoria(categoria);
			estancia.setExistencias(existencia);
			estancia.setTarifa(precio);
			estancias.add(estancia);
		}
		return estancias;
	}
	public estanciaHotel reservarHabitacion(int cod_habitacion) throws SQLException{
		String categoria="";
		float precio=0;
		int existencia;
		int codHabitacion;
		
		
		String query="select cod_aloj,categoria,existencias,tarifa from estanciaHotel where cod_aloj='"+cod_habitacion+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			codHabitacion = rs.getInt("cod_aloj");
			categoria = rs.getString("categoria");
			precio = rs.getFloat("tarifa");
			existencia=rs.getInt("existencias");
			estancia.setCodAlojamiento(codHabitacion);
			estancia.setCategoria(categoria);
			estancia.setExistencias(existencia);
			estancia.setTarifa(precio);
		}
		return estancia;
	}
	public ArrayList<String> mostrarUbicaciones () throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		String nombre="";
		String ubicacion="";
		int nEstrellas=0;
		ArrayList<String>ubicaciones =new ArrayList<String>();
		String query="select distinct  ubicacion from hotel;";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		while(rs.next()) {
				
				
				ubicacion = rs.getString("ubicacion");
				
				ubicaciones.add(ubicacion);
			}
			
		return ubicaciones;

	}


	
}
