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
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	/**
	 * Create the panel.
	 */
	public PanelElegirAlojamiento() {
		

		setMaximumSize(new Dimension(800, 600));
		setLayout(null);
		
		 hotel = new JButton("HOTEL");
		 hotel.setFont(new Font("Dialog", Font.BOLD, 13));
		 hotel.setName("hotel");
		hotel.setBounds(147, 343, 224, 70);
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\SaraReto4\\SAMISARETO4\\src\\main\\java\\imagenes\\9.png"));
		lblNewLabel.setBounds(188, 186, 128, 165);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\SaraReto4\\SAMISARETO4\\src\\main\\java\\imagenes\\ap.png"));
		lblNewLabel_1.setBounds(412, 150, 249, 195);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\SaraReto4\\SAMISARETO4\\src\\main\\java\\imagenes\\c.png"));
		lblNewLabel_2.setBounds(768, 198, 128, 134);
		add(lblNewLabel_2);
		add(hotel);
		
		 apart = new JButton("APARTAMENTO");
		 apart.setFont(new Font("Dialog", Font.BOLD, 13));
		 apart.setName("apart");
		
		apart.setBounds(436, 344, 224, 70);
		add(apart);
		
		 casa = new JButton("CASA");
		 casa.setFont(new Font("Dialog", Font.BOLD, 13));
		 casa.setName("casa");
		casa.setBounds(728, 343, 218, 70);
		add(casa);
		
		btnPerfil = new JButton("Perfil");
		btnPerfil.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnPerfil.setEnabled(false);
		btnPerfil.setName("btnPerfil");
		btnPerfil.setBounds(10, 42, 89, 23);
		add(btnPerfil);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnLogin.setName("btnLogin");
		btnLogin.setBounds(10, 18, 89, 23);
		add(btnLogin);
		
		ImageIcon imagen=new ImageIcon(PanelLogin.class.getResource("/imagenes/pattern.jpg"));
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);

	}
}
