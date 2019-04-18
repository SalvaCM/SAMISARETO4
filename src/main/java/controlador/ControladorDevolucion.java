package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import modelo.Modelo;
import vista.Ventana;

public class ControladorDevolucion implements ActionListener {
			
			private Ventana miVentana;
		
			FuncionesControlador funciones = new FuncionesControlador();

			
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
						
				case "btnSiguienteDevolucion": funciones.cambiarDePanel(miVentana.devolucion, miVentana.despedida);
				funciones.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);
				funciones.limpiarTabla(miVentana.estanciasHotel.tablaHabitaciones,miVentana.estanciasHotel.tableModel);
				PasarDeDespedidaASaludo();
				resetear();
				break;
		
				}
			}	
			
			/**
			 * Metodo para pasar del la ventana despedida a la de saludo automaticamente (en milisegundos)
			 */
			public void PasarDeDespedidaASaludo() {
				Timer timer = new Timer();
				TimerTask esperar = new TimerTask() {
					@Override
					public void run() {
						funciones.cambiarDePanel(miVentana.despedida, miVentana.saludo);
					}
				};
				timer.schedule(esperar, 3500);
			}
			
	
			
		

}

