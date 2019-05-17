package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionBD;
import conexion.ConsultaBD;

public class FuncionesServicios {
	
	ConexionBD miConexion = new ConexionBD();
	ConsultaBD miConsulta = new ConsultaBD();
	Connection con = miConexion.ConectarBD();
	
	public ArrayList<Casa> serviciosCasa (boolean parking, boolean piscina, boolean gimnasio, boolean wifi, boolean spa) throws SQLException{
		
    	//Declaracion e incializacion de variables
		ArrayList<Casa> casas =new ArrayList<Casa>();
		String cod_parking=null;
		String cod_piscina=null;
		String cod_gimnasio=null;
		String cod_wifi=null;
		String cod_spa=null;
		int codcasa ;
		String nombre ;
		String ubicacion ;
		int tamano ;
		float precio ;
		
		
		// Inicio
			
			if(parking == true) {
				
				cod_parking="1";
				String query="select c.COD_CASA, c.NOMBRE,c.UBICACION, c.TAMANO, c.PRECIO from servicios_casa s, casa c where s.cod_servicio in ('" + cod_parking + "');";
				ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
				Casa casa;
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
			}}
			if(piscina == true) {
				
				cod_piscina="2";
				String query2="select c.COD_CASA, c.NOMBRE,c.UBICACION, c.TAMANO, c.PRECIO from servicios_casa s, casa c where s.cod_servicio in ('" + cod_piscina + "');";
				ResultSet rs2 = miConsulta.hacerConsultaBD(con, query2);	
				Casa casa2;
				while(rs2.next()) {
					casa2=new Casa();
					
				    codcasa = rs2.getInt("cod_casa");
					nombre = rs2.getString("nombre");
					ubicacion = rs2.getString("ubicacion");
					tamano = rs2.getInt("tamano");
					precio = rs2.getFloat("precio");
						
					casa2.setCod_casa(codcasa);
					casa2.setNombre(nombre);
					casa2.setUbicacion(ubicacion);
					casa2.setTamano(tamano); 
					casa2.setPrecio(precio);
					casas.add(casa2);
			}}
			if(gimnasio == true) {
				
				cod_gimnasio="3";
			}
			if(wifi == true) {
				
				cod_wifi="4";
			}
			if(spa == true) {
				
				cod_spa="5";
			}
			
		return casas; 
	}
	
}