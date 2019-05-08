package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionBD;
import conexion.ConsultaBD;

public class FuncionesCodigos {
	
	ConexionBD miConexion = new ConexionBD();
	ConsultaBD miConsulta = new ConsultaBD();
	Connection con = miConexion.ConectarBD();
	
	
	public String leerCodigos(int codigoCliente, int codigoHotel) throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		int codcliente=0;
		String codigo="";
		float porcentaje;
		int codhotel=0;
		// Inicio
		
		String query="select cod_cliente,codigo,porcentaje,cod_hotel from codigos where cod_cliente ='" + codigoCliente + "' and cod_hotel='" + codigoHotel + "';";

		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
					while(rs.next()) {
							
							codigo= rs.getString("codigo");
							porcentaje= rs.getFloat("porcentaje");

							
						}
			
		return null;

	}

}
