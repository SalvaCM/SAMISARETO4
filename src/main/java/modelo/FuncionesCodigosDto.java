package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import conexion.ConexionBD;
import conexion.ConsultaBD;
import controlador.Controlador;
import vista.Ventana;

public class FuncionesCodigosDto {
	
	ConexionBD miConexion = new ConexionBD();
	ConsultaBD miConsulta = new ConsultaBD();
	Connection con = miConexion.ConectarBD();
	
	public CodigosDto codigosDto;
	public Modelo miModelo;
	public Controlador miControlador;
	public Ventana miVentana;
	
	
	public double descuentoHotel (int codigoCliente, int codigoHotel, String codigoDto, double total) throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		
		String codigo = "";
		float porcentaje = 0;
		
		
		// Inicio
		
		String query="select codigo,porcentaje from codigos_Hotel where cod_cliente ='" + codigoCliente + "' and cod_hotel='" + codigoHotel + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
							
							
						
							codigo= rs.getString("codigo");
							porcentaje = rs.getFloat("porcentaje");
							
							
						}
					
		double totalConDto = total;
		System.out.println("codigo:" + codigo);
		System.out.println("codigo:" + codigoDto);
					
		if (codigoDto == null || codigoDto == "")		
		{	
			JOptionPane.showMessageDialog(miVentana, "Introduce un codigo", "Atencion!", JOptionPane.WARNING_MESSAGE);
		}else {
			if(codigo.equals(codigoDto)) {	
				totalConDto = (float) (total - (total * porcentaje / 100));
							   
			}else {
				JOptionPane.showMessageDialog(miVentana, "No existe el codigo introducido", "Atencion!", JOptionPane.WARNING_MESSAGE);
				totalConDto = total;
			}
		}
				return totalConDto;

	}
	
	public boolean validarHotel (int codigoCliente, int codigoHotel, String codigoDto) throws SQLException{ 
    	//Declaracion e incializacion de variables	
		
		String codigo = "";

		// Inicio
		
		String query="select codigo from codigos_Hotel where cod_cliente ='" + codigoCliente + "' and cod_hotel='" + codigoHotel + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
				
							codigo= rs.getString("codigo");
			
						}

					boolean validar;
					
					if (codigo == null || codigo == "")		
					{	
						validar = false;
					}else {
						if(codigo.equals(codigoDto)) {	
							validar = true;					
						}else {
							validar = false;
						}
					}
					
					return validar;

	}
	
	public double descuentoCasa (int codigoCliente, int codigoCasa, String codigoDto, double total) throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		
		String codigo = "";
		float porcentaje = 0;
		
		
		// Inicio
		
		String query="select codigo,porcentaje from codigos_Casa where cod_cliente ='" + codigoCliente + "' and cod_casa='" + codigoCasa + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
											
							codigo= rs.getString("codigo");
							porcentaje = rs.getFloat("porcentaje");
										
							
						}
					
		double totalConDto = total;
		System.out.println("codigo:" + codigo);
		System.out.println("codigo:" + codigoDto);
					
		if (codigoDto == null || codigoDto == "")		
		{	
			JOptionPane.showMessageDialog(miVentana, "Introduce un codigo", "Atencion!", JOptionPane.WARNING_MESSAGE);
		}else {
			if(codigo.equals(codigoDto)) {	
				totalConDto = (float) (total - (total * porcentaje / 100));
							   
			}else {
				JOptionPane.showMessageDialog(miVentana, "No existe el codigo introducido", "Atencion!", JOptionPane.WARNING_MESSAGE);
				totalConDto = total;
			}
		}
				return totalConDto;

	}
	
	public boolean validarCasa (int codigoCliente, int codigoCasa, String codigoDto) throws SQLException{ 
    	//Declaracion e incializacion de variables
				
		String codigo = "";
		
		// Inicio
		
		String query="select codigo from codigos_Casa where cod_cliente ='" + codigoCliente + "' and cod_casa='" + codigoCasa + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
							
							
						
							codigo= rs.getString("codigo");

						}
					
					
		
					boolean validar;
					
					if (codigo == null || codigo == "")		
					{	
						validar = false;
					}else {
						if(codigo.equals(codigoDto)) {	
							validar = true;	

						}else {
							validar = false;
						}
					}
					
					return validar;

	}
	
	public double descuentoApart(int codigoCliente, int codigoApart, String codigoDto, double total) throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		
		String codigo = "";
		float porcentaje = 0;
		
		
		// Inicio
		
		String query="select codigo,porcentaje from codigos_Apartamento where cod_cliente ='" + codigoCliente + "' and cod_apartamento='" + codigoApart + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
											
							codigo= rs.getString("codigo");
							porcentaje = rs.getFloat("porcentaje");
										
							
						}
					
		double totalConDto = total;
		System.out.println("codigo:" + codigo);
		System.out.println("codigo:" + codigoDto);
					
		if (codigoDto == null || codigoDto == "")		
		{	
			JOptionPane.showMessageDialog(miVentana, "Introduce un codigo", "Atencion!", JOptionPane.WARNING_MESSAGE);
		}else {
			if(codigo.equals(codigoDto)) {	
				totalConDto = (float) (total - (total * porcentaje / 100));
							   
			}else {
				JOptionPane.showMessageDialog(miVentana, "No existe el codigo introducido", "Atencion!", JOptionPane.WARNING_MESSAGE);
				totalConDto = total;
			}
		}
				return totalConDto;

	}
	
	public boolean validarApart (int codigoCliente, int codigoApart, String codigoDto) throws SQLException{ 
    	//Declaracion e incializacion de variables
				
		String codigo = "";
		
		// Inicio
		
		String query="select codigo from codigos_Apartamento where cod_cliente ='" + codigoCliente + "' and cod_apartamento='" + codigoApart + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
							
							
						
							codigo= rs.getString("codigo");

						}
					
					boolean validar;
					
					if (codigo == null || codigo == "")		
					{	
						validar = false;
					}else {
						if(codigo.equals(codigoDto)) {	
							validar = true;		
							
						
							
						}else {
							validar = false;
						}
					}
					
					return validar;

	}
	
	public void borrarCodigoHotel (int codigoCliente, int codigoHotel, String codigoDto) throws SQLException{ 
    	//Declaracion e incializacion de variables	
		
		String codigo = "";

		// Inicio
		
		String query="select codigo from codigos_Hotel where cod_cliente ='" + codigoCliente + "' and cod_hotel='" + codigoHotel + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
				
							codigo= rs.getString("codigo");
			
						}

					
					if (codigo == null || codigo == "")		
					{	
						
					}else {
						if(codigo.equals(codigoDto)) {								
							String query2 =" DELETE FROM codigos_hotel WHERE codigo='" + codigo + "';";							
							miConsulta.insertarDatosBD(con, query2);						
						}else {
							
						}
					}
					
				

	}
	
	public void borrarCodigoCasa (int codigoCliente, int codigoCasa, String codigoDto) throws SQLException{ 
    	//Declaracion e incializacion de variables
				
		String codigo = "";
		
		// Inicio
		
		String query="select codigo from codigos_Casa where cod_cliente ='" + codigoCliente + "' and cod_casa='" + codigoCasa + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {				
						
							codigo= rs.getString("codigo");
						}
	
					
					if (codigo == null || codigo == "")		
					{	
						
					}else {
						if(codigo.equals(codigoDto)) {	
							String query2 =" DELETE FROM codigos_casa WHERE codigo='" + codigo + "';";							
							miConsulta.insertarDatosBD(con, query2);

						}else {
	
						}
					}
					


	}
	
	public void borrarCodigoApart (int codigoCliente, int codigoApart, String codigoDto) throws SQLException{ 
    	//Declaracion e incializacion de variables
				
		String codigo = "";
		
		// Inicio
		
		String query="select codigo from codigos_Apartamento where cod_cliente ='" + codigoCliente + "' and cod_apartamento='" + codigoApart + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
							
							
						
							codigo= rs.getString("codigo");

						}
					
		
					
					if (codigo == null || codigo == "")		
					{	
					
					}else {
						if(codigo.equals(codigoDto)) {	
							
							String query2 =" DELETE FROM codigos_apartamento WHERE codigo='" + codigo + "';";							
							miConsulta.insertarDatosBD(con, query2);
							
						}else {
						
						}
					}

	}
	public void crearCodigoHotel(ReservaHotel reservaHotel,Cliente cliente) {
		//Declaracion e inicializacion de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();

		String query = "INSERT into codigos_hotel (cod_hotel,cod_cliente,codigo,porcentaje) VALUES ('"+reservaHotel.getHotelReservado().getCod_hotel()+ "','" + cliente.getCodCliente() + "', '" + "BONO" + "','"+ 10 +"');";
		
		System.out.println(query);
		if (miConsulta.insertarDatosBD(con, query)) {
			System.out.println("codigo promocional recibido !");
		}
	}
	public void crearCodigoCasa(ReservaCASAoAPART reservaCasa,Cliente cliente) {
		//Declaracion e inicializacion de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();

		String query = "INSERT into codigos_casa (cod_casa,cod_cliente,codigo,porcentaje) VALUES ('"+reservaCasa.getCasaReservada().getCod_casa()+ "','" + cliente.getCodCliente() + "', '" + "BONO" + "','"+ 10 +"');";
		
		System.out.println(query);
		if (miConsulta.insertarDatosBD(con, query)) {
			System.out.println("codigo promocional recibido !");
		}
	}
	public void crearCodigoApart(ReservaCASAoAPART reservaApart,Cliente cliente) {
		//Declaracion e inicializacion de variables:

		ConexionBD miConexion = new ConexionBD();
		Connection con = miConexion.ConectarBD();
		ConsultaBD miConsulta = new ConsultaBD();

		String query = "INSERT into codigos_hotel (cod_hotel,cod_cliente,codigo,porcentaje) VALUES ('"+reservaApart.getApartReservado().getCod_apartamento()+ "','" + cliente.getCodCliente() + "', '" + "BONO" + "','"+ 10 +"');";
		
		System.out.println(query);
		if (miConsulta.insertarDatosBD(con, query)) {
			System.out.println("codigo promocional recibido !");
		}
	}
	



	
}