package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import conexion.ConexionBD;
import conexion.ConsultaBD;

public class FuncionesApartamento {
	
	public Apartamento apartamento;

 	ConexionBD miConexion = new ConexionBD();
	ConsultaBD miConsulta = new ConsultaBD();
	Connection con = miConexion.ConectarBD();

 	public ArrayList<Apartamento> leerApartamento() throws SQLException{ 
    	//Declaracion e incializacion de variables

 		String nombre="";	
		String ubicacion=""; 
		int codapartamento;
		int tamano;
		float precio;
		int piso;

 		ArrayList<Apartamento> apartamentos =new ArrayList<Apartamento>();

 		// Inicio

 		String query="select * from apartamento;";

 		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	

 		while(rs.next()) {
							apartamento=new Apartamento();

 							codapartamento = rs.getInt("cod_apartamento");
							nombre = rs.getString("nombre");
							ubicacion = rs.getString("ubicacion");
							tamano = rs.getInt("tamano");
							precio = rs.getFloat("precio");
							piso = rs.getInt("piso");
							
 							apartamento.setCod_apartamento(codapartamento);
							apartamento.setNombre(nombre);
							apartamento.setUbicacion(ubicacion);
							apartamento.setTamano(tamano);
							apartamento.setPrecio(precio);
							apartamento.setPiso(piso);

 							apartamentos.add(apartamento);
				}

 		return apartamentos;

 	}

 	public ArrayList<String> mostrarUbicaciones () throws SQLException{ 
    	//Declaracion e incializacion de variables

 		String ubicacion="";
		ArrayList<String> ubicaciones =new ArrayList<String>();
		String query="select distinct ubicacion from apartamento;";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	

 		while(rs.next()) {		
				ubicacion = rs.getString("ubicacion");
				ubicaciones.add(ubicacion);
			}

 		return ubicaciones;

 	}

 	public ArrayList<Apartamento> buscarUbicacion(String ubicacion) throws SQLException{

 		String nombre="";	
		int codapartamento;
		int tamano;
		float precio;
		int piso;


 		ArrayList<Apartamento> apartamentos =new ArrayList<Apartamento>();


 		String query="select * from apartamento where ubicacion='"+ubicacion+"';";

 		ResultSet rs = miConsulta.hacerConsultaBD(con, query);

 		while(rs.next()) {

 			apartamento=new Apartamento();

 			codapartamento = rs.getInt("cod_apartamento");
			nombre = rs.getString("nombre");
			ubicacion = rs.getString("ubicacion");
			tamano = rs.getInt("tamano");
			precio = rs.getFloat("precio");
			piso = rs.getInt("piso");

 			apartamento.setCod_apartamento(codapartamento);
			apartamento.setNombre(nombre);
			apartamento.setUbicacion(ubicacion);
			apartamento.setTamano(tamano);
			apartamento.setPrecio(precio);
			apartamento.setPiso(piso);

 			apartamentos.add(apartamento);
		}

 		return apartamentos;
	}
 	
}
