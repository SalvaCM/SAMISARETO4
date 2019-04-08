
package controlador;

import modelo.Modelo;
import vista.Ventana;

/**
 * Clase controlador. Se encarga de conectar la clase Modelo de tratamiento de la informacion con la clase Vista que interaccciona con el usuario
 * Tiene las instancias de todos los controladores de cada uno de los paneles donde se a�aden las acciones de cada boton y elemento del panel
 * 
 */

public class Controlador {
 
	//Declaracion e inicializacion de variables;
	//Instancias del Modelo y la Vista
	public Modelo miModelo;
	public Ventana miVentana;
	public Controlador miControlador;
	
	//Instancias de los controladores de cada panel de la ventana
	public ControladorPago miControladorPago;
	public ControladorResumen miControladorResumen;
	public ControladorDevolucion miControladorDevolucion;
	public ControladorHotel miControladorHotel;
	public ControladorSaludo miControladorSaludo;
	public ControladorEstanciasHotel miControladorEstanciasHotel;
	public ControladorDespedida miControladorDespedida;
	
	//Constructor
	
		public Controlador(Ventana miVentana, Modelo miModelo) { 
			this.miVentana = miVentana;
			this.miModelo = miModelo;
			
			this.miControladorPago = new ControladorPago(miVentana, miModelo);
			this.miControladorResumen = new ControladorResumen(miVentana, miModelo);
			this.miControladorDevolucion = new ControladorDevolucion(miVentana, miModelo);
			this.miControladorHotel = new ControladorHotel(miVentana, miModelo);
			this.miControladorSaludo = new ControladorSaludo(miVentana, miModelo);
			this.miControladorEstanciasHotel = new ControladorEstanciasHotel(miVentana, miModelo);
			this.miControladorDespedida = new ControladorDespedida(miVentana, miModelo);
		}

		

	
		
		
		
}