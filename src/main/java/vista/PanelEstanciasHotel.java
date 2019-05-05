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
	
	/**
	 * Create the panel.
	 */
	public PanelEstanciasHotel() {
		setMaximumSize(new Dimension(800, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("SELECCIONE UNA ESTANCIA");
		lblNewJgoodiesLabel.setBounds(10, 59, 1065, 48);
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewJgoodiesLabel);
		
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
		tablaHabitaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaHabitaciones.getColumnModel().getColumn(0).setMaxWidth(0);
		tablaHabitaciones.getColumnModel().getColumn(0).setMinWidth(0);
		tablaHabitaciones.getColumnModel().getColumn(0).setPreferredWidth(0);
		tablaHabitaciones.getColumnModel().getColumn(0).setResizable(false);
		tablaHabitaciones.setDefaultEditor(Object.class, null);
		tablaHabitaciones.setShowHorizontalLines(true);
		tablaHabitaciones.setBackground(new Color(230, 230, 250));
		tablaHabitaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		scrollPane.setViewportView(tablaHabitaciones);
		scrollPane.setBackground(new Color(230, 230, 250));
		scrollPane.setBounds(55, 118, 913, 213);
		add(scrollPane);
		
		 btnReservar = new JButton("Reservar");
		 btnReservar.setName("Reservar");
		btnReservar.setForeground(Color.BLACK);
		btnReservar.setBackground(Color.GREEN);
		btnReservar.setBounds(714, 384, 89, 31);
		add(btnReservar);

		ImageIcon imagen=new ImageIcon(PanelEstanciasHotel.class.getResource("/imagenes/fondo.jpg"));
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);
	}
}
