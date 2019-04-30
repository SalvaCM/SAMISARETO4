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
	private int controladorReservas=0;
	
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
		this.miVentana.estanciasHotel.btnReservar.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {

		case "btnCancelarEstancias": 
			funciones.cambiarDePanel(miVentana.estanciasHotel, miVentana.hotel);
			funciones.limpiarTabla(miVentana.estanciasHotel.tablaHabitaciones,miVentana.estanciasHotel.tableModel);
			funciones.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);
			todosLosHoteles();
			break;

		case "Reservar": 
			if (miVentana.estanciasHotel.tablaHabitaciones.getSelectedRow() == -1)
			{
				JOptionPane.showMessageDialog(miVentana, "Seleccione  estancia para reservar!", "Atencion!", JOptionPane.WARNING_MESSAGE);
			}
			else 
			{
				JOptionPane.showMessageDialog(miVentana, "Reservado!", "Atencion!", JOptionPane.WARNING_MESSAGE);
				HabitacionElegida();
				miVentana.resumen.resumenReserva.append(miModelo.reservaHotel.getHabReservadas().get(controladorReservas).toString());
				controladorReservas++;
			}
		break;
		
		case "btnSiguienteEstancias":
			
			if (controladorReservas==0)
			{
				JOptionPane.showMessageDialog(miVentana, "Reserve una estancia antes de continuar!", "Atencion!", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				funciones.cambiarDePanel(miVentana.estanciasHotel, miVentana.resumen);
				miVentana.resumen.mostrarResumen.addElement("Nombre: " + miModelo.reservaHotel.getHotelReservado().getNombre());
				miVentana.resumen.mostrarResumen.addElement("Ubicacion: " + miModelo.reservaHotel.getHotelReservado().getUbicacion());
				miVentana.resumen.mostrarResumen.addElement("Nº Estrellas: " +miModelo.reservaHotel.getHotelReservado().getnEstrellas());
				miVentana.resumen.txtDetalles.append(miModelo.reservaHotel.toString());
			}
			controladorReservas=0;
			
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
		
		
		int codigoHabitacion =miModelo.reservaHotel.getHotelReservado().getHabitacionesDisp().get(miVentana.estanciasHotel.tablaHabitaciones.getSelectedRow()).getCodHabitacion();
		try {
			miModelo.reservaHotel.getHabReservadas().add(miModelo.misFuncionesHotel.reservarHabitacion(codigoHabitacion));
			miModelo.reservaHotel.setNoches((int) ((miVentana.hotel.fechaSalida.getCalendar().getTimeInMillis()-miVentana.hotel.fechaEntrada.getCalendar().getTimeInMillis())/86400000));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
	}
	
}
