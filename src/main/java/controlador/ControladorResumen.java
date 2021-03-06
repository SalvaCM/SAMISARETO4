package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
				miVentana.resumen.btnLogin.addActionListener(this);
				miVentana.resumen.btnPerfil.addActionListener(this);
				
			}
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
					    
				case "btnSiguienteResumen":	if (miModelo.logged==false)
											{	
												JOptionPane.showMessageDialog(miVentana, "Resgistrese Para Continuar!", "¡Atencion!", JOptionPane.INFORMATION_MESSAGE);
												miControlador.miControladorLogin.tratarLogin(miVentana.resumen.btnLogin,miVentana.resumen);
											}
											else
											{
												funciones.desBotones(miVentana.pago.btnSiguiente);
												miControlador.miControladorPago.resetear();
												
												for(int i=0;i<miModelo.reservaHotel.getHabReservadas().size();i++) {
													miControlador.miControladorPago.total +=miModelo.reservaHotel.getHabReservadas().get(i).getPrecio()*miModelo.reservaHotel.getNoches();	
												}
												
												
												miVentana.pago.total.setText(formatoMoneda.format(0));
												miVentana.pago.total.setText(formatoMoneda.format(miControlador.miControladorPago.total));
												funciones.cambiarDePanel(miVentana.resumen, miVentana.pago);
												
												miVentana.resumen.resumenReserva.setText(null);
												miVentana.resumen.mostrarResumen.clear();
												miVentana.resumen.txtDetalles.setText(null);
												miControlador.miControladorHotel.rellenarTabla();
												
												funciones.desBotones(miVentana.pago.btnSiguiente);
												funciones.actBotones(miVentana.pago.btnCodigoDto);
												miVentana.pago.textCodigo.setText(null);
											}
												break;	
												
				case "btnCancelarResumen":	funciones.cambiarDePanel(miVentana.resumen, miVentana.estanciasHotel);
											miControlador.miFuncionesControlador.limpiarTabla(miVentana.estanciasHotel.tablaHabitaciones,miVentana.estanciasHotel.tableModel);
											
											miVentana.resumen.resumenReserva.setText(null);
											miVentana.resumen.mostrarResumen.clear();
											miVentana.resumen.txtDetalles.setText(null);
											
											miControlador.miControladorHotel.Estancias();
											miModelo.reservaHotel.getHabReservadas().removeAll(miModelo.reservaHotel.getHabReservadas());
											
											miControlador.miControladorHotel.rellenarTabla();
											miVentana.hotel.fechaSalida.setEnabled(false);
											
											funciones.limpiarTabla(miVentana.hotel.tablaResultados, miVentana.hotel.tableModel);
											funciones.limpiarTabla(miVentana.apartamento.tablaResultados, miVentana.apartamento.tableModel);
											funciones.limpiarTabla(miVentana.casa.tablaResultados, miVentana.casa.tableModel);
										
											
											funciones.actBotones(miVentana.pago.btnCancelar);
											miControlador.miControladorPago.actBotones(miVentana.pago.arrayBtn);
											
											break;
					case "btnLogin" : 
						miControlador.miControladorLogin.tratarLogin(miVentana.resumen.btnLogin,miVentana.resumen);
					break;
					
					case "btnPerfil" : 
						miControlador.miControladorUsuario.TratarPerfil(miVentana.resumen);
						miVentana.usuario.txtDatosPersonales.setText("");
						miVentana.usuario.txtDatosPersonales.append("Nombre : "+miModelo.cliente.getNombre()+" "+miModelo.cliente.getApellido()+"\nFecha Nac. :"+miModelo.cliente.getFechaNacimiento());
						miVentana.usuario.txtReservasPasadas.setText("");
						miVentana.usuario.txtReservasPasadas.append(miModelo.misFuncionesReserva.buscarReservasUsuario(miModelo.cliente));
						miVentana.usuario.txtreservasFuturas.setText("");
						miVentana.usuario.txtreservasFuturas.append(miModelo.misFuncionesReserva.buscarCodPromocionalesHotel(miModelo.cliente));
						miVentana.usuario.txtreservasFuturas.append(miModelo.misFuncionesReserva.buscarCodPromocionalesApart(miModelo.cliente));
						miVentana.usuario.txtreservasFuturas.append(miModelo.misFuncionesReserva.buscarCodPromocionalesCasa(miModelo.cliente));
					break;
				}
			}	
	
			
		

}
