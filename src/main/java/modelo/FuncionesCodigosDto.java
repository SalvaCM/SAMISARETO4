package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	/**
	 * Muestra el precio total con el descuento de los hoteles
	 * @param codigoCliente
	 * @param codigoHotel
	 * @param codigoDto
	 * @param total
	 * @return el precio total con el descuento incluido 
	 * @throws SQLException
	 */
	public double descuentoHotelTotal (int codigoCliente, int codigoHotel, String codigoDto, double total) throws SQLException{ 
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
	/**
	* comprueba el codigo introducido de los hoteles con el de la base de datos 
 	* @param codigoCliente
 	* @param codigoHotel
 	* @param codigoDto
 	* @return valida si es correcto el codigo introducido
 	* @throws SQLException
 	*/
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
	/**
	 * Muestra el precio total con el descuento de las casas
	 * @param codigoCliente
	 * @param codigoCasa
	 * @param codigoDto
	 * @param total
	 * @return el precio total con el descuento incluido 
	 * @throws SQLException
	 */
	public double descuentoCasaTotal  (int codigoCliente, int codigoCasa, String codigoDto, double total) throws SQLException{ 
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
	/**
	* comprueba el codigo introducido de las casas con el de la base de datos 
 	* @param codigoCliente
 	* @param codigoCasa
 	* @param codigoDto
 	* @return valida si es correcto el codigo introducido
 	* @throws SQLException
 	*/
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
	/**
	 * Muestra el precio total con el descuento de los apartamentos
	 * @param codigoCliente
	 * @param codigoApart
	 * @param codigoDto
	 * @param total
	 * @return el precio total con el descuento incluido 
	 * @throws SQLException
	 */
	public double descuentoApartTotal (int codigoCliente, int codigoApart, String codigoDto, double total) throws SQLException{ 
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
	/**
	* comprueba el codigo introducido de los apartamentos con el de la base de datos 
 	* @param codigoCliente
 	* @param codigoApart
 	* @param codigoDto
 	* @return valida si es correcto el codigo introducido
 	* @throws SQLException
 	*/
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
	/**
	 * borra el codigo de la base de datos una vez el cliente haya pagado
	 * @param codigoCliente
	 * @param codigoHotel
	 * @param codigoDto
	 * @throws SQLException
	 */
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
	/**
	 * borra el codigo de la base de datos una vez el cliente haya pagado
	 * @param codigoCliente
	 * @param codigoCasa
	 * @param codigoDto
	 * @throws SQLException
	 */
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
	/**
	 * borra el codigo de la base de datos una vez el cliente haya pagado
	 * @param codigoCliente
	 * @param codigoApart
	 * @param codigoDto
	 * @throws SQLException
	 */
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
	/**
	 * crea un codigo de descuento para el hotel 
	 * @param reservaHotel
	 * @param cliente
	 */
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
	/**
	 * crea un codigo de descuento para la casa
	 * @param reservaCasa
	 * @param cliente
	 */
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
	/**
	 * crea un codigo de descuento para el apartamento
	 * @param reservaApart
	 * @param cliente
	 */
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
	/**
	 * muestra solo el precio que se ha descontado del hotel
	 * @param codigoCliente
	 * @param codigoHotel
	 * @param codigoDto
	 * @param total
	 * @return descuento
	 * @throws SQLException
	 */
	public double descuentoHotel (int codigoCliente, int codigoHotel, String codigoDto, double total) throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		
		String codigo = "";
		float porcentaje = 0;
		float dto = 0;
		
		
		// Inicio 
		
		String query="select codigo,porcentaje from codigos_Hotel where cod_cliente ='" + codigoCliente + "' and cod_hotel='" + codigoHotel + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
							
							
						
							codigo= rs.getString("codigo");
							porcentaje = rs.getFloat("porcentaje");
							
							
						}
					
		
		System.out.println("codigo:" + codigo);
		System.out.println("codigo:" + codigoDto);
					
		if (codigoDto == null || codigoDto == "")		
		{	
			JOptionPane.showMessageDialog(miVentana, "Introduce un codigo", "Atencion!", JOptionPane.WARNING_MESSAGE);
		}else {
			if(codigo.equals(codigoDto)) {
				
				dto =(float) (total * porcentaje / 100);
							   
			}else {
				JOptionPane.showMessageDialog(miVentana, "No existe el codigo introducido", "Atencion!", JOptionPane.WARNING_MESSAGE);
			}
		}
				return dto;

	}
	/**
	 * muestra solo el precio que se ha descontado de la casa
	 * @param codigoCliente
	 * @param codigoCasa
	 * @param codigoDto
	 * @param total
	 * @return descuento
	 * @throws SQLException
	 */
	public double descuentoCasa (int codigoCliente, int codigoCasa, String codigoDto, double total) throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		
		String codigo = "";
		float porcentaje = 0;
		float dto=0;
		
		
		// Inicio
		
		String query="select codigo,porcentaje from codigos_Casa where cod_cliente ='" + codigoCliente + "' and cod_casa='" + codigoCasa + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
											
							codigo= rs.getString("codigo");
							porcentaje = rs.getFloat("porcentaje");
										
							
						}
					
		
		System.out.println("codigo:" + codigo);
		System.out.println("codigo:" + codigoDto);
					
		if (codigoDto == null || codigoDto == "")		
		{	
			JOptionPane.showMessageDialog(miVentana, "Introduce un codigo", "Atencion!", JOptionPane.WARNING_MESSAGE);
		}else {
			if(codigo.equals(codigoDto)) {	
				dto = (float) (total * porcentaje / 100);
							   
			}else {
				JOptionPane.showMessageDialog(miVentana, "No existe el codigo introducido", "Atencion!", JOptionPane.WARNING_MESSAGE);
			}
		}
				return dto;

	}
	/**
	 * muestra solo el precio que se ha descontado del apartamento
	 * @param codigoCliente
	 * @param codigoApart
	 * @param codigoDto
	 * @param total
	 * @return descuento
	 * @throws SQLException
	 */
	public double descuentoApart (int codigoCliente, int codigoApart, String codigoDto, double total) throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		
		String codigo = "";
		float porcentaje = 0;
		float dto=0;
		
		// Inicio
		
		String query="select codigo,porcentaje from codigos_Apartamento where cod_cliente ='" + codigoCliente + "' and cod_apartamento='" + codigoApart + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
											
							codigo= rs.getString("codigo");
							porcentaje = rs.getFloat("porcentaje");
										
							
						}
					
		
		System.out.println("codigo:" + codigo);
		System.out.println("codigo:" + codigoDto);
					
		if (codigoDto == null || codigoDto == "")		
		{	
			JOptionPane.showMessageDialog(miVentana, "Introduce un codigo", "Atencion!", JOptionPane.WARNING_MESSAGE);
		}else {
			if(codigo.equals(codigoDto)) {	
				dto = (float) (total * porcentaje / 100);
							   
			}else {
				JOptionPane.showMessageDialog(miVentana, "No existe el codigo introducido", "Atencion!", JOptionPane.WARNING_MESSAGE);
			}
		}
				return dto;

	}



	
}