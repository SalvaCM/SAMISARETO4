package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.Casa;
import modelo.HabitacionHotel;
import modelo.Hotel;
import modelo.Modelo;
import vista.Ventana;

public class ControladorCasa implements ActionListener {
	
	private Ventana miVentana;
	private Modelo miModelo;

	
	FuncionesControlador funciones = new FuncionesControlador();
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 */
	public ControladorCasa(Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		miVentana.casa.btnSiguiente.addActionListener(this);
		miVentana.casa.btnBuscar.addActionListener(this);
		miVentana.casa.btnCancelar.addActionListener(this);
		miVentana.casa.btnPerfil.addActionListener(this); 
		
		miVentana.casa.fechaEntrada.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
		    public void propertyChange(PropertyChangeEvent e) {
		        System.out.println(e.getPropertyName()+ ":++ " + e.getNewValue());
		        java.util.Date fechaMinimaSalida=(java.util.Date) e.getNewValue();
		        fechaMinimaSalida.setTime(fechaMinimaSalida.getTime()+86400000);
		        miVentana.casa.fechaSalida.setEnabled(true);
		        miVentana.casa.fechaSalida.setMinSelectableDate(fechaMinimaSalida);
		    }
		});
		
		
	}
	
	/**
	 * Metodo para las llamadas a los botones de la ventana resumen
	 */
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {
		

			case "btnCancelarCasa": funciones.cambiarDePanel(miVentana.casa, miVentana.alojamiento);
			funciones.limpiarTabla(miVentana.casa.tablaResultados,miVentana.casa.tableModel);
			miVentana.casa.comboBox.removeAllItems();
			break;
			
			case "btnSiguienteCasa": funciones.cambiarDePanel(miVentana.casa, miVentana.resumen);	
			funciones.limpiarTabla(miVentana.casa.tablaResultados,miVentana.casa.tableModel);
			validarCampos();
			break;	

			case "btnBuscarCasas": filtrarPorUbicacion(miModelo.listaCasas);
			
			break;	
			
			case "btnPerfil": funciones.cambiarDePanel(miVentana.hotel, miVentana.usuario);
			miVentana.usuario.txtDatosPersonales.append("Nombre : "+miModelo.cliente.getNombre()+" "+miModelo.cliente.getApellido()+"\nFecha Nac. :"+miModelo.cliente.getFechaNacimiento());
			break;
		}
		
	}
	
	
		//METODOS
	
	private void validarCampos() {
		if(miVentana.casa.tablaResultados.getSelectedRow() == -1)
		{
			JOptionPane.showMessageDialog(miVentana, "Seleccione una casa", "Atencion!", JOptionPane.WARNING_MESSAGE);
	
		}
		else {
			if (miVentana.casa.fechaEntrada.getDate()==null||miVentana.casa.fechaSalida.getDate()==null)
			{
				JOptionPane.showMessageDialog(miVentana, "Seleccione fechas", "Atencion!", JOptionPane.WARNING_MESSAGE);
			}
			
			
			
		}
		/**
		 * 	Añade a la reserva el hotel seleccionado en el jtable
		 */
	}
	
	/**
	 * DEVUELVE UN ARRAYLIST DE LAS HABITACIONES DE UN HOTEL DETERMINADO
	 */
	public ArrayList<HabitacionHotel> Estancias() {
		
			ArrayList<HabitacionHotel> habitaciones = new ArrayList<HabitacionHotel>();
			int codigo = miModelo.reservaHotel.getHotelReservado().getCod_hotel();
			try {
				habitaciones =miModelo.misFuncionesHotel.leerHabitaciones(codigo);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			for  (int i=0;i<habitaciones.size();i++)
			{
				try {
					habitaciones.get(i).setCamas(miModelo.misFuncionesHotel.leerCamas(habitaciones.get(i).getCodHabitacion()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return habitaciones;
	}

	/**
	 * FILTRA LAS CASAS POR SU UBICACION
	 */
	public void filtrarPorUbicacion(ArrayList<Casa> casas) {
		
		funciones.limpiarTabla(miVentana.casa.tablaResultados,miVentana.casa.tableModel);
		try {
			miModelo.listaCasas= miModelo.misFuncionesCasa.buscarUbicacion(miVentana.casa.comboBox.getSelectedItem().toString());
			for(int i=0;i<miModelo.listaCasas.size();i++) {
				
				Object[] casa = {miModelo.listaCasas.get(i).getCod_casa(), miModelo.listaCasas.get(i).getNombre(), miModelo.listaCasas.get(i).getUbicacion(),miModelo.listaCasas.get(i).getTamano(), miModelo.listaCasas.get(i).getPrecio() }; 
				miVentana.casa.tableModel.addRow(casa);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();}
	}
	

}
