package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;

import modelo.Modelo;
import vista.Ventana;

public class ControladorResumenCasayApart implements ActionListener {
			
			private Ventana miVentana;
			private Modelo miModelo;
			private Controlador miControlador;
		
			
			NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
			
			FuncionesControlador funciones = new FuncionesControlador();
			
			/**
			 * Constructor de la clase
			 * @param miVentana instancia de la ventna principal
			 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
			 * @param miControlador 
			 */
			public ControladorResumenCasayApart(Ventana miVentana, Modelo miModelo, Controlador miControlador) {
				
				this.miVentana = miVentana;
				this.miModelo = miModelo;
				this.miControlador=miControlador;
		
			
				miVentana.resumen.btnSiguiente.addActionListener(this);
				miVentana.resumen.btnCancelar.addActionListener(this);
			}
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
					    
				case "btnSiguienteResumen2":	funciones.cambiarDePanel(miVentana.resumenCyA, miVentana.pago);
											funciones.desBotones(miVentana.pago.btnSiguiente);
											miControlador.miControladorPago.resetear();
											
											System.out.println("HOLA");
											miVentana.pago.pagado.setText(formatoMoneda.format(0));
											miVentana.pago.total.setText(formatoMoneda.format(miControlador.miControladorPago.total));
											
											break;	
											
				case "btnCancelarResumen2":	funciones.cambiarDePanel(miVentana.resumenCyA, miVentana.alojamiento);
											miVentana.resumen.resumenReserva.setText(null);
											miVentana.resumen.mostrarResumen.clear();
											break;
				}
			}	
	
			
		

}
