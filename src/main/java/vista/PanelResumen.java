package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JList;

public class PanelResumen extends JPanel {

private static final long serialVersionUID = 3L;
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public DefaultListModel<String> mostrarResumen = new DefaultListModel<String>();	
	public JList<String> resumen = new JList<String>();
	public JLabel etiqueta ;
		

	/**
	 * Create the panel. 
	 */
	public PanelResumen() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("RESUMEN");
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Aharoni", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 35, 1060, 48);
		add(lblNewJgoodiesLabel);
		btnCancelar.setFont(new Font("Aharoni", Font.PLAIN, 16));
		
		btnCancelar.setName("btnCancelarResumen");
		btnCancelar.setBounds(60, 556, 151, 48);
		add(btnCancelar);
		btnSiguiente.setFont(new Font("Aharoni", Font.PLAIN, 16));
		
		btnSiguiente.setName("btnSiguienteResumen");
		btnSiguiente.setBounds(874, 556, 156, 48);
		add(btnSiguiente);
		
		mostrarResumen=new DefaultListModel<String>();
		resumen = new JList<String>(mostrarResumen);
		resumen.setBounds(224, 104, 632, 419);
		add(resumen);
		
		ImageIcon imagen=new ImageIcon(PanelEstanciasHotel.class.getResource("/imagenes/fondo.jpg"));
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);
		
		
		
	
	}
}
