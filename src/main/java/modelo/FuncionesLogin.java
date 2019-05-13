package modelo;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;

import conexion.ConexionBD;
import conexion.ConsultaBD;
import vista.Ventana;



public class FuncionesLogin {
	
	private Cliente cliente;
	private Ventana miVentana;

	public Cliente LogearUser (String DNI, char[] password) throws Exception {


		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.ConectarBD();
		
		String nombre;
		String apellido;
		Date fechaNacimiento;
		int cod;
		
    	//Inicio del programa
		String DniEncriptado=encriptar(DNI);
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select * from clientes where DNI = '" + DniEncriptado + "';");
		
		while(rs.next()) {
			
				cliente = new Cliente();
				cod=rs.getInt("cod_cliente");
				nombre = rs.getString("Nombre");
				apellido = rs.getString("Apellido");
				fechaNacimiento = rs.getDate("Fecha_nacimiento");
				String nomDesencriptado = desencriptar(nombre);
				String apeDesencriptado = desencriptar(apellido);		
				cliente.setCodCliente(cod);
				cliente.setDni(DNI);
				cliente.setNombre(nomDesencriptado);
				cliente.setApellido(apeDesencriptado);
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
		String dniEncriptado = encriptar(DNI);
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select Contrasena from clientes where DNI = '" + dniEncriptado + "';");
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
	public void cambiarContrasena(String passwordNueva, Cliente cliente) throws UnsupportedEncodingException {
		//Declaraci�n e inicializaci�n de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		String dniEncriptado = encriptar(cliente.getDni());
		String query = "UPDATE clientes SET contrasena = '" + passwordNueva +"' WHERE dni='" + dniEncriptado + "';";
		
		if (miConsulta.insertarDatosBD(con, query)) {
			JOptionPane.showMessageDialog(miVentana, "Password Cambiada con �xito", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
			cliente.setContrasena(passwordNueva);
		}
	}
	
	public static String encriptar(String cadena) throws UnsupportedEncodingException 
	{
		 	String cadenaEncriptada = Base64.getEncoder().encodeToString(cadena.toString().getBytes());
		 	System.out.println(cadena + " encriptando = " + cadenaEncriptada);
		 	 
		 	return cadenaEncriptada;
	}
	  
	public static String desencriptar(String cadenaEncriptada)
	{
	 
		  byte[] byteArray = Base64.getDecoder().decode(cadenaEncriptada);
		 
		  String cadenaDesencriptada = new String(byteArray);
		 
		  System.out.println(cadenaEncriptada + " desencriptando = " + cadenaDesencriptada);
		    
		 
		return cadenaDesencriptada;
		
	  }
}