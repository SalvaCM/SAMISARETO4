package modelo;


public abstract class Alojamiento {
	protected int codAlojamiento;
	protected String nombre;
	protected String ubicacion;
	protected float tarifa;
	
	protected Habitacion habitacion;
	
		
	public Alojamiento(int codAlojamiento, String nombre, String ubicacion,float tarifa) {
		this.codAlojamiento = codAlojamiento;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.tarifa = tarifa;
	}
	public Alojamiento() {
		
	}
	public int getCodAlojamiento() {
		return codAlojamiento;
	}
	public void setCodAlojamiento(int codAlojamiento) {
		this.codAlojamiento = codAlojamiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public float getTarifa() {
		return tarifa;
	}
	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
}
