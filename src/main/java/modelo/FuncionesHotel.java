package modelo;

import java.util.ArrayList;

public class FuncionesHotel {

	public ArrayList<Alojamiento> alojamientos;
	public Alojamiento alojamiento=new Alojamiento();
	
	public FuncionesHotel() { 
		
		alojamientos=new ArrayList<Alojamiento>();
		Hotel pezEspada = new Hotel(1,50,100, "Hotel Pez Espada", "Málaga",50,5);
		alojamientos.add(pezEspada);
		Hotel triton = new Hotel(1,50,100, "Hotel Tritón", "Málaga",50,5);
		alojamientos.add(triton);
		Hotel tropicana = new Hotel(1,50,100, "Hotel Tropicana", "Málaga",50,5);
		alojamientos.add(tropicana);
	}


	

}
