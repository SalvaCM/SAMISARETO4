package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;


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
	public JPasswordField passwordField2;
	public JPasswordField passwordField;

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
		lblNewJgoodiesLabel.setForeground(new Color(0, 0, 0));
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewJgoodiesLabel);
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("DNI:");
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
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(110, 231, 351, 29);
		add(lblNombre);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("APELLIDO:");
		lblNewJgoodiesLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_2.setBounds(110, 281, 351, 29);
		add(lblNewJgoodiesLabel_2);

		
		JLabel lblContrasea = DefaultComponentFactory.getInstance().createLabel("CONTRASE\u00D1A:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(110, 397, 351, 25);
		add(lblContrasea);
		
		JLabel lblContrasea2 = DefaultComponentFactory.getInstance().createLabel("CONFIRMAR CONTRASE\u00D1A:");
		lblContrasea2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea2.setBounds(110, 450, 351, 25);
		add(lblContrasea2);
		
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
		passwordField.setBounds(468, 396, 277, 26);
		add(passwordField);
		
		passwordField2 = new JPasswordField();
		passwordField2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField2.setBounds(468, 451, 277, 26);
		add(passwordField2);
		
		JLabel lblFechaDeNacimiento = DefaultComponentFactory.getInstance().createLabel("FECHA DE NACIMIENTO:");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFechaDeNacimiento.setBounds(242, 319, 219, 30);
		add(lblFechaDeNacimiento);
		
		JLabel lblNewJgoodiesLabel_11 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewJgoodiesLabel_11.setForeground(Color.CYAN);
		lblNewJgoodiesLabel_11.setBackground(Color.CYAN); 
		lblNewJgoodiesLabel_11.setBounds(189, 142, 715, 360);
		add(lblNewJgoodiesLabel_11);
		

		
	}

}
