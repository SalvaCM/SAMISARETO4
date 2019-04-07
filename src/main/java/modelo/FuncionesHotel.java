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
    
	public ArrayList<Hotel> leerHoteles() throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		String nombre="";
		String ubicacion="";
		float precio=0;
		ArrayList<Hotel> hoteles =new ArrayList<Hotel>();
		String query="select nombre, ubicacion, precionoche from hotel;";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		while(rs.next()) {
				
				nombre = rs.getString("nombre");
				ubicacion = rs.getString("ubicacion");
				precio = rs.getFloat("precionoche");
				Hotel hotel=new Hotel();
				hotel.setNombre(nombre);
				hotel.setUbicacion(ubicacion);
				hotel.setPrecioNoche(precio);
				System.out.println(hotel.getNombre());
				hoteles.add(hotel);
			}
			
		return hoteles;

	}
	

	public ArrayList<Hotel> buscarUbicacion(String ubicacion) throws SQLException{
		String nombre="";
		ArrayList<Hotel> hoteles =new ArrayList<Hotel>();
		
		String query="select cod_hotel,nombre,ubicacion,precionoche from hotel where ubicacion='"+ubicacion+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		System.out.println(ubicacion);
		while(rs.next()) {
				codhotel=rs.getInt("cod_hotel");
				nombre = rs.getString("nombre");
				ubicacion = rs.getString("ubicacion");
				float precio = rs.getFloat("precionoche");
				hotel=new Hotel();
				hotel.setCod_hotel(codhotel);
				hotel.setNombre(nombre);
				hotel.setUbicacion(ubicacion);
				hotel.setPrecioNoche(precio);
				hoteles.add(hotel);
		}
		return hoteles;
	}
	public ArrayList<estanciaHotel> leerEstancias(int codhotel) throws SQLException{
		String categoria="";
		float precio=0;
		int existencia;
		ArrayList<estanciaHotel> estancias =new ArrayList<estanciaHotel>();
		
		String query="select categoria,existencias,tarifa from estanciaHotel where cod_hotel='"+codhotel+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			categoria = rs.getString("categoria");
			precio = rs.getFloat("tarifa");
			existencia=rs.getInt("existencias");
			 estancia=new estanciaHotel();
			estancia.setCategoria(categoria);
			estancia.setExistencias(existencia);
			estancia.setTarifa(precio);
			estancias.add(estancia);
		}
		return estancias;
	}
	
	////////////////
	
	public ArrayList<Hotel> leerHoteles2(ArrayList<Hotel> listaHoteles) throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		String nombre="";
		String ubicacion="";
		float precio=0;

		String query="select nombre, ubicacion, precionoche from hotel;";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		while(rs.next()) {
				
				nombre = rs.getString("nombre");
				ubicacion = rs.getString("ubicacion");
				precio = rs.getFloat("precionoche");
				Hotel hotel=new Hotel();
				hotel.setNombre(nombre);
				hotel.setUbicacion(ubicacion);
				hotel.setPrecioNoche(precio);
				
				System.out.println(hotel.getNombre());
				listaHoteles.add(hotel);
			}
			
		return listaHoteles;

	}
	
	
}
