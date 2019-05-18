package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class PanelResumenCasayApart extends JPanel {

private static final long serialVersionUID = 3L;
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public DefaultListModel<String> mostrarResumen = new DefaultListModel<String>();	
	public JList<String> resumen = new JList<String>();
	public JLabel etiqueta ;
	public JTextArea resumenReserva;
	public JTextArea txtDetalles;
	public JButton btnPerfil;
	public JButton btnLogin;
		

	/**
	 * Create the panel. 
	 */
	public PanelResumenCasayApart() {

		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("DETALLES DE LA RESERVA");
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Aharoni", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(121, 35, 891, 48);
		add(lblNewJgoodiesLabel);
		btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		btnCancelar.setName("btnCancelarResumen2");
		btnCancelar.setBounds(106, 517, 151, 48);
		add(btnCancelar);
		btnSiguiente.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		btnSiguiente.setName("btnSiguienteResumen2");
		btnSiguiente.setBounds(828, 517, 156, 48);
		add(btnSiguiente);
		
		mostrarResumen=new DefaultListModel<String>();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(574, 109, 309, 334);
		add(scrollPane_1);
		
		resumenReserva = new JTextArea();
		scrollPane_1.setViewportView(resumenReserva);
		resumenReserva.setBorder(new TitledBorder(null, "Informacion alojamiento", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		resumenReserva.setFont(new Font("SansSerif", Font.PLAIN, 14));
		resumenReserva.setEditable(false);
		
		
		ImageIcon imagen=new ImageIcon(PanelEstanciasHotel.class.getResource("/imagenes/pattern.jpg"));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(235, 109, 273, 203);
		add(scrollPane_2);
		
		txtDetalles = new JTextArea();
		scrollPane_2.setViewportView(txtDetalles);
		txtDetalles.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDetalles.setEditable(false);
		txtDetalles.setBorder(new TitledBorder(null, "Detalles Reserva", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		
		btnPerfil = new JButton("Perfil");
		btnPerfil.setEnabled(false);
		btnPerfil.setName("btnPerfil");
		btnPerfil.setBounds(10, 35, 89, 23);
		add(btnPerfil);
		
		btnLogin = new JButton("Login");
		btnLogin.setName("btnLogin");
		btnLogin.setBounds(10, 11, 89, 23);
		add(btnLogin);
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);
		
		
		
	
	}
}
