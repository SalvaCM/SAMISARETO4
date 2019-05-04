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



	public int getnBaños() {
		return nBanos;
	}



	public void setnBaños(int nBanos) {
		this.nBanos = nBanos;
	}



	public int getTamanoT() {
		return tamanoT;
	}



	public void setTamanoT(int tamanoT) {
		this.tamanoT = tamanoT;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Apartamento [piso=");
		builder.append(piso);
		builder.append(", nBanos=");
		builder.append(nBanos);
		builder.append(", tamanoT=");
		builder.append(tamanoT);
		builder.append("]");
		return builder.toString();
	}
	
	

}
