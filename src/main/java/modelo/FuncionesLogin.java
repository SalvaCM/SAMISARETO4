package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JOptionPane;

import conexion.ConexionBD;
import conexion.ConsultaBD;
import vista.Ventana;


public class FuncionesLogin {
	

	private Ventana miVentana;
	private Cliente cliente;

	public Cliente comprobarDNIyContrasena (String DNI, char[] contrasena) throws Exception {
		
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.ConectarBD();
		
		String nombre;
		String apellido;
		Date fechaNacimiento;
		
    	//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select * from cliente where DNI = '" + DNI + "';");
		
		while(rs.next()) {

			if(comprobarContrasena(DNI, contrasena)) {
				
				cliente = new Cliente();
				nombre = rs.getString("Nombre");
				apellido = rs.getString("Apellido");
				fechaNacimiento = rs.getDate("Fecha_nacimiento");
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setFechaNacimiento(fechaNacimiento);
				cliente.setContrasena(contrasena);
					
			}else {
				
				JOptionPane.showMessageDialog(miVentana, "Contrasena incorrecta", "ATENCION", JOptionPane.WARNING_MESSAGE);
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
		boolean devuelve = false;
		
		//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select contrasena from cliente where DNI = '" + DNI + "';");
		
		while(rs.next()) {
			contrasenia = rs.getString("contrasena");
		}
		
		for(int i=0; i<contrasenia.length();i++) {

		 cadena = contrasenia.toCharArray();
		 if(contrasenia.length() == contrasena.length) {
			if(cadena[i] == contrasena[i]) {
				devuelve= true;		
			}
			else {
				devuelve= false;
			}
		 }else {
			 devuelve=false;
		 }
		}
		if(devuelve == true) {
			JOptionPane.showMessageDialog(miVentana, "Contrasena correcta", "ATENCION", JOptionPane.WARNING_MESSAGE);
		}
		return devuelve;
	}

}
