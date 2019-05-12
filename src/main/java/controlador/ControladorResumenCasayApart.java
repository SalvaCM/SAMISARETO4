package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
		
			
				miVentana.resumenCyA.btnSiguiente.addActionListener(this);
				miVentana.resumenCyA.btnCancelar.addActionListener(this);
			}
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
					    
				case "btnSiguienteResumen2":
					/*if (miModelo.logged==false)
					{	
						JOptionPane.showMessageDialog(miVentana, "¡Resgistrese Para Continuar!", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
						funciones.cambiarDePanel(miVentana.resumenCyA, miVentana.login);
					}
					else{*/					
											funciones.cambiarDePanel(miVentana.resumenCyA, miVentana.pago);
											funciones.actBotones(miVentana.pago.btnCancelar);
											miControlador.miControladorPago.actBotones(miVentana.pago.arrayBtn);
											funciones.desBotones(miVentana.pago.btnSiguiente);
											
											miVentana.resumenCyA.txtDetalles.setText(null);
											miVentana.resumenCyA.resumenReserva.setText(null);
											miVentana.resumenCyA.mostrarResumen.clear();
											funciones.limpiarTabla(miVentana.casa.tablaResultados, miVentana.casa.tableModel);
											funciones.limpiarTabla(miVentana.apartamento.tablaResultados, miVentana.apartamento.tableModel);
				//	}
					break;	
											
				case "btnCancelarResumen2":	funciones.cambiarDePanel(miVentana.resumenCyA, miVentana.alojamiento);

											miVentana.resumenCyA.txtDetalles.setText(null);
											miVentana.resumenCyA.resumenReserva.setText(null);
											miVentana.resumenCyA.mostrarResumen.clear();
											
											funciones.limpiarTabla(miVentana.apartamento.tablaResultados, miVentana.apartamento.tableModel);
										
											miVentana.apartamento.fechaEntrada.setCalendar(null);
											miVentana.apartamento.fechaSalida.setCalendar(null);
											miVentana.apartamento.fechaSalida.setEnabled(false);
											
											miVentana.casa.fechaEntrada.setCalendar(null);
											miVentana.casa.fechaSalida.setCalendar(null);
											miVentana.casa.fechaSalida.setEnabled(false);
											funciones.limpiarTabla(miVentana.casa.tablaResultados, miVentana.casa.tableModel);
											break;
				}
			}	
	
			
		

}
