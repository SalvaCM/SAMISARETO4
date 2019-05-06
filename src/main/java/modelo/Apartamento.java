package modelo;

public class Apartamento extends Alojamiento{
	
	private int piso;
	private int cod_apartamento;
	private float precio;
	private int tamano;
		
	public Apartamento(int codAlojamiento, int habDisponibles, int habTotales, String nombre, String ubicacion, float tarifa, int piso, int cod_apartamento, float precio, int tamano) {
		super(codAlojamiento, habDisponibles, habTotales, nombre, ubicacion, tarifa);
		this.piso = piso;
		this.cod_apartamento = cod_apartamento;
		this.precio = precio;
		this.tamano = tamano;
	}
	
	public Apartamento() {
		
	}
	
	
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getCod_apartamento() {
		return cod_apartamento;
	}
	public void setCod_apartamento(int cod_apartamento) {
		this.cod_apartamento = cod_apartamento;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}


	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Apartamento:");
		builder.append(nombre);
		builder.append("\nTamano :");
		builder.append(tamano + " m²");
		builder.append("\nPiso :");
		builder.append(piso);
		builder.append("\nUbicacion :");
		builder.append(ubicacion);
		builder.append("\n");
		builder.append("Precio :");
		builder.append(precio + " €");
		
		return builder.toString();
	}
	


}
