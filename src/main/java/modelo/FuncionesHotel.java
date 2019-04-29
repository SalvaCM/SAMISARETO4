package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexion.ConexionBD;
import conexion.ConsultaBD;
import vista.Ventana;


public class FuncionesHotel {
	
	public Hotel hotel;
	public HabitacionHotel habitacion;
	private Ventana miVentana;
	
	
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
	
	
				if(con != null) {
					ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
					while(rs.next()) {
							hotel=new Hotel();
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
				}else {
					JOptionPane.showMessageDialog(miVentana, "ERROR DE CONEXION", "Atencion!", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
		
			
		return hoteles;

	}
	/**
	 * Metodo para buscar los hoteles  por su UBICACION en la DB, devuelve un array con todos los hoteles.
	 */

	public ArrayList<Hotel> buscarUbicacion(String ubicacion) throws SQLException{
		String nombre=""; int codhotel;int nEstrellas ;
		ArrayList<Hotel> hoteles =new ArrayList<Hotel>();
		
		
		String query="select cod_hotel,nombre,ubicacion,nestrellas from hotel where ubicacion='"+ubicacion+"';";
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		while(rs.next()) {
				codhotel=rs.getInt("cod_hotel");
				nombre = rs.getString("nombre");
				ubicacion = rs.getString("ubicacion");
				nEstrellas = rs.getInt("nestrellas");
				hotel=new Hotel();
				hotel.setCod_hotel(codhotel);
				hotel.setNombre(nombre);
				hotel.setUbicacion(ubicacion);
				hotel.setnEstrellas(nEstrellas);
				hoteles.add(hotel);
		}
		return hoteles;
	}

	
	public ArrayList<HabitacionHotel> leerHabitaciones(int codhotel) throws SQLException{
		String tipo="";
		float precio=0;
		int nCamas;
		int codHabitacion;
		int tamano;
		boolean ocupada;
		ArrayList<HabitacionHotel> habitaciones =new ArrayList<HabitacionHotel>();
		
		String query="select codhabitacion,tipo,precio,ncamas,tamano,ocupada from habitacionesHotel where cod_hotel='"+codhotel+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			codHabitacion = rs.getInt("codhabitacion");
			tipo = rs.getString("tipo");
			precio = rs.getFloat("precio");
			nCamas=rs.getInt("ncamas");
			tamano=rs.getInt("tamano");
			ocupada=rs.getBoolean("ocupada");
			habitacion =new HabitacionHotel();
			habitacion.setCodHabitacion(codHabitacion);
			habitacion.setTipo(tipo);
			habitacion.setnCamas(nCamas);
			habitacion.setPrecio(precio);
			habitacion.setOcupada(ocupada);
			habitacion.setTamano(tamano);
			habitaciones.add(habitacion);
			System.out.println(habitacion.toString());
		}
		return habitaciones;
	}
	// AQUI SOLO LEEMOS LA HABITACION DONDE ESTA ESE CODIGO, PERO NO SE RESERVA COMO TAL, SOLO A NIVEL DE PROGRAMA NO DE BASE DE DATOS
	public HabitacionHotel reservarHabitacion(int cod_habitacion) throws SQLException{
		String tipo="";
		int tamano;
		boolean ocupada;
		float precio=0;
		int nCamas;
		int codHabitacion;
		habitacion =new HabitacionHotel();
		String query="select codhabitacion,tipo,precio,tamano,ncamas,ocupada from habitacionesHotel where codhabitacion='"+cod_habitacion+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			codHabitacion = rs.getInt("codhabitacion");
			tipo = rs.getString("tipo");
			precio = rs.getFloat("precio");
			nCamas=rs.getInt("ncamas");
			tamano=rs.getInt("tamano");
			ocupada=rs.getBoolean("ocupada");
			habitacion.setCodHabitacion(codHabitacion);
			habitacion.setTipo(tipo);
			habitacion.setTamano(tamano);
			habitacion.setnCamas(nCamas);
			habitacion.setPrecio(precio);
			habitacion.setOcupada(ocupada);
		}
		return habitacion;
	}
	public ArrayList<String> mostrarUbicaciones () throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		String ubicacion="";
		ArrayList<String> ubicaciones =new ArrayList<String>();
		String query="select distinct  ubicacion from hotel;";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		while(rs.next()) {
				
				
				ubicacion = rs.getString("ubicacion");
				
				ubicaciones.add(ubicacion);
			}
			
		return ubicaciones;

	}


	
}
