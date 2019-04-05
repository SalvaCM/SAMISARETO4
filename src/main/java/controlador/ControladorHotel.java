
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
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
				
			}
			
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
					    
				case "btnSiguienteHotel": funciones.cambiarDePanel(miVentana.hotel, miVentana.resumen); OpcionElegida();
						break;
							
				case "btnBuscarHoteles": 
					
					ArrayList<Hotel> hoteles;
					try {
						hoteles = miModelo.misFuncionesHotel.buscarUbicacion(miVentana.hotel.comboBox.getSelectedItem().toString());
						 for(int i=0;i<hoteles.size();i++) {
								Object[] hoteles1 = {hoteles.get(i).getNombre(), hoteles.get(i).getUbicacion(), hoteles.get(i).getTarifa()}; 
								miVentana.hotel.tableModel.addRow(hoteles1);
						 }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
				}	
			}
						
		
		    
		    public void OpcionElegida()
		    {
		    	Object vector=miVentana.hotel.tableModel.getDataVector().elementAt(miVentana.hotel.tablaResultados.getSelectedRow());
		    	System.out.println(vector);
		    	miVentana.resumen.mostrarResumen.addElement(vector.toString());
		    	
		    }
		    
		   
		
			
	
	
			
		

}

