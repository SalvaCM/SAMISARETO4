package modelo;

public class HabitacionHotel extends Habitacion {
	protected float precio;
	protected boolean ocupada;
	protected int nCamas;
	
	public HabitacionHotel(int codHabitacion, int tamano, String tipo, float precio, boolean ocupada,int nCamas) {
		super(codHabitacion,tamano,tipo);
		this.precio = precio;
		this.ocupada = ocupada;
		this.nCamas = nCamas;
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
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	public int getnCamas() {
		return nCamas;
	}
	public void setnCamas(int nCamas) {
		this.nCamas = nCamas;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HabitacionHotel [precio=");
		builder.append(precio);
		builder.append(", nCamas=");
		builder.append(nCamas);
		builder.append(", codHabitacion=");
		builder.append(codHabitacion);
		builder.append(", tamano=");
		builder.append(tamano);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

