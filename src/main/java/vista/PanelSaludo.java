package vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

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

	/**
	 * Create the panel.
	 */
	public PanelSaludo() {
		setMaximumSize(new Dimension(800, 600));
		
		setForeground(Color.WHITE);
		setBorder(new LineBorder(Color.BLACK, 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("BIENVENIDO");
		lblNewJgoodiesLabel.setBackground(new Color(245, 245, 245));
		lblNewJgoodiesLabel.setForeground(new Color(0, 0, 0));
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 11, 1065, 628);
		add(lblNewJgoodiesLabel); 

		
		JLabel lblNewJgoodiesLabel2 = DefaultComponentFactory.getInstance().createLabel("(PULSE PARA CONTINUAR)");
		lblNewJgoodiesLabel2.setBackground(Color.WHITE);
		lblNewJgoodiesLabel2.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewJgoodiesLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel2.setBounds(10, 438, 1080, 78);
		add(lblNewJgoodiesLabel2);
		
		btnSaludo.setName("btnSaludo");	
		btnSaludo.setBounds(-14, -11, 1150, 732);
		btnSaludo.setContentAreaFilled(false);
		add(btnSaludo);

	}

}
