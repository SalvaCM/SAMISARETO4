package modelo;

public class Habitacion {
	protected int codHabitacion;
	protected int tamano;
	protected String tipo;
	
	
	public Habitacion(int tamano) {
		this.tamano = tamano;
	}
	public int getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	public Habitacion(int codHabitacion, int tamano, String tipo) {
		this.codHabitacion = codHabitacion;
		this.tamano = tamano;
		this.tipo = tipo;
	}
	
	
	
}