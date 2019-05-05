package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import modelo.Modelo;
import vista.Ventana;

public class ControladorElegir implements ActionListener{

	private Ventana miVentana;
	private Modelo miModelo;
	FuncionesControlador funciones = new FuncionesControlador();
	public DefaultTableModel tabHotel ;
	
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
		

		case "hotel":funciones.cambiarDePanel(miVentana.alojamiento, miVentana.hotel);  MostrarHoteles();  
					
			try {
				ArrayList<String>ubicaciones=miModelo.misFuncionesHotel.mostrarUbicaciones();
				miVentana.hotel.comboBox.removeAllItems();
				for(int i=0;i<ubicaciones.size();i++) {
					miVentana.hotel.comboBox.addItem(ubicaciones.get(i));
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
	
		break;
		case "casa":  funciones.cambiarDePanel(miVentana.alojamiento, miVentana.casa); MostrarCasas(); 
		try {
			ArrayList<String>ubicaciones=miModelo.misFuncionesCasa.mostrarUbicaciones();
			miVentana.casa.comboBox.removeAllItems();
			for(int i=0;i<ubicaciones.size();i++) {
				miVentana.casa.comboBox.addItem(ubicaciones.get(i));
				
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		break;	
		
		case "apart":  funciones.cambiarDePanel(miVentana.alojamiento, miVentana.apartamento); MostrarApartamentos(); 
		try {
			ArrayList<String>ubicaciones=miModelo.misFuncionesApartamento.mostrarUbicaciones();
			miVentana.apartamento.comboBox.removeAllItems();
			for(int i=0;i<ubicaciones.size();i++) {
				miVentana.apartamento.comboBox.addItem(ubicaciones.get(i));
				
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
	
	public void MostrarCasas() {

	 try {
		miModelo.listaCasas=miModelo.misFuncionesCasa.leerCasa();
		
		for(int i=0;i<miModelo.listaCasas.size();i++) {
			Object[] casa = {miModelo.listaCasas.get(i).getCod_casa(),miModelo.listaCasas.get(i).getNombre(), miModelo.listaCasas.get(i).getUbicacion(),miModelo.listaCasas.get(i).getTamano(),miModelo.listaCasas.get(i).getPrecio()}; 
			miVentana.casa.tableModel.addRow(casa);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	
	}
	
	public void MostrarApartamentos() {

		 try {
			miModelo.listaApartamento=miModelo.misFuncionesApartamento.leerApartamento();
			
			for(int i=0;i<miModelo.listaApartamento.size();i++) {
				Object[] apartamento = {miModelo.listaApartamento.get(i).getCod_apartamento(),miModelo.listaApartamento.get(i).getNombre(), miModelo.listaApartamento.get(i).getUbicacion(),miModelo.listaApartamento.get(i).getTamano(),miModelo.listaApartamento.get(i).getPrecio(), miModelo.listaApartamento.get(i).getPiso()}; 
				miVentana.apartamento.tableModel.addRow(apartamento);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
		}

	
	
	/*
	public void tablaCasa() {
		String col[] = {"cod","Nombre","Ubicacion","Precio"};
		miVentana.hotel.tableModel= new DefaultTableModel(col, 0);
		
		 TableColumn tcol = miVentana.hotel.tablaResultados.getColumnModel().getColumn(3);
		 miVentana.hotel.tablaResultados.removeColumn(tcol);
		
		 this.miVentana.hotel.tablaResultados.setModel(miVentana.hotel.tableModel);
		 this.miVentana.hotel.tablaResultados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.miVentana.hotel.tablaResultados.getColumnModel().getColumn(0).setMaxWidth(0);
			this.miVentana.hotel.tablaResultados.getColumnModel().getColumn(0).setMinWidth(0);
			this.miVentana.hotel.tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(0);
			this.miVentana.hotel.tablaResultados.getColumnModel().getColumn(0).setResizable(false);
			this.miVentana.hotel.tablaResultados.setShowHorizontalLines(true);
			this.miVentana.hotel.tablaResultados.setDefaultEditor(Object.class, null);
			this.miVentana.hotel.tablaResultados.setBackground(new Color(230, 230, 250));
		
		
		
	}
	public void tablaApart() {
		String col[] = {"cod","Nombre","Ubicacion","Precio","Piso"};
		
		miVentana.hotel.tableModel= new DefaultTableModel(col, 0);
		
		 TableColumn tcol = miVentana.hotel.tablaResultados.getColumnModel().getColumn(3);
		 miVentana.hotel.tablaResultados.removeColumn(tcol);
		
		 this.miVentana.hotel.tablaResultados.setModel(miVentana.hotel.tableModel);
		 this.miVentana.hotel.tablaResultados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.miVentana.hotel.tablaResultados.getColumnModel().getColumn(0).setMaxWidth(0);
			this.miVentana.hotel.tablaResultados.getColumnModel().getColumn(0).setMinWidth(0);
			this.miVentana.hotel.tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(0);
			this.miVentana.hotel.tablaResultados.getColumnModel().getColumn(0).setResizable(false);
			this.miVentana.hotel.tablaResultados.setShowHorizontalLines(true);
			this.miVentana.hotel.tablaResultados.setDefaultEditor(Object.class, null);
			this.miVentana.hotel.tablaResultados.setBackground(new Color(230, 230, 250));
		
		
	}
	public void tablaHotel() {
		String col[] = {"cod","Nombre","Ubicacion","Estrellas"};
		
		miVentana.hotel.tableModel= new DefaultTableModel(col, 0);
		
		 TableColumn tcol = miVentana.hotel.tablaResultados.getColumnModel().getColumn(3);
		 miVentana.hotel.tablaResultados.removeColumn(tcol);
		this.miVentana.hotel.tablaResultados.setModel(miVentana.hotel.tableModel);
		this.miVentana.hotel.tablaResultados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.miVentana.hotel.tablaResultados.getColumnModel().getColumn(0).setMaxWidth(0);
		this.miVentana.hotel.tablaResultados.getColumnModel().getColumn(0).setMinWidth(0);
		this.miVentana.hotel.tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(0);
		this.miVentana.hotel.tablaResultados.getColumnModel().getColumn(0).setResizable(false);
		this.miVentana.hotel.tablaResultados.setShowHorizontalLines(true);
		this.miVentana.hotel.tablaResultados.setDefaultEditor(Object.class, null);
		this.miVentana.hotel.tablaResultados.setBackground(new Color(230, 230, 250));
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
		
		
	}*/

}