package modelo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Casa extends Alojamiento {
	
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
		
	 	private int cod_casa;
		private int tamano;
		private float precio=0;
		private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		private ArrayList<Dormitorio> dormitorios = new ArrayList<Dormitorio>();

	 	public Casa(int codAlojamiento, int habDisponibles, int habTotales, String nombre, String ubicacion, float tarifa, int cod_casa, int tamano, float precio) {
			super(codAlojamiento, nombre, ubicacion, tarifa);
			this.cod_casa = cod_casa;
			this.tamano = tamano;
			this.precio = precio;
		}

	 	public Casa() {

	 	}



		public int getCod_casa() {
			return cod_casa;
		}



		public void setCod_casa(int cod_casa) {
			this.cod_casa = cod_casa;
		}



		public int getTamano() {
			return tamano;
		}



		public void setTamano(int tamano) {
			this.tamano = tamano;
		}



		public float getPrecio() {
			return precio;
		}



		public void setPrecio(float precio) {
			this.precio = precio;
		}		

	 	

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Casa :");
			builder.append(nombre);
			builder.append("\nTamaño :");
			builder.append(tamano + "m²");
			builder.append("\nUbicacion :");
			builder.append(ubicacion);
			builder.append("\n");
			builder.append("Precio :");
			builder.append(formatoMoneda.format(precio));
			return builder.toString();
		}



		public ArrayList<Habitacion> getHabitaciones() {
			return habitaciones;
		}



		public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
			this.habitaciones = habitaciones;
		}

		public ArrayList<Dormitorio> getDormitorios() {
			return dormitorios;
		}

		public void setDormitorios(ArrayList<Dormitorio> dormitorios) {
			this.dormitorios = dormitorios;
		}
		


}
