package modelo;

public class Cama {
	private String tipoCama;
	private int nPersonas;

	public Cama(String tipoCama, int nPersonas) {
		super();
		this.tipoCama = tipoCama;
		this.nPersonas = nPersonas;
	}
	public Cama() {
		
	}
	public String getTipoCama() {
		return tipoCama;
	}
	public void setTipoCama(String tipoCama) {
		this.tipoCama = tipoCama;
	}
	public int getnPersonas() {
		return nPersonas;
	}
	public void setnPersonas(int nPersonas) {
		this.nPersonas = nPersonas;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nCama :");
		builder.append(tipoCama);
		builder.append("\nPersonas :");
		builder.append(nPersonas);
		builder.append("\n");
		return builder.toString();
	}
	
}
