package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Dimension;

/**
 * Clase del panel de devolucion de cambios
 *
 */
public class PanelDevolucion extends JPanel {
	
	private static final long serialVersionUID = 5L;
	
	public JButton btnSiguiente = new JButton("Siguiente");
	public DefaultListModel<String> cambios = new DefaultListModel<String>();	
	public JList<String> devolucion = new JList<String>();
		
		

	/**
	 * Create the panel.
	 */
	public PanelDevolucion() {
		setMaximumSize(new Dimension(800, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245)); 
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("CAMBIO");
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(new Color(0, 0, 0));
		lblNewJgoodiesLabel.setFont(new Font("Aharoni", Font.PLAIN, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(-123, 73, 1065, 48);
		add(lblNewJgoodiesLabel); 
		btnSiguiente.setFont(new Font("Aharoni", Font.PLAIN, 16));
		
		
		btnSiguiente.setName("btnSiguienteDevolucion");	
		btnSiguiente.setBounds(328, 435, 158, 48);
		add(btnSiguiente);
		
		cambios=new DefaultListModel<String>();
		devolucion = new JList<String>(cambios);
		devolucion.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		devolucion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		devolucion.setBackground(new Color(255, 255, 255));
		devolucion.setBounds(181, 160, 481, 264);
		add(devolucion);
		

		

	}
}
