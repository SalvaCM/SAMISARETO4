package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import modelo.Modelo;
import vista.Ventana;

public class ControladorDevolucion implements ActionListener {
			
			private Ventana miVentana;
			private Modelo miModelo;
			
			FuncionesControlador funciones = new FuncionesControlador();
			ControladorDespedida controladorDespedida = new ControladorDespedida(miVentana, miModelo);

			
			/**
			 * Constructor de la clase
			 * @param miVentana instancia de la ventna principal
			 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
			 */
			public ControladorDevolucion(Ventana miVentana, Modelo miModelo) {
				
				this.miVentana = miVentana;
				
				miVentana.devolucion.btnSiguiente.addActionListener(this);
			}
			
			/**
			 * Metodo para resetear los valores de la ventana devolucion	
			 */ 
			public void  resetear() {		
				miVentana.devolucion.cambios.removeAllElements();
			
			}
			
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
						
				case "btnSiguienteDevolucion": funciones.cambiarDePanel(miVentana.devolucion, miVentana.despedida); controladorDespedida.PasarDeDespedidaASaludo();
				resetear();
				break;
		
				}
			}	
	
			
		

}

