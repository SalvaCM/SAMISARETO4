package modelo;

import java.util.ArrayList;

public class Hotel {
	private int cod_hotel;
	private int nEstrellas;
	private String ubicacion;
	private String nombre;
	public ArrayList<estanciaHotel> estancias;
	
	
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
@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Nombre: ");
		builder.append(nombre);
		builder.append("Ubicacion: ");
		builder.append(ubicacion);
		builder.append("Nº Estrellas: ");
		builder.append(nEstrellas);
		return builder.toString();
	}

public ArrayList<estanciaHotel> getEstancias() {
	return estancias;
}

public void setEstancias(ArrayList<estanciaHotel> estancias) {
	this.estancias = estancias;
}

	
	
}
