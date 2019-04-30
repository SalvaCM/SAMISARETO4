package modelo;


import java.util.ArrayList;
import java.util.Date;

public class ReservaHotel{
	private int codReserva;
	private Date fechaEntrada;
	private Date fechaSalida;
	private int noches;
	private Hotel hotelReservado = new Hotel();
	private ArrayList<HabitacionHotel> habitacionesReservadas=new  ArrayList<HabitacionHotel>();

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

	public ArrayList<HabitacionHotel> getHabReservadas() {
		return habitacionesReservadas;
	}

	public void setHabReservadas(ArrayList<HabitacionHotel> habitacionesReservadas) {
		this.habitacionesReservadas = habitacionesReservadas;
	}

	public Hotel getHotelReservado() {
		return hotelReservado;
	}

	public void setHotelReservado(Hotel hotelReservado) {
		this.hotelReservado = hotelReservado;
	}

	public int getNoches() {
		return noches;
	}

	public void setNoches(int noches) {
		this.noches = noches;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nCodigo de Reserva :");
		builder.append(codReserva);
		builder.append("\nFecha de Entrada :");
		builder.append(fechaEntrada);
		builder.append("\nFecha de Salida :");
		builder.append(fechaSalida);
		builder.append("\nnoches=:");
		builder.append(noches);
		return builder.toString();
	}
	
}
