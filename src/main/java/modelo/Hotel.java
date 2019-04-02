package modelo;

public class Hotel extends Alojamiento{
	private int nEstrellas;
	
	public Hotel(int codAlojamiento, int habDisponibles, int habTotales, String nombre, String ubicacion,int nEstrellas) {
		super(codAlojamiento, habDisponibles, habTotales, nombre, ubicacion);
		this.nEstrellas=nEstrellas;
	}

	public int getnEstrellas() {
		return nEstrellas;
	}

	public void setnEstrellas(int nEstrellas) {
		this.nEstrellas = nEstrellas;
	}
	
}
