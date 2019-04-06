
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
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
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import java.awt.Rectangle;
import javax.swing.border.MatteBorder;
import java.awt.Component;

public class PanelHotel extends JPanel {


	private static final long serialVersionUID = 2L;
	public JTextArea textArea = new JTextArea();
	public JButton btnVer = new JButton("Estancias");
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JList<String> list_hoteles=new JList<String>(); 
	public DefaultListModel<String> modelo = new DefaultListModel<String>();
	public JButton btnBuscar = new JButton("Buscar");
	public JTable tablaResultados;
	public DefaultTableModel tableModel;
	private final JScrollPane scrollPane_1 = new JScrollPane();
	public final JComboBox comboBox = new JComboBox();
	/**
	 * Create the panel.
	 */
	public PanelHotel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(SystemColor.controlHighlight);
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("SELECCIONE EL HOTEL");
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(Color.BLUE);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewJgoodiesLabel);
		btnCancelar.setBounds(48, 551, 195, 70);
		
		btnCancelar.setName("btnCancelarHotel");
		btnCancelar.setBackground(new Color(248, 248, 255));
		btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(btnCancelar);
		btnSiguiente.setBounds(837, 551, 195, 70);
		
		btnSiguiente.setName("btnSiguienteHotel");
		btnSiguiente.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnSiguiente.setBackground(new Color(248, 248, 255));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(btnSiguiente);
		
		modelo=new DefaultListModel<String>();
		scrollPane_1.setBounds(516, 214, 379, 70);
		
		add(scrollPane_1);
		list_hoteles=new JList<String>(modelo);
		scrollPane_1.setColumnHeaderView(list_hoteles);
		list_hoteles.setModel(modelo);
		list_hoteles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		btnBuscar.setBounds(535, 148, 89, 23);
		
		btnBuscar.setName("btnBuscarHoteles");
		add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(196, 307, 635, 235);
		add(scrollPane);
		
		String col[] = {"Nombre","Ubicacion","Precio"};
		tableModel = new DefaultTableModel(col, 0);
		tablaResultados = new JTable(tableModel);
		scrollPane.setViewportView(tablaResultados);
		tablaResultados.setShowVerticalLines(true);
		tablaResultados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaResultados.setAutoCreateRowSorter(true);
		comboBox.setBounds(355, 149, 138, 22);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MADRID", "ASTURIAS", "VALENCIA", "BARCELONA", "SALAMANCA"}));
		add(comboBox);
		textArea.setBounds(10, 190, 483, 80);
		add(textArea);
		btnVer.setBounds(48, 277, 107, 23);
		
		
		btnVer.setName("ver");
		add(btnVer);
			

		tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(130);
		tablaResultados.getColumnModel().getColumn(2).setPreferredWidth(73);
		    
	       
	       
	       
		

	}
}

