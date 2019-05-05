package modelo;

public class Casa extends Alojamiento {

	 	private int cod_casa;
		private int tamano;
		private float precio;

	 	public Casa(int codAlojamiento, int habDisponibles, int habTotales, String nombre, String ubicacion, float tarifa, int cod_casa, int tamano, float precio) {
			super(codAlojamiento, habDisponibles, habTotales, nombre, ubicacion, tarifa);
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

	 	

	


}
