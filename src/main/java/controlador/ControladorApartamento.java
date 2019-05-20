package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Apartamento;
import modelo.Modelo;
import vista.Ventana;

public class ControladorApartamento implements ActionListener {
	
	private Ventana miVentana;
	private Modelo miModelo;
	private Controlador miControlador;

	
	FuncionesControlador funciones = new FuncionesControlador();
	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 */
	public ControladorApartamento(Ventana miVentana, Modelo miModelo,Controlador miControlador) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		this.miControlador=miControlador;
		
		miVentana.apartamento.btnSiguiente.addActionListener(this);
		miVentana.apartamento.btnBuscar.addActionListener(this);
		miVentana.apartamento.btnCancelar.addActionListener(this);
		miVentana.apartamento.btnPerfil.addActionListener(this); 
		miVentana.apartamento.btnLogin.addActionListener(this);
		miVentana.apartamento.BoxGim.addItemListener(new pincharServicios());
		miVentana.apartamento.BoxPark.addItemListener(new pincharServicios());
		miVentana.apartamento.BoxPisc.addItemListener(new pincharServicios());
		miVentana.apartamento.BoxSpa.addItemListener(new pincharServicios());
		miVentana.apartamento.BoxWi.addItemListener(new pincharServicios());
		
		
		miVentana.apartamento.fechaEntrada.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
		    public void propertyChange(PropertyChangeEvent e) {
		        System.out.println(e.getPropertyName()+ ":Entrada " + e.getNewValue());
		        java.util.Date fechaMinimaSalida=(java.util.Date) e.getNewValue();
		        if(fechaMinimaSalida != null) {
		        fechaMinimaSalida.setTime(fechaMinimaSalida.getTime()+86400000);
		        }
		        miVentana.apartamento.fechaSalida.setEnabled(true);
		        miVentana.apartamento.fechaSalida.setMinSelectableDate(fechaMinimaSalida);
		    }
		});
		miVentana.apartamento.fechaSalida.addPropertyChangeListener("date", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent e) {
            	 System.out.println(e.getPropertyName()+ ":Salida " + e.getNewValue());
            	funciones.limpiarTabla(miVentana.apartamento.tablaResultados,miVentana.apartamento.tableModel);
            	resetearServicios();
            	try {
            		miModelo.listaApartamento=miModelo.misFuncionesApartamento.leerApartamento();
            	} catch (SQLException e1) {
            		// TODO Auto-generated catch block
            		e1.printStackTrace();
            	}
        		//System.out.println("TASA: "+miModelo.misFuncionesPago.tasa(miVentana.apartamento.fechaEntrada.getDate(), miVentana.apartamento.fechaSalida.getDate()));
            	for(int i=0;i<miModelo.listaApartamento.size();i++) {

            		miModelo.listaApartamento.get(i).setPrecio((float) (miModelo.listaApartamento.get(i).getPrecio()*miModelo.misFuncionesPago.tasa(miVentana.apartamento.fechaEntrada.getDate(), miVentana.apartamento.fechaSalida.getDate())));
            		Object[] apart = {miModelo.listaApartamento.get(i).getCod_apartamento(),miModelo.listaApartamento.get(i).getNombre(), miModelo.listaApartamento.get(i).getUbicacion(),miModelo.listaApartamento.get(i).getTamano(),miModelo.listaApartamento.get(i).getPrecio(),miModelo.listaApartamento.get(i).getPiso()};
            		miVentana.apartamento.tableModel.addRow(apart);

                }

            	
}

});
		

		
	}
	
	/**
	 * Metodo para las llamadas a los botones de la ventana resumen
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {
		

			case "btnCancelarApartamento": funciones.cambiarDePanel(miVentana.apartamento, miVentana.alojamiento);
			funciones.limpiarTabla(miVentana.apartamento.tablaResultados,miVentana.apartamento.tableModel);
			miVentana.casa.comboBox.removeAllItems();
			
			miVentana.apartamento.fechaEntrada.setCalendar(null);
			miVentana.apartamento.fechaSalida.setCalendar(null);
			miVentana.apartamento.fechaSalida.setEnabled(false);
			
			break;
			
			case "btnSiguienteApartamento": 
			
			validarCampos();
			
			break;	

			case "btnBuscarApartamentos": filtrarPorUbicacion(miModelo.listaApartamento);
			
			break;	
			case "btnLogin" : 
				miControlador.miControladorLogin.tratarLogin(miVentana.apartamento.btnLogin,miVentana.apartamento);
			break;
			
			case "btnPerfil" : 
				miControlador.miControladorUsuario.TratarPerfil(miVentana.apartamento);
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
	
	
	/**
	 * para saber que servicios adicionales se han seleccionado 
	 */
	private class pincharServicios implements ItemListener {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
		
				try {
					
					ArrayList<Apartamento> apartamentos =new ArrayList<Apartamento>();
							apartamentos=miModelo.misFuncionesServicios.serviciosApart(miVentana.apartamento.BoxPark.isSelected(), miVentana.apartamento.BoxPisc.isSelected(),miVentana.apartamento.BoxGim.isSelected(),miVentana.apartamento.BoxWi.isSelected(),miVentana.apartamento.BoxSpa.isSelected());
						funciones.limpiarTabla(miVentana.apartamento.tablaResultados, miVentana.apartamento.tableModel);
						for(int i=0;i<apartamentos.size();i++) {
							apartamentos.get(i).setPrecio(miModelo.listaApartamento.get(i).getPrecio()+miModelo.misFuncionesServicios.adicionA(miModelo.listaApartamento.get(i).getCod_apartamento(), miVentana.apartamento.BoxPark.isSelected(), miVentana.apartamento.BoxPisc.isSelected(), miVentana.apartamento.BoxGim.isSelected(), miVentana.apartamento.BoxWi.isSelected(), miVentana.apartamento.BoxSpa.isSelected()));
								Object[] aparta = {apartamentos.get(i).getCod_apartamento(),apartamentos.get(i).getNombre(),apartamentos.get(i).getUbicacion(),apartamentos.get(i).getTamano(),apartamentos.get(i).getPrecio(),apartamentos.get(i).getPiso()}; 
								miVentana.apartamento.tableModel.addRow(aparta);
								}
						if(miVentana.apartamento.BoxGim.isSelected()==false && miVentana.apartamento.BoxPisc.isSelected()==false && miVentana.apartamento.BoxPark.isSelected()==false && miVentana.apartamento.BoxSpa.isSelected()==false && miVentana.apartamento.BoxWi.isSelected()==false) {

				    			funciones.limpiarTabla(miVentana.apartamento.tablaResultados, miVentana.apartamento.tableModel);
				    			for(int i=0;i<miModelo.listaApartamento.size();i++) {
									Object[] aparta2 = {miModelo.listaApartamento.get(i).getCod_apartamento(),miModelo.listaApartamento.get(i).getNombre(), miModelo.listaApartamento.get(i).getUbicacion(),miModelo.listaApartamento.get(i).getTamano(),miModelo.listaApartamento.get(i).getPrecio(),miModelo.listaApartamento.get(i).getPiso()}; 
									miVentana.apartamento.tableModel.addRow(aparta2);
									}
				    			
				    			
				    		}
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
		    		
				
			 
		    }
		
		
		
		
	}
	

	/**
	* valida que los campos del apartamento son validos 
 	*/

	private void validarCampos() {
		if(miVentana.apartamento.tablaResultados.getSelectedRow() == -1)
		{
			JOptionPane.showMessageDialog(miVentana, "Seleccione una apartamento", "Atencion!", JOptionPane.WARNING_MESSAGE);
	
		}
		else {
			if (miVentana.apartamento.fechaEntrada.getDate()==null||miVentana.apartamento.fechaSalida.getDate()==null)
			{
				JOptionPane.showMessageDialog(miVentana, "Seleccione fechas", "Atencion!", JOptionPane.WARNING_MESSAGE);
			}
			else{
				 DateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
				 funciones.cambiarDePanel(miVentana.apartamento, miVentana.resumenCyA);
				 miModelo.reserva.setApartReservado(ReservarApartamento());
				 miModelo.reserva.setFechaEntrada(miVentana.apartamento.fechaEntrada.getDate());
				 miModelo.reserva.setFechaSalida(miVentana.apartamento.fechaSalida.getDate());
				 String fechaE = dateF.format( miModelo.reserva.getFechaEntrada());
				 String fechaS=  dateF.format(miModelo.reserva.getFechaSalida());
				 miModelo.reserva.setNoches((int) ((miVentana.apartamento.fechaSalida.getCalendar().getTimeInMillis()-miVentana.apartamento.fechaEntrada.getCalendar().getTimeInMillis())/86400000));
				 miVentana.resumenCyA.resumenReserva.append(miModelo.reserva.getApartReservado().toString());
				 miVentana.resumenCyA.txtDetalles.append("Fecha entrada:  "+ fechaE+"\n");
				 miVentana.resumenCyA.txtDetalles.append("Fecha salida:  "+ fechaS+"\n");
				 miVentana.resumenCyA.txtDetalles.append("Numero de noches:  "+ miModelo.reserva.getNoches());		 
				 miControlador.miControladorPago.total = miModelo.reserva.getApartReservado().getPrecio()* miModelo.reserva.getNoches();
				 miVentana.pago.total.setText(formatoMoneda.format(0));
				 miVentana.pago.total.setText(formatoMoneda.format(miControlador.miControladorPago.total));


				 try {
						miVentana.resumenCyA.resumenReserva.append("\nHabitaciones :\n" ); 
						miModelo.apartamento.setHabitaciones(miModelo.misFuncionesApartamento.leerHabitaciones(miModelo.reserva.getApartReservado().getCod_apartamento()));
						for (int i = 0; i < miModelo.apartamento.getHabitaciones().size(); i++) {
							miVentana.resumenCyA.resumenReserva.append( miModelo.apartamento.getHabitaciones().get(i).toString());
						}
						miVentana.resumenCyA.resumenReserva.append("\nDormitorios :\n" );
						miModelo.apartamento.setDormitorios(miModelo.misFuncionesApartamento.leerDormitorios(miModelo.reserva.getApartReservado().getCod_apartamento()));
						for (int i = 0; i < miModelo.apartamento.getDormitorios().size(); i++) {
							miVentana.resumenCyA.resumenReserva.append( miModelo.apartamento.getDormitorios().get(i).toString());
						}
					} catch (SQLException e) {
			
						e.printStackTrace();
					}
					
			
				}
			}
		}

	


	/**
	 * añade a la tabla los apartamentos con la filtracion por ubicacion
	 * @param apartamento
	 */
	public void filtrarPorUbicacion(ArrayList<Apartamento> apartamento) {
		
		funciones.limpiarTabla(miVentana.apartamento.tablaResultados,miVentana.apartamento.tableModel);
		try {
			miModelo.listaApartamento= miModelo.misFuncionesApartamento.buscarUbicacion(miVentana.apartamento.comboBox.getSelectedItem().toString());
			for(int i=0;i<miModelo.listaApartamento.size();i++) {
				
				Object[] apartamento1 = {miModelo.listaApartamento.get(i).getCod_apartamento(), miModelo.listaApartamento.get(i).getNombre(), miModelo.listaApartamento.get(i).getUbicacion(),miModelo.listaApartamento.get(i).getTamano(), miModelo.listaApartamento.get(i).getPrecio(), miModelo.listaApartamento.get(i).getPiso()}; 
				miVentana.apartamento.tableModel.addRow(apartamento1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();}
	}
	
	/**
	 * Coge el apartamento seleccionado
	 * @return el apartamento seleccionado
	 */
	private Apartamento ReservarApartamento() {
		
		int indice = miVentana.apartamento.tablaResultados.getSelectedRow();
		Apartamento apartamento= miModelo.listaApartamento.get(indice);
		return apartamento;	
	}
	
	/**
	 * resetea los servicios 
	 */
	public void resetearServicios() {
		miVentana.apartamento.BoxGim.setSelected(false);
		miVentana.apartamento.BoxPark.setSelected(false);
		miVentana.apartamento.BoxPisc.setSelected(false);
		miVentana.apartamento.BoxSpa.setSelected(false);
		miVentana.apartamento.BoxWi.setSelected(false);
		
 }
}
