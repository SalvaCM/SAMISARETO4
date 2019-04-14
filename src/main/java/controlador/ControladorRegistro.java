package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.Modelo;
import vista.Ventana;

public class ControladorRegistro implements ActionListener {
	
	private Ventana miVentana;
	private Modelo miModelo;

	
	FuncionesControlador funciones = new FuncionesControlador();
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 * @param miControlador 
	 */
	public ControladorRegistro(Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;

		miVentana.registro.btnCancelar.addActionListener(this);
		miVentana.registro.btnRegistrarse.addActionListener(this);
	
	}
	
	/**
	 * Metodo para las llamadas a los botones de la ventana resumen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {
			    
		case "btnRegistro": try {
			if(miVentana.registro.textFieldDni.getText()==null|| miVentana.registro.textFieldNombre.getText()==null||miVentana.registro.textFieldApellido.getText()==null||miVentana.registro.passwordField.getPassword()==null||miVentana.registro.dateChooser.getDate()==null) {
				JOptionPane.showMessageDialog(miVentana.registro, "Introduzca todos los campos");
			}else {
			miModelo.misFuncionesRegistro.registrarNuevoCliente(miVentana.registro.textFieldDni.getText(), miVentana.registro.textFieldNombre.getText(),  miVentana.registro.textFieldApellido.getText(), miVentana.registro.dateChooser.getDate(),miVentana.registro.passwordField.getPassword());
			System.out.println("entra");
			funciones.cambiarDePanel(miVentana.registro, miVentana.login);
			}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break;
				
		case "btnCancelarRegistro": funciones.cambiarDePanel(miVentana.registro, miVentana.login);		
				break;

		}
	}	

}
