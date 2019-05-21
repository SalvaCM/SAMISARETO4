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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

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
	private JLabel label;
		

	/**
	 * Create the panel. 
	 */
	public PanelResumen() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		btnCancelar.setName("btnCancelarResumen");
		btnCancelar.setBounds(106, 517, 151, 48);
		add(btnCancelar);
		btnSiguiente.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		btnSiguiente.setName("btnSiguienteResumen");
		btnSiguiente.setBounds(859, 517, 156, 48);
		add(btnSiguiente);
		
		mostrarResumen=new DefaultListModel<String>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(202, 125, 336, 177);
		add(scrollPane);
		resumenHotel = new JList<String>(mostrarResumen);
		resumenHotel.setFont(new Font("Dialog", Font.BOLD, 12));
		resumenHotel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion del Hotel", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		scrollPane.setViewportView(resumenHotel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(537, 125, 360, 360);
		add(scrollPane_1);
		
		resumenReserva = new JTextArea();
		scrollPane_1.setViewportView(resumenReserva);
		resumenReserva.setBorder(new TitledBorder(null, "Habitacion Reservada", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		resumenReserva.setFont(new Font("Dialog", Font.BOLD, 14));
		resumenReserva.setEditable(false);
		
		
		ImageIcon imagen=new ImageIcon(PanelEstanciasHotel.class.getResource("/imagenes/pattern.jpg"));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(202, 299, 336, 186);
		add(scrollPane_2);
		
		txtDetalles = new JTextArea();
		scrollPane_2.setViewportView(txtDetalles);
		txtDetalles.setFont(new Font("Dialog", Font.BOLD, 12));
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
		
		JLabel lblResumenDeLa = new JLabel("Resumen de la compra :\r\n");
		lblResumenDeLa.setOpaque(true);
		lblResumenDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblResumenDeLa.setFont(new Font("Dialog", Font.BOLD, 40));
		lblResumenDeLa.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblResumenDeLa.setBackground(Color.LIGHT_GRAY);
		lblResumenDeLa.setBounds(190, 17, 713, 82);
		add(lblResumenDeLa);
		
		label = new JLabel("");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		label.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(190, 111, 713, 394);
		add(label);
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);
		
		
		
	
	}
}
