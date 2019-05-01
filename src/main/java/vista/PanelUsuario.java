package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 * Clase PaneCambioFinal
 * @author IN1DM3B_18
 *
 */
public class PanelUsuario extends JPanel {
	
	private static final long serialVersionUID = 12L;
	
	public DefaultListModel<String> modelo2;
	public JButton btnCambiarPw;
	public JLabel lblCodVuelta;
	public JButton btnVolver = new JButton("Volver");
	public JPasswordField passwordNueva;
	public JPasswordField passwordNuevacheck;
	public JLabel lblCuentaDeUsuario;
	public JLabel lblNewPassword ;
	public JLabel lblNewPasswordCheck;
	public JLabel lblSeguridad;
	public JLabel lblErrContra;
	public JTextArea txtDatosPersonales;
	public JButton btnCambiarContrasena = new JButton("Cambiar Contrasena");

	/**
	 * M�todo: PaneCambioFinal
	 * @param frame1
	 */
	public PanelUsuario()
	{
		
		setForeground(Color.BLACK);
		setBackground(new Color(230, 230, 250));
		setBounds(0, 0, 800, 600);
		setLayout(null);

		
		modelo2=new DefaultListModel<String>();
		
		lblCodVuelta = new JLabel("");
		lblCodVuelta.setForeground(Color.GRAY);
		lblCodVuelta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodVuelta.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblCodVuelta.setBounds(574, 354, 108, 29);
		add(lblCodVuelta);
		
		btnVolver.setName("btnVolver");
		btnVolver.setBounds(637, 523, 153, 46);
		add(btnVolver);
		
		lblCuentaDeUsuario = new JLabel("Cuenta de Usuario :");
		lblCuentaDeUsuario.setForeground(Color.BLACK);
		lblCuentaDeUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblCuentaDeUsuario.setBounds(47, 66, 270, 46);
		add(lblCuentaDeUsuario);
		
		passwordNueva = new JPasswordField();
		passwordNueva.setBackground(Color.WHITE);
		passwordNueva.setBounds(555, 157, 189, 29);
		passwordNueva.setVisible(false);
		add(passwordNueva);
		
		lblNewPassword = new JLabel("Contrase\u00F1a :");
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setForeground(Color.BLACK);
		lblNewPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewPassword.setBounds(408, 150, 135, 39);
		lblNewPassword.setVisible(false);
		add(lblNewPassword);
		
		passwordNuevacheck = new JPasswordField();
		passwordNuevacheck.setBackground(Color.WHITE);
		passwordNuevacheck.setBounds(555, 197, 189, 29);
		passwordNuevacheck.setVisible(false);
		add(passwordNuevacheck);
		
		lblNewPasswordCheck = new JLabel("Nueva Contrase\u00F1a :");
		lblNewPasswordCheck.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPasswordCheck.setForeground(Color.BLACK);
		lblNewPasswordCheck.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewPasswordCheck.setBounds(378, 190, 165, 39);
		lblNewPasswordCheck.setVisible(false);
		add(lblNewPasswordCheck);
		
		btnCambiarPw = new JButton("Cambiar");
		btnCambiarPw.setName("btnCambiarPw");
		btnCambiarPw.setForeground(new Color(0, 51, 102));
		btnCambiarPw.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnCambiarPw.setBounds(627, 250, 117, 29);
		btnCambiarPw.setVisible(false);
		add(btnCambiarPw);
		
		lblSeguridad = new JLabel("");
		lblSeguridad.setBounds(491, 136, 114, 16);
		add(lblSeguridad);
		
		lblErrContra = new JLabel("*Las contrase\u00F1as no cumplen los requisitos");
		lblErrContra.setVisible(false);
		lblErrContra.setForeground(Color.RED);
		lblErrContra.setBounds(491, 230, 250, 16);
		lblErrContra.setVisible(false);
		add(lblErrContra);
		
		txtDatosPersonales = new JTextArea();
		txtDatosPersonales.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDatosPersonales.setEditable(false);
		txtDatosPersonales.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Personales", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		txtDatosPersonales.setBounds(47, 109, 319, 187);
		add(txtDatosPersonales);
		
		btnCambiarContrasena.setName("btnCambiarContrasena");
		btnCambiarContrasena.setBounds(410, 109, 153, 28);
		add(btnCambiarContrasena);
		
		JTextArea txtReservasPasadas = new JTextArea();
		txtReservasPasadas.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtReservasPasadas.setEditable(false);
		txtReservasPasadas.setBorder(new TitledBorder(null, "Reservas Pasadas", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(178, 34, 34)));
		txtReservasPasadas.setBounds(47, 319, 319, 187);
		add(txtReservasPasadas);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setBorder(new TitledBorder(null, "Reservas Futuras", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 0)));
		textArea.setBounds(373, 319, 319, 187);
		add(textArea);
		
		
		
		setVisible(false);
	}
}
	