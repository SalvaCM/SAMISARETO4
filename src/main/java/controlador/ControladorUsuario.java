package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import org.apache.commons.codec.digest.DigestUtils;
import vista.Ventana;
import modelo.Modelo;


public class ControladorUsuario implements ActionListener{
	
	private Ventana miVentana;
	private Modelo miModelo;
	FuncionesControlador funciones = new FuncionesControlador();
	
	public ControladorUsuario(Ventana miVentana, Modelo miModelo)
	{
		this.miVentana=miVentana;
		this.miModelo=miModelo;
		this.miVentana.usuario.btnCambiarPw.addActionListener(this);
		this.miVentana.usuario.btnCambiarContrasena.addActionListener(this);
		this.miVentana.usuario.btnVolver.addActionListener(this);
		
	
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getName()) {

			case "btnCambiarPw": 
				if(ValidarContrasena())
				{
					String passwordEncriptada = DigestUtils.md5Hex(String.valueOf(miVentana.usuario.passwordNueva.getPassword()));
					try {
						miModelo.misFuncionesLogin.cambiarContrasena(passwordEncriptada, miModelo.cliente);
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(passwordEncriptada);
					ocultarCampos();
				}
				else
				{
					miVentana.usuario.lblErrContra.setVisible(true);
				}
				break;
			case "btnCambiarContrasena":
				mostrarCampos();
				break;
			
			case "btnVolver":
				funciones.cambiarDePanel(miVentana.usuario, miVentana.hotel);
				
				break;
	}
	
	
}
	private void mostrarCampos() {
		miVentana.usuario.btnCambiarPw.setVisible(true);
		miVentana.usuario.lblNewPasswordCheck.setVisible(true);
		miVentana.usuario.passwordNueva.setVisible(true);
		miVentana.usuario.passwordNuevacheck.setVisible(true);
		miVentana.usuario.lblNewPassword.setVisible(true);
		
	}

	private void ocultarCampos() {
		miVentana.usuario.passwordNueva.setText("");
		miVentana.usuario.passwordNuevacheck.setText("");
		miVentana.usuario.lblErrContra.setVisible(false);
		miVentana.usuario.btnCambiarPw.setVisible(false);
		miVentana.usuario.lblNewPasswordCheck.setVisible(false);
		miVentana.usuario.passwordNueva.setVisible(false);
		miVentana.usuario.passwordNuevacheck.setVisible(false);
		miVentana.usuario.lblNewPassword.setVisible(false);
	}

	/*
	 *  Función que Compara que la contraseña antigua y la nueva sean iguales
	 */
	public boolean ValidarContrasena() {
		boolean resultado=true;

		int passLength=String.valueOf(miVentana.usuario.passwordNueva.getPassword()).length();
		boolean contrasenasIguales=false;
		if(String.valueOf(miVentana.usuario.passwordNueva.getPassword()).equals(String.valueOf(miVentana.usuario.passwordNuevacheck.getPassword())))
		contrasenasIguales=true;
			
		if(passLength<8 || passLength>16 || !contrasenasIguales)
		{
			miVentana.usuario.lblErrContra.setVisible(true); 
			resultado=false;
		}
		return resultado;
}
	public void buscarReservas() {
		// HACER LLAMADA A LOS CAMPOS DE LA TABLA RESERVAS 
		// ANTES HAY QUE HACER UN METODO PARA INSERTAR RESERVAS EN LA BD DESPUES DEL PAGO
		// OPCIONAL HACER UN METODO PARA RECUPERAR POR SEPARADO LOS DATOS DE LA RESERVA DE HOTEL Y HABITACIONES
		// ASI SE ESCRIBIRIAN EN EL PANEL USUARIO EN RESERVAS PASADAS Y FUTURAS
	}


}