package modelo;

import java.util.Date;

public class Cliente {
	
	private String dni;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private char[] contrasena;
	
	public Cliente(String dni,String nombre, String apellidos, Date fechaNacimiento, char[] contrasena) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasena = contrasena;	
	}
	
	public Cliente() {
		// TODO Auto-generated constructor stub
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public char[] getContrasena() {
		return contrasena;
	}
	public void setContrasena(char[] contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
