package modelo;

public class Dormitorio extends Habitacion{
	private int nCamas;
	private int Capacidad;

	public Dormitorio(int codHabitacion, int tamano, String tipo, int nCamas,int Capacidad) {
		super(codHabitacion, tamano, tipo);
		this.nCamas = nCamas;
		this.Capacidad = Capacidad;
	}

	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tipo :");
		builder.append(tipo);
		builder.append(" Camas :"+nCamas);
		builder.append(" Capacidad :"+Capacidad+"\n");
		return builder.toString();
	}



	public Dormitorio() {
		// TODO Auto-generated constructor stub
	}

	public int getnCamas() {
		return nCamas;
	}

	public void setnCamas(int nCamas) {
		this.nCamas = nCamas;
	}

	public int getCapacidad() {
		return Capacidad;
	}

	public void setCapacidad(int capacidad) {
		Capacidad = capacidad;
	}
	
	
	
	
	
}
