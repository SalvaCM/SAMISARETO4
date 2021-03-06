package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Cliente;
import modelo.Modelo;
import vista.Ventana;

public class ControladorLogin  implements ActionListener{
	
	private Ventana miVentana;
	private Modelo miModelo;
	private Controlador miControlador;
	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	

	
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
			    
		case "btnCancelarLogin": miControlador.miFuncionesControlador.cambiarDePanel(miVentana.login, miVentana.saludo); resetear();
		break;
		
		case "btnLogin": 
			try {
					
				if(miModelo.misFuncionesLogin.comprobarPasword(miVentana.login.TextDni.getText(), miVentana.login.passwordField.getPassword())==true) {
					miModelo.cliente = new Cliente();
					miModelo.cliente = miModelo.misFuncionesLogin.LogearUser(miVentana.login.TextDni.getText());
					miModelo.logged = true;
					activarPerfil();
					
					miControlador.miFuncionesControlador.cambiarDePanel(miVentana.login, miVentana.login.paneldeRetorno);
				}
				else {
					JOptionPane.showMessageDialog(miVentana, "Password Incorrecto", "Atencion!", JOptionPane.WARNING_MESSAGE);
				}
				
			
					resetear();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
			
	
		break;
		
		case "btnRegistrarseLogin": miControlador.miFuncionesControlador.cambiarDePanel(miVentana.login, miVentana.registro);
		break;

		}
	}

	/**
	 * restear campos al activar el perfil
	 */
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
	
	/**
	 * restear campos al desactivar el perfil
	 */
	public void desactivarPerfil() {
		
		String login="Login";
		miVentana.alojamiento.btnLogin.setText(login);
		miVentana.apartamento.btnLogin.setText(login);
		miVentana.casa.btnLogin.setText(login);
		miVentana.devolucion.btnLogin.setText(login);
		miVentana.estanciasHotel.btnLogin.setText(login);
		miVentana.resumen.btnLogin.setText(login);
		miVentana.resumenCyA.btnLogin.setText(login);
		miVentana.hotel.btnLogin.setText(login);

		
		miVentana.alojamiento.btnPerfil.setEnabled(false);
		miVentana.apartamento.btnPerfil.setEnabled(false);
		miVentana.casa.btnPerfil.setEnabled(false);
		miVentana.devolucion.btnPerfil.setEnabled(false);
		miVentana.estanciasHotel.btnPerfil.setEnabled(false);
		miVentana.resumen.btnPerfil.setEnabled(false);
		miVentana.resumenCyA.btnPerfil.setEnabled(false);
		miVentana.hotel.btnPerfil.setEnabled(false);
		
	}	

	
	/**
	 * para saber si el usuario esta logueado o no logueado. Cuando se loguea vuelve al panel que estaba y para desloguearse cuando el usuario quiera
	 * @param botonLogin
	 * @param panelActual
	 */
	public void tratarLogin(JButton botonLogin,JPanel panelActual) {
		if (botonLogin.getText().equals("Login"))
		{
			miVentana.login.paneldeRetorno=panelActual;
			miControlador.miFuncionesControlador.cambiarDePanel(panelActual, miVentana.login);
		}
		else
		{
			desactivarPerfil();
			miVentana.login.paneldeRetorno=null;
			miControlador.miFuncionesControlador.cambiarDePanel(panelActual, miVentana.saludo);
			JOptionPane.showMessageDialog(miVentana, "Desconectando Usuario", "Atencion!", JOptionPane.WARNING_MESSAGE);
			miModelo.logged=false;
			miControlador.miFuncionesControlador.limpiarTabla(miVentana.hotel.tablaResultados,miVentana.hotel.tableModel);
			miControlador.miFuncionesControlador.limpiarTabla(miVentana.estanciasHotel.tablaHabitaciones,miVentana.estanciasHotel.tableModel);
			miControlador.miFuncionesControlador.limpiarTabla(miVentana.casa.tablaResultados,miVentana.hotel.tableModel);
			miControlador.miFuncionesControlador.limpiarTabla(miVentana.apartamento.tablaResultados,miVentana.hotel.tableModel);
		}
	}
	
		
}
