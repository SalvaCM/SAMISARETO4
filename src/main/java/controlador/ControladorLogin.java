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
	public ControladorLogin(Ventana miVentana, Modelo miModelo) {
		
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
				boolean valido;
				valido = miModelo.misFuncionesLogin.comprobarContrasena(miVentana.login.TextDni.getText(), miVentana.login.passwordField.getPassword());
				if (valido==true)
				{
					miModelo.cliente = new Cliente();
					miModelo.cliente = miModelo.misFuncionesLogin.LogearUser(miVentana.login.TextDni.getText());
					funciones.cambiarDePanel(miVentana.login, miVentana.hotel);
					resetear();
				}
				else
				{
					JOptionPane.showMessageDialog(miVentana, "Usuario/Contraseña Incorrectos", "ATENCION", JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	
		break;
		
		case "btnRegistrarseLogin": funciones.cambiarDePanel(miVentana.login, miVentana.registro);

		}
	}	

}
