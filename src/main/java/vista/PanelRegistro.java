package vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelRegistro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;

	/**
	 * Create the panel.
	 */
	public PanelRegistro() {

		setMaximumSize(new Dimension(800, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
	}

}
