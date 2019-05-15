package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.NumberFormat;
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
            	try {
            		miModelo.listaApartamento=miModelo.misFuncionesApartamento.leerApartamento();
            	} catch (SQLException e1) {
            		// TODO Auto-generated catch block
            		e1.printStackTrace();
            	}
        		System.out.println("TASA: "+miModelo.misFuncionesPago.tasa(miVentana.apartamento.fechaEntrada.getDate(), miVentana.apartamento.fechaSalida.getDate()));
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
				miVentana.login.paneldeRetorno=miVentana.apartamento;
				funciones.cambiarDePanel(miVentana.apartamento, miVentana.login);	
			break;
			
			case "btnPerfil" : 
				funciones.cambiarDePanel(miVentana.apartamento, miVentana.usuario);
				miVentana.usuario.txtDatosPersonales.append("Nombre : " + miModelo.cliente.getNombre() + " "
						+ miModelo.cliente.getApellido() + "\nFecha Nac. :" + miModelo.cliente.getFechaNacimiento());
			break;
		}
		
	}
	
	
		//METODOS
	
	private void validarCampos() {
		if(miVentana.apartamento.tablaResultados.getSelectedRow() == -1)
		{
			JOptionPane.showMessageDialog(miVentana, "Seleccione una apartamento", "Atencion!", JOptionPane.WARNING_MESSAGE);
	
		}
		else {
			if (miVentana.apartamento.fechaEntrada.getDate()==null||miVentana.apartamento.fechaSalida.getDate()==null)
			{
				JOptionPane.showMessageDialog(miVentana, "Seleccione fechas", "Atencion!", JOptionPane.WARNING_MESSAGE);
			}else{
				 funciones.cambiarDePanel(miVentana.apartamento, miVentana.resumenCyA);
				 miModelo.reserva.setApartReservado(ReservarApartamento());
				 miModelo.reserva.setFechaEntrada(miVentana.apartamento.fechaEntrada.getDate());
				 miModelo.reserva.setFechaSalida(miVentana.apartamento.fechaSalida.getDate());
				
				 miModelo.reserva.setNoches((int) ((miVentana.apartamento.fechaSalida.getCalendar().getTimeInMillis()-miVentana.apartamento.fechaEntrada.getCalendar().getTimeInMillis())/86400000));
				 miVentana.resumenCyA.resumenReserva.append(miModelo.reserva.getApartReservado().toString());
				 miVentana.resumenCyA.txtDetalles.append("Fecha entrada:  "+ miModelo.reserva.getFechaEntrada()+"\n");
				 miVentana.resumenCyA.txtDetalles.append("Fecha salida:  "+ miModelo.reserva.getFechaSalida()+"\n");
				 miVentana.resumenCyA.txtDetalles.append("Numero de noches:  "+ miModelo.reserva.getNoches());
				 System.out.println( "COD APARTAMENTO:"+miModelo.reserva.getApartReservado().getCod_apartamento());
				 System.out.println( miModelo.reserva.getApartReservado().getPrecio());
				 
				 miControlador.miControladorPago.total = miModelo.reserva.getApartReservado().getPrecio()* miModelo.reserva.getNoches();
				 System.out.println("Total: "+miControlador.miControladorPago.total);
				 
				 miVentana.pago.total.setText(formatoMoneda.format(0));
				 miVentana.pago.total.setText(formatoMoneda.format(miControlador.miControladorPago.total));
				
			//	funciones.limpiarTabla(miVentana.apartamento.tablaResultados,miVentana.apartamento.tableModel);
			}
					
			
		}
	
	}
	
	

	/**
	 * FILTRA LAS CASAS POR SU UBICACION
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
	
	private Apartamento ReservarApartamento() {
		
		int indice = miVentana.apartamento.tablaResultados.getSelectedRow();
		Apartamento apartamento= miModelo.listaApartamento.get(indice);
		return apartamento;	
	}

}
