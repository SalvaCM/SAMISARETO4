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
public ArrayList<Hotel> serviciosHotel (boolean parking, boolean piscina, boolean gimnasio, boolean wifi, boolean spa) throws SQLException{
		
    	//Declaracion e incializacion de variables
		ArrayList<Hotel> hotelesF =new ArrayList<Hotel>();
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
		Hotel hotelF;
		
		
		// Inicio
			
			if(parking == true) {
				
				cod_parking="1";
			}
			 if(piscina == true) {
				cod_piscina="2";
				}
			 if(gimnasio == true) {
				
				cod_gimnasio="3";
			}
			if(wifi == true) {
				
				cod_wifi="4";
			}
			if(spa == true) {
				
				cod_spa="5";
			}
			String query="select DISTINCT h.cod_hotel,h.nombre,h.ubicacion, h.nestrellas from hotel h, servicios_hotel s where h.cod_hotel=s.cod_hotel and h.cod_hotel in (select  cod_hotel from servicios_hotel where cod_servicio='"+cod_parking+"' or cod_servicio='"+cod_piscina+"' or cod_servicio='"+cod_wifi+"' or cod_servicio='"+cod_gimnasio+"' or cod_servicio='"+cod_spa+"');";
		
			ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
			while(rs.next()) {
								hotelF=new Hotel();
								int codhotel = rs.getInt("cod_hotel");
								nombre = rs.getString("nombre");
								ubicacion = rs.getString("ubicacion");
							int 	nEstrellas = rs.getInt("nestrellas");
								hotelF.setCod_hotel(codhotel);
								hotelF.setNombre(nombre);
								hotelF.setUbicacion(ubicacion);
								hotelF.setnEstrellas(nEstrellas);
								
								hotelesF.add(hotelF);
				}
			
			
		return hotelesF; 
	}
public int adicionH (int codhotel,boolean parking,boolean piscina,boolean gimnasio, boolean wifi, boolean spa) throws SQLException{
		
    	//Declaracion e incializacion de variables
		String cod_parking=null;
		String cod_piscina=null;
	
		String cod_gimnasio=null;
		String cod_wifi=null;
		String cod_spa=null;
		int adicion = 0; 
		
		if(parking == true) {
			System.out.println("1");
			cod_parking="1";
		}
		 if(piscina == true) {
			cod_piscina="2";
			System.out.println("2");
			}
		 if(gimnasio == true) {
				
				cod_gimnasio="3";
			}
			if(wifi == true) {
				
				cod_wifi="4";
			}
			if(spa == true) {
				
				cod_spa="5";
			}
		
			String query="select sum(precio) i from servicios_hotel sh, servicios_adicionales sa where sh.cod_servicio=sa.cod_servicio and cod_hotel='"+codhotel+"' and (sa.cod_servicio='"+cod_parking+"' or sa.cod_servicio='"+cod_piscina+"' or sa.cod_servicio='"+cod_wifi+"' or sa.cod_servicio='"+cod_gimnasio+"' or sa.cod_servicio='"+cod_spa+"');";
			ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
			while(rs.next()) {
								
					adicion = rs.getInt("i");
					System.out.println("qadicion"+adicion);
								
				}
			
			
		return adicion; 
	}
	
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
			}
			if(piscina == true) {
				
				cod_piscina="2";
				
				}
			if(gimnasio == true) {
				
				cod_gimnasio="3";
			}
			if(wifi == true) {
				
				cod_wifi="4";
			}
			if(spa == true) {
				
				cod_spa="5";
			}
			String query2="select DISTINCT c.cod_casa,c.nombre,c.ubicacion,c.tamano, c.precio from casa c, servicios_casa s where c.cod_casa=s.cod_casa and c.cod_casa in (select  cod_casa from servicios_casa where cod_servicio='"+cod_parking+"' or cod_servicio='"+cod_piscina+"' or  cod_servicio='"+cod_wifi+"' or cod_servicio='"+cod_gimnasio+"' or  cod_servicio='"+cod_spa+"');";
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
		}
		return casas; 
	}
