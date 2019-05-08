package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JDateChooser;


public class PanelRegistro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	
	public JButton btnCancelar;
	public JButton btnRegistrarse;
	public JTextField textFieldApellido;
	public JTextField textFieldNombre;
	public JTextField textFieldDni;
	public JComboBox<String> comboBoxGenero = new JComboBox<String>();
	public JPasswordField passwordField;
	public JDateChooser fechaNac = new JDateChooser();
	public JLabel etiqueta;

	/**
	 * Create the panel.
	 */
	public PanelRegistro() {

		setMaximumSize(new Dimension(800, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("REGISTRARSE");
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(Color.BLUE);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewJgoodiesLabel);
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("DNI:");
		lblNewJgoodiesLabel_1.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_1.setBounds(110, 178, 351, 35);
		add(lblNewJgoodiesLabel_1);	
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCancelar.setName("btnCancelarRegistro");
		btnCancelar.setBounds(60, 556, 151, 48);
		add(btnCancelar);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnRegistrarse.setName("btnRegistro");
		btnRegistrarse.setBounds(874, 556, 156, 48);
		add(btnRegistrarse);
		
		JLabel lblNombre = DefaultComponentFactory.getInstance().createLabel("NOMBRE:");
		lblNombre.setForeground(Color.ORANGE);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(110, 231, 351, 29);
		add(lblNombre);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("APELLIDO:");
		lblNewJgoodiesLabel_2.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_2.setBounds(202, 281, 259, 29);
		add(lblNewJgoodiesLabel_2);

		
		JLabel lblContrasea = DefaultComponentFactory.getInstance().createLabel("CONTRASE\u00D1A:");
		lblContrasea.setForeground(Color.ORANGE);
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(110, 387, 351, 25);
		add(lblContrasea);
		
		textFieldDni = new JTextField();
		textFieldDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(468, 184, 277, 26);
		add(textFieldDni);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldNombre.setColumns(10); 
		textFieldNombre.setBounds(468, 234, 277, 26);
		add(textFieldNombre);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(468, 284, 277, 26);
		add(textFieldApellido);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(468, 388, 277, 26);
		add(passwordField);
		
		JLabel lblFechaDeNacimiento = DefaultComponentFactory.getInstance().createLabel("FECHA DE NACIMIENTO:");
		lblFechaDeNacimiento.setForeground(Color.ORANGE);
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFechaDeNacimiento.setBounds(242, 335, 219, 30);
		add(lblFechaDeNacimiento);
		

		Calendar LimitadorFecha = Calendar.getInstance(); LimitadorFecha.add(Calendar.YEAR, -18); 
	    Date edadMin = LimitadorFecha.getTime(); 
	    Calendar LimitadorFecha2 = Calendar.getInstance(); LimitadorFecha2.add(Calendar.YEAR, -114); 
	    Date edadMax = LimitadorFecha2.getTime();
	    
	    fechaNac.getJCalendar().setMaxSelectableDate(edadMin);
	    fechaNac.getJCalendar().setMinSelectableDate(edadMax);
		fechaNac.setBounds(468, 336, 219, 29);
		fechaNac.setDateFormatString("yyyy-MM-dd");
		add(fechaNac);
	
		ImageIcon imagen=new ImageIcon(PanelRegistro.class.getResource("/imagenes/pattern.jpg"));
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);
		

		
	}
}
