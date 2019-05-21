package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.util.Locale;

public class PanelApartamento extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 22L;
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public DefaultListModel<String> modelo = new DefaultListModel<String>();
	public JButton btnBuscar = new JButton("Buscar");
	public JTable tablaResultados;
	public DefaultTableModel tableModel;
	public JLabel etiqueta ;
	public JComboBox<String> comboBox = new JComboBox<String>();
	public JDateChooser fechaEntrada;
	public JDateChooser fechaSalida;
	public JButton btnPerfil = new JButton("Perfil");
	public JButton btnLogin = new JButton("Login");
	public JCheckBox BoxPisc;
	public JCheckBox BoxGim;
	public JCheckBox BoxPark;
	public JCheckBox BoxSpa;
	public JCheckBox BoxWi;
	private JLabel lblEncuentreSuApartamento;
	private JLabel label;

	/**
	 * Create the panel.
	 */
	public PanelApartamento() {
		

		setMaximumSize(new Dimension(800, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		Date hoy = new Date();
		fechaSalida=new JDateChooser();
		fechaSalida.setName("vuelta");
		fechaSalida.setOpaque(false);
		fechaSalida.setDateFormatString("yyyy-MM-dd");
		
		fechaSalida.setBounds(749, 155, 161, 26);
		fechaSalida.setMinSelectableDate(hoy);
		fechaSalida.setEnabled(false);
		add(fechaSalida);
		
		
		fechaEntrada =new JDateChooser();
		fechaEntrada.setName("ida");
		fechaEntrada.setOpaque(false);
		fechaEntrada.setDateFormatString("yyyy-MM-dd");
		fechaEntrada.setBounds(576, 155, 161, 26);
		fechaEntrada.setMinSelectableDate(hoy);
		
		add(fechaEntrada);
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCancelar.setBounds(60, 556, 151, 48);
		
		btnCancelar.setName("btnCancelarApartamento");

		add(btnCancelar);
		btnSiguiente.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSiguiente.setBounds(874, 556, 156, 48);
		
		btnSiguiente.setName("btnSiguienteApartamento");
	
		add(btnSiguiente);
		
		modelo=new DefaultListModel<String>();
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnBuscar.setBounds(428, 155, 98, 26);
		btnBuscar.setName("btnBuscarApartamentos");
		add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocale(new Locale("es", "ES"));
		scrollPane.setBounds(209, 202, 701, 301);
		scrollPane.setBackground(new Color(230, 230, 250));
		add(scrollPane);
		
		String col[] = {"cod","Nombre","Ubicacion","Tamaño","Precio","Piso"};
		tableModel = new DefaultTableModel(col, 0);
		tablaResultados = new JTable(tableModel);
		tablaResultados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaResultados.getColumnModel().getColumn(0).setMaxWidth(0);
		tablaResultados.getColumnModel().getColumn(0).setMinWidth(0);
		tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(0);
		tablaResultados.getColumnModel().getColumn(0).setResizable(false);
		
		tablaResultados.getColumnModel().getColumn(2).setMaxWidth(150);
		tablaResultados.getColumnModel().getColumn(2).setMinWidth(150);
		tablaResultados.getColumnModel().getColumn(2).setPreferredWidth(150);
		tablaResultados.getColumnModel().getColumn(2).setResizable(false);
		
		tablaResultados.getColumnModel().getColumn(3).setMaxWidth(150);
		tablaResultados.getColumnModel().getColumn(3).setMinWidth(150);
		tablaResultados.getColumnModel().getColumn(3).setPreferredWidth(150);
		tablaResultados.getColumnModel().getColumn(3).setResizable(false);
		
		tablaResultados.getColumnModel().getColumn(4).setMaxWidth(150);
		tablaResultados.getColumnModel().getColumn(4).setMinWidth(150);
		tablaResultados.getColumnModel().getColumn(4).setPreferredWidth(150);
		tablaResultados.getColumnModel().getColumn(4).setResizable(false);
		tablaResultados.setRowHeight(35);
		tablaResultados.setShowHorizontalLines(true);
		tablaResultados.setDefaultEditor(Object.class, null);
		tablaResultados.setBackground(new Color(230, 230, 250));
		scrollPane.setViewportView(tablaResultados);
		tablaResultados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		comboBox.setBounds(207, 155, 209, 26);
		
		// anadir funcion para buscar provincias en la base de datos
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"MADRID", "BILBAO", "VALENCIA", "BARCELONA", "SALAMANCA", "SEVILLA","BURGOS"}));

		add(comboBox);
		   
		ImageIcon imagen=new ImageIcon(PanelHotel.class.getResource("/imagenes/pattern.jpg"));
		btnPerfil.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnPerfil.setEnabled(false);
		
		btnPerfil.setName("btnPerfil");
		btnPerfil.setBounds(10, 48, 89, 23);
		add(btnPerfil);
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnLogin.setName("btnLogin");
		btnLogin.setBounds(10, 23, 89, 23);
		
		add(btnLogin);
		
		BoxPisc = new JCheckBox("Piscina");
		BoxPisc.setFont(new Font("Dialog", Font.BOLD, 11));
		BoxPisc.setBounds(60, 363, 97, 23);
		add(BoxPisc);
		
		
		BoxGim = new JCheckBox("Gimnasio");
		BoxGim.setFont(new Font("Dialog", Font.BOLD, 11));
		BoxGim.setBounds(60, 262, 97, 23);
		add(BoxGim);
		
		 BoxPark = new JCheckBox("Parking");
		 BoxPark.setFont(new Font("Dialog", Font.BOLD, 11));
		 BoxPark.setBounds(60, 414, 97, 23);
		 add(BoxPark);
		
		 BoxSpa = new JCheckBox("Spa");
		 BoxSpa.setFont(new Font("Dialog", Font.BOLD, 11));
		 BoxSpa.setBounds(60, 308, 97, 23);
		 add(BoxSpa);
		
		 BoxWi = new JCheckBox("Wifi");
		 BoxWi.setFont(new Font("Dialog", Font.BOLD, 11));
		 BoxWi.setBounds(60, 211, 97, 23);
		 add(BoxWi);
		
		lblEncuentreSuApartamento = new JLabel("Encuentre su Apartamento deseado:");
		lblEncuentreSuApartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblEncuentreSuApartamento.setOpaque(true);
		lblEncuentreSuApartamento.setFont(new Font("Dialog", Font.BOLD, 38));
		lblEncuentreSuApartamento.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblEncuentreSuApartamento.setBackground(Color.LIGHT_GRAY);
		lblEncuentreSuApartamento.setBounds(209, 23, 701, 78);
		add(lblEncuentreSuApartamento);
		
		label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBorder(new TitledBorder(null, "Servicios ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		label.setBounds(44, 183, 126, 320);
		add(label);
		
		
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(-20, -20, 1200, 800);
		add(etiqueta);
			

	}

}
