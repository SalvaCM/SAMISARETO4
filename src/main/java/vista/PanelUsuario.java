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
import javax.swing.ListModel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

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
	public JButton btnCambiar;
	public JLabel lblCodVuelta;
	public JButton btnVolver;
	public JPasswordField passwordNueva;
	public JPasswordField passwordNuevacheck;
	public JLabel lblCuentaDeUsuario;
	public JLabel lblNewPassword ;
	public JLabel lblNewPasswordCheck;
	private JLabel lblDatos;
	private JLabel lblDni;
	private JLabel lblNombreYApellidos;
	public JTextField fieldDNI;
	public JTextField fieldNombre;
	public JLabel lblSeguridad;
	public JProgressBar progressBarSeguridad;
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
		passwordNueva.setBounds(425, 191, 189, 29);
		pane.add(passwordNueva);
		
		lblNewPassword = new JLabel("Contrase\u00F1a :");
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setForeground(Color.BLACK);
		lblNewPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewPassword.setBounds(280, 184, 135, 39);
		pane.add(lblNewPassword);
		
		passwordNuevacheck = new JPasswordField();
		passwordNuevacheck.setBackground(Color.WHITE);
		passwordNuevacheck.setBounds(425, 231, 189, 29);
		pane.add(passwordNuevacheck);
		
		lblNewPasswordCheck = new JLabel("Nueva Contrase\u00F1a :");
		lblNewPasswordCheck.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPasswordCheck.setForeground(Color.BLACK);
		lblNewPasswordCheck.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewPasswordCheck.setBounds(249, 224, 165, 39);
		pane.add(lblNewPasswordCheck);
		
		btnCambiar = new JButton("Cambiar Contrase\u00F1a");
		btnCambiar.setForeground(new Color(0, 51, 102));
		btnCambiar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnCambiar.setBackground(Color.WHITE);
		btnCambiar.setBounds(331, 138, 150, 29);
		pane.add(btnCambiar);
		
		lblDatos = new JLabel("Informacion Personal");
		lblDatos.setForeground(Color.BLACK);
		lblDatos.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDatos.setBounds(123, 112, 241, 27);
		pane.add(lblDatos);
		
		lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDni.setForeground(Color.BLACK);
		lblDni.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDni.setBounds(10, 148, 173, 16);
		pane.add(lblDni);
		
		lblNombreYApellidos = new JLabel("Nombre y apellidos:");
		lblNombreYApellidos.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombreYApellidos.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNombreYApellidos.setForeground(Color.BLACK);
		lblNombreYApellidos.setBounds(10, 174, 173, 16);
		pane.add(lblNombreYApellidos);
		
		fieldDNI = new JTextField();
		fieldDNI.setEditable(false);
		fieldDNI.setColumns(10);
		fieldDNI.setBounds(195, 141, 116, 22);
		pane.add(fieldDNI);
		
		fieldNombre = new JTextField();
		fieldNombre.setEditable(false);
		fieldNombre.setColumns(10);
		fieldNombre.setBounds(195, 174, 116, 22);
		pane.add(fieldNombre);
		
		lblSeguridad = new JLabel("");
		lblSeguridad.setBounds(491, 136, 114, 16);
		pane.add(lblSeguridad);
		
		progressBarSeguridad = new JProgressBar();
		progressBarSeguridad.setMaximum(16);
		progressBarSeguridad.setBounds(491, 151, 158, 16);
		pane.add(progressBarSeguridad);
		
		lblErrContra = new JLabel("*Las contrase\u00F1as no cumplen los requisitos");
		lblErrContra.setVisible(false);
		lblErrContra.setForeground(Color.RED);
		lblErrContra.setBounds(333, 163, 294, 16);
		pane.add(lblErrContra);
		
		
		
		pane.setVisible(false);
	}

	public void reset() {
		lblCodVuelta.setText("");
		
	}
}
	