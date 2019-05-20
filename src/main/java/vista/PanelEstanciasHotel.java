package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;


public class PanelEstanciasHotel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JList<String> estancias_hoteles=new JList<String>(); 
	public DefaultListModel<String> modelo = new DefaultListModel<String>();
	public DefaultTableModel tableModel;
	public JTable tablaHabitaciones;
	private final JScrollPane scrollPane = new JScrollPane();
	public JButton btnReservar;
	public JLabel etiqueta ;
	public JButton btnPerfil = new JButton("Perfil");
	public JButton btnLogin = new JButton("Login");
	/**
	 * Create the panel.
	 */
	public PanelEstanciasHotel() {
		setMaximumSize(new Dimension(800, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		btnCancelar.setBounds(60, 556, 151, 48);
		
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCancelar.setName("btnCancelarEstancias");
		add(btnCancelar);
		btnSiguiente.setBounds(874, 556, 156, 48);
		
		btnSiguiente.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSiguiente.setName("btnSiguienteEstancias");
		add(btnSiguiente);
		
		String col[] = {"cod","Tipo","Tamaño","Precio","Tipo de Cama"};
		tableModel = new DefaultTableModel(col, 0);
		tablaHabitaciones = new JTable(tableModel);
		tablaHabitaciones.setDragEnabled(false);
		tablaHabitaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaHabitaciones.getColumnModel().getColumn(0).setMaxWidth(0);
		tablaHabitaciones.getColumnModel().getColumn(0).setMinWidth(0);
		tablaHabitaciones.getColumnModel().getColumn(0).setPreferredWidth(0);
		tablaHabitaciones.setRowHeight(25);
		tablaHabitaciones.getColumnModel().getColumn(1).setMinWidth(50);
		tablaHabitaciones.getColumnModel().getColumn(1).setPreferredWidth(50);
		tablaHabitaciones.getColumnModel().getColumn(2).setMinWidth(25);
		tablaHabitaciones.getColumnModel().getColumn(2).setPreferredWidth(25);
		tablaHabitaciones.getColumnModel().getColumn(3).setMinWidth(25);
		tablaHabitaciones.getColumnModel().getColumn(3).setPreferredWidth(25);
		tablaHabitaciones.getColumnModel().getColumn(4).setMinWidth(200);
		tablaHabitaciones.getColumnModel().getColumn(4).setPreferredWidth(200);
		tablaHabitaciones.getColumnModel().getColumn(1).setResizable(false);
		tablaHabitaciones.getColumnModel().getColumn(2).setResizable(false);
		tablaHabitaciones.getColumnModel().getColumn(3).setResizable(false);
		tablaHabitaciones.getColumnModel().getColumn(4).setResizable(false);
		
		
		tablaHabitaciones.setDefaultEditor(Object.class, null);
		tablaHabitaciones.setShowHorizontalLines(true);
		tablaHabitaciones.setBackground(new Color(230, 230, 250));
		tablaHabitaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		scrollPane.setViewportView(tablaHabitaciones);
		scrollPane.setBackground(new Color(230, 230, 250));
		scrollPane.setBounds(62, 231, 913, 196);
		add(scrollPane);
		
		 btnReservar = new JButton("Reservar");
		 btnReservar.setFont(new Font("Dialog", Font.BOLD, 11));
		 btnReservar.setName("Reservar");
		btnReservar.setForeground(Color.BLACK);
		btnReservar.setBackground(Color.GREEN);
		btnReservar.setBounds(482, 451, 89, 31);
		add(btnReservar);

		ImageIcon imagen=new ImageIcon(PanelEstanciasHotel.class.getResource("/imagenes/pattern.jpg"));
		btnPerfil.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		
		btnPerfil.setEnabled(false);
		btnPerfil.setName("btnPerfil");
		btnPerfil.setBounds(10, 35, 89, 23);
		add(btnPerfil);
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		
		btnLogin.setName("btnLogin");
		btnLogin.setBounds(10, 11, 89, 23);
		add(btnLogin);
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);
	}
}
