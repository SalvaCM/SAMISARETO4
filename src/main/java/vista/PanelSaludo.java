package vista;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;

public class PanelSaludo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton btnSaludo = new JButton("");
	private JLabel etiqueta;
	private JLabel etiqueta2;

	/**
	 * Create the panel.
	 */
	public PanelSaludo() {
		setMaximumSize(new Dimension(800, 600));
		
		setForeground(Color.WHITE);
		setBorder(new LineBorder(Color.BLACK, 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		btnSaludo.setName("btnSaludo");	
		btnSaludo.setBounds(-14, -11, 1150, 916);
		btnSaludo.setContentAreaFilled(false);
		add(btnSaludo);
		
		ImageIcon imagen=new ImageIcon(PanelHotel.class.getResource("/imagenes/LOGO3.png"));
		ImageIcon imagen2=new ImageIcon(PanelHotel.class.getResource("/imagenes/LOADER.gif"));

		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(24, -139, 1000, 800);
		add(etiqueta);
		
		etiqueta2 = new JLabel(imagen2);
		etiqueta2.setBounds(20, -139, 1005, 900);
		add(etiqueta2);
		
		JLabel lblNewLabel = new JLabel("\r\n Bidai-on");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 34));
		lblNewLabel.setBounds(435, 405, 634, 182);
		add(lblNewLabel);

	}
}
