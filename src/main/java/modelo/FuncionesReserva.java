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

	public void registrarReserva(int codReserva,int i, ReservaHotel reservaHotel,Cliente cliente) {
		//Declaraci�n e inicializaci�n de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String fechaE = dateFormat.format(reservaHotel.getFechaEntrada());
		String fechaS=dateFormat.format(reservaHotel.getFechaSalida());
		
		System.out.println(codReserva);
		System.out.println(reservaHotel.getHotelReservado().getCod_hotel());
		System.out.println(reservaHotel.getHabReservadas().get(i).getCodHabitacion());
		System.out.println(cliente.getDni());
		System.out.println(reservaHotel.getFechaEntrada());
		System.out.println(reservaHotel.getFechaSalida());
		//codReserva iba en el insert
		String query = "INSERT into reservas_Hotel (cod_reserva,cod_hotel,cod_"
				+ "habitacion,codcliente,fechaEntrada,fechaSalida) VALUES ('"+codReserva+"','" + reservaHotel.getHotelReservado().getCod_hotel()+ "', '" + reservaHotel.getHabReservadas().get(i).getCodHabitacion() + "', '" + cliente.getCodCliente() + "', '" + fechaE + "','"+ fechaS+"');";
		
		System.out.println(query);
		if (miConsulta.insertarDatosBD(con, query)) {
			System.out.println("Reserva Realizada");
		}
	}
	public int buscarNumeroReserva() {
		//Declaraci�n e inicializaci�n de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		String query = ("select max(codreserva) from reservas_hotel;");
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
	public void registrarReservaC(int codReserva, ReservaCASAoAPART reserva,Cliente cliente) {
		//Declaraci�n e inicializaci�n de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String fechaE = dateFormat.format(reserva.getFechaEntrada());
		String fechaS=dateFormat.format(reserva.getFechaSalida());
		
		System.out.println(codReserva);
		System.out.println(reserva.getCasaReservada().getCod_casa());
		System.out.println(cliente.getDni());
		System.out.println(reserva.getFechaEntrada());
		System.out.println(reserva.getFechaSalida());
		//codReserva iba en el insert
		String query = "INSERT into reserva_casa (codreserva,cod_casa,codcliente,fechaEntrada,fechaSalida) VALUES ('"+codReserva+"','" + reserva.getCasaReservada().getCod_casa()+  "', '" + cliente.getCodCliente() + "', '" + fechaE + "','"+ fechaS+"');";
		
		System.out.println(query);
		if (miConsulta.insertarDatosBD(con, query)) {
			System.out.println("Reserva Realizada");
		}
	}
	
	
	 
}
