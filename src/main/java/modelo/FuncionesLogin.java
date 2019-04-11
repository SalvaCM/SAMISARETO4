package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import conexion.ConexionBD;
import conexion.ConsultaBD;


public class FuncionesLogin {
	
	public Cliente cliente;

	public Cliente comprobarDNIyContraseña (String DNI, String contrasena) throws Exception {
		
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.ConectarBD();
		
		String nombre;
		String apellido;
		String fechaNacimiento;
		
    	//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select * from cliente where DNI = '" + DNI + "';");
		
		while(rs.next()) {

			if(comprobarContrasena(DNI, contrasena)) {
				
				nombre = rs.getString("Nombre");
				apellido = rs.getString("Apellidos");
				fechaNacimiento = rs.getString("Fecha_nacimiento");
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setFechaNacimiento(fechaNacimiento);
				
				
				
			}else {
				
				System.out.println("Error contraseña incorrecta");
			}
			
		}
		
		return cliente; 
	} 
	
	public boolean comprobarContrasena (String DNI, String contrasena) throws Exception {
		
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.ConectarBD();
		
		String contrasenia = "";
		
		//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select contrasena from cliente where DNI = '" + DNI + "';");
		
		while(rs.next()) {
			contrasenia = rs.getString("contrasena");
		}
		
		if(contrasena.equals(contrasenia)) 
			return true;
		else
			return false;
	}

}
