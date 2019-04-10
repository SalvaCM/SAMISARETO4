package modelo;

public class Dormitorio extends Habitacion{
	private int nCamas;

	public Dormitorio(int codHabitacion, int tamano, String tipo, int nCamas) {
		super(codHabitacion, tamano, tipo);
		this.nCamas = nCamas;
	}

	public int getnCamas() {
		return nCamas;
	}

	public void setnCamas(int nCamas) {
		this.nCamas = nCamas;
	}
	
	
	
	
	
}
