package modelo;

public class Apartamento extends Alojamiento{
	private int piso;
	private int nBanos;
	private int tamanoT;

	
	public Apartamento(int piso) {
		this.piso=piso;
	}
	
	
	
	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}



	public int getnBa�os() {
		return nBanos;
	}



	public void setnBa�os(int nBanos) {
		this.nBanos = nBanos;
	}



	public int getTamanoT() {
		return tamanoT;
	}



	public void setTamanoT(int tamanoT) {
		this.tamanoT = tamanoT;
	}

}
