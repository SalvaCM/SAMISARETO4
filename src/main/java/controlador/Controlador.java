
package controlador;


import modelo.Modelo;
import vista.Ventana;

/**
 * Clase controlador. Se encarga de conectar la clase Modelo de tratamiento de la informacion con la clase Vista que interaccciona con el usuario
 * Tiene las instancias de todos los controladores de cada uno de los paneles donde se a�aden las acciones de cada boton y elemento del panel
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
	public ControladorLogin miControladorLogin;
	public ControladorRegistro miControladorRegistro;
	public ControladorUsuario miControladorUsuario;
	public FuncionesControlador miFuncionesControlador;
	public ControladorElegir miControladorElegir;
	public ControladorCasa miControladorCasa;
	public ControladorApartamento miControladorApartamento;
	public ControladorResumenCasayApart miControladorResumenCasayApart;


	
	//Constructor
	
		public Controlador(Ventana miVentana, Modelo miModelo) { 
			this.miVentana = miVentana;
			this.miModelo = miModelo;
	
			this.miControladorPago = new ControladorPago(miVentana, miModelo,this);
			this.miControladorResumen = new ControladorResumen(miVentana, miModelo,this);
			this.miControladorDevolucion = new ControladorDevolucion(miVentana, miModelo,this);
			this.miControladorHotel = new ControladorHotel(miVentana, miModelo,this);
			this.miControladorSaludo = new ControladorSaludo(miVentana, miModelo);
			this.miControladorEstanciasHotel = new ControladorEstanciasHotel(miVentana, miModelo,this);
			this.miControladorLogin = new ControladorLogin(miVentana, miModelo,this);
			this.miControladorRegistro = new ControladorRegistro(miVentana, miModelo);
			this.miControladorUsuario = new ControladorUsuario(miVentana, miModelo,this);
			this.miFuncionesControlador = new FuncionesControlador();
			this.miControladorElegir=new ControladorElegir(miVentana, miModelo,this);
			this.miControladorCasa = new ControladorCasa(miVentana, miModelo,this);
			this.miControladorApartamento = new ControladorApartamento(miVentana, miModelo,this);
			this.miControladorResumenCasayApart = new ControladorResumenCasayApart(miVentana, miModelo, this);
		
		}


	
		
		
		
}