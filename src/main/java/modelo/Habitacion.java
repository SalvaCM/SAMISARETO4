package modelo;

public class Habitacion {
	protected int codHabitacion;
	protected int tamano;
	protected String tipo;
	protected float nNoches;
	
	public Habitacion(int codHabitacion, int tamano, String tipo) {
		this.codHabitacion = codHabitacion;
		this.tamano = tamano;
		this.tipo = tipo;
	}
	public Habitacion() {
		super();
	}
	public int getCodHabitacion() {
		return codHabitacion;
	}
	public void setCodHabitacion(int codHabitacion) {
		this.codHabitacion = codHabitacion;
	}
	public int getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getNoches() {
		return this.nNoches;
	}
	public void setNoches(float f) {
		this.nNoches = f;
	}
	
	
	
	
}