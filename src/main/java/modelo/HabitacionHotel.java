package modelo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class HabitacionHotel extends Habitacion {
	
	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
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
		builder.append("Tamano: "+tamano+ " m²" +"\n");
		builder.append("Precio: "+formatoMoneda.format(precio)+ "\n");
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

