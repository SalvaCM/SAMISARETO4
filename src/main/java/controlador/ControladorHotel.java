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
import modelo.Modelo;
import vista.Ventana;

public class ControladorHotel implements ActionListener {
			
			//private Controlador miControlador;
			private Ventana miVentana;
			private Modelo miModelo;
			
			FuncionesControlador funciones = new FuncionesControlador();
			ConexionBD miConexion = new ConexionBD();
			ConsultaBD miConsulta = new ConsultaBD();
			
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
					    
				case "btnSiguienteHotel": funciones.cambiarDePanel(miVentana.hotel, miVentana.resumen);  
						break;
						
				case "btnBuscarHoteles": mostrarAlojamientos(miModelo.misFuncionesHotel.alojamientos); buscar();
						break;
				}
			}
			
			public void mostrarAlojamientos(ArrayList<Alojamiento> alojamientos){      
		        for(int i = 0; i< alojamientos.size(); i++) {
		        	miVentana.hotel.modelo.addElement(alojamientos.get(i).toString());
		        	//se invoca el m�todo toString de la clase
		        }
			}
			
			public void buscar() {
				Connection conexion = miConexion.ConectarBD();  
				ResultSet rs = miConsulta.hacerConsultaBD(conexion, "select * from cliente where nombre = 'pepe';");
			
				String nombre = null;
				String edad = null ; 
				
				
				
				try {
					while(rs.next()) {
						
						nombre = rs.getString("nombre");
						edad = rs.getString("edad");
						

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				miVentana.hotel.modelo.addElement(nombre);
				miVentana.hotel.modelo.addElement(edad);
				
			}
	
	
			
		

}
