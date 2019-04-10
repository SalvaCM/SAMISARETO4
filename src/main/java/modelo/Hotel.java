package modelo;

import java.util.ArrayList;

public class Hotel {
	private int cod_hotel;
	private int nEstrellas;
	private String ubicacion;
	private String nombre;
	public ArrayList<HabitacionHotel> habitaciones= new ArrayList<HabitacionHotel>();
	public int habDisponibles;
	
	public Hotel() {
	}

	public int getnEstrellas() {
		return this.nEstrellas;
	}

	public void setnEstrellas(int nEstrellas) {
		this.nEstrellas = nEstrellas;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getCod_hotel() {
		return cod_hotel;
	}

	public void setCod_hotel(int cod_hotel) {
		this.cod_hotel = cod_hotel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public int getHabDisponibles() {
		return habDisponibles;
	}

	public void setHabDisponibles(int habDisponibles) {
		this.habDisponibles = habDisponibles;
	}

	public ArrayList<HabitacionHotel> getHabitaciones() {
	return habitaciones;
	}

	public void setHabitaciones(ArrayList<HabitacionHotel> habitaciones) {
	this.habitaciones = habitaciones;
	}
	

	
	
}