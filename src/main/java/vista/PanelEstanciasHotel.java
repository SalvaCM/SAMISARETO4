package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

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

	/**
	 * Create the panel.
	 */
	public PanelEstanciasHotel() {
		setMaximumSize(new Dimension(800, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		btnCancelar.setBounds(80, 528, 123, 43);
		
		btnCancelar.setFont(new Font("Aharoni", Font.PLAIN, 18));
		btnCancelar.setName("btnCancelarEstancias");
		add(btnCancelar);
		btnSiguiente.setBounds(662, 528, 123, 43);
		
		btnSiguiente.setFont(new Font("Aharoni", Font.PLAIN, 18));
		btnSiguiente.setName("btnSiguienteEstancias");
		add(btnSiguiente);
		
		String col[] = {"cod","Categoria","Existencias","Precio"};
		tableModel = new DefaultTableModel(col, 0);
		tablaHabitaciones = new JTable(tableModel);
		tablaHabitaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaHabitaciones.getColumnModel().getColumn(0).setMaxWidth(0);
		tablaHabitaciones.getColumnModel().getColumn(0).setMinWidth(0);
		tablaHabitaciones.getColumnModel().getColumn(0).setPreferredWidth(0);
		tablaHabitaciones.getColumnModel().getColumn(0).setResizable(false);
		tablaHabitaciones.setShowHorizontalLines(true);
		tablaHabitaciones.setBackground(new Color(230, 230, 250));
		tablaHabitaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaHabitaciones.setAutoCreateRowSorter(true);
		
		scrollPane.setViewportView(tablaHabitaciones);
		scrollPane.setBackground(new Color(230, 230, 250));
		scrollPane.setBounds(79, 92, 706, 412);
		add(scrollPane);

	}
}
