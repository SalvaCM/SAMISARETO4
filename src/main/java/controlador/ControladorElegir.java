package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Modelo;
import vista.Ventana;

public class ControladorElegir implements ActionListener{

	private Ventana miVentana;
	private Modelo miModelo;
	FuncionesControlador funciones = new FuncionesControlador();
	public DefaultTableModel tabHotel ;
	public int elegido = 1;
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 * @param miControlador 
	 */
	public ControladorElegir(Ventana miVentana, Modelo miModelo, Controlador miControlador) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		miVentana.alojamiento.hotel.addActionListener(this);
		miVentana.alojamiento.apart.addActionListener(this);
		miVentana.alojamiento.casa.addActionListener(this);
		miVentana.alojamiento.btnLogin.addActionListener(this);
		miVentana.alojamiento.btnPerfil.addActionListener(this);
	}

	/**
	 * Metodo para las llamadas a los botones de la ventana resumen
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (((JButton) e.getSource()).getName()) {
		

		case "hotel":	
			funciones.cambiarDePanel(miVentana.alojamiento, miVentana.hotel);  MostrarHoteles();  
					
			try {
				elegido=1;
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
		elegido=2;
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
		
		case "apart":  funciones.cambiarDePanel(miVentana.alojamiento, miVentana.apartamento);
		elegido=3;
		MostrarApartamentos(); 
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
		case "btnLogin" : 
			if (miVentana.alojamiento.btnLogin.getText().equals("Login"))
			{
				miVentana.login.paneldeRetorno=miVentana.alojamiento;
				funciones.cambiarDePanel(miVentana.alojamiento, miVentana.login);
			}
			else
			{
				desactivarPerfil();
				miVentana.login.paneldeRetorno=null;
				funciones.cambiarDePanel(miVentana.alojamiento, miVentana.saludo);
				JOptionPane.showMessageDialog(miVentana, "Desconectando Usuario", "Atencion!", JOptionPane.WARNING_MESSAGE);
				miModelo.logged=false;
				funciones.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);
				funciones.limpiarTabla(miVentana.estanciasHotel.tablaHabitaciones,miVentana.estanciasHotel.tableModel);
				funciones.limpiarTabla(miVentana.casa.tablaResultados,miVentana.hotel.tableModel);
				funciones.limpiarTabla(miVentana.apartamento.tablaResultados,miVentana.hotel.tableModel);
			}
		break;
		
		case "btnPerfil" : 
			funciones.cambiarDePanel(miVentana.alojamiento, miVentana.usuario);	
			miVentana.usuario.txtDatosPersonales.append("Nombre : " + miModelo.cliente.getNombre() + " "
					+ miModelo.cliente.getApellido() + "\nFecha Nac. :" + miModelo.cliente.getFechaNacimiento());
		break;
	}
	
	
	}
	public void MostrarHoteles() {

		 try {
			miModelo.listaHoteles=miModelo.misFuncionesHotel.leerHoteles();
			funciones.limpiarTabla(miVentana.hotel.tablaResultados, miVentana.hotel.tableModel);
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
		funciones.limpiarTabla(miVentana.casa.tablaResultados,miVentana.casa.tableModel);
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
			funciones.limpiarTabla(miVentana.apartamento.tablaResultados,miVentana.apartamento.tableModel);
			for(int i=0;i<miModelo.listaApartamento.size();i++) {
				Object[] apartamento = {miModelo.listaApartamento.get(i).getCod_apartamento(),miModelo.listaApartamento.get(i).getNombre(), miModelo.listaApartamento.get(i).getUbicacion(),miModelo.listaApartamento.get(i).getTamano(),miModelo.listaApartamento.get(i).getPrecio(), miModelo.listaApartamento.get(i).getPiso()}; 
				miVentana.apartamento.tableModel.addRow(apartamento);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
		}
	public void desactivarPerfil() {
		String logout="Login";
		miVentana.alojamiento.btnLogin.setText(logout);
		miVentana.apartamento.btnLogin.setText(logout);
		miVentana.casa.btnLogin.setText(logout);
		miVentana.devolucion.btnLogin.setText(logout);
		miVentana.estanciasHotel.btnLogin.setText(logout);
		miVentana.resumen.btnLogin.setText(logout);
		miVentana.resumenCyA.btnLogin.setText(logout);
		miVentana.hotel.btnLogin.setText(logout);

		
		miVentana.alojamiento.btnPerfil.setEnabled(false);
		miVentana.apartamento.btnPerfil.setEnabled(false);
		miVentana.casa.btnPerfil.setEnabled(false);
		miVentana.devolucion.btnPerfil.setEnabled(false);
		miVentana.estanciasHotel.btnPerfil.setEnabled(false);
		miVentana.resumen.btnPerfil.setEnabled(false);
		miVentana.resumenCyA.btnPerfil.setEnabled(false);
		miVentana.hotel.btnPerfil.setEnabled(false);
		
	}	




}
