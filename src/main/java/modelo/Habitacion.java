package modelo;

public class Habitacion {
	protected int codHabitacion;
	protected int tamano;
	protected String tipo;

	
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tipo : ");
		builder.append(tipo);
		builder.append(" Tamano : ");
		builder.append(tamano);
		builder.append("\n");
		return builder.toString();
	}
	
	
	
	
}