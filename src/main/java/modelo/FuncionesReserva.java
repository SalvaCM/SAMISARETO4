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
import testmodelo.miModelo;
import vista.Ventana;


public class FuncionesReserva {
	
	private Ventana miVentana;


	public void registrarReserva(int codReserva,Cliente cliente, Hotel hotel,HabitacionHotel habitacionReservada,ReservaHotel reservaHotel) {
		//Declaración e inicialización de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		String query = "INSERT into reservasHotel codReserva,codhotel,codhabitacion,codcliente,fechaEntrada,fechaSalida) VALUES ('" + codReserva + "', '" + hotel.getCod_hotel() + "', '" + habitacionReservada.getCodHabitacion() + "', '" + cliente.getDni() + "', '" + reservaHotel.getFechaEntrada() + "','"+ reservaHotel.getFechaSalida()+"');";
		
		if (miConsulta.insertarDatosBD(con, query)) {
			JOptionPane.showMessageDialog(miVentana, "Reserva Realizada!", "¡Atención!", JOptionPane.WARNING_MESSAGE);
			
		}
	}
	
	
	
	
	 
}
