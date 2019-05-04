package modelo;

import java.util.ArrayList;

public class HabitacionHotel extends Habitacion {
	protected float precio;
	protected ArrayList<Cama> camas= new ArrayList<Cama>(); 
	
	public HabitacionHotel(int codHabitacion, int tamano, String tipo, float precio,ArrayList<Cama> camas) {
		super(codHabitacion,tamano,tipo);
		this.precio = precio;
		this.camas=camas;
	}
	public HabitacionHotel()
	{
		super();
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tipo: "+tipo+"\n");
		builder.append("Tamaño: "+tamano+"\n");
		builder.append("Precio: "+precio+"\n");
		builder.append("\n");
		return builder.toString();
	}
	public ArrayList<Cama> getCamas() {
		return camas;
	}
	public void setCamas(ArrayList<Cama> camas) {
		this.camas = camas;
	}
	
	
	
}

