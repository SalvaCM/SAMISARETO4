package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.util.Locale;

public class PanelResumen extends JPanel {

private static final long serialVersionUID = 3L;
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public DefaultListModel<String> mostrarResumen = new DefaultListModel<String>();	
	public JList<String> resumen = new JList<String>();
	private JList<String> resumenHotel;
	public JLabel etiqueta ;
	public JTextArea resumenReserva;
	public JTextArea txtDetalles;
	public JButton btnPerfil;
	public JButton btnLogin;
		

	/**
	 * Create the panel. 
	 */
	public PanelResumen() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		btnCancelar.setName("btnCancelarResumen");
		btnCancelar.setBounds(60, 556, 151, 48);
		add(btnCancelar);
		btnSiguiente.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		btnSiguiente.setName("btnSiguienteResumen");
		btnSiguiente.setBounds(874, 556, 156, 48);
		add(btnSiguiente);
		
		mostrarResumen=new DefaultListModel<String>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(209, 87, 269, 174);
		add(scrollPane);
		resumenHotel = new JList<String>(mostrarResumen);
		resumenHotel.setBorder(new TitledBorder(null, "Informacion del Hotel", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		scrollPane.setViewportView(resumenHotel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(665, 95, 239, 386);
		add(scrollPane_1);
		
		resumenReserva = new JTextArea();
		resumenReserva.setLocale(new Locale("es", "ES"));
		scrollPane_1.setViewportView(resumenReserva);
		resumenReserva.setBorder(new TitledBorder(null, "Habitacion Reservada", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		resumenReserva.setFont(new Font("SansSerif", Font.PLAIN, 14));
		resumenReserva.setEditable(false);
		
		
		ImageIcon imagen=new ImageIcon(PanelEstanciasHotel.class.getResource("/imagenes/pattern.jpg"));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(209, 280, 269, 190);
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
		btnPerfil.setBounds(10, 41, 89, 23);
		add(btnPerfil);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnLogin.setName("btnLogin");
		btnLogin.setBounds(10, 17, 89, 23);
		add(btnLogin);
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);
		
		
		
	
	}
}
