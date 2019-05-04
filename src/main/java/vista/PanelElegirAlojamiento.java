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
		hotel.setBounds(247, 118, 138, 396);
		
		setLayout(null);
		add(hotel);
		
		 apart = new JButton("APARTAMENTO");
		 apart.setName("apart");
		
		apart.setBounds(395, 118, 138, 396);
		add(apart);
		
		 casa = new JButton("CASA");
		 casa.setName("casa");
		casa.setBounds(543, 118, 138, 396);
		add(casa);

	}
}
