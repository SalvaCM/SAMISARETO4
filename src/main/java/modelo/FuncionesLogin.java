package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import conexion.ConexionBD;
import conexion.ConsultaBD;



public class FuncionesLogin {
	
	private Cliente cliente;


	public Cliente LogearUser (String DNI, char[] password) throws Exception {
		
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.ConectarBD();
		
		String nombre;
		String apellido;
		Date fechaNacimiento;
		
    	//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select * from clientes where DNI = '" + DNI + "';");
		
		while(rs.next()) {
			
				cliente = new Cliente();
				nombre = rs.getString("Nombre");
				apellido = rs.getString("Apellido");
				fechaNacimiento = rs.getDate("Fecha_nacimiento");
				cliente.setDni(DNI);
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setFechaNacimiento(fechaNacimiento);
			
		}
		return cliente;
	} 
	
	public boolean comprobarPasword(String DNI, char[] pass) throws Exception {
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.ConectarBD();
		String passwordEncriptada = "";
		boolean devuelve = false;
		
		//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select Contrasena from clientes where DNI = '" + DNI + "';");
		while(rs.next()) {
			passwordEncriptada = rs.getString("Contrasena");
		}
		
		String pass1 = DigestUtils.md5Hex(String.valueOf(pass));

		if(pass1.equals(passwordEncriptada)) {
			devuelve= true;
		}else {
			devuelve= false;
		}
			
		
		return devuelve;
		
		
		
	}
	
	

}
