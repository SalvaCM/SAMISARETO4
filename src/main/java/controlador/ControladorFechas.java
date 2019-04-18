package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import modelo.Modelo;
import vista.Ventana;

public class ControladorFechas implements ActionListener {
	
	private Ventana miVentana;
	private Modelo miModelo;
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 * @param miControlador 
	 */
	public ControladorFechas(Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;

		miVentana.fechas.btnCancelar.addActionListener(this);
		miVentana.fechas.btnSiguiente.addActionListener(this);
	
	}
	
	/**
	 * Metodo para las llamadas a los botones de la ventana resumen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {
			    
		case "btnSiguienteFechas": funciones.cambiarDePanel(miVentana.fechas, miVentana.resumen);	
				break;
				
		case "btnCancelarFechas": funciones.cambiarDePanel(miVentana.fechas, miVentana.estanciasHotel);		
				break;

		}
	}	

}
