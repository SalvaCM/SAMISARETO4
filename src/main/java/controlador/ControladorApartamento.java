package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.Apartamento;
import modelo.Casa;
import modelo.HabitacionHotel;
import modelo.Modelo;
import vista.Ventana;

public class ControladorApartamento implements ActionListener {
	
	private Ventana miVentana;
	private Modelo miModelo;

	
	FuncionesControlador funciones = new FuncionesControlador();
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 */
	public ControladorApartamento(Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		miVentana.apartamento.btnSiguiente.addActionListener(this);
		miVentana.apartamento.btnBuscar.addActionListener(this);
		miVentana.apartamento.btnCancelar.addActionListener(this);
		miVentana.apartamento.btnPerfil.addActionListener(this); 
		
		miVentana.apartamento.fechaEntrada.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
		    public void propertyChange(PropertyChangeEvent e) {
		        System.out.println(e.getPropertyName()+ ":++ " + e.getNewValue());
		        java.util.Date fechaMinimaSalida=(java.util.Date) e.getNewValue();
		        fechaMinimaSalida.setTime(fechaMinimaSalida.getTime()+86400000);
		        miVentana.apartamento.fechaSalida.setEnabled(true);
		        miVentana.apartamento.fechaSalida.setMinSelectableDate(fechaMinimaSalida);
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
			break;
			
			case "btnSiguienteApartamento": funciones.cambiarDePanel(miVentana.apartamento, miVentana.resumen);
			funciones.limpiarTabla(miVentana.apartamento.tablaResultados,miVentana.apartamento.tableModel);
			validarCampos();
			break;	

			case "btnBuscarApartamentos": filtrarPorUbicacion(miModelo.listaApartamento);
			
			break;	
			
			case "btnPerfil": funciones.cambiarDePanel(miVentana.hotel, miVentana.usuario);
			miVentana.usuario.txtDatosPersonales.append("Nombre : "+miModelo.cliente.getNombre()+" "+miModelo.cliente.getApellido()+"\nFecha Nac. :"+miModelo.cliente.getFechaNacimiento());
			break;
		}
		
	}
	
	
		//METODOS
	
	private void validarCampos() {
		if(miVentana.apartamento.tablaResultados.getSelectedRow() == -1)
		{
			JOptionPane.showMessageDialog(miVentana, "Seleccione una casa", "Atencion!", JOptionPane.WARNING_MESSAGE);
	
		}
		else {
			if (miVentana.apartamento.fechaEntrada.getDate()==null||miVentana.apartamento.fechaSalida.getDate()==null)
			{
				JOptionPane.showMessageDialog(miVentana, "Seleccione fechas", "Atencion!", JOptionPane.WARNING_MESSAGE);
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

}
