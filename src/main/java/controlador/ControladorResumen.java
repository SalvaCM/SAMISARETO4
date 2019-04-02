package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Modelo;
import vista.Ventana;

public class ControladorResumen implements ActionListener {
			
			//private Controlador miControlador;
			private Ventana miVentana;
			
			FuncionesControlador funciones = new FuncionesControlador();
			
			/**
			 * Constructor de la clase
			 * @param miVentana instancia de la ventna principal
			 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
			 */
			public ControladorResumen(Ventana miVentana, Modelo miModelo) {
				
				this.miVentana = miVentana;
				
				miVentana.resumen.btnSiguiente.addActionListener(this);
			}
			
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
					    
				case "btnSiguienteResumen": funciones.cambiarDePanel(miVentana.resumen, miVentana.pago);  System.out.println("hola");
						break;
				
				}
			}	
	
			
		

}
