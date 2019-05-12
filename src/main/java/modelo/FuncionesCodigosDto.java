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
					
					
					System.out.println("codigo:" + codigo);
					System.out.println("codigo:" + codigoDto);
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
					
					
					System.out.println("codigo:" + codigo);
					System.out.println("codigo:" + codigoDto);
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
}