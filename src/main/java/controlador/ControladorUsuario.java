package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.apache.commons.codec.digest.DigestUtils;
import vista.Ventana;
import modelo.Modelo;


public class ControladorUsuario implements ActionListener{
	
	private Ventana miVentana;
	private Modelo miModelo;
	private Controlador miControlador;
	
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 * @param miControlador 
	 */
	public ControladorUsuario(Ventana miVentana, Modelo miModelo, Controlador miControlador)
	{
		this.miVentana=miVentana;
		this.miModelo=miModelo;
		this.miControlador=miControlador;
		this.miVentana.usuario.btnCambiarPw.addActionListener(this);
		this.miVentana.usuario.btnCambiarContrasena.addActionListener(this);
		this.miVentana.usuario.btnVolver.addActionListener(this);
		this.miVentana.usuario.btnEliminar.addActionListener(this);
		
	
	}
		
	
	/**
	 * Metodo para las llamadas a los botones de la 
	 * ventana resumen
	 */
	
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
				miControlador.miFuncionesControlador.cambiarDePanel(miVentana.usuario, miVentana.usuario.paneldeRetorno);
				break;
			
			case "btnEliminar":
			System.out.println("LALALALALALAA");
				
			try {
				miModelo.misFuncionesLogin.EliminarCuenta(miModelo.cliente);
				miControlador.miFuncionesControlador.cambiarDePanel(miVentana.usuario, miVentana.saludo); miControlador.miControladorLogin.resetear();
				miModelo.logged=false;
				 miControlador.miControladorLogin.desactivarPerfil();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				break;
	}
}
	/**
	 * muestra los campos
	 */
	private void mostrarCampos() {
		miVentana.usuario.btnCambiarPw.setVisible(true);
		miVentana.usuario.lblNewPasswordCheck.setVisible(true);
		miVentana.usuario.passwordNueva.setVisible(true);
		miVentana.usuario.passwordNuevacheck.setVisible(true);
		miVentana.usuario.lblNewPassword.setVisible(true);
		
	}
	/**
	 * oculta los campos
	 */
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

	/**
	 *  Funcion que compara que la contraseña antigua y la nueva sean iguales
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
	
	/**
	 * cuando se cancela en el perfil vuelve al panel anterior
	 * @param panelActual
	 */
	public void TratarPerfil(JPanel panelActual) {
			miVentana.usuario.paneldeRetorno=panelActual;
			miControlador.miFuncionesControlador.cambiarDePanel(panelActual, miVentana.usuario);
		}


}