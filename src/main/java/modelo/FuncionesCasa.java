package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
	/*public boolean casaOcupada (int cod, Date fida,Date fvuelta) throws SQLException{ 
    	//Declaracion e incializacion de variables
	
		boolean r = false;
		Date f1 = null;
		Date f2 = null;
		String query="select fechaEntrada,fechaSalida from reservas where cod_casa='"+cod+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		while(rs.next()) {
				
				
				f1 = rs.getDate("fechaEntrada");
				f2= rs.getDate("fechaSalida");
				
			}

		//System.out.println("FECHA ENTRADA:  "+f1.getTime()+" | "+fida.getTime());
	
		
	
	 if(f2==null || f1==null) {
			r=false;
		}else {
			if((fvuelta.compareTo(f1)>=0 && fida.compareTo(f2)<=0)) {
				//JOptionPane.showMessageDialog(miVentana, "Ocupado entre fechas  "+f1+"  y  "+f2+"", "Atencion!", JOptionPane.WARNING_MESSAGE);
				r=true;
			}
		}
		
       return r;
	}
	/*public ArrayList rangoFechas(int cod, Date fida,Date fvuelta) throws SQLException{ 
    	//Declaracion e incializacion de variables
	
		ArrayList<String> fechas = new ArrayList<String>();
		Date f1 = null;
		Date f2 = null;
		String query="select fechaEntrada,fechaSalida from reservas where cod_casa='"+cod+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		while(rs.next()) {
				
				
				f1 = rs.getDate("fechaEntrada");
				f2= rs.getDate("fechaSalida");
				
			}

		fechas.add(f1.toString());
		fechas.add(f2.toString());
	
		
	
	 
		
       return fechas;
	}
	*/

	
	}
	