public int adicionC(int codcasa,boolean parking,boolean piscina,boolean gimnasio, boolean wifi, boolean spa) throws SQLException{
		
    	//Declaracion e incializacion de variables
		String cod_parking=null;
		String cod_piscina=null;
	
		String cod_gimnasio=null;
		String cod_wifi=null;
		String cod_spa=null;
		int adicion = 0; 
		
		if(parking == true) {
			System.out.println("1");
			cod_parking="1";
		}
		 if(piscina == true) {
			cod_piscina="2";
			System.out.println("2");
			}
		 if(gimnasio == true) {
				
				cod_gimnasio="3";
			}
			if(wifi == true) {
				
				cod_wifi="4";
			}
			if(spa == true) {
				
				cod_spa="5";
			}
		
			String query="select sum(precio) i from servicios_casa sc, servicios_adicionales sa where sc.cod_servicio=sa.cod_servicio and cod_casa='"+codcasa+"' and (sa.cod_servicio='"+cod_parking+"' or sa.cod_servicio='"+cod_piscina+"' or  sa.cod_servicio='"+cod_wifi+"' or sa.cod_servicio='"+cod_gimnasio+"' or sa.cod_servicio='"+cod_spa+"');";
			ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
			while(rs.next()) {
								
					adicion = rs.getInt("i");
					System.out.println("qadicion"+adicion);
								
				}
			
			
		return adicion; 
	}
public ArrayList<Apartamento> serviciosApart (boolean parking, boolean piscina, boolean gimnasio, boolean wifi, boolean spa) throws SQLException{
		
    	//Declaracion e incializacion de variables
		ArrayList<Apartamento> apartamentos =new ArrayList<Apartamento>();
		String cod_parking=null;
		String cod_piscina=null;
		String cod_gimnasio=null;
		String cod_wifi=null;
		String cod_spa=null;
		int codcasa ;
		int piso;
		String nombre ;
		String ubicacion ;
		int tamano ;
		float precio ;
		
		
		// Inicio
			
			if(parking == true) {
				
				cod_parking="1";
			}
			if(piscina == true) {
				
				cod_piscina="2";
				
				}
			if(gimnasio == true) {
				
				cod_gimnasio="3";
			}
			if(wifi == true) {
				
				cod_wifi="4";
			}
			if(spa == true) {
				
				cod_spa="5";
			}
			String query2="select DISTINCT a.cod_apartamento,a.nombre,a.ubicacion,a.tamano, a.precio,a.piso from apartamento a, servicios_apartamento s where a.cod_apartamento=s.cod_apartamento and a.cod_apartamento in (select  cod_apartamento from servicios_apartamento where cod_servicio='"+cod_parking+"' or cod_servicio='"+cod_piscina+"' or  cod_servicio='"+cod_wifi+"' or cod_servicio='"+cod_gimnasio+"' or  cod_servicio='"+cod_spa+"');";
			ResultSet rs = miConsulta.hacerConsultaBD(con, query2);	
			Apartamento apartamento;
			while(rs.next()) {
				apartamento=new Apartamento();
				
				codcasa = rs.getInt("cod_apartamento");
				nombre = rs.getString("nombre");
				ubicacion = rs.getString("ubicacion");
				tamano = rs.getInt("tamano");
				precio = rs.getFloat("precio");
				piso = rs.getInt("piso");
					
				apartamento.setCod_apartamento(codcasa);
				apartamento.setNombre(nombre);
				apartamento.setUbicacion(ubicacion);
				apartamento.setTamano(tamano); 
				apartamento.setPrecio(precio);
				apartamento.setPiso(piso);
				apartamentos.add(apartamento);
		}
		return apartamentos; 
	}
public int adicionA(int codapart,boolean parking,boolean piscina,boolean gimnasio, boolean wifi, boolean spa) throws SQLException{
	
	//Declaracion e incializacion de variables
	String cod_parking=null;
	String cod_piscina=null;

	String cod_gimnasio=null;
	String cod_wifi=null;
	String cod_spa=null;
	int adicion = 0; 
	
	if(parking == true) {
		System.out.println("1");
		cod_parking="1";
	}
	 if(piscina == true) {
		cod_piscina="2";
		System.out.println("2");
		}
	 if(gimnasio == true) {
			
			cod_gimnasio="3";
		}
		if(wifi == true) {
			
			cod_wifi="4";
		}
		if(spa == true) {
			
			cod_spa="5";
		}
	
		String query="select sum(precio) i from servicios_apartamento sc, servicios_adicionales sa where sc.cod_servicio=sa.cod_servicio and cod_apartamento='"+codapart+"' and (sa.cod_servicio='"+cod_parking+"' or sa.cod_servicio='"+cod_piscina+"' or  sa.cod_servicio='"+cod_wifi+"' or sa.cod_servicio='"+cod_gimnasio+"' or sa.cod_servicio='"+cod_spa+"');";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		while(rs.next()) {
							
				adicion = rs.getInt("i");
				System.out.println("qadicion"+adicion);
							
			}
		
		
	return adicion; 
}
	
}