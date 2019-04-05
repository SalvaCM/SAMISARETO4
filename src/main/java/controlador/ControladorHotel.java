
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import conexion.ConexionBD;
import conexion.ConsultaBD;
import modelo.Alojamiento;
import modelo.Hotel;
import modelo.Modelo;
import vista.Ventana;

public class ControladorHotel implements ActionListener {
			
			//private Controlador miControlador;
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
						
				case "BuscarHoteles": try {
						ArrayList<Hotel> hoteles = miModelo.misFuncionesHotel.leerHoteles();
					for(int i=0;i<hoteles.size();i++) {
						Object[] hoteles1 = {hoteles.get(i).getNombre(), hoteles.get(i).getUbicacion(), hoteles.get(i).getTarifa()}; 
						miVentana.hotel.tableModel.addRow(hoteles1);
					
						//Ir ala BBDD y leer los hoteles
						//Rellenar la lista con lo que le devuelve el metodo del modelo
						
					}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
						break;
				}
			}
			
	/*		public void mostrarAlojamientos(ArrayList<Alojamiento> alojamientos){      
		        for(int i = 0; i< alojamientos.size(); i++) {
		        	miVentana.hotel.modelo.addElement(alojamientos.get(i).toString());
		        	//se invoca el m�todo toString de la clase
		        }
			}*/

		
		    
		    public void OpcionElegida()
		    {
		    	Object vector=miVentana.hotel.tableModel.getDataVector().elementAt(miVentana.hotel.tablaResultados.getSelectedRow());
		    	System.out.println(vector);
		    	miVentana.resumen.mostrarResumen.addElement(vector.toString());
		    	
		    }
		    
		   
		
			
	
	
			
		

}

