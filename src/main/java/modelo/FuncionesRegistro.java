package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;

import conexion.ConexionBD;
import conexion.ConsultaBD;
import vista.Ventana;


public class FuncionesRegistro {
	
	private Ventana miVentana;

	
	public Cliente registrarNuevoCliente(String DNI, String Nombre, String Apellido, Date date2, char[] contrasena, Date fechaRegistro) throws SQLException, ParseException {
		
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.ConectarBD();
		
		Cliente cliente;
		String query = "";	
		String passwordEncriptada = "";
		
		passwordEncriptada = DigestUtils.md5Hex(String.valueOf(contrasena));
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateN=dateFormat.format(date2);
		String dateR=dateFormat.format(fechaRegistro);
		
		
		query = "INSERT into clientes (DNI,Nombre,Apellido, Fecha_nacimiento, Contrasena,fechaRegistro) VALUES ('" + DNI + "', '" + Nombre + "', '" + Apellido + "', '" + dateN + "', '" + passwordEncriptada + "', '" + dateR + "');";
		
				
		//Comprobar que la insercion de los datos en la BD es correcta
		if (miConsulta.insertarDatosBD(con, query)) {
			passwordEncriptada = DigestUtils.md5Hex(String.valueOf(contrasena));
			cliente = new Cliente(DNI, Nombre, Apellido, date2 , passwordEncriptada);
			System.out.println("contrasena: " +passwordEncriptada);
		} else {
			cliente = null;
		}
				
		return cliente;
		

	}
	
	/**
	 * Valida el campo del DNI.
	 * @param El DNI.
	 * @return Comprueba si el formato del DNI es el correcto.
	 */
	public boolean validarDNI(String dni){
        boolean correcto=false;
        Pattern pattern=Pattern.compile("(\\d{8})([TRWAGMYFPDXBNJZSQVHLCKE])");
        Matcher matcher=pattern.matcher(dni);
        if(matcher.matches()){
            String letra=matcher.group(2);
            String letras="TRWAGMYFPDXBNJZSQVHLCKE";
            int index=Integer.parseInt(matcher.group(1));
            index=index%23;
            String reference=letras.substring(index,index+1);
            if(reference.equals(letra)){
                correcto=true;
            }else{
                correcto=false;
            }
        }else{
            correcto=false;
        }
        return correcto;
    }
	
	/**
	 * Valida el campo del DNI.
	 * @param Nombre o Apellido.
	 * @return Comprueba si es correcto el nombre y apellido ,es decir , comprueba que no ha introducido numeros o caracteres.
	 */
	public boolean validarNombreYApellido (String NombreOApellido) {
		
		 if (NombreOApellido.matches("^[a-zA-Z]+$"))
			return false;
		  else 
			 return true;
	}
	
	public boolean verificarDNI (String dni) throws SQLException {
		//Declaraci�n e inicializaci�n de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.ConectarBD();
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select * from clientes where DNI = '" + dni + "';");
	
		if (rs.last()) {
			con.close();
			return true;
		} else {
			con.close();
			return false;
		}
	}
	
	public boolean comprobarCamposRegistro(String dni, String nombre, String apellido, Date fecha, char[] contrasena) throws SQLException {

		
		//Comprobar si ya existe ese DNI
		if (verificarDNI(dni)) {
			JOptionPane.showMessageDialog(miVentana, "Ya existe un ususario con ese DNI", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			//Validacion de los campos
			if (dni != "" && nombre != "" && apellido !="" && fecha != null && contrasena.length != 0 ) {
					if(validarDNI(dni)) {
						if(validarNombreYApellido(nombre) || validarNombreYApellido(apellido))
						{
							JOptionPane.showMessageDialog(miVentana, "�Nombre o apellido incorrecto!", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
							return false;
							
						} else {
						return true;
						}
					}
					else {
						JOptionPane.showMessageDialog(miVentana, "�Formato DNI incorrecto!", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
						return false;
					}
			} else {
				JOptionPane.showMessageDialog(miVentana, "�Debe rellenar todos los campos!", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
				return false;
			} 
		}
		
	}
	
	
	
	
	 
}
