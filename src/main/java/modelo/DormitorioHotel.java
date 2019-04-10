package modelo;

public class DormitorioHotel extends Habitacion {
	protected int codHabitacion;
	protected int tamano;
	protected String tipo;
	protected boolean ocupada;
	
	
	public DormitorioHotel(int tamano, int codHabitacion, int tamano2, String tipo, boolean ocupada) {
		super(tamano);
		this.codHabitacion = codHabitacion;
		tamano = tamano2;
		this.tipo = tipo;
		this.ocupada = ocupada;
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
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	
}

