package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class ReservaHotel{
	private int codReserva;
	private Date fechaEntrada;
	private Date fechaSalida;
	private int noches;
	private Hotel hotel = new Hotel();
	private ArrayList<HabitacionHotel> reservas=new  ArrayList<HabitacionHotel>();

	public ReservaHotel() {};
	
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
	public int getCodReserva() {
		return codReserva;
	}
	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}

	public ArrayList<HabitacionHotel> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<HabitacionHotel> reservas) {
		this.reservas = reservas;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getNoches() {
		return noches;
	}

	public void setNoches(int noches) {
		this.noches = noches;
	}
}
