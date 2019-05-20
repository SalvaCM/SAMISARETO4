package controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.Modelo;
import vista.Ventana;

public class ControladorEstanciasHotel  implements ActionListener{

	private Ventana miVentana;
	private Modelo miModelo;
	
	
	FuncionesControlador funciones = new FuncionesControlador();
	private int controladorReservas=0;
	private Controlador miControlador;
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 * @param miControlador 
	 */
	public ControladorEstanciasHotel(Ventana miVentana, Modelo miModelo, Controlador miControlador) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		this.miControlador = miControlador;
		miVentana.estanciasHotel.btnCancelar.addActionListener(this);
		miVentana.estanciasHotel.btnSiguiente.addActionListener(this);	
		miVentana.estanciasHotel.btnReservar.addActionListener(this);
		miVentana.estanciasHotel.btnLogin.addActionListener(this);
		miVentana.estanciasHotel.btnPerfil.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {

		case "btnCancelarEstancias": funciones.cambiarDePanel(miVentana.estanciasHotel, miVentana.hotel);
			resetear();
			todosLosHoteles();
			break;

		case "Reservar": 
			try {
				
				if (miVentana.estanciasHotel.tablaHabitaciones.getSelectedRow() != -1 && miModelo.misFuncionesHotel.habitaOcupada(miModelo.reservaHotel.getHotelReservado().getHabitacionesDisp().get(miVentana.estanciasHotel.tablaHabitaciones.getSelectedRow()).getCodHabitacion(), miVentana.hotel.fechaEntrada.getDate(),miVentana.hotel.fechaSalida.getDate())==true)
				{
					// JOptionPane.showMessageDialog(miVentana, "Ocupado entre fechas  "+miModelo.misFuncionesHotel.rangoFechas(miModelo.reservaHotel.getHotelReservado().getHabitacionesDisp().get(miVentana.estanciasHotel.tablaHabitaciones.getSelectedRow()).getCodHabitacion(), miVentana.hotel.fechaEntrada.getDate(),miVentana.hotel.fechaSalida.getDate()).get(0)+"  y  "+miModelo.misFuncionesHotel.rangoFechas(miModelo.reservaHotel.getHotelReservado().getHabitacionesDisp().get(miVentana.estanciasHotel.tablaHabitaciones.getSelectedRow()).getCodHabitacion(), miVentana.hotel.fechaEntrada.getDate(),miVentana.hotel.fechaSalida.getDate()).get(1)+"", "SELECIONES OTRAS FECHAS!", JOptionPane.WARNING_MESSAGE);
					
					
				}
				
				 if(miVentana.estanciasHotel.tablaHabitaciones.getSelectedRow() == -1)	{
					JOptionPane.showMessageDialog(miVentana, "Seleccione  estancia para reservar!", "Atencion!", JOptionPane.WARNING_MESSAGE);
				}
				 else if (miVentana.estanciasHotel.tablaHabitaciones.getSelectedRow() != -1)
					{
						JOptionPane.showMessageDialog(miVentana, "Reservado!", "Atencion!", JOptionPane.WARNING_MESSAGE);
						
						HabitacionElegida();
						miVentana.estanciasHotel.tableModel.removeRow(miVentana.estanciasHotel.tablaHabitaciones.getSelectedRow());
						miVentana.resumen.resumenReserva.append(miModelo.reservaHotel.getHabReservadas().get(controladorReservas).toString());
						controladorReservas++;
						
					}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
				miVentana.resumen.mostrarResumen.addElement("N Estrellas: " +miModelo.reservaHotel.getHotelReservado().getnEstrellas());
				miVentana.resumen.txtDetalles.append(miModelo.reservaHotel.toString());
			}
			controladorReservas=0;
		break;
		case "btnLogin" : 
			miControlador.miControladorLogin.tratarLogin(miVentana.estanciasHotel.btnLogin,miVentana.estanciasHotel);
		break;
		
		case "btnPerfil" : 
			miControlador.miControladorUsuario.TratarPerfil(miVentana.estanciasHotel);
			miVentana.usuario.txtDatosPersonales.setText("");
			miVentana.usuario.txtDatosPersonales.append("Nombre : "+miModelo.cliente.getNombre()+" "+miModelo.cliente.getApellido()+"\nFecha Nac. :"+miModelo.cliente.getFechaNacimiento());
			miVentana.usuario.txtReservasPasadas.setText("");
			miVentana.usuario.txtReservasPasadas.append(miModelo.misFuncionesReserva.buscarReservasUsuario(miModelo.cliente));
			miVentana.usuario.txtreservasFuturas.setText("");
			miVentana.usuario.txtreservasFuturas.append(miModelo.misFuncionesReserva.buscarCodPromocionalesHotel(miModelo.cliente));
			miVentana.usuario.txtreservasFuturas.append(miModelo.misFuncionesReserva.buscarCodPromocionalesApart(miModelo.cliente));
			miVentana.usuario.txtreservasFuturas.append(miModelo.misFuncionesReserva.buscarCodPromocionalesCasa(miModelo.cliente));
			
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
		 int row = miVentana.estanciasHotel.tablaHabitaciones.getSelectedRow();
		 int codigoHabitacion = (int) miVentana.estanciasHotel.tableModel.getValueAt(row, 0);
		try {
			miModelo.reservaHotel.getHabReservadas().add(miModelo.misFuncionesHotel.reservarHabitacion(codigoHabitacion));
			miModelo.reservaHotel.setNoches((int) ((miVentana.hotel.fechaSalida.getCalendar().getTimeInMillis()-miVentana.hotel.fechaEntrada.getCalendar().getTimeInMillis())/86400000));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
	}
	public void resetear() {
		funciones.limpiarTabla(miVentana.estanciasHotel.tablaHabitaciones,miVentana.estanciasHotel.tableModel);
		funciones.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);
		miVentana.hotel.fechaEntrada.setCalendar(null);
		miVentana.hotel.fechaSalida.setCalendar(null);
		miVentana.hotel.fechaSalida.setEnabled(false);
		miVentana.hotel.nCamas.setValue(0);
		miVentana.resumen.mostrarResumen.clear();
		miVentana.resumen.resumenReserva.setText(null);
		miVentana.hotel.nEstrellas.setValue(0);
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
	}
}
