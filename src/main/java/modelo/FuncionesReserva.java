package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import conexion.ConexionBD;
import conexion.ConsultaBD;



public class FuncionesReserva {


	public void registrarReserva(int codReserva,int i, ReservaHotel reservaHotel,Cliente cliente) {
		//Declaracion e inicializacion de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String fechaE = dateFormat.format(reservaHotel.getFechaEntrada());
		String fechaS=dateFormat.format(reservaHotel.getFechaSalida());
		
		//codReserva iba en el insert
		String query = "INSERT into reservas_Hotel (cod_reserva,cod_hotel,cod_"
				+ "habitacion,cod_cliente,fechaEntrada,fechaSalida) VALUES ('"+codReserva+"','" + reservaHotel.getHotelReservado().getCod_hotel()+ "', '" + reservaHotel.getHabReservadas().get(i).getCodHabitacion() + "', '" + cliente.getCodCliente() + "', '" + fechaE + "','"+ fechaS+"');";
		
		System.out.println(query);
		if (miConsulta.insertarDatosBD(con, query)) {
			System.out.println("Reserva Realizada");
		}
	}
	public int buscarNumeroReservaHotel() {
		//Declaracion e inicializacion de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		String query = ("select max(cod_reserva) from reservas_hotel;");
		int maxCodReserva=0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		try {
			while(rs.next()) {
				   maxCodReserva = rs.getInt("max(cod_reserva)");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(maxCodReserva);
		return maxCodReserva+1;
		
	}
	
	public int buscarNumeroReservaCasa() {
		//Declaracion e inicializacion de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		String query = ("select max(cod_reserva) from reserva_casa;");
		System.out.println(query);
		int maxCodReserva=0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		try {
			while(rs.next()) {
				   maxCodReserva = rs.getInt("max(cod_reserva)");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(maxCodReserva);
		return maxCodReserva+1;
		
	}
	public int buscarNumeroReservaApartamento() {
		//Declaracion e inicializacion de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		String query = ("select max(cod_reserva) from reserva_apartamento;");
		System.out.println(query);
		int maxCodReserva=0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		try {
			while(rs.next()) {
				   maxCodReserva = rs.getInt("max(cod_reserva)");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(maxCodReserva);
		return maxCodReserva+1;
		
	}
	
	public void registrarReservaCasa(int codReserva, ReservaCASAoAPART reserva,Cliente cliente) {
		//Declaracion e inicializacion de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String fechaE = dateFormat.format(reserva.getFechaEntrada());
		String fechaS=  dateFormat.format(reserva.getFechaSalida());
		
		System.out.println(codReserva);
		System.out.println(reserva.getCasaReservada().getCod_casa());
		System.out.println(cliente.getDni());
		System.out.println(reserva.getFechaEntrada());
		System.out.println(reserva.getFechaSalida());
		//codReserva iba en el insert

		String query = "INSERT into reserva_casa (cod_reserva,cod_casa,cod_cliente,fechaEntrada,fechaSalida) VALUES ('"+codReserva+"','" + reserva.getCasaReservada().getCod_casa()+  "', '" + cliente.getCodCliente() + "', '" + fechaE + "','"+ fechaS+"');";
		
		System.out.println(query);
		if (miConsulta.insertarDatosBD(con, query)) {
			System.out.println("Reserva Realizada");
		}
	}
	
	public void registrarReservaApartamento(int codReserva, ReservaCASAoAPART reserva,Cliente cliente) {
		//Declaracion e inicializacion de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String fechaE = dateFormat.format(reserva.getFechaEntrada());
		String fechaS=  dateFormat.format(reserva.getFechaSalida());
		
		System.out.println(codReserva);
		System.out.println(reserva.getApartReservado().getCod_apartamento());
		System.out.println(cliente.getDni());
		System.out.println(reserva.getFechaEntrada());
		System.out.println(reserva.getFechaSalida());
		//codReserva iba en el insert
		String query = "INSERT into reserva_apartamento (cod_reserva,cod_apart,cod_cliente,fechaEntrada,fechaSalida) VALUES ('"+codReserva+"','" + reserva.getApartReservado().getCod_apartamento()+  "', '" + cliente.getCodCliente() + "', '" + fechaE + "','"+ fechaS+"');";
		
		System.out.println(query);
		if (miConsulta.insertarDatosBD(con, query)) {
			System.out.println("Reserva Realizada");
		}
	}
	
	
	 
}
