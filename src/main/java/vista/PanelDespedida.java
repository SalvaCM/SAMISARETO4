package vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class PanelDespedida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private JLabel etiqueta;

	/**
	 * Create the panel.
	 */
	public PanelDespedida() {
		
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245)); 
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("\u00A1Buen Viaje!");
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(Color.RED);
		lblNewJgoodiesLabel.setFont(new Font("Dialog", Font.BOLD, 70));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(121, 379, 632, 144);
		add(lblNewJgoodiesLabel); 
		
		ImageIcon imagen=new ImageIcon(PanelHotel.class.getResource("/imagenes/BuenViaje.jpg"));
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(-20, -20, 1200, 800);
		add(etiqueta);

	}

}
