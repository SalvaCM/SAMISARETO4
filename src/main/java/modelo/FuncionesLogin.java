package modelo;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexion.ConexionBD;
import conexion.ConsultaBD;
import vista.Ventana;


public class FuncionesLogin {
	
	private Cliente cliente;
	private Ventana miVentana;

	public Cliente comprobarDNIyContrasena (String DNI, char[] contrasena) throws Exception {
		
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
				
				JOptionPane.showMessageDialog(miVentana, "Contrasena incorrecta", "¡Atención!", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		return cliente; 
	} 
	

	public boolean comprobarContrasena (String DNI, char[] contrasena) throws Exception {
		
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.ConectarBD();
		
		String contrasenia = "";
		char[] cadena = null;
		
		//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select contrasena from cliente where DNI = '" + DNI + "';");
		
		while(rs.next()) {
			contrasenia = rs.getString("contrasena");
		}
		
		for(int i=0; i<contrasenia.length();i++) {
		 cadena = contrasenia.toCharArray();
		}
		
		if(cadena == contrasena)
			return true;
		else
			return false;
	}

}
