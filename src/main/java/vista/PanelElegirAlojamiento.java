package vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class PanelElegirAlojamiento extends JPanel {


	private static final long serialVersionUID = 20L;
	
	public JButton hotel;
	public JButton apart;
	public JButton casa;
	public JButton btnPerfil;
	public JButton btnLogin;
	public JLabel etiqueta ;
	/**
	 * Create the panel.
	 */
	public PanelElegirAlojamiento() {
		

		setMaximumSize(new Dimension(800, 600));
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("SELECCIONE EL ALOJAMIENTO");
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewJgoodiesLabel);
		
		 hotel = new JButton("HOTEL");
		 hotel.setName("hotel");
		hotel.setBounds(147, 202, 218, 211);
		
		setLayout(null);
		add(hotel);
		
		 apart = new JButton("APARTAMENTO");
		 apart.setName("apart");
		
		apart.setBounds(436, 200, 218, 214);
		add(apart);
		
		 casa = new JButton("CASA");
		 casa.setName("casa");
		casa.setBounds(728, 200, 218, 213);
		add(casa);
		
		btnPerfil = new JButton("Perfil");
		btnPerfil.setEnabled(false);
		btnPerfil.setName("btnPerfil");
		btnPerfil.setBounds(10, 42, 89, 23);
		add(btnPerfil);
		
		btnLogin = new JButton("Login");
		btnLogin.setName("btnLogin");
		btnLogin.setBounds(10, 18, 89, 23);
		add(btnLogin);
		
		ImageIcon imagen=new ImageIcon(PanelLogin.class.getResource("/imagenes/pattern.jpg"));
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);

	}
}
