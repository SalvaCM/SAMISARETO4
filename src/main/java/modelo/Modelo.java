package modelo;

import java.util.ArrayList;

import controlador.Controlador;

public class Modelo {
	

	// Declaracion e inicializacion de variables
	private Controlador miControlador;
	public FuncionesHotel misFuncionesHotel;
	public FuncionesDevolucion misFuncionesDevolucion;
	public FuncionesPago misFuncionesPago;
	public ArrayList<Hotel> listaHoteles;
	public Hotel hotel;	
	public estanciaHotel reserva;
		
	/**
	 * Constructor de la clase
	 */
	public Modelo() {
			
		//Instacias de todas las clases de las funciones de cada panel
		this.misFuncionesHotel = new FuncionesHotel();
		this.misFuncionesDevolucion = new FuncionesDevolucion();
		this.misFuncionesPago = new FuncionesPago();
		this.listaHoteles  = new ArrayList<Hotel>();
		this.hotel = new Hotel();
		this.reserva = new estanciaHotel();
	}
	
	public Controlador getControlador() {
		return miControlador;
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	} 
	
	

	

}
