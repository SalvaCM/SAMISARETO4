package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
import javax.swing.JScrollPane;

/**
 * Clase PaneCambioFinal
 * @author IN1DM3B_18
 *
 */
public class PanelUsuario extends JPanel {
	
	private static final long serialVersionUID = 12L;
	
	public DefaultListModel<String> modelo2;
	public JButton btnCambiarPw;
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
	public JTextArea txtReservasPasadas = new JTextArea();
	public JTextArea txtreservasFuturas = new JTextArea();
	public JLabel etiqueta;

	public JPanel paneldeRetorno;
	

	/**
	 * Método: PaneCambioFinal
	 * @param frame1
	 */
	public PanelUsuario()
	{
		
		setForeground(Color.BLACK);
		setBackground(new Color(230, 230, 250));
		setBounds(0, 0, 800, 600);
		setLayout(null);

		
		modelo2=new DefaultListModel<String>();
		btnVolver.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		btnVolver.setName("btnVolver");
		btnVolver.setBounds(637, 523, 153, 46);
		add(btnVolver);
		
		lblCuentaDeUsuario = new JLabel("Cuenta de Usuario :");
		lblCuentaDeUsuario.setForeground(Color.BLACK);
		lblCuentaDeUsuario.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCuentaDeUsuario.setBounds(47, 66, 270, 46);
		add(lblCuentaDeUsuario);
		
		passwordNueva = new JPasswordField();
		passwordNueva.setBackground(Color.WHITE);
		passwordNueva.setBounds(601, 174, 189, 29);
		passwordNueva.setVisible(false);
		add(passwordNueva);
		
		lblNewPassword = new JLabel("Contrase\u00F1a :");
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setForeground(Color.BLACK);
		lblNewPassword.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewPassword.setBounds(454, 167, 135, 39);
		lblNewPassword.setVisible(false);
		add(lblNewPassword);
		
		passwordNuevacheck = new JPasswordField();
		passwordNuevacheck.setBackground(Color.WHITE);
		passwordNuevacheck.setBounds(601, 214, 189, 29);
		passwordNuevacheck.setVisible(false);
		add(passwordNuevacheck);
		
		lblNewPasswordCheck = new JLabel("Nueva Contrase\u00F1a :");
		lblNewPasswordCheck.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPasswordCheck.setForeground(Color.BLACK);
		lblNewPasswordCheck.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewPasswordCheck.setBounds(424, 207, 165, 39);
		lblNewPasswordCheck.setVisible(false);
		add(lblNewPasswordCheck);
		
		btnCambiarPw = new JButton("Cambiar");
		btnCambiarPw.setName("btnCambiarPw");
		btnCambiarPw.setForeground(new Color(0, 51, 102));
		btnCambiarPw.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnCambiarPw.setBounds(673, 267, 117, 29);
		btnCambiarPw.setVisible(false);
		add(btnCambiarPw);
		
		lblSeguridad = new JLabel("");
		lblSeguridad.setBounds(537, 153, 114, 16);
		add(lblSeguridad);
		
		lblErrContra = new JLabel("*Las contrase\u00F1as no cumplen los requisitos");
		lblErrContra.setVisible(false);
		lblErrContra.setForeground(Color.RED);
		lblErrContra.setBounds(537, 247, 250, 16);
		lblErrContra.setVisible(false);
		add(lblErrContra);
		
		txtDatosPersonales = new JTextArea();
		txtDatosPersonales.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDatosPersonales.setEditable(false);
		txtDatosPersonales.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Personales", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		txtDatosPersonales.setBounds(33, 170, 333, 126);
		add(txtDatosPersonales);
		btnCambiarContrasena.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		btnCambiarContrasena.setName("btnCambiarContrasena");
		btnCambiarContrasena.setBounds(378, 267, 153, 28);
		add(btnCambiarContrasena);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 319, 448, 187);
		add(scrollPane);
		scrollPane.setViewportView(txtReservasPasadas);
		
		
		txtReservasPasadas.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtReservasPasadas.setEditable(false);
		txtReservasPasadas.setBorder(new TitledBorder(null, "Reservas Realizadas", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(178, 34, 34)));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(482, 319, 516, 187);
		add(scrollPane_1);
		scrollPane_1.setViewportView(txtreservasFuturas);
		
		
		txtreservasFuturas.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtreservasFuturas.setEditable(false);
		txtreservasFuturas.setBorder(new TitledBorder(null, "Bonos Disponibles", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 0)));
		ImageIcon imagen=new ImageIcon(PanelLogin.class.getResource("/imagenes/pattern.jpg"));
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(-20, -20, 1200, 800);
		add(etiqueta);
		
		setVisible(false);
	}
}
	