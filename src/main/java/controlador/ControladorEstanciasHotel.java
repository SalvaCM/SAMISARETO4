package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Modelo;
import vista.Ventana;

public class ControladorEstanciasHotel  implements ActionListener{

	private Ventana miVentana;
	
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 */
	public ControladorEstanciasHotel(Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		
		this.miVentana.estanciasHotel.btnCancelar.addActionListener(this);
		this.miVentana.estanciasHotel.btnSiguiente.addActionListener(this);	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {
		
		case "btnCancelarEstancias": funciones.cambiarDePanel(miVentana.estanciasHotel, miVentana.hotel);
		break;
		case "btnSiguienteEstancias": funciones.cambiarDePanel(miVentana.estanciasHotel, miVentana.resumen);
		break;
		
		}
	}
	
}