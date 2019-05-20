package modelo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Apartamento extends Alojamiento{
	
	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
	private int piso;
	private int cod_apartamento;
	private float precio;
	private int tamano;
	private ArrayList<Habitacion> habitaciones= new ArrayList<Habitacion>();
	private ArrayList<Dormitorio> dormitorios = new ArrayList<Dormitorio>();
		
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Apartamento() {
		
	}
	
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getCod_apartamento() {
		return cod_apartamento;
	}
	public void setCod_apartamento(int cod_apartamento) {
		this.cod_apartamento = cod_apartamento;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}


	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Apartamento:");
		builder.append(nombre);
		builder.append("\nTamano :");
		builder.append(tamano + " m²");
		builder.append("\nPiso :");
		builder.append(piso);
		builder.append("\nUbicacion :");
		builder.append(ubicacion);
		builder.append("\n");
		builder.append("Precio :");
		builder.append(formatoMoneda.format(precio));
		
		return builder.toString();
	}

	public ArrayList<Dormitorio> getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(ArrayList<Dormitorio> dormitorios) {
		this.dormitorios = dormitorios;
	}
	


}
