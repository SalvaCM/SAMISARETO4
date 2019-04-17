package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;

import modelo.Modelo;
import vista.Ventana;

public class ControladorResumen implements ActionListener {
			
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
			public ControladorResumen(Ventana miVentana, Modelo miModelo, Controlador miControlador) {
				
				this.miVentana = miVentana;
				this.miModelo = miModelo;
				this.miControlador=miControlador;
		
			
				miVentana.resumen.btnSiguiente.addActionListener(this);
				miVentana.resumen.btnCancelar.addActionListener(this);
			}
			
			
			/**
			 * Metodo para resetear los valores de la ventana pago	
			 */
			public void resetear() {
				miVentana.resumen.mostrarResumen.clear();
				int rows=miVentana.estanciasHotel.tableModel.getRowCount();
			
				for (int i = rows; i > 0; i--) {
					miVentana.estanciasHotel.tableModel.removeRow(i-1);
				}	
			}
			
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
					    
				case "btnSiguienteResumen": 
				
											System.out.println(miModelo.reservas.size());
											funciones.desBotones(miVentana.pago.btnSiguiente);
											//miVentana.pago.btnSiguiente.setEnabled(false);
											miControlador.miControladorPago.resetear();
											//miControlador.miControladorPago.total=0;
											for(int i=0;i<miModelo.reservas.size();i++) {
												miControlador.miControladorPago.total += miModelo.reservas.get(i).getPrecio();
												
												
											}
											System.out.println(miControlador.miControladorPago.total);
											miVentana.pago.pagado.setText(formatoMoneda.format(0));
											miVentana.pago.total.setText(formatoMoneda.format(	miControlador.miControladorPago.total));
											funciones.cambiarDePanel(miVentana.resumen, miVentana.pago);			
						break;
						
				case "btnCancelarResumen": funciones.cambiarDePanel(miVentana.resumen, miVentana.estanciasHotel); resetear();  miControlador.miControladorHotel.Estancias();
			
				break;
		
				}
			}	
	
			
		

}
