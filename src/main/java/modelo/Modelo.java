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
	public FuncionesCasa misFuncionesCasa;
	public FuncionesApartamento misFuncionesApartamento;
	public FuncionesServicios misFuncionesServicios;
	public ArrayList<Hotel> listaHoteles;
	public ArrayList<Apartamento> listaApartamento;
	public ArrayList<Casa> listaCasas;
	public Cliente cliente;
	public ReservaHotel reservaHotel;
	public ReservaCASAoAPART reserva;
	public Cama cama;
	public Hotel hotel;
	public FuncionesCodigosDto misFuncionesCodigos;
	public boolean logged=false;
	public CodigosDto codigosDto;
	public Casa casa;
	public Apartamento apartamento;
		
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
		this.misFuncionesCasa = new FuncionesCasa();
		this.misFuncionesApartamento = new FuncionesApartamento();
		this.misFuncionesServicios=new FuncionesServicios();
		this.listaHoteles  = new ArrayList<Hotel>();
		this.listaApartamento=new ArrayList<Apartamento>();
		this.listaCasas=new ArrayList<Casa>();
		this.reservaHotel= new ReservaHotel();
		this.reserva=new ReservaCASAoAPART();
		this.hotel = new Hotel();
		this.misFuncionesCodigos = new FuncionesCodigosDto();
		this.codigosDto = new CodigosDto();
		this.casa = new Casa();
		this.apartamento = new Apartamento();
		
		
	}
	
	public Controlador getControlador() {
		return miControlador;
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	} 
}
