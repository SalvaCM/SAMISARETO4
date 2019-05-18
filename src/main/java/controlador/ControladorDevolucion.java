package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

import modelo.Modelo;
import modelo.ReservaCASAoAPART;
import modelo.ReservaHotel;
import vista.Ventana;

public class ControladorDevolucion implements ActionListener {
			
			private Ventana miVentana;
			private Modelo miModelo;
			private Controlador miControlador; 
			
			FuncionesControlador funciones = new FuncionesControlador();

			
			/**
			 * Constructor de la clase
			 * @param miVentana instancia de la ventna principal
			 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
			 * @param miControlador 
			 */
			public ControladorDevolucion(Ventana miVentana, Modelo miModelo, Controlador miControlador) {
				
				this.miVentana = miVentana;
				this.miModelo = miModelo;
				this.miControlador = miControlador;
				
				miVentana.devolucion.btnSiguiente.addActionListener(this);
				miVentana.devolucion.btnLogin.addActionListener(this);
				miVentana.devolucion.btnPerfil.addActionListener(this);
			}
			
			
			
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
						
				case "btnSiguienteDevolucion": funciones.cambiarDePanel(miVentana.devolucion, miVentana.despedida);
					PasarDeDespedidaASaludo();
					resetear();
				break;
				
				case "btnLogin" : 
					miControlador.miControladorLogin.tratarLogin(miVentana.devolucion.btnLogin,miVentana.devolucion);
				break;
				
				case "btnPerfil" : 
					miControlador.miControladorUsuario.TratarPerfil(miVentana.devolucion);
					miVentana.usuario.txtDatosPersonales.setText("");
					miVentana.usuario.txtDatosPersonales.append("Nombre : "+miModelo.cliente.getNombre()+" "+miModelo.cliente.getApellido()+"\nFecha Nac. :"+miModelo.cliente.getFechaNacimiento());
					miVentana.usuario.txtReservasPasadas.setText("");
					miVentana.usuario.txtReservasPasadas.append(miModelo.misFuncionesReserva.buscarReservasUsuario());
					
				break;
				
		
				}
			}	
			
			/**
			 * Metodo para pasar del la ventana despedida a la de saludo automaticamente (en milisegundos)
			 */
			public void PasarDeDespedidaASaludo() {
		
				Timer timer = new Timer();
				TimerTask esperar = new TimerTask() {
					@Override
					public void run() {
						funciones.cambiarDePanel(miVentana.despedida, miVentana.saludo);
						
					}
				};
				timer.schedule(esperar, 3500);
			}
			/**
			 * Metodo para resetear los valores de la ventana devolucion y en este caso preparar para una nueva sesion
			 */ 
			public void  resetear() {		
				miVentana.devolucion.cambios.removeAllElements();
				funciones.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);
				funciones.limpiarTabla(miVentana.estanciasHotel.tablaHabitaciones,miVentana.estanciasHotel.tableModel);
				miModelo.logged = false;
				miModelo.reserva = new ReservaCASAoAPART();
				miModelo.reservaHotel = new ReservaHotel();
			
			}
	
			
		

}

