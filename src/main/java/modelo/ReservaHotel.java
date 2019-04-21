package modelo;

import java.sql.Date;

public class ReservaHotel extends HabitacionHotel {
	Date fechaEntrada;
	Date fechaSalida;
	public ReservaHotel(int codHabitacion, int tamano, String tipo, float precio, boolean ocupada, int nCamas,
			Date fechaEntrada, Date fechaSalida) {
		super(codHabitacion, tamano, tipo, precio, ocupada, nCamas);
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	

	
}
