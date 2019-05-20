package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import conexion.ConexionBD;
import conexion.ConsultaBD;
import testmodelo.miModelo;



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
	
		System.out.println(reserva.getFechaEntrada());
		System.out.println(reserva.getFechaSalida());
		//codReserva iba en el insert
		String query = "INSERT into reserva_apartamento (cod_reserva,cod_apart,cod_cliente,fechaEntrada,fechaSalida) VALUES ('"+codReserva+"','" + reserva.getApartReservado().getCod_apartamento()+  "', '" + cliente.getCodCliente() + "', '" + fechaE + "','"+ fechaS+"');";
		
		System.out.println(query);
		if (miConsulta.insertarDatosBD(con, query)) {
			System.out.println("Reserva Realizada");
		}
	}
	public String buscarReservasUsuario(Cliente cliente) {
		//Declaracion e inicializacion de variables:
		StringBuilder cadenaReservas = new StringBuilder();
		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		String query =" SELECT R.COD_RESERVA,HH.TIPO,HH.PRECIO,H.NOMBRE,C.COD_CLIENTE,R.FECHAENTRADA,R.FECHASALIDA"+
				" FROM HABITACION_HOTEL HH,HOTEL H,RESERVAS_HOTEL R,CLIENTES C"+
				" WHERE R.COD_HABITACION=HH.COD_HABITACION AND R.COD_HOTEL=H.COD_HOTEL AND C.COD_CLIENTE=R.COD_CLIENTE and hh.cod_hotel=h.cod_hotel And r.cod_cliente="+cliente.getCodCliente()+
				" GROUP BY R.COD_RESERVA,R.COD_HABITACION,R.COD_HOTEL"+  
				" ORDER BY R.FECHAENTRADA ASC;";
		System.out.println(query);
		int codReserva=0;String tipo;String precio;String nombre;String fEntrada;String fSalida;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		try {
			while(rs.next()) {
				cadenaReservas.append(rs.getInt("cod_reserva")+" ");
				cadenaReservas.append(rs.getString("TIPO")+" ");
				cadenaReservas.append(rs.getFloat("PRECIO")+" ");
				cadenaReservas.append(rs.getString("NOMBRE")+" ");
				cadenaReservas.append(rs.getInt("COD_CLIENTE")+" ");
				cadenaReservas.append(rs.getDate("FECHAENTRADA")+" ");
				cadenaReservas.append(rs.getDate("FECHASALIDA")+" ");
				cadenaReservas.append("\n");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cReservas = cadenaReservas.toString();
		return cReservas;
		
	}
	public String buscarCodPromocionalesHotel(Cliente cliente) {
		//Declaracion e inicializacion de variables:
		StringBuilder cadenaReservas = new StringBuilder();
		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		String query =" SELECT ch.codigo,ch.porcentaje,h.nombre"+
				" FROM codigos_HOTEL ch,HOTEL H"+
				" WHERE ch.COD_HOTEL=H.COD_HOTEL and ch.cod_hotel=h.cod_hotel And ch.cod_cliente="+cliente.getCodCliente()+";";
		
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		try {
			while(rs.next()) {
				cadenaReservas.append("Nombre:");
				cadenaReservas.append(rs.getString("codigo")+" Porcentaje: ");
				cadenaReservas.append(rs.getFloat("porcentaje")+" Hotel: ");
				cadenaReservas.append(rs.getString("nombre")+" ");
				cadenaReservas.append("\n");

				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cReservas = cadenaReservas.toString();
		return cReservas;
		
	}
	public String buscarCodPromocionalesCasa(Cliente cliente) {
		//Declaracion e inicializacion de variables:
		StringBuilder cadenaReservas = new StringBuilder();
		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		String query =" SELECT ch.codigo,ch.porcentaje,c.nombre"+
				" FROM codigos_casa ch,casa c"+
				" WHERE ch.COD_casa=c.COD_casa and ch.cod_casa=c.cod_casa And ch.cod_cliente="+cliente.getCodCliente()+";";
		
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		try {
			while(rs.next()) {
				cadenaReservas.append("Nombre:");
				cadenaReservas.append(rs.getString("codigo")+" Porcentaje: ");
				cadenaReservas.append(rs.getFloat("porcentaje")+" Casa: ");
				cadenaReservas.append(rs.getString("nombre")+" ");
				cadenaReservas.append("\n");

				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cReservas = cadenaReservas.toString();
		return cReservas;
		
	}
	public String buscarCodPromocionalesApart(Cliente cliente) {
		//Declaracion e inicializacion de variables:
		StringBuilder cadenaReservas = new StringBuilder();
		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();
		String query =" SELECT ch.codigo,ch.porcentaje,a.nombre"+
				" FROM codigos_apartamento ch,Apartamento a"+
				" WHERE ch.COD_apartamento=a.cod_apartamento and ch.cod_apartamento=a.cod_apartamento And ch.cod_cliente="+cliente.getCodCliente()+";";
		
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		try {
			while(rs.next()) {
				cadenaReservas.append("Nombre:");
				cadenaReservas.append(rs.getString("codigo")+" Porcentaje: ");
				cadenaReservas.append(rs.getFloat("porcentaje")+" Hotel: ");
				cadenaReservas.append(rs.getString("nombre")+" ");
				cadenaReservas.append("\n");

				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cReservas = cadenaReservas.toString();
		return cReservas;
	}
}
