
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
				miVentana.hotel.btnVer.addActionListener(this);
				miVentana.hotel.btnCancelar.addActionListener(this);
		

			}
			
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			public ArrayList<estanciaHotel> estancias;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
				
					case "btnCancelarHotel": funciones.cambiarDePanel(miVentana.hotel, miVentana.saludo); 					
					break;
					    

					case "btnSiguienteHotel": funciones.cambiarDePanel(miVentana.hotel, miVentana.resumen); OpcionElegida();					
					break;
						

					case "btnBuscarHoteles": buscarHoteles();
					break;
					
					case "ver": verEstancias();
					break;
				}

			}
				
			private void verEstancias() {
				try {
					estancias = miModelo.misFuncionesHotel.leerEstancias(001);
					for(int i=0;i<estancias.size();i++) {
						miVentana.hotel.textArea.append("Categoria :"+estancias.get(i).getCategoria()+"    Precio :"+estancias.get(i).getTarifa()+"€"+"     Corre, solo quedan "+estancias.get(i).getExistencias()+"   disponibles!"+"\n");
					}
				}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
			}

			public void buscarHoteles() {
				ArrayList<Hotel> hoteles;
				int rows=miVentana.hotel.tableModel.getRowCount();
				for (int i = rows; i > 0; i--) {
					miVentana.hotel.tableModel.removeRow(i-1);
				}
				try {
					hoteles = miModelo.misFuncionesHotel.buscarUbicacion(miVentana.hotel.comboBox.getSelectedItem().toString());
					for(int i=0;i<hoteles.size();i++) {
						Object[] hoteles1 = {hoteles.get(i).getNombre(), hoteles.get(i).getUbicacion()}; 
						miVentana.hotel.tableModel.addRow(hoteles1);
					}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();}
			}

			public void OpcionElegida()

		    {
		    	Object hotelSelecionado = miVentana.hotel.tableModel.getDataVector().elementAt(miVentana.hotel.tablaResultados.getSelectedRow());
		    	miVentana.resumen.mostrarResumen.addElement(hotelSelecionado.toString());

		    }

}

