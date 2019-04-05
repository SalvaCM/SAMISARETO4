package modelo;


public class Alojamiento {
	protected int codAlojamiento;
	protected int habDisponibles;
	protected int habTotales;
	protected String nombre;
	protected String ubicacion;
	protected float tarifa;
		
	public Alojamiento(int codAlojamiento, int habDisponibles, int habTotales, String nombre, String ubicacion,float tarifa) {
		this.codAlojamiento = codAlojamiento;
		this.habDisponibles = habDisponibles;
		this.habTotales = habTotales;
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
	public int getHabDisponibles() {
		return habDisponibles;
	}
	public void setHabDisponibles(int habDisponibles) {
		this.habDisponibles = habDisponibles;
	}
	public int getHabTotales() {
		return habTotales;
	}
	public void setHabTotales(int habTotales) {
		this.habTotales = habTotales;
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
