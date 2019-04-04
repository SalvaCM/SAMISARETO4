package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import modelo.Alojamiento;
import modelo.Modelo;
import vista.Ventana;

public class ControladorHotel implements ActionListener {
			
			//private Controlador miControlador;
			private Ventana miVentana;
			private Modelo miModelo;
			
			FuncionesControlador funciones = new FuncionesControlador();
			
			/**
			 * Constructor de la clase
			 * @param miVentana instancia de la ventna principal
			 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
			 */
			public ControladorHotel(Ventana miVentana, Modelo miModelo) {
				
				this.miVentana = miVentana;
				this.miModelo = miModelo;
				
				miVentana.hotel.btnSiguiente.addActionListener(this);
				miVentana.hotel.btnBuscar.addActionListener(this);
			}
			
			/**
			 * Metodo para las llamadas a los botones de la ventana resumen
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (((JButton) e.getSource()).getName()) {
					    
				case "btnSiguienteHotel": funciones.cambiarDePanel(miVentana.hotel, miVentana.resumen);OpcionElegida();  
						break;
						
				case "BuscarHoteles": mostrarAlojamientosTable(miModelo.misFuncionesHotel.alojamientos);
						break;
				}
			}
			
			public void mostrarAlojamientos(ArrayList<Alojamiento> alojamientos){      
		        for(int i = 0; i< alojamientos.size(); i++) {
		        	miVentana.hotel.modelo.addElement(alojamientos.get(i).toString());
		        	//se invoca el método toString de la clase
		        }
			}

			/**
			 * Metodo para mostrar los alojamientos disponibles en el JTABLE
			 */
		    public void mostrarAlojamientosTable(ArrayList<Alojamiento> alojamientos){      
			    for(int i = 0; i< alojamientos.size(); i++) {
			       
			        /*String classnombre=alojamientos.get(i).getClass().getName();
			        System.out.println(classnombre);*/
			        String nombreHotel=alojamientos.get(i).getNombre();
			        String ubicacion=alojamientos.get(i).getUbicacion();
			        int estrellas=alojamientos.get(i).getHabDisponibles();
			        int habDisp=alojamientos.get(i).getHabTotales();
			        float precio=alojamientos.get(i).getTarifa();
			        Object[] linea= {nombreHotel,ubicacion,estrellas,habDisp,precio};
			        miVentana.hotel.tableModel.addRow(linea);
			    }   
			}
		    public void OpcionElegida()
		    {
		    	Object vector=miVentana.hotel.tableModel.getDataVector().elementAt(miVentana.hotel.tablaResultados.getSelectedRow());
		    	System.out.println(vector);
		    	miVentana.resumen.mostrarResumen.addElement(vector.toString());
		    	
		    }
		    /*
		     * for (int i = 0; i < originalLeagueList.size(); i++){
   int position = originalLeagueList.get(i).getPosition();
   String name = originalLeagueList.get(i).getName();
   int points = originalLeagueList.get(i).getPoinst();
   int wins = originalLeagueList.get(i).getWins();
   int defeats = originalLeagueList.get(i).getDefeats();
   int draws = originalLeagueList.get(i).getDraws();
   int totalMatches = originalLeagueList.get(i).getTotalMathces();
   int goalF = originalLeagueList.get(i).getGoalF();
   int goalA = originalLeagueList.get(i).getGoalA();
   in ttgoalD = originalLeagueList.get(i).getTtgoalD();

   Object[] data = {position, name, points, wins, defeats, draws, 
                               totalMatches, goalF, goalA, ttgoalD};

   tableModel.add(data);
		     */
			
			
	
	
			
		

}
