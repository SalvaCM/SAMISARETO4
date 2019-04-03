package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import modelo.Alojamiento;
import modelo.Modelo;
import vista.Ventana;

public class ControladorHotel implements ActionListener {
			
			//private Controlador miControlador;
			private Ventana miVentana;
			private Modelo miModelo;
			
			FuncionesControlador funciones = new FuncionesControlador();
			
			/**
			 * Constructor de la clase
			 * @param miVentana instancia de la ventna principal
			 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
			 */
			public ControladorHotel(Ventana miVentana, Modelo miModelo) {
				
				this.miVentana = miVentana;
				this.miModelo = miModelo;
				
				miVentana.hotel.btnSiguiente.addActionListener(this);
				miVentana.hotel.btnBuscar.addActionListener(this);
			}
			
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
					    
				case "btnSiguienteHotel": funciones.cambiarDePanel(miVentana.hotel, miVentana.resumen);  
						break;
						
				case "BuscarHoteles": mostrarAlojamientos(miModelo.misFuncionesHotel.alojamientos);
						break;
				}
			}
			
			public void mostrarAlojamientos(ArrayList<Alojamiento> alojamientos){      
		        for(int i = 0; i< alojamientos.size(); i++) {
		        	miVentana.hotel.modelo.addElement(alojamientos.get(i).toString());
		        	//se invoca el método toString de la clase
		        }
			}
			
			
	
	
			
		

}
