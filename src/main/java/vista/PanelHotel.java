
package vista;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.Hashtable;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JCheckBox;

public class PanelHotel extends JPanel {


	private static final long serialVersionUID = 2L;
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JList<String> list_hoteles=new JList<String>(); 
	public DefaultListModel<String> modelo = new DefaultListModel<String>();
	public JButton btnBuscar = new JButton("Buscar");
	public JTable tablaResultados;
	public DefaultTableModel tableModel;
	public JLabel etiqueta ;
	public JComboBox<String> comboBox = new JComboBox<String>();
	public JDateChooser fechaEntrada;
	public JDateChooser fechaSalida;
	public JButton btnPerfil = new JButton("Perfil");
	public JSlider nCamas;
	public JSlider nEstrellas;
	public JButton btnLogin = new JButton("Login");
	public CheckboxGroup group;

	
	/**
	 * Create the panel.
	 */
	public PanelHotel() {
		setMaximumSize(new Dimension(800, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		Date hoy = new Date();
		group=new CheckboxGroup();
		JCheckBox chckbxPiscina = new JCheckBox("piscina",false);
		chckbxPiscina.setBounds(757, 207, 97, 23);
		add(chckbxPiscina);
		
		JCheckBox chckbxWifi = new JCheckBox("parking");
		chckbxWifi.setBounds(627, 207, 97, 23);
		add(chckbxWifi);
		fechaSalida=new JDateChooser();
		fechaSalida.setName("vuelta");
		fechaSalida.setOpaque(false);
		fechaSalida.setDateFormatString("yyyy-MM-dd");
		
		fechaSalida.setBounds(731, 157, 161, 26);
		fechaSalida.setMinSelectableDate(hoy);
		fechaSalida.setEnabled(false);
		add(fechaSalida);
		
		
		fechaEntrada =new JDateChooser();
		fechaEntrada.setName("ida");
		fechaEntrada.setOpaque(false);
		fechaEntrada.setDateFormatString("yyyy-MM-dd");
		fechaEntrada.setBounds(731, 131, 161, 26);
		fechaEntrada.setMinSelectableDate(hoy);
		
		add(fechaEntrada);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("SELECCIONE EL HOTEL");
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewJgoodiesLabel);
		Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
		position.put(0, new JLabel("0"));
		position.put(1, new JLabel("1"));
		position.put(2, new JLabel("2"));
		position.put(3, new JLabel("3"));
		position.put(4, new JLabel("4"));
		position.put(5, new JLabel("5"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Camas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(193, 169, 181, 68);
		add(panel_1);
		panel_1.setLayout(null);
		
		nCamas = new JSlider();
		nCamas.setBounds(6, 16, 169, 45);
		panel_1.add(nCamas);
		nCamas.setForeground(Color.WHITE);
		nCamas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nCamas.setValue(0);
		nCamas.setMaximum(5);
		nCamas.setMinorTickSpacing(1);
		nCamas.setPaintTicks(true);
		nCamas.setPaintLabels(true); 
		nCamas.setPaintLabels(true); 
		// Set the label to be drawn
		nCamas.setLabelTable(position); 
		Hashtable<Integer, JLabel> position2 = new Hashtable<Integer, JLabel>();
		position2.put(0, new JLabel("0"));
		position2.put(1, new JLabel("1"));
		position2.put(2, new JLabel("2"));
		position2.put(3, new JLabel("3"));
		position2.put(4, new JLabel("4"));
		position2.put(5, new JLabel("5"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estrellas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(388, 169, 181, 68);
		add(panel);
		panel.setLayout(null);
		nEstrellas = new JSlider();
		nEstrellas.setBounds(6, 16, 169, 45);
		panel.add(nEstrellas);
		
		nEstrellas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nEstrellas.setValue(0);
		nEstrellas.setMaximum(5);
		nEstrellas.setMinorTickSpacing(1);
		nEstrellas.setPaintTicks(true);
		nEstrellas.setPaintLabels(true); 
		nEstrellas.setPaintLabels(true); 
		
		// Set the label to be drawn
		nEstrellas.setLabelTable(position2); 
		
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCancelar.setBounds(60, 556, 151, 48);
		
		btnCancelar.setName("btnCancelarHotel");

		add(btnCancelar);
		btnSiguiente.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSiguiente.setBounds(874, 556, 156, 48);
		
		btnSiguiente.setName("btnSiguienteHotel");
	
		add(btnSiguiente);
		
		modelo=new DefaultListModel<String>();
		btnBuscar.setBounds(422, 131, 98, 26);
		btnBuscar.setName("btnBuscarHoteles");
		add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(193, 248, 701, 242);
		scrollPane.setBackground(new Color(230, 230, 250));
		add(scrollPane);
		
		String col[] = {"cod","Nombre","Ubicacion","Estrellas"};
		tableModel = new DefaultTableModel(col, 0);
		tablaResultados = new JTable(tableModel);
		tablaResultados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaResultados.getColumnModel().getColumn(0).setMaxWidth(0);
		tablaResultados.getColumnModel().getColumn(0).setMinWidth(0);
		tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(0);
		tablaResultados.getColumnModel().getColumn(0).setResizable(false);
		tablaResultados.setRowHeight(25);
		tablaResultados.setShowHorizontalLines(true);
		tablaResultados.setDefaultEditor(Object.class, null);
		tablaResultados.setBackground(new Color(230, 230, 250));
		scrollPane.setViewportView(tablaResultados);
		tablaResultados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		comboBox.setBounds(193, 131, 209, 26);
		
		// anadir funcion para buscar provincias en la base de datos
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"MADRID", "ASTURIAS", "VALENCIA", "BARCELONA", "SALAMANCA"}));

		add(comboBox);
		   
		ImageIcon imagen=new ImageIcon(PanelHotel.class.getResource("/imagenes/pattern.jpg"));
		btnPerfil.setEnabled(false);
		
		btnPerfil.setName("btnPerfil");
		btnPerfil.setBounds(10, 41, 89, 23);
		add(btnPerfil);
		
		
		btnLogin.setName("btnLogin");
		btnLogin.setBounds(10, 17, 89, 23);
		add(btnLogin);
		
		JLabel lblFechas = new JLabel("Fechas :\r\n\r\n");
		lblFechas.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFechas.setBounds(615, 131, 104, 38);
		add(lblFechas);
		
		JLabel lblUbicacion = new JLabel("Ubicacion :");
		lblUbicacion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUbicacion.setBounds(79, 125, 104, 38);
		add(lblUbicacion);
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(-20, -20, 1200, 800);
		add(etiqueta);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(903, 207, 89, 23);
		add(btnNewButton);
		

		
	}
}

