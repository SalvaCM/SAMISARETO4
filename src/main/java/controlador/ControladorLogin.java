package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import conexion.ConexionBD;
import conexion.ConsultaBD;
import modelo.Cliente;
import modelo.Modelo;
import vista.Ventana;

public class ControladorLogin  implements ActionListener{
	
	private Ventana miVentana;
	private Modelo miModelo;
	private Controlador miControlador;


	
	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 * @param miControlador 
	 */
	public ControladorLogin(Ventana miVentana, Modelo miModelo, Controlador miControlador) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		this.miControlador = miControlador;
	
		miVentana.login.btnCancelar.addActionListener(this);
		miVentana.login.btnRegistrarse.addActionListener(this);
		miVentana.login.btnLogin.addActionListener(this);
	}
	
	/** 
	 * Metodo para resetear los valores de la ventana login 	
	 */
	public void resetear() {
		miVentana.login.TextDni.setText(""); 
		miVentana.login.passwordField.setText("");
	}

	
	
	/**
	 * Metodo para las llamadas a los botones de la ventana resumen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {
			    
		case "btnCancelarLogin": funciones.cambiarDePanel(miVentana.login, miVentana.saludo); resetear();
		break;
		
		case "btnLogin": 
			try {
					
				if(miModelo.misFuncionesLogin.comprobarPasword(miVentana.login.TextDni.getText(), miVentana.login.passwordField.getPassword())==true) {
					miModelo.cliente = new Cliente();
					miModelo.cliente = miModelo.misFuncionesLogin.LogearUser(miVentana.login.TextDni.getText(), miVentana.login.passwordField.getPassword());
					miModelo.logged = true;					
				
					if(miControlador.miControladorElegir.elegido==1) {
						funciones.cambiarDePanel(miVentana.login, miVentana.resumen);
					}					
					else if(miControlador.miControladorElegir.elegido==2 || miControlador.miControladorElegir.elegido==3) {
						funciones.cambiarDePanel(miVentana.login, miVentana.resumenCyA);
					} 
				}

				
				else {
					JOptionPane.showMessageDialog(miVentana, "�Contrase�a incorrecta!", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
				}
				
			
					resetear();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
			
	
		break;
		
		case "btnRegistrarseLogin": funciones.cambiarDePanel(miVentana.login, miVentana.registro);
		break;

		}
	}	
	
		
}
