package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JList;

public class PanelResumen extends JPanel {

private static final long serialVersionUID = 3L;
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public DefaultListModel<String> mostrarResumen = new DefaultListModel<String>();	
	public JList<String> resumen = new JList<String>();
		

	/**
	 * Create the panel. 
	 */
	public PanelResumen() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(SystemColor.controlHighlight);
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("RESUMEN");
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(Color.BLUE);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		add(lblNewJgoodiesLabel);
		
		btnCancelar.setName("btnCancelarResumen");
		btnCancelar.setBackground(new Color(248, 248, 255));
		btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(48, 551, 195, 70);
		add(btnCancelar);
		
		btnSiguiente.setName("btnSiguienteResumen");
		btnSiguiente.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnSiguiente.setBackground(new Color(248, 248, 255));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(837, 551, 195, 70);
		add(btnSiguiente);
		
		mostrarResumen=new DefaultListModel<String>();
		resumen = new JList<String>(mostrarResumen);
		resumen.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		resumen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		resumen.setBackground(new Color(255, 255, 255));
		resumen.setBounds(195, 134, 696, 385);
		add(resumen);
		
		
	
	}
}
