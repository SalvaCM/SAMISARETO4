package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import modelo.Modelo;
import modelo.estanciaHotel;
import vista.Ventana;

public class ControladorEstanciasHotel  implements ActionListener{

	private Ventana miVentana;
	private Modelo miModelo;
	private ControladorPago controladorPago;
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 */
	public ControladorEstanciasHotel(Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		this.miVentana.estanciasHotel.btnCancelar.addActionListener(this);
		this.miVentana.estanciasHotel.btnSiguiente.addActionListener(this);	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {
		
		case "btnCancelarEstancias": funciones.cambiarDePanel(miVentana.estanciasHotel, miVentana.hotel);limpiarTablas();todosLosHoteles();
		break;
		case "btnSiguienteEstancias": funciones.cambiarDePanel(miVentana.estanciasHotel, miVentana.resumen); HabitacionElegida();
		break;
		
		}
	}
	private void todosLosHoteles() {
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
	private void HabitacionElegida() {
		int codigo = miModelo.listaHoteles.get(miVentana.hotel.tablaResultados.getSelectedRow()).getCod_hotel();
		try {
			miModelo.reserva = miModelo.misFuncionesHotel.reservarHabitacion(codigo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		miVentana.resumen.mostrarResumen.addElement(miModelo.hotel.toString());
		miVentana.resumen.mostrarResumen.addElement("Categoria - "+miModelo.reserva.getCategoria()+" Tarifa - "+miModelo.reserva.getTarifa()+"Habitacion - "+miModelo.reserva.getCodAlojamiento());
		controladorPago.total=miModelo.reserva.getTarifa();
	}
	public void limpiarTablas()
	{
		int rows=miVentana.estanciasHotel.tableModel.getRowCount();
		for (int i = rows; i > 0; i--) {
			miVentana.estanciasHotel.tableModel.removeRow(i-1);
		}	
		rows=miVentana.hotel.tableModel.getRowCount();
		for (int i = rows; i > 0; i--) {
			miVentana.hotel.tableModel.removeRow(i-1);
		}	
}}
