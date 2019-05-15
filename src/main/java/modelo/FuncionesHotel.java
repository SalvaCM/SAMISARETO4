package modelo;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import conexion.ConexionBD;
import conexion.ConsultaBD;
import vista.Ventana;


public class FuncionesHotel {
	
	public Hotel hotel;
	public HabitacionHotel habitacion;
	public Cama cama;
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
		
		
		String query="select cod_hotel,nombre,ubicacion, nestrellas from hotel   where cod_hotel not in (select reservas_hotel.cod_hotel from reservas_hotel);";
	

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
				
		
					ArrayList<Hotel> hotelesOrden=leerHotelesOrden();
					hotelesOrden.addAll(hoteles);
		return hotelesOrden;

	}
	public ArrayList<Hotel> leerHotelesOrden() throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		String nombre="";	String ubicacion="";	int nEstrellas=0; int codhotel;
		ArrayList<Hotel> hoteles2 =new ArrayList<Hotel>();
		
		// Inicio
		
		String query="select h.cod_hotel,h.nombre,h.ubicacion, h.nestrellas from hotel h ,reservas_hotel r where h.cod_hotel=r.cod_hotel  group by r.cod_hotel order by count(r.cod_hotel) desc; ";
		
	

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
							hoteles2.add(hotel);
						}
				
		
		
		return hoteles2;

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
	/**
	 * Metodo para buscar los las habitaciones de un hotel determinado, devuelve un array con todos las habitaciones
	 */
	
	public ArrayList<HabitacionHotel> leerHabitaciones(int codhotel) throws SQLException{
		String tipo="";
		float precio=0;
		int codHabitacion;
		int tamano;
		ArrayList<HabitacionHotel> habitaciones =new ArrayList<HabitacionHotel>();
		
		String query="select cod_habitacion,tipo,precio,tamano from habitacion_Hotel where cod_hotel='"+codhotel+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			codHabitacion = rs.getInt("cod_habitacion");
			tipo = rs.getString("tipo");
			precio = rs.getFloat("precio");
			tamano=rs.getInt("tamano");
			habitacion =new HabitacionHotel();
			habitacion.setCodHabitacion(codHabitacion);
			habitacion.setTipo(tipo);
			habitacion.setPrecio(precio);
			habitacion.setTamano(tamano);
			habitaciones.add(habitacion);
		}
		return habitaciones;
	}
	public ArrayList<Cama> leerCamas(int codHabitacion) throws SQLException{
		String tipocama="";
		int npersonas;
		ArrayList<Cama> camas =new ArrayList<Cama>();
		
		String query="select a.cod_tipocama,a.tipocama,a.n_personas from cama a,habitacion_cama h where a.cod_tipocama=h.COD_TIPOCAMA and h.cod_habitacion='"+codHabitacion+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		while(rs.next()) {
			tipocama = rs.getString("tipocama");
			npersonas=rs.getInt("n_personas");
			cama =new Cama();
			cama.setTipoCama(tipocama);
			cama.setnPersonas(npersonas);
			camas.add(cama);
		}
		return camas;
	}
	/**
	 *  BUSCA UNA HABITACION Y LA A�ADE AL ARRAY DE RESERVAS
	 */
	// AQUI SOLO LEEMOS LA HABITACION DONDE ESTA ESE CODIGO, PERO NO SE RESERVA COMO TAL, SOLO A NIVEL DE PROGRAMA NO DE BASE DE DATOS
	public HabitacionHotel reservarHabitacion(int cod_habitacion) throws SQLException{
		String tipo="";
		int tamano;
		float precio=0;
		int codHabitacion;
		habitacion =new HabitacionHotel();
		String query="select cod_habitacion,tipo,precio,tamano from habitacion_Hotel where cod_habitacion='"+cod_habitacion+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			codHabitacion = rs.getInt("cod_habitacion");
			tipo = rs.getString("tipo");
			precio = rs.getFloat("precio");
			tamano=rs.getInt("tamano");
			habitacion.setCodHabitacion(codHabitacion);
			habitacion.setTipo(tipo);
			habitacion.setTamano(tamano);
			habitacion.setPrecio(precio);
		}
		return habitacion;
	}
	/**
	 *  LEE DE LA BASE DE DATOS LAS UBICACIONES DE LOS HOTELES Y LAS HACE DISPONIBLES PARA SELECCIONAR EN ESE FILTRO
	 */
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
	public boolean habitaOcupada (int cod, Date fida,Date fvuelta) throws SQLException{ 
    	//Declaracion e incializacion de variables
	
		boolean r = false;

		Date fechaEntrada = null;
		Date fechaSalida = null;

		String query="select fechaEntrada,fechaSalida from reservas_hotel where cod_habitacion='"+cod+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		while(rs.next()) {
				fechaEntrada = rs.getDate("fechaEntrada");
				fechaSalida= rs.getDate("fechaSalida");			
			}
		System.out.println("Resultado de la select"+fechaEntrada);
	 if(fechaSalida==null || fechaEntrada==null) {
			r=false;
		}else {
			if((fvuelta.compareTo(fechaEntrada)>=0 && fida.compareTo(fechaSalida)<=0)) {
				//JOptionPane.showMessageDialog(miVentana, "Ocupado entre fechas  "+f1+"  y  "+f2+"", "Atencion!", JOptionPane.WARNING_MESSAGE);
				r=true;
			}
		}
		
       return r;
	}


	
}
