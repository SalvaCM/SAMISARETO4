package modelo;

public class Casa extends Alojamiento {
	
	private int nBanos;
	private int tamanoT;
	
	public Casa(int nbanos,int tamanoTotal) {
		this.nBanos=nbanos;
		this.tamanoT=tamanoTotal;
		
	}
	
	
	
	
	public int getnBaños() {
	
		return this.nBanos;
	}
	public void setnBaños(int nBanos) {
		this.nBanos = nBanos;
	}
	public int getTamanoT() {
		return this.tamanoT;
	}
	public void setTamanoT(int tamanoT) {
		this.tamanoT = tamanoT;
	}
	
	


}
