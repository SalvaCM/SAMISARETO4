package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import modelo.Modelo;
import vista.Ventana;

public class ControladorSaludo implements ActionListener{

	private Ventana miVentana;
	private Modelo miModelo;
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	public ControladorSaludo(Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miModelo =miModelo;
		
		miVentana.saludo.btnSaludo.addActionListener(this);
		
	}
	
	/**
	 * Metodo para las llamadas a los botones de la 
	 * ventana resumen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {
			    

		case "btnSaludo": funciones.cambiarDePanel(miVentana.saludo, miVentana.login);MostrarHoteles(); 
		
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
	

}
