package modelo;

import java.sql.Connection;

import javax.swing.JOptionPane;

import conexion.ConexionBD;
import conexion.ConsultaBD;
import vista.Ventana;

public class FuncionesPago {
	private Ventana miVentana;
	
	public double sumarDineroPago(String valor, double pagado) {
		//Declaracion e inicializacion de variables

		//Inicio del programa
		pagado = pagado + Double.parseDouble(valor);

		return pagado;
			
	}
	

}
