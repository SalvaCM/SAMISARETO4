
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
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
			
			public void resetear() {
				int rows=miVentana.hotel.tableModel.getRowCount();
				for (int i = rows; i > 0; i--) {
					miVentana.hotel.tableModel.removeRow(i-1);
				}
				
			}
			
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
				

					case "btnCancelarHotel": funciones.cambiarDePanel(miVentana.hotel, miVentana.saludo);
					funciones.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);					
					break;

					case "btnSiguienteHotel": 	
					
					if(miVentana.hotel.tablaResultados.getSelectedRow() == -1)
					{
						JOptionPane.showMessageDialog(miVentana, "Seleccione un hotel", "Atencion!", JOptionPane.WARNING_MESSAGE);
				
					}else {
						
						funciones.cambiarDePanel(miVentana.hotel, miVentana.estanciasHotel); Estancias();
					}

					break;
						

					case "btnBuscarHoteles": filtrarPorUbicacion(miModelo.listaHoteles);
					break;
					
					
				
						
					
					
				}

			}
				
			
			public void Estancias() {
				try {
					miModelo.hotel= miModelo.listaHoteles.get(miVentana.hotel.tablaResultados.getSelectedRow());
					int codigo = miModelo.listaHoteles.get(miVentana.hotel.tablaResultados.getSelectedRow()).getCod_hotel();
					
					miModelo.hotel.setEstancias(miModelo.misFuncionesHotel.leerEstancias(codigo));
					for(int i=0;i<miModelo.hotel.estancias.size();i++) {
						Object[] habitacion = {miModelo.hotel.estancias.get(i).getCodAlojamiento(),miModelo.hotel.estancias.get(i).getCategoria(), miModelo.hotel.estancias.get(i).getExistencias(),miModelo.hotel.estancias.get(i).getTarifa()};
						miVentana.estanciasHotel.tableModel.addRow(habitacion);
					}
					
				} catch (SQLException e1) {
				System.out.println("seleccione un hotel");
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


}

