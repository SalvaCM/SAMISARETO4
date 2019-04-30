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
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
					    
				case "btnSiguienteResumen":	funciones.desBotones(miVentana.pago.btnSiguiente);
											miControlador.miControladorPago.resetear();
											
											for(int i=0;i<miModelo.reservaHotel.getHabReservadas().size();i++) {
												miControlador.miControladorPago.total +=miModelo.reservaHotel.getHabReservadas().get(i).getPrecio()*miModelo.reservaHotel.getNoches();	
											}
											
											System.out.println(miControlador.miControladorPago.total);
											miVentana.pago.pagado.setText(formatoMoneda.format(0));
											miVentana.pago.total.setText(formatoMoneda.format(	miControlador.miControladorPago.total));
											funciones.cambiarDePanel(miVentana.resumen, miVentana.pago);
											break;	
											
				case "btnCancelarResumen":	funciones.cambiarDePanel(miVentana.resumen, miVentana.estanciasHotel);
											miControlador.miFuncionesControlador.limpiarTabla(miVentana.estanciasHotel.tablaHabitaciones,miVentana.estanciasHotel.tableModel);
											miVentana.resumen.resumenReserva.setText(null);
											miVentana.resumen.mostrarResumen.clear();
											
											miControlador.miControladorHotel.Estancias();miModelo.reservaHotel.getHabReservadas().removeAll(miModelo.reservaHotel.getHabReservadas());
											break;
				}
			}	
	
			
		

}
