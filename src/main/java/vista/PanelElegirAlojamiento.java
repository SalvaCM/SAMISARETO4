package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelElegirAlojamiento extends JPanel {

	/**
	 * Create the panel.
	 */
	public JButton hotel;
	public JButton apart;
	public JButton casa;
	public PanelElegirAlojamiento() {
		
		 hotel = new JButton("HOTEL");
		 hotel.setName("hotel");
		hotel.setBounds(395, 114, 138, 84);
		
		setLayout(null);
		add(hotel);
		
		 apart = new JButton("APARTAMENTO");
		 apart.setName("apart");
		
		apart.setBounds(395, 243, 138, 90);
		add(apart);
		
		 casa = new JButton("CASA");
		 casa.setName("casa");
		casa.setBounds(395, 372, 138, 76);
		add(casa);

	}
}
