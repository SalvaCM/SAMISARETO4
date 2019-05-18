package controlador;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import modelo.Modelo;
import vista.Ventana;

/** 
 * Clase principal. Contiene el metodo main e instancia el Controlador, la Vista y el Modelo
 *
 */
public class Principal {
	// Instancias de Controlador, Vista y Modelo
	Modelo miModelo;
	Ventana miVentana;
	Controlador miControlador;
	
	/**
	 * Metodo main. Inicio del programa
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaracion e inicializacion de variables
		Principal miPrincipal = new Principal();
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		//Inicio del programa
		miPrincipal.iniciar();
		
	}
	
	/**
	 * Metodo que inicia el programa instanciando el Controlador y anadiendole la Vista y el Modelo
	 * Tambien muestra la ventana por primera vez
	 */
	public void iniciar() {
		// Instanciar clases
		miVentana = new Ventana();
		miModelo = new Modelo();
		miControlador = new Controlador(miVentana, miModelo);

		
		//Iniciar la ventana
		miVentana.setVisible(true);
		
		
	}

	
}
