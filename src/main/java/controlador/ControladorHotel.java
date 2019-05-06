
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import modelo.Cama;
import modelo.HabitacionHotel;
import modelo.Hotel;
import modelo.Modelo;
import vista.PanelDevolucion;
import vista.PanelEstanciasHotel;
import vista.PanelHotel;
import vista.PanelPago;
import vista.PanelResumen;
import vista.Ventana;

public class ControladorHotel implements ActionListener {
						
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
				miVentana.hotel.btnCancelar.addActionListener(this);
				miVentana.hotel.btnPerfil.addActionListener(this); 
				
				miVentana.hotel.fechaEntrada.addPropertyChangeListener("date", new PropertyChangeListener() {
					@Override
				    public void propertyChange(PropertyChangeEvent e) {
				        System.out.println(e.getPropertyName()+ ":++ " + e.getNewValue());
				        java.util.Date fechaMinimaSalida=(java.util.Date) e.getNewValue();
				        if( fechaMinimaSalida != null) {
				        fechaMinimaSalida.setTime(fechaMinimaSalida.getTime()+86400000);
				        }
				        miVentana.hotel.fechaSalida.setEnabled(true);
				        miVentana.hotel.fechaSalida.setMinSelectableDate(fechaMinimaSalida);
				    }
				});
				
				
			}
			
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
				

					case "btnCancelarHotel": funciones.cambiarDePanel(miVentana.hotel, miVentana.alojamiento);
					funciones.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);
					miVentana.hotel.comboBox.removeAllItems();
					

					miVentana.hotel.fechaEntrada.setCalendar(null);
					miVentana.hotel.fechaSalida.setCalendar(null);
					miVentana.hotel.fechaSalida.setEnabled(false);
					break;
					
					case "btnSiguienteHotel": 	
					validarCampos();
					reiniciarImagen();
					
					break;	

					case "btnBuscarHoteles": filtrarPorUbicacion(miModelo.listaHoteles); imagen();
					
					break;	
					
					case "btnPerfil": funciones.cambiarDePanel(miVentana.hotel, miVentana.usuario);
					miVentana.usuario.txtDatosPersonales.append("Nombre : "+miModelo.cliente.getNombre()+" "+miModelo.cliente.getApellido()+"\nFecha Nac. :"+miModelo.cliente.getFechaNacimiento());
					break;
				}
				
			}
			
			
				//METODOS
			
			private void validarCampos() {
				if(miVentana.hotel.tablaResultados.getSelectedRow() == -1)
				{
					JOptionPane.showMessageDialog(miVentana, "Seleccione un hotel", "Atencion!", JOptionPane.WARNING_MESSAGE);
			
				}
				else {
					if (miVentana.hotel.fechaEntrada.getDate()==null||miVentana.hotel.fechaSalida.getDate()==null)
					{
						JOptionPane.showMessageDialog(miVentana, "Seleccione fechas", "Atencion!", JOptionPane.WARNING_MESSAGE);
					}
					
					else {
							miModelo.reservaHotel.setFechaEntrada(miVentana.hotel.fechaEntrada.getDate());
							miModelo.reservaHotel.setFechaSalida(miVentana.hotel.fechaSalida.getDate());
							funciones.cambiarDePanel(miVentana.hotel, miVentana.estanciasHotel); 
							miModelo.reservaHotel.setHotelReservado(ReservarHotel());
							miModelo.reservaHotel.getHotelReservado().setHabitacionesDisp(Estancias());
							rellenarTabla();
							System.out.println(miModelo.reservaHotel.getHotelReservado().toString());
							System.out.println(miModelo.reservaHotel.getHotelReservado().getHabitacionesDisp().get(0).toString());
							System.out.println(miModelo.reservaHotel.getHotelReservado().getHabitacionesDisp().get(0).getCamas().get(0).toString());
							
						}
					
				}
				/**
				 * 	A�ade a la reserva el hotel seleccionado en el jtable
				 */
			}
			public void rellenarTabla() {
				String cadena="";
				for(int i=0;i<miModelo.reservaHotel.getHotelReservado().habitacionesDisponibles.size();i++) {
					System.out.println(miModelo.reservaHotel.getHotelReservado().habitacionesDisponibles.get(i).getCodHabitacion());
					for(int z=0;z<miModelo.reservaHotel.getHotelReservado().habitacionesDisponibles.get(i).getCamas().size();z++)
					{
						
						cadena=cadena+miModelo.reservaHotel.getHotelReservado().habitacionesDisponibles.get(i).getCamas().get(z).getTipoCama()+",Para "+miModelo.reservaHotel.getHotelReservado().habitacionesDisponibles.get(i).getCamas().get(z).getnPersonas()+" Persona/s #";
						System.out.println("cadena"+cadena);
					}

					try {
						if (miModelo.misFuncionesHotel.habitaOcupada(miModelo.reservaHotel.getHotelReservado().getHabitacionesDisp().get(i).getCodHabitacion(), miVentana.hotel.fechaEntrada.getDate(),miVentana.hotel.fechaSalida.getDate())==false) {
							miModelo.reservaHotel.getHotelReservado().habitacionesDisponibles.get(i)
									.setPrecio((float) (miModelo.reservaHotel.getHotelReservado().habitacionesDisponibles
											.get(i).getPrecio()
											* miModelo.misFuncionesPago.tasa(miVentana.hotel.fechaEntrada.getDate(),
													miVentana.hotel.fechaSalida.getDate())));
							Object[] habitacion = {
									miModelo.reservaHotel.getHotelReservado().habitacionesDisponibles.get(i)
											.getCodHabitacion(),
									miModelo.reservaHotel.getHotelReservado().habitacionesDisponibles.get(i).getTipo(),
									miModelo.reservaHotel.getHotelReservado().habitacionesDisponibles.get(i).getTamano(),
									miModelo.reservaHotel.getHotelReservado().habitacionesDisponibles.get(i).getPrecio(),
									cadena };
							miVentana.estanciasHotel.tableModel.addRow(habitacion);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					cadena="";
					
				}
			}

			private Hotel ReservarHotel() {
				
				int indice = miVentana.hotel.tablaResultados.getSelectedRow();
				Hotel hotel= miModelo.listaHoteles.get(indice);
				return hotel;	
			}

			/**
			 * DEVUELVE UN ARRAYLIST DE LAS HABITACIONES DE UN HOTEL DETERMINADO
			 */
			public ArrayList<HabitacionHotel> Estancias() {
				
					ArrayList<HabitacionHotel> habitaciones = new ArrayList<HabitacionHotel>();
					int codigo = miModelo.reservaHotel.getHotelReservado().getCod_hotel();
					try {
						habitaciones =miModelo.misFuncionesHotel.leerHabitaciones(codigo);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					for  (int i=0;i<habitaciones.size();i++)
					{
						try {
							habitaciones.get(i).setCamas(miModelo.misFuncionesHotel.leerCamas(habitaciones.get(i).getCodHabitacion()));
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				return habitaciones;
			}

			/**
			 * FILTRA LOS HOTELES POR SU UBICACION
			 */
			public void filtrarPorUbicacion(ArrayList<Hotel> hoteles) {
				
				funciones.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);
				try {
					miModelo.listaHoteles= miModelo.misFuncionesHotel.buscarUbicacion(miVentana.hotel.comboBox.getSelectedItem().toString());
					for(int i=0;i<miModelo.listaHoteles.size();i++) {
						
						Object[] hotel = {miModelo.listaHoteles.get(i).getCod_hotel(),miModelo.listaHoteles.get(i).getNombre(), miModelo.listaHoteles.get(i).getUbicacion(),miModelo.listaHoteles.get(i).getnEstrellas()}; 
						miVentana.hotel.tableModel.addRow(hotel);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();}
			}
			
			
			
			
			//IMAGENES
			public void imagen() {
				 String enlace = "";
				 ImageIcon imagen1;
				 ImageIcon imagen2;
				 ImageIcon imagen3;
				 ImageIcon imagen4; 
				 ImageIcon imagen5;
				 ImageIcon imagen6;
				 
				// JLabel etiqueta = null;
				this.miVentana.hotel.repaint();
				
				
				 if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("BARCELONA")) {
					 miVentana.hotel.remove(miVentana.hotel.etiqueta);
					 miVentana.estanciasHotel.remove(miVentana.estanciasHotel.etiqueta);
					 miVentana.resumen.remove(miVentana.resumen.etiqueta);
					 //miVentana.pago.remove(miVentana.pago.etiqueta);
					 miVentana.devolucion.remove(miVentana.devolucion.etiqueta);
					// miVentana.fechas.remove(miVentana.fechas.etiqueta);
						enlace="/imagenes/b.jpg";
					
						
				}
				 else if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("MADRID")) {
					 miVentana.hotel.remove(miVentana.hotel.etiqueta);
					 miVentana.estanciasHotel.remove(miVentana.estanciasHotel.etiqueta);
					 miVentana.resumen.remove(miVentana.resumen.etiqueta);
					// miVentana.pago.remove(miVentana.pago.etiqueta);
					 miVentana.devolucion.remove(miVentana.devolucion.etiqueta);
					// miVentana.fechas.remove(miVentana.fechas.etiqueta);
						enlace="/imagenes/m.jpg";
					
						
				}
				 else if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("SEVILLA")) {
						 miVentana.hotel.remove( miVentana.hotel.etiqueta);
						 miVentana.estanciasHotel.remove(miVentana.estanciasHotel.etiqueta);
						 miVentana.resumen.remove(miVentana.resumen.etiqueta);
						// miVentana.pago.remove(miVentana.pago.etiqueta);
						 miVentana.devolucion.remove(miVentana.devolucion.etiqueta);
						// miVentana.fechas.remove(miVentana.fechas.etiqueta);
						enlace="/imagenes/sev.jpg";
						
						 
						
					}
				 else	if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("VALENCIA")) {
						 miVentana.hotel.remove( miVentana.hotel.etiqueta);
						 miVentana.estanciasHotel.remove(miVentana.estanciasHotel.etiqueta);
						 miVentana.resumen.remove(miVentana.resumen.etiqueta);
						// miVentana.pago.remove(miVentana.pago.etiqueta);
						 miVentana.devolucion.remove(miVentana.devolucion.etiqueta);
						// miVentana.fechas.remove(miVentana.fechas.etiqueta);
						enlace="/imagenes/valencia.jpg";
						 
					}
				 else	if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("PAR�S")) {
						 miVentana.hotel.remove( miVentana.hotel.etiqueta);
						 miVentana.estanciasHotel.remove(miVentana.estanciasHotel.etiqueta);
						 miVentana.resumen.remove(miVentana.resumen.etiqueta);
						// miVentana.pago.remove(miVentana.pago.etiqueta);
						 miVentana.devolucion.remove(miVentana.devolucion.etiqueta);
						 //miVentana.fechas.remove(miVentana.fechas.etiqueta);
						enlace="/imagenes/paris.jpg";
						 
					}
				 else	if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("NUEVA YORK")) {
					 miVentana.hotel.remove( miVentana.hotel.etiqueta);
					 miVentana.estanciasHotel.remove(miVentana.estanciasHotel.etiqueta);
					 miVentana.resumen.remove(miVentana.resumen.etiqueta);
					// miVentana.pago.remove(miVentana.pago.etiqueta);
					 miVentana.devolucion.remove(miVentana.devolucion.etiqueta);
					// miVentana.fechas.remove(miVentana.fechas.etiqueta);
					enlace="/imagenes/ny2.jpg";
					 
				} else	if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("ROMA")) {
					 miVentana.hotel.remove( miVentana.hotel.etiqueta);
					 miVentana.estanciasHotel.remove(miVentana.estanciasHotel.etiqueta);
					 miVentana.resumen.remove(miVentana.resumen.etiqueta);
					// miVentana.pago.remove(miVentana.pago.etiqueta);
					 miVentana.devolucion.remove(miVentana.devolucion.etiqueta);
					// miVentana.fechas.remove(miVentana.fechas.etiqueta);
					enlace="/imagenes/roma.jpg";
					 
				
				}
					imagen1=new ImageIcon(PanelHotel.class.getResource(enlace));
					imagen2=new ImageIcon(PanelEstanciasHotel.class.getResource(enlace));
					imagen3=new ImageIcon(PanelResumen.class.getResource(enlace));
					imagen4=new ImageIcon(PanelDevolucion.class.getResource(enlace));
					imagen5=new ImageIcon(PanelPago.class.getResource(enlace));
					//imagen6=new ImageIcon(PanelFechas.class.getResource(enlace));
					
					miVentana.hotel.etiqueta = new JLabel(imagen1);
					miVentana.hotel.etiqueta.setBounds(-20,-20, 1200, 800);
					miVentana.hotel.etiqueta.setVisible(true);
					
					miVentana.estanciasHotel.etiqueta = new JLabel(imagen2);
					miVentana.estanciasHotel.etiqueta.setBounds(-20,-20, 1200, 800);
					miVentana.estanciasHotel.etiqueta.setVisible(true);
					
					miVentana.resumen.etiqueta = new JLabel(imagen3);
					miVentana.resumen.etiqueta.setBounds(-20,-20, 1200, 800);
					miVentana.resumen.etiqueta.setVisible(true);
					
					/*miVentana.pago.etiqueta = new JLabel(imagen4);
					miVentana.pago.etiqueta.setBounds(-20,-20, 1200, 800);
					miVentana.pago.etiqueta.setVisible(true);*/
					
					miVentana.devolucion.etiqueta = new JLabel(imagen5);
					miVentana.devolucion.etiqueta.setBounds(-20,-20, 1200, 800);
					miVentana.devolucion.etiqueta.setVisible(true);
					
					//miVentana.fechas.etiqueta = new JLabel(imagen6);
				//	miVentana.fechas.etiqueta.setBounds(-20,-20, 1200, 800);
				//	miVentana.fechas.etiqueta.setVisible(true);
					
					//AGREGAMOS LA ETIQUETA QUE CONTIENE LA IMAGEN AL FRAME
					this.miVentana.hotel.add(miVentana.hotel.etiqueta);	 
					this.miVentana.estanciasHotel.add(miVentana.estanciasHotel.etiqueta);
					this.miVentana.resumen.add(miVentana.resumen.etiqueta);
					//this.miVentana.pago.add(miVentana.pago.etiqueta);
					this.miVentana.devolucion.add(miVentana.devolucion.etiqueta);
					//this.miVentana.fechas.add(miVentana.fechas.etiqueta);
			}
			
			public void reiniciarImagen() {
				 miVentana.hotel.remove(miVentana.hotel.etiqueta);
					ImageIcon imagen=new ImageIcon(PanelHotel.class.getResource("/imagenes/pattern.jpg"));
					miVentana.hotel.etiqueta = new JLabel(imagen);
					miVentana.hotel.etiqueta.setBounds(-20, -20, 1200, 800);
					this.miVentana.hotel.add(miVentana.hotel.etiqueta);
					miVentana.hotel.etiqueta.setVisible(true);
			}

}

