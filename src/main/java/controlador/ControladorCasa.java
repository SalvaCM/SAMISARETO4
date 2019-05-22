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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Casa;
import modelo.Modelo;
import vista.PanelCasa;
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
		miVentana.casa.btnLogin.addActionListener(this);
		miVentana.casa.chckbxNewCheckBoxGim.addItemListener(new pincharServicio());
		miVentana.casa.chckbxNewCheckBoxPark.addItemListener(new pincharServicio());
		miVentana.casa.chckbxNewCheckBoxPisc.addItemListener(new pincharServicio());
		miVentana.casa.chckbxNewCheckBoxSpa.addItemListener(new pincharServicio());
		miVentana.casa.chckbxNewCheckBoxWi.addItemListener(new pincharServicio());
		
	
		
		miVentana.casa.fechaEntrada.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
		    public void propertyChange(PropertyChangeEvent e) {
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
            		try {
            			funciones.limpiarTabla(miVentana.casa.tablaResultados,miVentana.casa.tableModel);
						miModelo.listaCasas=miModelo.misFuncionesCasa.leerCasa();
						resetearServicio();
		            	for(int i=0;i<miModelo.listaCasas.size();i++) {

		            		miModelo.listaCasas.get(i).setPrecio((float) (miModelo.listaCasas.get(i).getPrecio()*miModelo.misFuncionesPago.tasa(miVentana.casa.fechaEntrada.getDate(), miVentana.casa.fechaSalida.getDate())));
		            		Object[] casa = {miModelo.listaCasas.get(i).getCod_casa(),miModelo.listaCasas.get(i).getNombre(), miModelo.listaCasas.get(i).getUbicacion(),miModelo.listaCasas.get(i).getTamano(),miModelo.listaCasas.get(i).getPrecio()};
		            		miVentana.casa.tableModel.addRow(casa);

		                }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
			resetearServicio();
			reiniciarImagen();
			
			break;
			
			case "btnSiguienteCasa":
				validarCampos();
				reiniciarImagen();
				
			break;	

			case "btnBuscarCasas": filtrarPorUbicacion(miModelo.listaCasas); imagen();
			
			break;	
			case "btnLogin" : 
				miControlador.miControladorLogin.tratarLogin(miVentana.casa.btnLogin,miVentana.casa);
			break;
			
			case "btnPerfil" : 
				miControlador.miControladorUsuario.TratarPerfil(miVentana.casa);
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
	private class pincharServicio implements ItemListener {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
				try {
					
					ArrayList<Casa> casas =new ArrayList<Casa>();
					casas=miModelo.misFuncionesServicios.serviciosCasa(miVentana.casa.chckbxNewCheckBoxPark.isSelected(), miVentana.casa.chckbxNewCheckBoxPisc.isSelected(),miVentana.casa.chckbxNewCheckBoxGim.isSelected(),miVentana.casa.chckbxNewCheckBoxWi.isSelected(),miVentana.casa.chckbxNewCheckBoxSpa.isSelected());
						 funciones.limpiarTabla(miVentana.casa.tablaResultados, miVentana.casa.tableModel);
							for(int i=0;i<casas.size();i++) {
								casas.get(i).setPrecio(miModelo.listaCasas.get(i).getPrecio()+miModelo.misFuncionesServicios.adicionC(miModelo.listaCasas.get(i).getCod_casa(),miVentana.casa.chckbxNewCheckBoxPark.isSelected() ,miVentana.casa.chckbxNewCheckBoxPisc.isSelected(), miVentana.casa.chckbxNewCheckBoxGim.isSelected(), miVentana.casa.chckbxNewCheckBoxWi.isSelected(), miVentana.casa.chckbxNewCheckBoxSpa.isSelected()));
								Object[] casa = {casas.get(i).getCod_casa(),casas.get(i).getNombre(), casas.get(i).getUbicacion(),casas.get(i).getTamano(),casas.get(i).getPrecio()}; 
								miVentana.casa.tableModel.addRow(casa);
								}
							if(miVentana.casa.chckbxNewCheckBoxGim.isSelected()==false && miVentana.casa.chckbxNewCheckBoxPisc.isSelected()==false && miVentana.casa.chckbxNewCheckBoxPark.isSelected()==false && miVentana.casa.chckbxNewCheckBoxSpa.isSelected()==false && miVentana.casa.chckbxNewCheckBoxWi.isSelected()==false) {
								
				    			//miModelo.listaCasas=miModelo.misFuncionesCasa.leerCasa();
				    			funciones.limpiarTabla(miVentana.casa.tablaResultados, miVentana.casa.tableModel);
				    			for(int i=0;i<miModelo.listaCasas.size();i++) {
									Object[] casa2 = {miModelo.listaCasas.get(i).getCod_casa(),miModelo.listaCasas.get(i).getNombre(), miModelo.listaCasas.get(i).getUbicacion(),miModelo.listaCasas.get(i).getTamano(),miModelo.listaCasas.get(i).getPrecio()}; 
									miVentana.casa.tableModel.addRow(casa2);
									}
				    			
				    			
				    		}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
				
			 
		    }
		
		
		
		
	}
	
	
	
	

	/**
	* valida que los campos del apartamento son validos 
 	*/
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
				DateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
				
				 funciones.cambiarDePanel(miVentana.casa, miVentana.resumenCyA);
				 miModelo.reserva.setCasaReservada(ReservarCasa());
				 miModelo.reserva.setFechaEntrada(miVentana.casa.fechaEntrada.getDate());
				 miModelo.reserva.setFechaSalida(miVentana.casa.fechaSalida.getDate());
				 String fechaE = dateF.format( miModelo.reserva.getFechaEntrada());
					String fechaS=  dateF.format(miModelo.reserva.getFechaSalida());
				 miModelo.reserva.setNoches((int) ((miVentana.casa.fechaSalida.getCalendar().getTimeInMillis()-miVentana.casa.fechaEntrada.getCalendar().getTimeInMillis())/86400000));
				 miVentana.resumenCyA.resumenReserva.append(miModelo.reserva.getCasaReservada().toString());
				 miVentana.resumenCyA.txtDetalles.append("Fecha entrada:  "+ fechaE+"\n");
				 miVentana.resumenCyA.txtDetalles.append("Fecha salida:  "+ fechaS+"\n");
				 miVentana.resumenCyA.txtDetalles.append("Numero de noches:  "+ miModelo.reserva.getNoches());
				 miControlador.miControladorPago.total = miModelo.reserva.getCasaReservada().getPrecio()* miModelo.reserva.getNoches();	
				 
				 miVentana.pago.total.setText(formatoMoneda.format(0));
				 miVentana.pago.total.setText(formatoMoneda.format(miControlador.miControladorPago.total));
				try {
					miVentana.resumenCyA.resumenReserva.append("\nHabitaciones :\n" ); 
					miModelo.casa.setHabitaciones(miModelo.misFuncionesCasa.leerHabitaciones(miModelo.reserva.getCasaReservada().getCod_casa()));
					for (int i = 0; i < miModelo.casa.getHabitaciones().size(); i++) {
						miVentana.resumenCyA.resumenReserva.append( miModelo.casa.getHabitaciones().get(i).toString());
					}
					miVentana.resumenCyA.resumenReserva.append("\nDormitorios :\n" );
					miModelo.casa.setDormitorios(miModelo.misFuncionesCasa.leerDormitorios(miModelo.reserva.getCasaReservada().getCod_casa()));
					for (int i = 0; i < miModelo.casa.getDormitorios().size(); i++) {
						miVentana.resumenCyA.resumenReserva.append( miModelo.casa.getDormitorios().get(i).toString());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
				//funciones.limpiarTabla(miVentana.casa.tablaResultados,miVentana.casa.tableModel);
			
		
			
			
		}
	}
	
	
	/**
	 * Coge la casa seleccionada
	 * @return la casa seleccionada
	 */
	private Casa ReservarCasa() {
		
		int indice = miVentana.casa.tablaResultados.getSelectedRow();
		
		Casa casa= miModelo.listaCasas.get(indice);
		return casa;	
	}
	
	/**
	 * añade a la tabla las casas con la filtracion por ubicacion
	 * @param casas
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
	
	/**
	 * resetear servicios
	 */
	public void resetearServicio() {
		miVentana.casa.chckbxNewCheckBoxGim.setSelected(false);
		miVentana.casa.chckbxNewCheckBoxPark.setSelected(false);
		miVentana.casa.chckbxNewCheckBoxPisc.setSelected(false);
		miVentana.casa.chckbxNewCheckBoxSpa.setSelected(false);
		miVentana.casa.chckbxNewCheckBoxWi.setSelected(false);
	}
	
	
	/**
	 * muestra las imagenes en los paneles
	 */
	public void imagen() {
		 String enlace = "";
		 ImageIcon imagen1;
	
		 
		
		this.miVentana.casa.repaint();
		

		
		  if(miVentana.casa.comboBox.getSelectedItem().toString().equals("MADRID")) {
			 miVentana.casa.remove(miVentana.casa.etiqueta);
		
				enlace="/imagenes/m.jpg";	
		  }
		  
		  if(miVentana.casa.comboBox.getSelectedItem().toString().equals("BARCELONA")) {
				 miVentana.casa.remove(miVentana.casa.etiqueta);
			
				  enlace="/imagenes/b.jpg";
			}
		  if(miVentana.casa.comboBox.getSelectedItem().toString().equals("BILBAO")) {
				 miVentana.casa.remove(miVentana.casa.etiqueta);
			
				  enlace="/imagenes/bilbao (1).jpg";	
			}
		  if(miVentana.casa.comboBox.getSelectedItem().toString().equals("SEVILLA")) {
				 miVentana.casa.remove(miVentana.casa.etiqueta);
			
					enlace="/imagenes/sev.jpg";
			}
		  if(miVentana.casa.comboBox.getSelectedItem().toString().equals("SALAMANCA")) {
				 miVentana.casa.remove(miVentana.casa.etiqueta);
				 enlace="/imagenes/salamanca2.jpg";
						
			}
		  if(miVentana.casa.comboBox.getSelectedItem().toString().equals("VALENCIA")) {
				 miVentana.casa.remove(miVentana.casa.etiqueta);
			
				 enlace="/imagenes/valencia.jpg";	
			}
		  if(miVentana.casa.comboBox.getSelectedItem().toString().equals("BURGOS")) {
				 miVentana.casa.remove(miVentana.casa.etiqueta);
			
				 enlace="/imagenes/burgos.jpg";
			}
		  
		  
		  
			imagen1=new ImageIcon(PanelCasa.class.getResource(enlace));
			
		
			miVentana.casa.etiqueta.setIcon(imagen1);
		
			

			this.miVentana.casa.add(miVentana.casa.etiqueta);	 
		
	}
	
	public void reiniciarImagen() {
	    miVentana.casa.remove(miVentana.casa.etiqueta);
		ImageIcon imagen=new ImageIcon(PanelCasa.class.getResource("/imagenes/pattern.jpg"));
		miVentana.casa.etiqueta = new JLabel(imagen);
		miVentana.casa.etiqueta.setBounds(-20, -20, 1200, 800);
		this.miVentana.casa.add(miVentana.casa.etiqueta);
		miVentana.casa.etiqueta.setVisible(true);
}

	

}
