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
	
	
	public FuncionesHotel() { 
		
		alojamientos=new ArrayList<Alojamiento>();
		Hotel pezEspada = new Hotel(1,50,100, "Hotel Pez Espada", "M�laga",50,5);
		alojamientos.add(pezEspada);
		Hotel triton = new Hotel(1,50,100, "Hotel Trit�n", "M�laga",50,5);
		alojamientos.add(triton);
		Hotel tropicana = new Hotel(1,50,100, "Hotel Tropicana", "M�laga",50,5);
		alojamientos.add(tropicana);
	}
	
	
	
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
				hotel.setTarifa(precio);
				System.out.println(hotel.getNombre());
				hoteles.add(hotel);
			}
			
		return hoteles;

	}


	public ArrayList<Hotel> buscarUbicacion(String ubicacion) throws SQLException{
		String nombre="";
		float precio=0;
		ArrayList<Hotel> hoteles =new ArrayList<Hotel>();
		
		String query="select*from hotel where ubicacion='"+ubicacion+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			nombre = rs.getString("nombre");
			ubicacion = rs.getString("ubicacion");
			precio = rs.getFloat("precionoche");
			Hotel hotel=new Hotel();
			hotel.setNombre(nombre);
			hotel.setUbicacion(ubicacion);
			hotel.setTarifa(precio);
			hoteles.add(hotel);
		}
		
		
	return hoteles;
		
		
	

	
	}
}
