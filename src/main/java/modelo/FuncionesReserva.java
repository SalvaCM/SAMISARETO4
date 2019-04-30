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
	private Modelo miModelo;

/*
	public void registrarReserva(int codReserva,int i) {
		//Declaración e inicialización de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		System.out.println(codReserva);
		String query = "INSERT into reservasHotel (codReserva,codhotel,codhabitacion,codcliente,fechaEntrada,fechaSalida) VALUES ('" + codReserva + "', '" + miModelo.hotelReservado.getCod_hotel()+ "', '" + miModelo.habitacionReservada.getCodHabitacion() + "', '" + miModelo.cliente.getDni() + "', '" + miModelo.reservaHotel.getFechaEntrada() + "','"+ miModelo.reservaHotel.getFechaSalida()+"');";
		System.out.println(query);
		if (miConsulta.insertarDatosBD(con, query)) {
			JOptionPane.showMessageDialog(miVentana, "Reserva Realizada!", "¡Atención!", JOptionPane.WARNING_MESSAGE);
			
		}
	}*/
	public int buscarNumeroReserva() {
		//Declaración e inicialización de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		String query = ("select max(codreserva) from reservashotel;");
		System.out.println(query);
		int maxCodReserva=0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		try {
			while(rs.next()) {
				   maxCodReserva = rs.getInt("max(codreserva)");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(maxCodReserva);
		return maxCodReserva+1;
		
	}
	
	
	
	 
}
