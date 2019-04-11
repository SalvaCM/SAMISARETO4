package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class PanelLogin extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	
	public JButton btnCancelar;
	public JButton btnRegistrarse;
	public JButton btnLogin;
	public JTextField TextDni; 
	public JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		
		setMaximumSize(new Dimension(1080, 650));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("LOGIN");
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(new Color(0, 0, 0));
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewJgoodiesLabel);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCancelar.setName("btnCancelarLogin");
		btnCancelar.setBounds(60, 556, 151, 48);
		add(btnCancelar);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setName("btnRegistrarseLogin");
		btnRegistrarse.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnRegistrarse.setBounds(874, 556, 156, 48);
		add(btnRegistrarse);
	
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("DNI:");
		lblNewJgoodiesLabel_3.setBounds(322, 175, 440, 33);
		add(lblNewJgoodiesLabel_3);
		lblNewJgoodiesLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewJgoodiesLabel2 = DefaultComponentFactory.getInstance().createLabel("CONTRASEÑA:");
		lblNewJgoodiesLabel2.setBounds(322, 281, 440, 33);
		add(lblNewJgoodiesLabel2);
		lblNewJgoodiesLabel2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		
		TextDni = new JTextField();
		TextDni.setBounds(386, 212, 311, 33);
		add(TextDni);
		TextDni.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(386, 325, 311, 33);
		add(passwordField);
		
		btnLogin = new JButton ("Login");
		btnLogin.setName("btnLogin");
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnLogin.setBounds(432, 406, 221, 57);
		add(btnLogin);

		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewJgoodiesLabel_1.setForeground(Color.CYAN);
		lblNewJgoodiesLabel_1.setBackground(Color.CYAN); 
		lblNewJgoodiesLabel_1.setBounds(322, 142, 440, 360);
		add(lblNewJgoodiesLabel_1);
		

	}
}
