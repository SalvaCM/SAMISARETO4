package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
	
	private static final long serialVersionUID = 11L;
	
	public JButton btnSiguiente = new JButton("Siguiente");
	public DefaultListModel<String> cambios = new DefaultListModel<String>();	
	public JList<String> devolucion = new JList<String>();
	public JLabel etiqueta;
	public JButton btnPerfil = new JButton("Perfil");
	public JButton btnLogin = new JButton("Login");
		
		

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
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Aharoni", Font.PLAIN, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 68, 1065, 48);
		add(lblNewJgoodiesLabel); 
		btnSiguiente.setFont(new Font("Aharoni", Font.PLAIN, 16));
		
		
		btnSiguiente.setName("btnSiguienteDevolucion");	
		btnSiguiente.setBounds(461, 546, 158, 48);
		add(btnSiguiente);
		
		cambios=new DefaultListModel<String>();
		devolucion = new JList<String>(cambios);
		devolucion.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		devolucion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		devolucion.setBackground(new Color(255, 255, 255));
		devolucion.setBounds(217, 155, 657, 360);
		add(devolucion);
		
		ImageIcon imagen=new ImageIcon(PanelEstanciasHotel.class.getResource("/imagenes/pattern.jpg"));
		btnPerfil.setEnabled(false);
		btnPerfil.setName("btnPerfil");
		btnPerfil.setBounds(10, 35, 89, 23);
		
		add(btnPerfil);
		btnLogin.setName("btnLogin");
		btnLogin.setBounds(10, 11, 89, 23);
		
		add(btnLogin);
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);
		

		

	}
}
