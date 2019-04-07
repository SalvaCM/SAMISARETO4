package modelo;

public class Dormitorio extends Habitacion{
	private int nCamas;
	
	
	public Dormitorio(int tamano, boolean ocupada, int nCamas) {
		super(tamano, ocupada);
		this.nCamas = nCamas;
	}

	public int getnCamas() {
		return nCamas;
	}

	public void setnCamas(int nCamas) {
		this.nCamas = nCamas;
	}

	
	
	
	
}
