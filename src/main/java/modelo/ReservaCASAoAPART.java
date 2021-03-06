package modelo;

import java.util.Date;

public class ReservaCASAoAPART {
	
	private int codReserva;
	private Date fechaEntrada;
	private Date fechaSalida;
	private int noches;
	private Casa casaReservada = new Casa();
	private Apartamento apartReservado = new Apartamento();
	
	public int getCodReserva() {
		return codReserva;
	}
	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
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
	public int getNoches() {
		return noches;
	}
	public void setNoches(int noches) {
		this.noches = noches;
	}
	public Casa getCasaReservada() {
		return casaReservada;
	}
	public void setCasaReservada(Casa casaReservada) {
		this.casaReservada = casaReservada;
	}
	public Apartamento getApartReservado() {
		return apartReservado;
	}
	public void setApartReservado(Apartamento apartReservado) {
		this.apartReservado = apartReservado;
	}
}
