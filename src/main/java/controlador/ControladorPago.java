package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import ficheros.ManejadorFicherosTexto;
import modelo.Modelo;
import vista.Ventana;

public class ControladorPago implements ActionListener {
	private Ventana miVentana;
	private Modelo miModelo;
	private Controlador miControlador;
	FuncionesControlador funciones = new FuncionesControlador();
	
	private int[] arrayCambios=null;
	public double total=0;
	public double pagado = 0;

	
	
	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 */
	public ControladorPago (Ventana miVentana, Modelo miModelo,Controlador miControlador) { 
		
		this.miControlador=miControlador;
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		//Definicion de los listeners de los botones del panel
		miVentana.pago.btnSiguiente.addActionListener(this); 
		miVentana.pago.btnCancelar.addActionListener(this); 
		miVentana.pago.btnCodigoDto.addActionListener(this);
		miVentana.pago.btn500.addActionListener(this);
		miVentana.pago.btn200.addActionListener(this);
		miVentana.pago.btn100.addActionListener(this); 
		miVentana.pago.btn50.addActionListener(this);
		miVentana.pago.btn20.addActionListener(this);
		miVentana.pago.btn10.addActionListener(this);
		miVentana.pago.btn5.addActionListener(this);
		miVentana.pago.btn2.addActionListener(this);
		miVentana.pago.btn1.addActionListener(this);
		miVentana.pago.btn050.addActionListener(this);
		miVentana.pago.btn020.addActionListener(this);
		miVentana.pago.btn010.addActionListener(this);
		miVentana.pago.btn005.addActionListener(this);
		miVentana.pago.btn002.addActionListener(this);
		miVentana.pago.btn001.addActionListener(this);
		
		
		
	}
	/**
	 * Metodo para resetear los valores de la ventana pago	
	 */
	public void resetear() {
		
		miVentana.pago.total.setText("");
		miVentana.pago.pagado.setText("");
		miVentana.pago.restante.setText("");
		actBotones(miVentana.pago.arrayBtn); 
		miVentana.pago.btnCancelar.setEnabled(true);
		total=0;
		pagado = 0;
		miVentana.hotel.fechaEntrada.setCalendar(null);
		miVentana.hotel.fechaSalida.setCalendar(null);
		miVentana.hotel.fechaSalida.setEnabled(false);
		miVentana.apartamento.fechaEntrada.setCalendar(null);
		miVentana.apartamento.fechaSalida.setCalendar(null);
		miVentana.apartamento.fechaSalida.setEnabled(false);
		miVentana.casa.fechaEntrada.setCalendar(null);
		miVentana.casa.fechaSalida.setCalendar(null);
		miVentana.casa.fechaSalida.setEnabled(false);
		miVentana.hotel.nCamas.setValue(0);
		
				
	}
		
