package modelo;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Modelo {
		public ArrayList<Alojamiento> alojamientos;
		public Alojamiento alojamiento=new Alojamiento();
		
	public Modelo() {
		
		alojamientos=new ArrayList<Alojamiento>();
		Hotel pezEspada = new Hotel(1,50,100, "Hotel Pez Espada", "M�laga",50,5);
		alojamientos.add(pezEspada);
		Hotel triton = new Hotel(1,50,100, "Hotel Trit�n", "M�laga",50,5);
		alojamientos.add(triton);
		Hotel tropicana = new Hotel(1,50,100, "Hotel Tropicana", "M�laga",50,5);
		alojamientos.add(tropicana);
		
	}
	
	
	

}
