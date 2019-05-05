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


	public ArrayList<Casa> leerCasa() throws SQLException{ 
    	//Declaracion e incializacion de variables	    

				String nombre="";
				String ubicacion=""; 
				int codcasa;
				int tamano;
				float precio;

 				ArrayList<Casa> casas =new ArrayList<Casa>();


 				// Inicio			

				String query="select * from casa;";
					
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
	

