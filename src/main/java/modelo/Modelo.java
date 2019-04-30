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
	public FuncionesReserva misFuncionesReserva;
	public ArrayList<Hotel> listaHoteles;
	public Hotel hotelReservado;	
	public HabitacionHotel habitacionReservada;
	public ArrayList<HabitacionHotel> reservas;
	public Cliente cliente;
	public ReservaHotel reservaHotel;

		
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
		this.misFuncionesReserva = new FuncionesReserva();
		this.listaHoteles  = new ArrayList<Hotel>();
		this.hotelReservado = new Hotel();
		this.reservas=new  ArrayList<HabitacionHotel>(); 
		this.reservaHotel= new ReservaHotel();
		
	}
	
	public Controlador getControlador() {
		return miControlador;
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	} 
}
