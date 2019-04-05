package modelo;

public class Hotel extends Alojamiento{
	private int nEstrellas;
	
	public Hotel(int codAlojamiento, int habDisponibles, int habTotales, String nombre, String ubicacion,int nEstrellas,float tarifa) {
		super(codAlojamiento, habDisponibles, habTotales, nombre, ubicacion,tarifa);
		this.nEstrellas=nEstrellas;
	}
	
	public Hotel() {
		
	}

	public int getnEstrellas() {
		return nEstrellas;
	}

	public void setnEstrellas(int nEstrellas) {
		this.nEstrellas = nEstrellas;
	}

/*	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hotel [nEstrellas=");
		builder.append(nEstrellas);
		builder.append(", codAlojamiento=");
		builder.append(codAlojamiento);
		builder.append(", habDisponibles=");
		builder.append(habDisponibles);
		builder.append(", habTotales=");
		builder.append(habTotales);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", ubicacion=");
		builder.append(ubicacion);
		builder.append(", tarifa=");
		builder.append(tarifa);
		builder.append("]");
		return builder.toString();
	}*/
	
}
