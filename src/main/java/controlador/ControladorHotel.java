
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import modelo.Hotel;
import modelo.Modelo;
import modelo.estanciaHotel;
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
			public ArrayList<estanciaHotel> estancias;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
				
					case "btnCancelarHotel": funciones.cambiarDePanel(miVentana.hotel, miVentana.saludo); resetear();			
					break;

					case "btnSiguienteHotel": funciones.cambiarDePanel(miVentana.hotel, miVentana.estanciasHotel); OpcionElegida(); Estancias();
					
					break;
						

					case "btnBuscarHoteles": filtrarPorUbicacion(miModelo.listaHoteles);
					break;
					
				}

			}
				
			
			public void Estancias() {
				int rows=miVentana.estanciasHotel.tableModel.getRowCount();
				for (int i = rows; i > 0; i--) {
					miVentana.estanciasHotel.tableModel.removeRow(i-1);
				}
				
				try {
					int codigo = miVentana.hotel.tablaResultados.getSelectedRow()+1;
					estancias = miModelo.misFuncionesHotel.leerEstancias(codigo);
					for(int i=0;i<estancias.size();i++) {
						Object[] habitacion = {estancias.get(i).getCategoria(), estancias.get(i).getExistencias(),estancias.get(i).getTarifa()};
						miVentana.estanciasHotel.tableModel.addRow(habitacion);
						
					}
					
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
			public void filtrarPorUbicacion(ArrayList<Hotel> hoteles) {
				int rows=miVentana.hotel.tableModel.getRowCount();
				for (int i = rows; i > 0; i--) {
					miVentana.hotel.tableModel.removeRow(i-1);
				}
				try {
					miModelo.listaHoteles= miModelo.misFuncionesHotel.buscarUbicacion(miVentana.hotel.comboBox.getSelectedItem().toString());
					for(int i=0;i<miModelo.listaHoteles.size();i++) {
						
						Object[] hotel = {miModelo.listaHoteles.get(i).getNombre(), miModelo.listaHoteles.get(i).getUbicacion(),miModelo.listaHoteles.get(i).getnEstrellas()}; 
						miVentana.hotel.tableModel.addRow(hotel);
					}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();}
			}

			public void OpcionElegida()

		    {
		    	Object hotelSelecionado = miVentana.hotel.tableModel.getDataVector().elementAt(miVentana.hotel.tablaResultados.getSelectedRow());
		    	miVentana.resumen.mostrarResumen.addElement(miModelo.listaHoteles.get(miVentana.hotel.tablaResultados.getSelectedRow()).toString());
		    	
		    	//miVentana.resumen.mostrarResumen.addElement(miModelo.lista);
		    }

}

