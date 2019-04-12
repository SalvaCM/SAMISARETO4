package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import conexion.ConexionBD;
import conexion.ConsultaBD;


public class FuncionesRegistro {

	
	public Cliente registrarNuevoCliente(String DNI, String Nombre, String Apellido, Date date2, char[] contrasena) throws SQLException, ParseException {
		
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.ConectarBD();
		
		Cliente cliente;
		String query = "";	
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		query = "INSERT into clientes (DNI,Nombre,Apellido, Fecha_nacimiento, Contrasena) VALUES ('" + DNI + "', '" + Nombre + "', '" + Apellido + "', '" + date2 + "', '" + contrasena + "');";
		
				
		//Comprobar que la insercion de los datos en la BD es correcta
		if (miConsulta.insertarDatosBD(con, query)) {
			cliente = new Cliente(DNI, Nombre, Apellido, date2 , contrasena);		
		} else {
			cliente = null;
		}
				
		return cliente;
		

	}
	
	 
}
