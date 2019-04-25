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
	
	private static final long serialVersionUID = 11L;
	
	public JPanel pane;
	public DefaultListModel<String> modelo2;
	public JList<String> listaReservasPasados;
	public JList<String> listaReservasFuturos;
	public JButton btnCambiarPw;
	public JLabel lblCodVuelta;
	public JButton btnVolver;
	public JPasswordField passwordNueva;
	public JPasswordField passwordNuevacheck;
	public JLabel lblCuentaDeUsuario;
	public JLabel lblNewPassword ;
	public JLabel lblNewPasswordCheck;
	public JLabel lblSeguridad;
	public JLabel lblErrContra;


	/**
	 * Método: PaneCambioFinal
	 * @param frame1
	 */
	public PanelUsuario()
	{
		
		
		pane = new JPanel();
		pane.setForeground(Color.BLACK);
		pane.setBackground(new Color(230, 230, 250));
		pane.setBounds(0, 0, 800, 600);
		pane.setLayout(null);

		
		modelo2=new DefaultListModel<String>();
		listaReservasPasados = new JList<String>(modelo2);
		listaReservasPasados.setValueIsAdjusting(true);
		listaReservasPasados.setForeground(new Color(0, 51, 102));
		listaReservasPasados.setBackground(Color.WHITE);
		listaReservasPasados.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(212, 208, 200), null, null, null), "Reservas Pasadas", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		listaReservasPasados.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		listaReservasPasados.setBounds(47, 308, 349, 181);
		pane.add(listaReservasPasados);
		
		lblCodVuelta = new JLabel("");
		lblCodVuelta.setForeground(Color.GRAY);
		lblCodVuelta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodVuelta.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblCodVuelta.setBounds(574, 354, 108, 29);
		pane.add(lblCodVuelta);
		
		btnVolver = new JButton("Volver a Compra");
		
		btnVolver.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setForeground(Color.BLACK);
		
		btnVolver.setBounds(637, 523, 153, 46);
		pane.add(btnVolver);
		
		lblCuentaDeUsuario = new JLabel("Cuenta de Usuario :");
		lblCuentaDeUsuario.setForeground(Color.BLACK);
		lblCuentaDeUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblCuentaDeUsuario.setBounds(47, 66, 270, 46);
		pane.add(lblCuentaDeUsuario);
		
		listaReservasFuturos = new JList<String>(modelo2);
		listaReservasFuturos.setForeground(new Color(0, 51, 102));
		listaReservasFuturos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		listaReservasFuturos.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(212, 208, 200), null, null, null), "Reservas Futuras", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		listaReservasFuturos.setBackground(Color.WHITE);
		listaReservasFuturos.setBounds(398, 308, 356, 181);
		pane.add(listaReservasFuturos);
		
		passwordNueva = new JPasswordField();
		passwordNueva.setBackground(Color.WHITE);
		passwordNueva.setBounds(555, 157, 189, 29);
		passwordNueva.setVisible(false);
		pane.add(passwordNueva);
		
		lblNewPassword = new JLabel("Contrase\u00F1a :");
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setForeground(Color.BLACK);
		lblNewPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewPassword.setBounds(408, 150, 135, 39);
		lblNewPassword.setVisible(false);
		pane.add(lblNewPassword);
		
		passwordNuevacheck = new JPasswordField();
		passwordNuevacheck.setBackground(Color.WHITE);
		passwordNuevacheck.setBounds(555, 197, 189, 29);
		passwordNuevacheck.setVisible(false);
		pane.add(passwordNuevacheck);
		
		lblNewPasswordCheck = new JLabel("Nueva Contrase\u00F1a :");
		lblNewPasswordCheck.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPasswordCheck.setForeground(Color.BLACK);
		lblNewPasswordCheck.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewPasswordCheck.setBounds(378, 190, 165, 39);
		lblNewPasswordCheck.setVisible(false);
		pane.add(lblNewPasswordCheck);
		
		btnCambiarPw = new JButton("Cambiar");
		btnCambiarPw.setForeground(new Color(0, 51, 102));
		btnCambiarPw.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnCambiarPw.setBounds(627, 250, 117, 29);
		btnCambiarPw.setVisible(false);
		pane.add(btnCambiarPw);
		
		lblSeguridad = new JLabel("");
		lblSeguridad.setBounds(491, 136, 114, 16);
		pane.add(lblSeguridad);
		
		lblErrContra = new JLabel("*Las contrase\u00F1as no cumplen los requisitos");
		lblErrContra.setVisible(false);
		lblErrContra.setForeground(Color.RED);
		lblErrContra.setBounds(491, 230, 250, 16);
		lblErrContra.setVisible(false);
		pane.add(lblErrContra);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Personales", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		textArea.setBounds(47, 109, 319, 187);
		pane.add(textArea);
		
		JButton btnCambiarContrasea = new JButton("Cambiar Contrase\u00F1a");
		btnCambiarContrasea.setBounds(410, 109, 153, 28);
		pane.add(btnCambiarContrasea);
		
		
		
		pane.setVisible(false);
	}

	public void reset() {
		lblCodVuelta.setText("");
		
	}
}
	