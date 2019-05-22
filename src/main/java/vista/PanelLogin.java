package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class PanelLogin extends JPanel {
	
	/**	Panel Dedicado a la Funcion de Login de Usuario
	 * 
	 */
	private static final long serialVersionUID = 9L;
	
	public JButton btnCancelar;
	public JButton btnRegistrarse;
	public JButton btnLogin;
	public JTextField TextDni; 
	public JPasswordField passwordField;
	public JLabel etiqueta ;
	public JPanel paneldeRetorno;
	

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		
		setMaximumSize(new Dimension(1080, 650));

		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
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
		lblNewJgoodiesLabel_3.setForeground(Color.BLACK);
		lblNewJgoodiesLabel_3.setBounds(322, 175, 440, 33);
		add(lblNewJgoodiesLabel_3);
		lblNewJgoodiesLabel_3.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewJgoodiesLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewJgoodiesLabel2 = DefaultComponentFactory.getInstance().createLabel("PASSWORD:");
		lblNewJgoodiesLabel2.setForeground(Color.BLACK);
		lblNewJgoodiesLabel2.setBounds(322, 281, 440, 33);
		add(lblNewJgoodiesLabel2);
		lblNewJgoodiesLabel2.setFont(new Font("Dialog", Font.BOLD, 25));
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
		lblNewJgoodiesLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewJgoodiesLabel_1.setBackground(Color.LIGHT_GRAY); 
		lblNewJgoodiesLabel_1.setBounds(310, 120, 452, 382);
		add(lblNewJgoodiesLabel_1);
		
		ImageIcon imagen=new ImageIcon(PanelLogin.class.getResource("/imagenes/pattern.jpg"));
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);
		

	}


	public JPanel getPaneldeRetorno() {
		return paneldeRetorno;
	}


	public void setPaneldeRetorno(JPanel paneldeRetorno) {
		this.paneldeRetorno = paneldeRetorno;
	}
}
