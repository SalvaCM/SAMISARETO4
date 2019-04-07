package modelo;

public class Habitacion {
	protected int tamano;
	protected boolean ocupada;

	
	
	public Habitacion(int tamano, boolean ocupada) {
		this.tamano = tamano;
		this.ocupada = ocupada;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	public Habitacion(int tamano) {
		this.tamano = tamano;
	}
	
}