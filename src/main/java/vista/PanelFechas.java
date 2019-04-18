package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JDateChooser;

public class PanelFechas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JDateChooser fechaIda = new JDateChooser();
	public JDateChooser fechaVuelta = new JDateChooser();
	public JLabel etiqueta;

	/**
	 * Create the panel.
	 */
	public PanelFechas() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("SELECCIONE LAS FECHAS");
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Aharoni", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 35, 1060, 48);
		add(lblNewJgoodiesLabel);
		
		btnCancelar.setFont(new Font("Aharoni", Font.PLAIN, 16));
		btnCancelar.setName("btnCancelarFechas");
		btnCancelar.setBounds(60, 556, 151, 48);
		add(btnCancelar);
		
		btnSiguiente.setFont(new Font("Aharoni", Font.PLAIN, 16));	
		btnSiguiente.setName("btnSiguienteFechas");
		btnSiguiente.setBounds(874, 556, 156, 48);
		add(btnSiguiente);
		
		JLabel lblFechaDeIda = DefaultComponentFactory.getInstance().createLabel("Fecha de Ida:");
		lblFechaDeIda.setForeground(Color.BLACK);
		lblFechaDeIda.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblFechaDeIda.setBounds(153, 249, 252, 49);
		add(lblFechaDeIda);
		
		JLabel lblNewJgoodiesLabel1 = DefaultComponentFactory.getInstance().createLabel("Fecha de Vuelta:");
		lblNewJgoodiesLabel1.setForeground(Color.BLACK);
		lblNewJgoodiesLabel1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewJgoodiesLabel1.setBounds(684, 249, 266, 49);
		add(lblNewJgoodiesLabel1);
		

		fechaIda.setBounds(153, 309, 212, 48);
		add(fechaIda);
		

		fechaVuelta.setBounds(684, 309, 205, 48);
		add(fechaVuelta);
		
		
		ImageIcon imagen=new ImageIcon(PanelEstanciasHotel.class.getResource("/imagenes/fondo.jpg"));
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);

	}
}
