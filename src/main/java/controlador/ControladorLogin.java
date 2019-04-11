package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import modelo.Modelo;
import vista.Ventana;

public class ControladorLogin  implements ActionListener{
	
	private Ventana miVentana;
	private Modelo miModelo;


	
	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 * @param miControlador 
	 */
	public ControladorLogin(Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;

	
		miVentana.login.btnCancelar.addActionListener(this);
		miVentana.login.btnRegistrarse.addActionListener(this);
	}
	
	
	
	/**
	 * Metodo para las llamadas a los botones de la ventana resumen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {
			    
		case "btnCancelarLogin": funciones.cambiarDePanel(miVentana.login, miVentana.saludo); 
				
		break;

		}
	}	

}
