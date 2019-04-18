package vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

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

	/**
	 * Create the panel.
	 */
	public PanelSaludo() {
		setMaximumSize(new Dimension(800, 600));
		
		setForeground(Color.WHITE);
		setBorder(new LineBorder(Color.BLACK, 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		
		JLabel lblNewJgoodiesLabel2 = DefaultComponentFactory.getInstance().createLabel("(PULSE PARA CONTINUAR)");
		lblNewJgoodiesLabel2.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel2.setBackground(Color.WHITE);
		lblNewJgoodiesLabel2.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewJgoodiesLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel2.setBounds(63, 321, 1080, 78);
		add(lblNewJgoodiesLabel2);
		
		btnSaludo.setName("btnSaludo");	
		btnSaludo.setBounds(-14, -11, 1150, 732);
		btnSaludo.setContentAreaFilled(false);
		add(btnSaludo);
		
		ImageIcon imagen=new ImageIcon(PanelHotel.class.getResource("/imagenes/welcome.jpg"));
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(-20, -20, 1200, 800);
		add(etiqueta);

	}

}
