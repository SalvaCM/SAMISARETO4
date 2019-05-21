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
	private JLabel label_1;
		

	/**
	 * Create the panel. 
	 */
	public PanelResumenCasayApart() {

		setBackground(new Color(245, 245, 245));
		setLayout(null);
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		btnCancelar.setName("btnCancelarResumen2");
		btnCancelar.setBounds(106, 517, 151, 48);
		add(btnCancelar);
		btnSiguiente.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		btnSiguiente.setName("btnSiguienteResumen2");
		btnSiguiente.setBounds(828, 517, 156, 48);
		add(btnSiguiente);
		
		mostrarResumen=new DefaultListModel<String>();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(554, 127, 329, 316);
		add(scrollPane_1);
		
		resumenReserva = new JTextArea();
		scrollPane_1.setViewportView(resumenReserva);
		resumenReserva.setBorder(new TitledBorder(null, "Informacion alojamiento", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		resumenReserva.setFont(new Font("SansSerif", Font.PLAIN, 14));
		resumenReserva.setEditable(false);
		
		
		ImageIcon imagen=new ImageIcon(PanelEstanciasHotel.class.getResource("/imagenes/pattern.jpg"));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(235, 127, 309, 195);
		add(scrollPane_2);
		
		txtDetalles = new JTextArea();
		scrollPane_2.setViewportView(txtDetalles);
		txtDetalles.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDetalles.setEditable(false);
		txtDetalles.setBorder(new TitledBorder(null, "Detalles Reserva", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		
		btnPerfil = new JButton("Perfil");
		btnPerfil.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnPerfil.setEnabled(false);
		btnPerfil.setName("btnPerfil");
		btnPerfil.setBounds(10, 35, 89, 23);
		add(btnPerfil);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnLogin.setName("btnLogin");
		btnLogin.setBounds(10, 11, 89, 23);
		add(btnLogin);
		
		JLabel label = new JLabel("Resumen de la compra :\r\n");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		label.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(203, 16, 713, 82);
		add(label);
		
		label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Dialog", Font.BOLD, 40));
		label_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(203, 110, 713, 367);
		add(label_1);
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);
		
		
		
	
	}
}
