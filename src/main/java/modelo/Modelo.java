package modelo;

import java.util.ArrayList;

import controlador.Controlador;

public class Modelo {
	

	// Declaracion e inicializacion de variables
	private Controlador miControlador;
	public FuncionesHotel misFuncionesHotel;
	public FuncionesDevolucion misFuncionesDevolucion;
	public FuncionesPago misFuncionesPago;
	public FuncionesLogin misFuncionesLogin;
	public FuncionesRegistro misFuncionesRegistro;
	public ArrayList<Hotel> listaHoteles;
	public Hotel hotelReservado;	
	public HabitacionHotel habitacionReservada;
	public ArrayList<HabitacionHotel> reservas;
	public Cliente cliente;
		
	/**
	 * Constructor de la clase
	 */
	public Modelo() {
			
		//Instacias de todas las clases de las funciones de cada panel
		this.misFuncionesHotel = new FuncionesHotel();
		this.misFuncionesDevolucion = new FuncionesDevolucion();
		this.misFuncionesPago = new FuncionesPago();
		this.misFuncionesLogin = new FuncionesLogin();
		this.misFuncionesRegistro = new FuncionesRegistro();
		this.listaHoteles  = new ArrayList<Hotel>();
		this.hotelReservado = new Hotel();
		//this.reserva = new HabitacionHotel();
		this.reservas=new  ArrayList<HabitacionHotel>(); 
	}
	
	public Controlador getControlador() {
		return miControlador;
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	} 
}
