package modelo;

public class Hotel {
	private int cod_hotel;
	private int nEstrellas;
	private String ubicacion;
	private String nombre;
	private Habitacion habitacion;
	private float precioNoche;
	
	
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

	public float getPrecioNoche() {
		return precioNoche;
	}
	
	public void setPrecioNoche(float precio) {
		this.precioNoche = precio;
	}
@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[nombre=");
		builder.append(nombre);
		builder.append(", ubicacion=");
		builder.append(ubicacion);
		builder.append("precio x noche ="+precioNoche);
		builder.append("]");
		return builder.toString();
	}
	
	public Habitacion getHabitacion() {
		return habitacion;
	}
	
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	
}
