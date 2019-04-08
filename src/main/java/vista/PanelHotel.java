
package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.Cursor;

public class PanelHotel extends JPanel {


	private static final long serialVersionUID = 2L;
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JList<String> list_hoteles=new JList<String>(); 
	public DefaultListModel<String> modelo = new DefaultListModel<String>();
	public JButton btnBuscar = new JButton("Buscar");
	public JTable tablaResultados;
	public DefaultTableModel tableModel;
	
	public JComboBox<String> comboBox = new JComboBox<String>();

	
	/**
	 * Create the panel.
	 */
	public PanelHotel() {
		setMaximumSize(new Dimension(800, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("SELECCIONE EL HOTEL");
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(new Color(0, 0, 0));
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewJgoodiesLabel);
		btnCancelar.setBounds(197, 573, 125, 48);
		
		btnCancelar.setName("btnCancelarHotel");

		add(btnCancelar);
		btnSiguiente.setBounds(707, 573, 125, 48);
		
		btnSiguiente.setName("btnSiguienteHotel");
	
		add(btnSiguiente);
		
		modelo=new DefaultListModel<String>();
		
		btnBuscar.setBounds(505, 149, 89, 23);
		btnBuscar.setName("btnBuscarHoteles");
		add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(230, 230, 250));
		scrollPane.setBounds(197, 183, 635, 345);
		add(scrollPane);
		
		String col[] = {"codhotel","Nombre","Ubicacion","Estrellas"};
		tableModel = new DefaultTableModel(col, 0);
		tablaResultados = new JTable(tableModel);
		tablaResultados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaResultados.getColumnModel().getColumn(0).setMaxWidth(0);
		tablaResultados.getColumnModel().getColumn(0).setMinWidth(0);
		tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(0);
		tablaResultados.setShowHorizontalLines(true);
		tablaResultados.setBackground(new Color(230, 230, 250));
		scrollPane.setViewportView(tablaResultados);
		tablaResultados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaResultados.setAutoCreateRowSorter(true);
		comboBox.setBounds(305, 149, 138, 22);
		
		// a�adir funcion para buscar provincias en la base de datos
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"MADRID", "ASTURIAS", "VALENCIA", "BARCELONA", "SALAMANCA"}));
		comboBox.setBounds(355, 149, 138, 22);

		add(comboBox);
			

		tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(130);
		tablaResultados.getColumnModel().getColumn(2).setPreferredWidth(73);
		    
	       
	       
	       
		

	}
}

