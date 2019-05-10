package controlador;

import java.awt.HeadlessException;
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

import modelo.Casa;
import modelo.HabitacionHotel;
import modelo.Hotel;
import modelo.Modelo;
import modelo.ReservaCASAoAPART;
import vista.Ventana;

public class ControladorCasa implements ActionListener {
	
	private Ventana miVentana;
	private Modelo miModelo;
	private Controlador miControlador;
	

	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 */
	public ControladorCasa(Ventana miVentana, Modelo miModelo, Controlador miControlador) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		this.miControlador=miControlador;
		miVentana.casa.btnSiguiente.addActionListener(this);
		miVentana.casa.btnBuscar.addActionListener(this);
		miVentana.casa.btnCancelar.addActionListener(this);
		miVentana.casa.btnPerfil.addActionListener(this); 
	
		
		miVentana.casa.fechaEntrada.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
		    public void propertyChange(PropertyChangeEvent e) {
		        System.out.println(e.getPropertyName()+ ":ENTRADA CASA " + e.getNewValue());
		        java.util.Date fechaMinimaSalida=(java.util.Date) e.getNewValue();
		        if(fechaMinimaSalida != null ) {
		        	fechaMinimaSalida.setTime(fechaMinimaSalida.getTime()+86400000);
		        }
		        miVentana.casa.fechaSalida.setEnabled(true);
		        miVentana.casa.fechaSalida.setMinSelectableDate(fechaMinimaSalida);
		    }
		});
		miVentana.casa.fechaSalida.addPropertyChangeListener("date", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent e) {
            	 System.out.println(e.getPropertyName()+ ":Salida CASA " + e.getNewValue());
            	funciones.limpiarTabla(miVentana.casa.tablaResultados,miVentana.casa.tableModel);
            	try {
            		miModelo.listaCasas=miModelo.misFuncionesCasa.leerCasa();
            	} catch (SQLException e1) {
            		// TODO Auto-generated catch block
            		e1.printStackTrace();
            	}
        		System.out.println("TASA: "+miModelo.misFuncionesPago.tasa(miVentana.casa.fechaEntrada.getDate(), miVentana.casa.fechaSalida.getDate()));
            	for(int i=0;i<miModelo.listaCasas.size();i++) {

            		miModelo.listaCasas.get(i).setPrecio((float) (miModelo.listaCasas.get(i).getPrecio()*miModelo.misFuncionesPago.tasa(miVentana.casa.fechaEntrada.getDate(), miVentana.casa.fechaSalida.getDate())));
            		Object[] casa = {miModelo.listaCasas.get(i).getCod_casa(),miModelo.listaCasas.get(i).getNombre(), miModelo.listaCasas.get(i).getUbicacion(),miModelo.listaCasas.get(i).getTamano(),miModelo.listaCasas.get(i).getPrecio()};
            		miVentana.casa.tableModel.addRow(casa);

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
		

			case "btnCancelarCasa": funciones.cambiarDePanel(miVentana.casa, miVentana.alojamiento);
			funciones.limpiarTabla(miVentana.casa.tablaResultados,miVentana.casa.tableModel);
			miVentana.casa.comboBox.removeAllItems();
			

			miVentana.casa.fechaEntrada.setCalendar(null);
			miVentana.casa.fechaSalida.setCalendar(null);
			miVentana.casa.fechaSalida.setEnabled(false);
			break;
			
			case "btnSiguienteCasa":
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
			else{
				 funciones.cambiarDePanel(miVentana.casa, miVentana.resumenCyA);
				 miModelo.reserva.setCasaReservada(ReservarCasa());
				 miModelo.reserva.setFechaEntrada(miVentana.casa.fechaEntrada.getDate());
				 miModelo.reserva.setFechaSalida(miVentana.casa.fechaSalida.getDate());
				 miModelo.reserva.setNoches((int) ((miVentana.casa.fechaSalida.getCalendar().getTimeInMillis()-miVentana.casa.fechaEntrada.getCalendar().getTimeInMillis())/86400000));
				 miVentana.resumenCyA.resumenReserva.append(miModelo.reserva.getCasaReservada().toString());
				 miVentana.resumenCyA.txtDetalles.append("Fecha entrada:  "+ miModelo.reserva.getFechaEntrada()+"\n");
				 miVentana.resumenCyA.txtDetalles.append("Fecha salida:  "+ miModelo.reserva.getFechaSalida()+"\n");
				 miVentana.resumenCyA.txtDetalles.append("Numero de noches:  "+ miModelo.reserva.getNoches());
				 System.out.println("COD CASA:  " +miModelo.reserva.getCasaReservada().getCod_casa());
				 System.out.println( miModelo.reserva.getCasaReservada().getPrecio());
				
				 miControlador.miControladorPago.total = miModelo.reserva.getCasaReservada().getPrecio()* miModelo.reserva.getNoches();
				 System.out.println("Total: "+ miControlador.miControladorPago.total);
				 
				
				 
				miVentana.pago.total.setText(formatoMoneda.format(0));
				miVentana.pago.total.setText(formatoMoneda.format(miControlador.miControladorPago.total));
				 
				 
			}
				//funciones.limpiarTabla(miVentana.casa.tablaResultados,miVentana.casa.tableModel);
			
		
			
			
		}
	}
	
	

	private Casa ReservarCasa() {
		
		int indice = miVentana.casa.tablaResultados.getSelectedRow();
		
		Casa casa= miModelo.listaCasas.get(indice);
		return casa;	
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
