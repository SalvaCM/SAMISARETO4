package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import modelo.Modelo;
import vista.Ventana;

public class ControladorPago implements ActionListener {

		private Ventana miVentana;
		
		FuncionesControlador funciones = new FuncionesControlador();
		
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
		
		/**
		 * Constructor de la clase
		 * @param miVentana instancia de la ventna principal
		 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
		 */
		public ControladorPago (Ventana miVentana, Modelo miModelo) { 
			
			this.miVentana = miVentana;
			
			//Definicion de los listeners de los botones del panel
			miVentana.pago.btnSiguiente.addActionListener(this); 
			miVentana.pago.btnCancelar.addActionListener(this); 
			miVentana.pago.btn500.addActionListener(this);
			miVentana.pago.btn200.addActionListener(this);
			miVentana.pago.btn100.addActionListener(this); 
			miVentana.pago.btn50.addActionListener(this);
			miVentana.pago.btn20.addActionListener(this);
			miVentana.pago.btn10.addActionListener(this);
			miVentana.pago.btn5.addActionListener(this);
			miVentana.pago.btn2.addActionListener(this);
			miVentana.pago.btn1.addActionListener(this);
			miVentana.pago.btn050.addActionListener(this);
			miVentana.pago.btn020.addActionListener(this);
			miVentana.pago.btn010.addActionListener(this);
			miVentana.pago.btn005.addActionListener(this);
			miVentana.pago.btn002.addActionListener(this);
			miVentana.pago.btn001.addActionListener(this);
			
			
		}
		
		/**
		 * Metodo para las llamadas a los botones de la ventana pago
		 */	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch (((JButton) e.getSource()).getName()) {
			
			case "btnCancelarPago": funciones.cambiarDePanel(miVentana.pago, miVentana.resumen);
					break;
								    
			case "btnSiguientePago": funciones.cambiarDePanel(miVentana.pago, miVentana.devolucion);  
					break;
			
			}
		}	
}