package modelo;

public class Cliente {
	
	private String dni;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String contrasena;
	
	public Cliente(String dni,String nombre, String apellidos, String fechaNacimiento, String contrasena) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasena = contrasena;	
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
