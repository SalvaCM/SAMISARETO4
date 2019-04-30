package modelo;

import java.util.ArrayList;

public class Hotel {
	private int cod_hotel;
	private int nEstrellas;
	private String ubicacion;
	private String nombre;
	public ArrayList<HabitacionHotel> habitacionesDisponibles= new ArrayList<HabitacionHotel>();
	
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
	
	public ArrayList<HabitacionHotel> getHabitacionesDisp() {
	return habitacionesDisponibles;
	}

	public void setHabitacionesDisp(ArrayList<HabitacionHotel> habitacionesDisponibles) {
	this.habitacionesDisponibles = habitacionesDisponibles;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hotel :");
		builder.append(nombre);
		builder.append("\nEstrellas :");
		builder.append(nEstrellas);
		builder.append("\nUbicacion :");
		builder.append(ubicacion);
		builder.append("\n");
		return builder.toString();
	}
	

	
	
}