package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import conexion.ConexionBD;
import conexion.ConsultaBD;
import modelo.Modelo;
import vista.Ventana;

public class ControladorSaludo implements ActionListener{

	private Ventana miVentana;
	private Modelo miModelo;
	
	ConexionBD miConexion = new ConexionBD();
	ConsultaBD miConsulta = new ConsultaBD();
	Connection con = miConexion.ConectarBD();
	FuncionesControlador funciones = new FuncionesControlador();
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 * @param miControlador 
	 */
	public ControladorSaludo(Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miModelo =miModelo;
		
		miVentana.saludo.btnSaludo.addActionListener(this);
		
	}
	
	/**
	 * Metodo para las llamadas a los botones de la 
	 * ventana resumen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {
			    

		case "btnSaludo": funciones.cambiarDePanel(miVentana.saludo, miVentana.alojamiento); 
						  if ( con != null) {
							  
						  }else {
							  JOptionPane.showMessageDialog(miVentana, "ERROR DE CONEXION", "�Atencion!", JOptionPane.ERROR_MESSAGE);
							  System.exit(0);
						  }
		
				break;
		}
	}


	
		
	

}
