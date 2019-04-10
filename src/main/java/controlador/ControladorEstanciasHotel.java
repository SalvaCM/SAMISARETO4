package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.Modelo;
import vista.Ventana;

public class ControladorEstanciasHotel  implements ActionListener{

	private Ventana miVentana;
	private Modelo miModelo;
	
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
		case "btnSiguienteEstancias": 
		
		if(miVentana.estanciasHotel.tablaHabitaciones.getSelectedRow() == -1)
		{
			JOptionPane.showMessageDialog(miVentana, "Seleccione una estancia", "Atencion!", JOptionPane.WARNING_MESSAGE);
	
		}else {
			
			funciones.cambiarDePanel(miVentana.estanciasHotel, miVentana.resumen); HabitacionElegida();
		}
		
		break;
		
		}
	}
	public void todosLosHoteles() {
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
	public void HabitacionElegida() {

		int codigoHabitacion = miModelo.hotel.estancias.get(miVentana.estanciasHotel.tablaHabitaciones.getSelectedRow()).getCodAlojamiento();
		try {
			miModelo.reserva = miModelo.misFuncionesHotel.reservarHabitacion(codigoHabitacion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		miVentana.resumen.mostrarResumen.addElement("Nombre del Hotel: " + miModelo.hotel.getNombre());
		miVentana.resumen.mostrarResumen.addElement("Ubicacion: " + miModelo.hotel.getUbicacion());
		miVentana.resumen.mostrarResumen.addElement("Nº Estrellas: " +miModelo.hotel.getnEstrellas());
		
		miVentana.resumen.mostrarResumen.addElement("Categoria: "+miModelo.reserva.getCategoria());
		miVentana.resumen.mostrarResumen.addElement("Tarifa: "+miModelo.reserva.getTarifa());
		miVentana.resumen.mostrarResumen.addElement("Habitacion: "+miModelo.reserva.getCodAlojamiento());

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
