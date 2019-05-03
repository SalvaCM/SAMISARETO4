package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import modelo.Modelo;
import vista.Ventana;

public class ControladorSaludo implements ActionListener{

	private Ventana miVentana;
	private Modelo miModelo;
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	public ControladorSaludo(Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miModelo =miModelo;
		
		miVentana.saludo.btnSaludo.addActionListener(this);
		
	}
	
	/**
	 * Metodo para las llamadas a los botones de la 
	 * ventana resumen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {
			    

		case "btnSaludo": funciones.cambiarDePanel(miVentana.saludo, miVentana.login); 
		
		
				break;
		}
	}


	
		
	

}
