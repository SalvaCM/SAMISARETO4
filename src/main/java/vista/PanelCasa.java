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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;

public class PanelCasa extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 13L;
	
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
	public JCheckBox chckbxNewCheckBoxPisc;
	public JCheckBox chckbxNewCheckBoxGim;
	public JCheckBox chckbxNewCheckBoxPark;
	public JCheckBox chckbxNewCheckBoxSpa;
	public JCheckBox chckbxNewCheckBoxWi;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	/**
	 * Create the panel.
	 */
	public PanelCasa() {

		
		setMaximumSize(new Dimension(800, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		Date hoy = new Date();
		fechaSalida=new JDateChooser();
		fechaSalida.setName("vuelta");
		fechaSalida.setOpaque(false);
		fechaSalida.setDateFormatString("yyyy-MM-dd");
		
		fechaSalida.setBounds(719, 155, 161, 26);
		fechaSalida.setMinSelectableDate(hoy);
		fechaSalida.setEnabled(false);
		add(fechaSalida);
		
		
		fechaEntrada =new JDateChooser();
		fechaEntrada.setName("ida");
		fechaEntrada.setOpaque(false);
		fechaEntrada.setDateFormatString("yyyy-MM-dd");
		fechaEntrada.setBounds(546, 155, 161, 26);
		fechaEntrada.setMinSelectableDate(hoy);
		
		add(fechaEntrada);
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCancelar.setBounds(60, 556, 151, 48);
		
		btnCancelar.setName("btnCancelarCasa");

		add(btnCancelar);
		btnSiguiente.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSiguiente.setBounds(874, 556, 156, 48);
		
		btnSiguiente.setName("btnSiguienteCasa");
	
		add(btnSiguiente);
		
		modelo=new DefaultListModel<String>();
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnBuscar.setBounds(411, 155, 98, 26);
		btnBuscar.setName("btnBuscarCasas");
		add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 205, 701, 278);
		scrollPane.setBackground(new Color(230, 230, 250));
		add(scrollPane);
		
		String col[] = {"cod","Nombre","Ubicacion","Tamano","Precio"};
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
		tablaResultados.setBackground(Color.WHITE);
		scrollPane.setViewportView(tablaResultados);
		tablaResultados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		comboBox.setBounds(201, 155, 209, 26);
		
		// anadir funcion para buscar provincias en la base de datos
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"MADRID", "BILBAO", "VALENCIA", "BARCELONA", "SALAMANCA", "SEVILLA","BURGOS"}));

		add(comboBox);
		   
		ImageIcon imagen=new ImageIcon(PanelHotel.class.getResource("/imagenes/pattern.jpg"));
		
		 chckbxNewCheckBoxPisc = new JCheckBox("Piscina");
		 chckbxNewCheckBoxPisc.setFont(new Font("Dialog", Font.BOLD, 11));
		chckbxNewCheckBoxPisc.setBounds(60, 395, 97, 23);
		add(chckbxNewCheckBoxPisc);
		btnPerfil.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnPerfil.setEnabled(false);
		btnPerfil.setName("btnPerfil");
		btnPerfil.setBounds(10, 38, 89, 23);
		
		add(btnPerfil);
		
		 chckbxNewCheckBoxGim = new JCheckBox("Gimnasio");
		 chckbxNewCheckBoxGim.setFont(new Font("Dialog", Font.BOLD, 11));
		chckbxNewCheckBoxGim.setBounds(60, 290, 97, 23);
		add(chckbxNewCheckBoxGim);
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnLogin.setName("btnLogin");
		btnLogin.setBounds(10, 14, 89, 23);
		
		add(btnLogin);
		
		 chckbxNewCheckBoxPark = new JCheckBox("Parking");
		 chckbxNewCheckBoxPark.setFont(new Font("Dialog", Font.BOLD, 11));
		chckbxNewCheckBoxPark.setBounds(60, 441, 97, 23);
		add(chckbxNewCheckBoxPark);
		
		 chckbxNewCheckBoxSpa = new JCheckBox("Spa");
		 chckbxNewCheckBoxSpa.setFont(new Font("Dialog", Font.BOLD, 11));
		chckbxNewCheckBoxSpa.setBounds(60, 343, 97, 23);
		add(chckbxNewCheckBoxSpa);
		
		 chckbxNewCheckBoxWi = new JCheckBox("Wifi");
		 chckbxNewCheckBoxWi.setFont(new Font("Dialog", Font.BOLD, 11));
		chckbxNewCheckBoxWi.setBounds(60, 236, 97, 23);
		add(chckbxNewCheckBoxWi);
		
		JLabel lblEncuentreSuCasa = new JLabel("Encuentre su Casa deseada :");
		lblEncuentreSuCasa.setOpaque(true);
		lblEncuentreSuCasa.setFont(new Font("SansSerif", Font.PLAIN, 40));
		lblEncuentreSuCasa.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblEncuentreSuCasa.setBackground(Color.LIGHT_GRAY);
		lblEncuentreSuCasa.setBounds(190, 19, 701, 78);
		add(lblEncuentreSuCasa);
		
		label = new JLabel("");
		label.setOpaque(true);
		label.setBorder(new TitledBorder(null, "Servicios ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(52, 205, 126, 278);
		add(label);
		
		label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBorder(new TitledBorder(null, "Ubicacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(190, 138, 336, 65);
		add(label_1);
		
		label_2 = new JLabel("");
		label_2.setOpaque(true);
		label_2.setBorder(new TitledBorder(null, "Fechas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		label_2.setBackground(Color.LIGHT_GRAY);
		label_2.setBounds(526, 138, 365, 65);
		add(label_2);
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(-20, -20, 1200, 800);
		add(etiqueta);
	}
}
