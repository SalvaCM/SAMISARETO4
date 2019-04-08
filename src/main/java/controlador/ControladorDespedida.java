package controlador;

import java.util.Timer;
import java.util.TimerTask;
import vista.Ventana;


/**
 * Clase que controla el panel de despedida de la aplicacion
 *
 */
public class ControladorDespedida {
	private Ventana miVentana;
	
    
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventana principal del programa
	 */
	public ControladorDespedida(Ventana miVentana) {
		this.miVentana=miVentana;
	}
	
	/**
	 * Metodo para pasar del la ventana despedida a la de saludo automaticamente (en milisegundos)
	 */
	public void PasarDeDespedidaASaludo() {
		Timer timer = new Timer();
		TimerTask esperar = new TimerTask() {
			@Override
			public void run() {
				miVentana.despedida.setVisible(false);
				miVentana.saludo.setVisible(true);
			}
		};
		timer.schedule(esperar, 3500);
	}
}
