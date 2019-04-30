package modelo;

import java.util.Date;

public class Cliente {
	
	private int codCliente;
	private String dni;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String contrasena;
	
	public Cliente(String dni,String nombre, String apellidos, Date fechaNacimiento, String password) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasena = password;	
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
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	
	
}
