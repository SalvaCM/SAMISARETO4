
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Hotel;
import modelo.Modelo;
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
		
				
			}
			
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
				

					case "btnCancelarHotel": funciones.cambiarDePanel(miVentana.hotel, miVentana.saludo);
					funciones.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);
					System.out.println("contraseña ="+miModelo.cliente.getContrasena().toString());
					break;
					case "btnSiguienteHotel": 	
					
					if(miVentana.hotel.tablaResultados.getSelectedRow() == -1)
					{
						JOptionPane.showMessageDialog(miVentana, "Seleccione un hotel", "Atencion!", JOptionPane.WARNING_MESSAGE);
				
					}else {
						
						funciones.cambiarDePanel(miVentana.hotel, miVentana.estanciasHotel); Estancias();
					}

					break;
						

					case "btnBuscarHoteles": filtrarPorUbicacion(miModelo.listaHoteles); imagen();
					
					break;
					
					
				
						
					
					
				}

			}
				
			
			public void Estancias() {
				try {
					miModelo.hotel = miModelo.listaHoteles.get(miVentana.hotel.tablaResultados.getSelectedRow());
					int codigo = miModelo.listaHoteles.get(miVentana.hotel.tablaResultados.getSelectedRow()).getCod_hotel();
					miModelo.hotel.habitaciones=miModelo.misFuncionesHotel.leerHabitaciones(codigo);
					for(int i=0;i<miModelo.hotel.habitaciones.size();i++) {
						Object[] habitacion = {miModelo.hotel.habitaciones.get(i).getCodHabitacion(),miModelo.hotel.habitaciones.get(i).getTipo(), miModelo.hotel.habitaciones.get(i).getnCamas(),miModelo.hotel.habitaciones.get(i).getPrecio()};
						miVentana.estanciasHotel.tableModel.addRow(habitacion);
					}
					
				} catch (SQLException e1) {
				e1.printStackTrace();
				}
			}
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
				 ImageIcon imagen;
				// JLabel etiqueta = null;
				this.miVentana.hotel.repaint();
				
				
				 if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("BARCELONA")) {
					 miVentana.hotel.remove( miVentana.hotel.etiqueta);
						enlace="C:\\workReto4\\SAMISARETO4\\src\\main\\java\\imagenes\\b.jpg";
						System.out.println("barcelona");
						
				}
				 else if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("MADRID")) {
					 miVentana.hotel.remove( miVentana.hotel.etiqueta);
						enlace="C:\\workReto4\\SAMISARETO4\\src\\main\\java\\imagenes\\m.jpg";
						System.out.println("m");
						
				}
				 else if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("SEVILLA")) {
						 miVentana.hotel.remove( miVentana.hotel.etiqueta);
						enlace="C:\\workReto4\\SAMISARETO4\\src\\main\\java\\imagenes\\sev.jpg";
						 
					}
				 else	if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("VALENCIA")) {
						 miVentana.hotel.remove( miVentana.hotel.etiqueta);
						enlace="C:\\workReto4\\SAMISARETO4\\src\\main\\java\\imagenes\\valencia.jpg";
						 
					}
				 else	if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("PARÍS")) {
						 miVentana.hotel.remove( miVentana.hotel.etiqueta);
						enlace="C:\\workReto4\\SAMISARETO4\\src\\main\\java\\imagenes\\paris.jpg";
						 
					}
				 else	if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("NUEVA YORK")) {
					 miVentana.hotel.remove( miVentana.hotel.etiqueta);
					enlace="C:\\workReto4\\SAMISARETO4\\src\\main\\java\\imagenes\\ny2.jpg";
					 
				} else	if(miVentana.hotel.comboBox.getSelectedItem().toString().equals("ROMA")) {
					 miVentana.hotel.remove( miVentana.hotel.etiqueta);
					enlace="C:\\workReto4\\SAMISARETO4\\src\\main\\java\\imagenes\\roma.jpg";
					 
				
				}
					imagen=new ImageIcon(enlace);
					//JOptionPane.showMessageDialog(null,imagen);
					miVentana.hotel.etiqueta = new JLabel(imagen);
					miVentana.hotel.etiqueta.setBounds(-20,-20, 1200, 800);
					miVentana.hotel.etiqueta.setVisible(true);
					//AGREGAMOS LA ETIQUETA QUE CONTIENE LA IMAGEN AL FRAME
					//this.miVentana.hotel.repaint();
					this.miVentana.hotel.add(miVentana.hotel.etiqueta);	 
				
			}
			


}

