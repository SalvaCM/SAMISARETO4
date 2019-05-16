package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Modelo;
import vista.Ventana;

public class ControladorLogin  implements ActionListener{
	
	private Ventana miVentana;
	private Modelo miModelo;
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
	public void LoggingOut() {
		miModelo.logged=false;
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
					activarPerfil();
					
					funciones.cambiarDePanel(miVentana.login, miVentana.login.paneldeRetorno);
				}
				else {
					JOptionPane.showMessageDialog(miVentana, "Password Incorrecto", "Atencion!", JOptionPane.WARNING_MESSAGE);
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

	public void activarPerfil() {
		String logout="Logout";
		miVentana.alojamiento.btnLogin.setText(logout);
		miVentana.apartamento.btnLogin.setText(logout);
		miVentana.casa.btnLogin.setText(logout);
		miVentana.devolucion.btnLogin.setText(logout);
		miVentana.estanciasHotel.btnLogin.setText(logout);
		miVentana.resumen.btnLogin.setText(logout);
		miVentana.resumenCyA.btnLogin.setText(logout);
		miVentana.hotel.btnLogin.setText(logout);

		
		miVentana.alojamiento.btnPerfil.setEnabled(true);
		miVentana.apartamento.btnPerfil.setEnabled(true);
		miVentana.casa.btnPerfil.setEnabled(true);
		miVentana.devolucion.btnPerfil.setEnabled(true);
		miVentana.estanciasHotel.btnPerfil.setEnabled(true);
		miVentana.resumen.btnPerfil.setEnabled(true);
		miVentana.resumenCyA.btnPerfil.setEnabled(true);
		miVentana.hotel.btnPerfil.setEnabled(true);
		
	}	
	
		
}
