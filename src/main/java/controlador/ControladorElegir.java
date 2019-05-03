package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import modelo.Modelo;
import vista.Ventana;

public class ControladorElegir implements ActionListener{

	private Ventana miVentana;
	private Modelo miModelo;
	FuncionesControlador funciones = new FuncionesControlador();
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 */
	public ControladorElegir(Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		miVentana.alojamiento.hotel.addActionListener(this);
		miVentana.alojamiento.apart.addActionListener(this);
		miVentana.alojamiento.casa.addActionListener(this);
	
		
		
	}
	
	
	
	
	/**
	 * Metodo para las llamadas a los botones de la ventana resumen
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (((JButton) e.getSource()).getName()) {
		

		case "hotel":funciones.cambiarDePanel(miVentana.alojamiento, miVentana.hotel);MostrarHoteles(); 
					//funciones.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);
			try {
				ArrayList<String>ubicaciones=miModelo.misFuncionesHotel.mostrarUbicaciones();
				miVentana.hotel.comboBox.removeAllItems();
				for(int i=0;i<ubicaciones.size();i++) {
					//Object[] hotel = {miModelo.listaHoteles.get(i).getNombre(), miModelo.listaHoteles.get(i).getUbicacion(),miModelo.listaHoteles.get(i).getnEstrellas()}; 
					miVentana.hotel.comboBox.addItem(ubicaciones.get(i));
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
	
		break;
		case "casa":  funciones.cambiarDePanel(miVentana.alojamiento, miVentana.hotel);
		funciones.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);
		
		break;	
		case "apart":  funciones.cambiarDePanel(miVentana.alojamiento, miVentana.hotel);
		funciones.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);
			
			break;
		
	}
	
	
	}
	public void MostrarHoteles() {

		 try {
			miModelo.listaHoteles=miModelo.misFuncionesHotel.leerHoteles();
			
			for(int i=0;i<miModelo.listaHoteles.size();i++) {
				Object[] hotel = {miModelo.listaHoteles.get(i).getCod_hotel(),miModelo.listaHoteles.get(i).getNombre(), miModelo.listaHoteles.get(i).getUbicacion(),miModelo.listaHoteles.get(i).getnEstrellas()}; 
				miVentana.hotel.tableModel.addRow(hotel);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
	}	
	public void MostrarCasas() {

		 try {
			miModelo.listaApartamento=miModelo.misFuncionesHotel.leerHoteles();
			
			for(int i=0;i<miModelo.listaHoteles.size();i++) {
				Object[] hotel = {miModelo.listaHoteles.get(i).getCod_hotel(),miModelo.listaHoteles.get(i).getNombre(), miModelo.listaHoteles.get(i).getUbicacion(),miModelo.listaHoteles.get(i).getnEstrellas()}; 
				miVentana.hotel.tableModel.addRow(hotel);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
	}

}
