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
	
	public CodigosDto leerCodigos(int codigoCliente, int codigoHotel) throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		
		String codigo;
		float porcentaje;
		
		// Inicio
		
		String query="select codigo,porcentaje from codigos where cod_cliente ='" + codigoCliente + "' and cod_hotel='" + codigoHotel + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
							
							codigosDto=new CodigosDto();
						
							codigo= rs.getString("codigo");
							porcentaje = rs.getFloat("porcentaje");
							
							codigosDto.setCodigo(codigo);
							codigosDto.setPorcentaje(porcentaje);
							
							
						}
			
		return codigosDto;

	}
	
	public float restarDescuento () {
		
		float totalConDto = 0;
		
		if(miModelo.codigosDto.getPorcentaje()== 0) {
		   JOptionPane.showMessageDialog(miVentana, "No existe el codigo introducido", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
		}else {
			totalConDto = (float) (miControlador.miControladorPago.total - (miControlador.miControladorPago.total * miModelo.codigosDto.getPorcentaje() / 100));
			
		}
		
		return totalConDto;
	
	}

}
