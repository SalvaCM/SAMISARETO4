package vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelElegirAlojamiento extends JPanel {


	private static final long serialVersionUID = 20L;
	
	public JButton hotel;
	public JButton apart;
	public JButton casa;
	public JButton btnPerfil;
	public JButton btnLogin;
	public JLabel etiqueta ;
	private JLabel label;
	/**
	 * Create the panel.
	 */
	public PanelElegirAlojamiento() {
		

		setMaximumSize(new Dimension(800, 600));
		setLayout(null);
		
		 hotel = new JButton("");
		 hotel.setIcon(new ImageIcon(PanelElegirAlojamiento.class.getResource("/imagenes/hotel (1).png")));
		 hotel.setFont(new Font("Dialog", Font.BOLD, 13));
		 hotel.setName("hotel");
		 hotel.setBounds(142, 228, 224, 227);
		
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("ELIJA EL TIPO DE ALOJAMIENTO :");
		lblNewJgoodiesLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_3.setOpaque(true);
		lblNewJgoodiesLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewJgoodiesLabel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewJgoodiesLabel_3.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewJgoodiesLabel_3.setBounds(128, 87, 851, 78);
		add(lblNewJgoodiesLabel_3);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("APARTAMENTO");
		lblNewJgoodiesLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewJgoodiesLabel_2.setBounds(441, 416, 222, 21);
		add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("CASA");
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewJgoodiesLabel_1.setBounds(742, 415, 224, 23);
		add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("HOTEL");
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewJgoodiesLabel.setBounds(142, 415, 224, 23);
		add(lblNewJgoodiesLabel);
		add(hotel);
		
		 apart = new JButton("");
		 apart.setIcon(new ImageIcon(PanelElegirAlojamiento.class.getResource("/imagenes/apartamento (1).png")));
		 apart.setFont(new Font("Dialog", Font.BOLD, 13));
		 apart.setName("apart");
		
		apart.setBounds(439, 228, 224, 227);
		add(apart);
		
		 casa = new JButton("");
		 casa.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	}
		 });
		 casa.setIcon(new ImageIcon(PanelElegirAlojamiento.class.getResource("/imagenes/c.png")));
		 casa.setFont(new Font("Dialog", Font.BOLD, 13));
		 casa.setName("casa");
		casa.setBounds(742, 228, 224, 227);
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
		
		label = new JLabel("");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		label.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(128, 208, 851, 311);
		add(label);
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);

	}
}
