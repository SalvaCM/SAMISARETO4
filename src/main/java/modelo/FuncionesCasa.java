package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexion.ConexionBD;
import conexion.ConsultaBD;

public class FuncionesCasa {
	
	public Casa casa;



	ConexionBD miConexion = new ConexionBD();
	ConsultaBD miConsulta = new ConsultaBD();
	Connection con = miConexion.ConectarBD();

	/**
	 * Leer de la base de datos las casas que no estan en la tabla reservas
	 * @return ArrayList de casas no reservadas
	 * @throws SQLException
	 */
	public ArrayList<Casa> leerCasa() throws SQLException{ 
    	//Declaracion e incializacion de variables	    

				String nombre="";
				String ubicacion=""; 
				int codcasa;
				int tamano;
				float precio;

 				ArrayList<Casa> casas =new ArrayList<Casa>();


 				// Inicio			

				String query="SELECT `COD_CASA`, `NOMBRE`, `UBICACION`, `TAMANO`, `PRECIO` FROM casa where cod_casa NOT IN (select reserva_casa.cod_casa from reserva_casa);";
					
				ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
				
 					while(rs.next()) {
							casa=new Casa();
								
							codcasa = rs.getInt("cod_casa");
							nombre = rs.getString("nombre");
							ubicacion = rs.getString("ubicacion");
							tamano = rs.getInt("tamano");
							precio = rs.getFloat("precio");
								
 							casa.setCod_casa(codcasa);
							casa.setNombre(nombre);
							casa.setUbicacion(ubicacion);
							casa.setTamano(tamano); 
							casa.setPrecio(precio);
							casas.add(casa);
							
						}	
 									
 					ArrayList<Casa> casasOrden=leerCasaOrden();
 					casasOrden.addAll(casas);
 					return casasOrden;

 		}
	/**
	 * Lee de la base de datos todas habitaciones de la casa que desee, excepto los dormitorios
	 * @param codCasa
	 * @return ArrayList de todas las habitaciones de esa casa
	 * @throws SQLException
	 */
	public ArrayList<Habitacion> leerHabitaciones(int codCasa) throws SQLException{
		String tipo="";
		int codHabitacion;
		int tamano;
		ArrayList<Habitacion> habitaciones =new ArrayList<Habitacion>();
		
		String query="select h.cod_habitacion,h.tipo,h.tamano from habitacion h,habitacion_casa hc where hc.cod_casa='"+codCasa+"' and hc.cod_habitacion=h.cod_habitacion;";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			codHabitacion = rs.getInt("cod_habitacion");
			tipo = rs.getString("tipo");
			tamano=rs.getInt("tamano");
			Habitacion habitacion =new Habitacion();
			habitacion.setCodHabitacion(codHabitacion);
			habitacion.setTipo(tipo);
			habitacion.setTamano(tamano);
			habitaciones.add(habitacion);
		}
		return habitaciones;
	}
	/**
	 * Lee de la base de datos todos los dormitorios de la casa que desee
	 * @param codCasa
	 * @return ArrayList de los dormitorios de esa casa
	 * @throws SQLException
	 */
	public ArrayList<Dormitorio> leerDormitorios(int codCasa) throws SQLException{
		String tipo="";
		int codHabitacion;
		int tamano;int capacidad;int nCamas;
		ArrayList<Dormitorio> dormitorios =new ArrayList<Dormitorio>();
		
		String query="select d.cod_dormitorio,d.tipo,d.ncamas,d.capacidad from dormitorio_Casa d where d.cod_casa='"+codCasa+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			codHabitacion = rs.getInt("cod_dormitorio");
			tipo = rs.getString("tipo");
			//tamano=rs.getInt("tamano");
			capacidad=rs.getInt("capacidad");
			nCamas=rs.getInt("nCamas");
			Dormitorio dormitorio =new Dormitorio();
			dormitorio.setCodHabitacion(codHabitacion);
			dormitorio.setTipo(tipo);
			//dormitorio.setTamano(tamano);
			dormitorio.setCapacidad(capacidad);
			dormitorio.setnCamas(nCamas);
			dormitorios.add(dormitorio);
		}
		return dormitorios;
	}
	/**
	 * Lee de la base de datos todas las casas en orden
	 * @return ArrayList de todas las casas
	 * @throws SQLException
	 */
	public ArrayList<Casa> leerCasaOrden() throws SQLException{ 
    	//Declaracion e incializacion de variables	    

				String nombre="";
				String ubicacion=""; 
				int codcasa;
				int tamano;
				float precio;

 				ArrayList<Casa> casas =new ArrayList<Casa>();


 				// Inicio			

				String query="SELECT c.COD_CASA, c.NOMBRE,c.UBICACION, c.TAMANO, c.PRECIO FROM casa c, reserva_casa r where c.cod_casa=r.cod_casa group by r.cod_casa order by count(r.cod_casa);";
					
				ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
				
 					while(rs.next()) {
							casa=new Casa();
								
							codcasa = rs.getInt("cod_casa");
							nombre = rs.getString("nombre");
							ubicacion = rs.getString("ubicacion");
							tamano = rs.getInt("tamano");
							precio = rs.getFloat("precio");
								
 							casa.setCod_casa(codcasa);
							casa.setNombre(nombre);
							casa.setUbicacion(ubicacion);
							casa.setTamano(tamano); 
							casa.setPrecio(precio);
							casas.add(casa);
							
						}	
 									
 					
 					return casas;

 		}



	/**
 	* Muestra todas las ubicaciones de las casas
 	* @return Arraylist de las ubicaciones de las casas
 	* @throws SQLException
 	*/
 	public ArrayList<String> mostrarUbicaciones () throws SQLException{ 
 			
	    //Declaracion e incializacion de variables
 		String ubicacion="";
		ArrayList<String> ubicaciones =new ArrayList<String>();
		
		String query="select distinct ubicacion from casa;";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	

 			while(rs.next()) {		
					ubicacion = rs.getString("ubicacion");
					ubicaciones.add(ubicacion);
				}

 			return ubicaciones;


 	}

	/**
 	 * Busca en la base de datos todas las casas con la ubicacion que desee
 	 * @param ubicacion
 	 * @return ArrayList de todas las casas con esa ubicacion
 	 * @throws SQLException
 	 */
	public ArrayList<Casa> buscarUbicacion(String ubicacion) throws SQLException{

		String nombre="";	 
		int codcasa;
		int tamano;
		float precio;


		ArrayList<Casa> casas =new ArrayList<Casa>();


		String query="select * from casa where ubicacion='"+ubicacion+"';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
			while(rs.next()) {
				casa=new Casa();
					
				codcasa = rs.getInt("cod_casa");
				nombre = rs.getString("nombre");
				ubicacion = rs.getString("ubicacion");
				tamano = rs.getInt("tamano");
				precio = rs.getFloat("precio");
					
				casa.setCod_casa(codcasa);
				casa.setNombre(nombre);
				casa.setUbicacion(ubicacion);
				casa.setTamano(tamano); 
				casa.setPrecio(precio);
				casas.add(casa);
				
			}	
						
			return casas;
		}


	
	}
	