	/**
	 * Metodo para las llamadas a los botones de la ventana pago
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Accion dependiendo de que boton venga el evento
		switch (((JButton) e.getSource()).getName()) {
	
			case "btnCancelarPago": funciones.cambiarDePanel(miVentana.pago, miVentana.alojamiento);
		     	JOptionPane.showMessageDialog(miVentana, "Devolucion de dinero introducido", "Atencion!", JOptionPane.WARNING_MESSAGE);
				resetear();
				miVentana.resumen.mostrarResumen.clear();
				miVentana.resumenCyA.mostrarResumen.clear();
				miModelo.reservaHotel.getHabReservadas().removeAll(miModelo.reservaHotel.getHabReservadas());
				miVentana.resumen.resumenReserva.setText(null);
				miVentana.resumen.resumen.removeAll();
				
				funciones.limpiarTabla(miVentana.hotel.tablaResultados, miVentana.hotel.tableModel);
				funciones.limpiarTabla(miVentana.estanciasHotel.tablaHabitaciones, miVentana.estanciasHotel.tableModel);
				funciones.limpiarTabla(miVentana.apartamento.tablaResultados, miVentana.apartamento.tableModel);
				funciones.limpiarTabla(miVentana.casa.tablaResultados, miVentana.casa.tableModel);
				funciones.desBotones(miVentana.pago.btnSiguiente);
				funciones.actBotones(miVentana.pago.btnCodigoDto);
				miVentana.pago.textCodigo.setText(null);
				miVentana.pago.descuento.setVisible(false);
				miVentana.pago.lblNewJgoodiesTitle.setVisible(false);
											
				
				break;
			case "btnCodigoDto": 
				if (miControlador.miControladorElegir.elegido==1) {
					try {	

					double totalConDto = miModelo.misFuncionesCodigos.descuentoHotelTotal(miModelo.cliente.getCodCliente(), miModelo.hotel.getCod_hotel(),miVentana.pago.textCodigo.getText(), miControlador.miControladorPago.total);
					miControlador.miControladorPago.total = totalConDto;
					
					miVentana.pago.total.setText(formatoMoneda.format(0));
					miVentana.pago.total.setText(formatoMoneda.format(miControlador.miControladorPago.total));
					
					
					if(miModelo.misFuncionesCodigos.validarHotel(miModelo.cliente.getCodCliente(), miModelo.hotel.getCod_hotel(),miVentana.pago.textCodigo.getText())==true) {
						
						double dto = miModelo.misFuncionesCodigos.descuentoHotel(miModelo.cliente.getCodCliente(), miModelo.hotel.getCod_hotel(), miVentana.pago.textCodigo.getText(), miControlador.miControladorPago.total);
						
						miVentana.pago.descuento.setText(formatoMoneda.format(0));
						miVentana.pago.descuento.setText(formatoMoneda.format(dto));
						System.out.println(miVentana.pago.descuento.getText());
						miVentana.pago.descuento.setVisible(true);
						miVentana.pago.lblNewJgoodiesTitle.setVisible(true);
	
						funciones.desBotones(miVentana.pago.btnCodigoDto);

					}
					
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
				else if (miControlador.miControladorElegir.elegido==2) {
					try {	
						
						
						double totalConDto = miModelo.misFuncionesCodigos.descuentoCasaTotal(miModelo.cliente.getCodCliente(), miModelo.reserva.getCasaReservada().getCod_casa(),miVentana.pago.textCodigo.getText(), miControlador.miControladorPago.total);
						miControlador.miControladorPago.total = totalConDto;
						
						miVentana.pago.total.setText(formatoMoneda.format(0));
						miVentana.pago.total.setText(formatoMoneda.format(miControlador.miControladorPago.total));
						
						if(miModelo.misFuncionesCodigos.validarCasa(miModelo.cliente.getCodCliente(),  miModelo.reserva.getCasaReservada().getCod_casa(),miVentana.pago.textCodigo.getText())==true) {
							
							double dto = miModelo.misFuncionesCodigos.descuentoCasa(miModelo.cliente.getCodCliente(), miModelo.reserva.getCasaReservada().getCod_casa(), miVentana.pago.textCodigo.getText(), miControlador.miControladorPago.total);
							
							miVentana.pago.descuento.setText(formatoMoneda.format(0));
							miVentana.pago.descuento.setText(formatoMoneda.format(dto));
							
							System.out.println(miVentana.pago.descuento.getText());
							
							miVentana.pago.descuento.setVisible(true);
							miVentana.pago.lblNewJgoodiesTitle.setVisible(true);
							
							funciones.desBotones(miVentana.pago.btnCodigoDto);

						}
						
						} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
				}
				else if (miControlador.miControladorElegir.elegido==3) { 
					
					try {	
						
						
						
						double totalConDto = miModelo.misFuncionesCodigos.descuentoApartTotal(miModelo.cliente.getCodCliente(), miModelo.reserva.getApartReservado().getCod_apartamento(),miVentana.pago.textCodigo.getText(), miControlador.miControladorPago.total);
						miControlador.miControladorPago.total = totalConDto;
						
						miVentana.pago.total.setText(formatoMoneda.format(0));
						miVentana.pago.total.setText(formatoMoneda.format(miControlador.miControladorPago.total));
						
						if(miModelo.misFuncionesCodigos.validarApart(miModelo.cliente.getCodCliente(), miModelo.reserva.getApartReservado().getCod_apartamento() ,miVentana.pago.textCodigo.getText())==true) {
							
							double dto = miModelo.misFuncionesCodigos.descuentoApart(miModelo.cliente.getCodCliente(), miModelo.reserva.getApartReservado().getCod_apartamento(), miVentana.pago.textCodigo.getText(), miControlador.miControladorPago.total);
							
							miVentana.pago.descuento.setText(formatoMoneda.format(0));
							miVentana.pago.descuento.setText(formatoMoneda.format(dto));
							
							System.out.println(miVentana.pago.descuento.getText());
							
							miVentana.pago.descuento.setVisible(true);
							miVentana.pago.lblNewJgoodiesTitle.setVisible(true);
							funciones.desBotones(miVentana.pago.btnCodigoDto);
							

						}
						
						} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
				}
				
				break;
										 
			case "btnSiguientePago": funciones.cambiarDePanel(miVentana.pago, miVentana.devolucion); 

				
				//Calcular cambios despues del pago

			if (miControlador.miControladorElegir.elegido==1) {
				try {	
				
				
				if(miModelo.misFuncionesCodigos.validarHotel(miModelo.cliente.getCodCliente(), miModelo.hotel.getCod_hotel(),miVentana.pago.textCodigo.getText())==true) {
					miModelo.misFuncionesCodigos.borrarCodigoHotel(miModelo.cliente.getCodCliente(), miModelo.hotel.getCod_hotel(),miVentana.pago.textCodigo.getText());
				}
				
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
			else if (miControlador.miControladorElegir.elegido==2) {
				try {	
				
				
				if(miModelo.misFuncionesCodigos.validarCasa(miModelo.cliente.getCodCliente(), miModelo.reserva.getCasaReservada().getCod_casa(),miVentana.pago.textCodigo.getText())==true) {
					miModelo.misFuncionesCodigos.borrarCodigoCasa(miModelo.cliente.getCodCliente(), miModelo.reserva.getCasaReservada().getCod_casa(),miVentana.pago.textCodigo.getText());
				}
				
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
			else if (miControlador.miControladorElegir.elegido==3) {
				try {	
				
				
				if(miModelo.misFuncionesCodigos.validarApart(miModelo.cliente.getCodCliente(), miModelo.reserva.getApartReservado().getCod_apartamento(),miVentana.pago.textCodigo.getText())==true) {
					miModelo.misFuncionesCodigos.borrarCodigoApart(miModelo.cliente.getCodCliente(), miModelo.reserva.getApartReservado().getCod_apartamento(),miVentana.pago.textCodigo.getText());
				}
				
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
			
			
				if (pagado > total) {
					arrayCambios = miModelo.misFuncionesDevolucion.cambios(Math.abs(total - pagado));
				}
			    mostrarCambios(arrayCambios);
			    
			    JOptionPane.showMessageDialog(miVentana, "Reserva Completada!", "�Atencion!", JOptionPane.WARNING_MESSAGE);
			    
			    //DEPENDIENDO  si hemos elegido hotel,apartamento o casa
			    if(miControlador.miControladorElegir.elegido==1) {
			    	ManejadorFicherosTexto fichero = new ManejadorFicherosTexto();
			    	GuardarReservaH();
			    	for (int j = 0; j <miModelo.reservaHotel.getHabReservadas().size(); j++) {
			    		fichero.archivoTexto("Nombre del Hotel: " + miModelo.reservaHotel.getHotelReservado().getNombre() + "\r\n "
						+ "Ubicacion: " + miModelo.reservaHotel.getHotelReservado().getUbicacion() + "\r\n  "
						+ "N Estrellas: " + miModelo.reservaHotel.getHotelReservado().getnEstrellas() + " \r\n "
						+ "Categoria: " + miModelo.reservaHotel.getHabReservadas().get(j).getTipo() + "\r\n  " + "Tarifa: "
						+ miModelo.reservaHotel.getHabReservadas().get(j).getPrecio() + "\r\n  " + "Habitacion: "
						+  " " + "Cliente: "
						+ miModelo.cliente.getDni()+"\n");
			    	}
			    	 miModelo.misFuncionesCodigos.crearCodigoHotel(miModelo.reservaHotel, miModelo.cliente);
			    	 try {
						fichero.leerContenido();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    }
			    else if(miControlador.miControladorElegir.elegido==3) {
			    
			    	GuardarReservaA();
			    	ManejadorFicherosTexto fichero = new ManejadorFicherosTexto();
			    	miModelo.reserva.getApartReservado();
			    	fichero.archivoTexto("Nombre del Apartamento: " + miModelo.reserva.getApartReservado().getNombre() + "\r\n "
							+ "Ubicacion: " + miModelo.reserva.getApartReservado().getUbicacion() + "\r\n "
						
							+  " " + "Cliente: "
							+ miModelo.cliente.getDni());
			    	miModelo.misFuncionesCodigos.crearCodigoApart(miModelo.reserva, miModelo.cliente);
			    }
			    
			    else if(miControlador.miControladorElegir.elegido==2) {
			    	GuardarReservaC();
			    	ManejadorFicherosTexto fichero = new ManejadorFicherosTexto();
			    	miModelo.reserva.getCasaReservada();
			    	fichero.archivoTexto("Nombre de la casa: " + miModelo.reserva.getCasaReservada().getNombre() + "\r\n "
							+ "Ubicacion: " + miModelo.reserva.getCasaReservada().getUbicacion() + " "
						
							+  " " + "Cliente: "
							+ miModelo.cliente.getDni());
			    	miModelo.misFuncionesCodigos.crearCodigoCasa(miModelo.reserva, miModelo.cliente);
			    }
			    resetear();		
			    miVentana.pago.descuento.setVisible(false);
				miVentana.pago.lblNewJgoodiesTitle.setVisible(false);
				break;
			
				default: 
				pagado = miModelo.misFuncionesPago.sumarDineroPago(((JButton) e.getSource()).getName(), pagado);
				
		}
		
		if (pagado >= total) {
			miVentana.pago.restante.setText(formatoMoneda.format(0));
			miVentana.pago.pagado.setText(formatoMoneda.format(pagado));
			desBotones(miVentana.pago.arrayBtn);
			miVentana.pago.btnSiguiente.setEnabled(true);
			funciones.actBotones(miVentana.pago.btnSiguiente);
			funciones.desBotones(miVentana.pago.btnCancelar);
			
		} else {
			miVentana.pago.restante.setText(formatoMoneda.format(total - pagado));
			miVentana.pago.pagado.setText(formatoMoneda.format(pagado));
			
		}
		
	}
	
	/**
	 * Guarda la reserva del hotel
	 */
    private void GuardarReservaH() {
    	int codReserva=miModelo.misFuncionesReserva.buscarNumeroReservaHotel();
    	
		for (int j = 0; j < miModelo.reservaHotel.getHabReservadas().size(); j++) {
			miModelo.misFuncionesReserva.registrarReserva(codReserva, j, miModelo.reservaHotel, miModelo.cliente);
		}
			miModelo.reservaHotel.setCodReserva(codReserva);
		
	}
    /**
	 * Guarda la reserva de la casa
	 */
    private void GuardarReservaC() {
    	int codReserva=miModelo.misFuncionesReserva.buscarNumeroReservaCasa();
    	miModelo.misFuncionesReserva.registrarReservaCasa(codReserva, miModelo.reserva, miModelo.cliente);
    	miModelo.reserva.setCodReserva(codReserva);
    }
    
