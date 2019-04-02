package modelo;

public class Dormitorio extends Habitaciones{
	private int nCamas;
	

	public Dormitorio(int tamano, int nCamas) {
		super(tamano);
		this.nCamas = nCamas;
	}

	public int getnCamas() {
		return nCamas;
	}

	public void setnCamas(int nCamas) {
		this.nCamas = nCamas;
	}
	
	
}