    /**
	 * Guarda la reserva del apartamento
	 */
    private void GuardarReservaA() {
    	int codReserva=miModelo.misFuncionesReserva.buscarNumeroReservaApartamento();
    	miModelo.misFuncionesReserva.registrarReservaApartamento(codReserva, miModelo.reserva, miModelo.cliente);
    	miModelo.reserva.setCodReserva(codReserva);
    }

	/**
     * Metodo que desactiva todos los botones de dinero de la ventana pago
     * @param array de botones a desactivar 
     */
	public void desBotones(JButton[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i].setEnabled(false);
		}
	}

	/**
	 * Metodo que activa todos los botones de dinero de la ventana pago
	 * @param array array de botones a activar
	 */
	public void actBotones(JButton[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i].setEnabled(true);
		}
	}
	
	
	
	/**
	 * Metodo para mostrar los cambios en la ventana de devolucion 
	 * @param miVentana instancia de la ventana principal
	 * @param cambios array con el numero de cada moneda o billete a devolver segun su posicion en el array
	 */
	public void mostrarCambios(int[] cambios) {
		//Declaracion e inicializacion de
		String mensajeCambios = "";
		
		//Inicio del programa
		if (arrayCambios != null) {
			//Recorremos el array de cambios. Cada posicion es una moneda o billete 500, 200, 100...
			miVentana.devolucion.cambios.addElement("Cambios: " + formatoMoneda.format(pagado - total));
			for(int z=0 ; z < cambios.length ; z++) {
				//Si la posicion es distinta de cero hay cambios de esa moneda/billete 
				if (cambios[z]>0) {
					switch (z) {
					
						case 0 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(500)) + ": " ; break;
					
						case 1 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(200)) + ": " ; break;
						
						case 2 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(100)) + ": " ; break;
							
						case 3 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(50)) + ": " ; break;
							
						case 4 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(20)) + ": " ; break;
							
						case 5 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(10)) + ": " ; break;
							
						case 6 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(5)) + ": " ; break;
						
						case 7 :  mensajeCambios= "Monedas de " + (formatoMoneda.format(2)) + ": " ; break;
							
						case 8 :  mensajeCambios= "Monedas de " + (formatoMoneda.format(1)) + ": " ; break;
							
						case 9 :  mensajeCambios= "Monedas de " + (formatoMoneda.format(0.5)) + ": " ; break;
						
						case 10 :  mensajeCambios= "Monedas de " + (formatoMoneda.format(0.2)) + ": " ; break;
						
						case 11 :  mensajeCambios= "Monedas de " + (formatoMoneda.format(0.1)) + ": " ; break;
						
						case 12 :  mensajeCambios= "Monedas de " + (formatoMoneda.format(0.05)) + ": " ; break;
						
						case 13 :  mensajeCambios= "Monedas de " + (formatoMoneda.format(0.02)) + ": " ; break;
						
						case 14 :  mensajeCambios= "Monedas de " + (formatoMoneda.format(0.01)) + ": " ; break;
					
					}
					//A�adimos la linea al modelo de la lista
					miVentana.devolucion.cambios.addElement(mensajeCambios + cambios[z]);
				}
			}
		}else {
			//Si no hay cambios
			miVentana.devolucion.cambios.addElement("No hay cambios");
		}
		//Actualizamos la lista con los datos del modelo
		miVentana.devolucion.devolucion.setModel(miVentana.devolucion.cambios);
		
	}

	
}