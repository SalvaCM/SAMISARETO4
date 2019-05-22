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
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
	private JLabel lblRegistrateAhora;
	private JLabel label;
	public 	JButton btnNewButton = new JButton("mostrar");

	/**
	 * Create the panel.
	 */
	public PanelRegistro() {

		setMaximumSize(new Dimension(800, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		
		btnNewButton.setIcon(new ImageIcon(PanelRegistro.class.getResource("/imagenes/ver.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setName("mostrar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(btnNewButton.getText().equals("mostrar")) {					
					passwordField.setEchoChar((char)0);
					btnNewButton.setText("ocultar");
					btnNewButton.setIcon(new ImageIcon(PanelRegistro.class.getResource("/imagenes/ocultar.png")));
				}
				
				else if(btnNewButton.getText().equals("ocultar")){
					passwordField.setEchoChar('*');
					btnNewButton.setText("mostrar");
					btnNewButton.setIcon(new ImageIcon(PanelRegistro.class.getResource("/imagenes/ver.png")));
					
				}
			}
		});
		btnNewButton.setBounds(733, 387, 122, 25);
		add(btnNewButton);
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("DNI:");
		lblNewJgoodiesLabel_1.setForeground(new Color(0, 153, 204));
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
		lblNombre.setForeground(new Color(0, 153, 204));
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(110, 231, 351, 29);
		add(lblNombre);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("APELLIDO:");
		lblNewJgoodiesLabel_2.setForeground(new Color(0, 153, 204));
		lblNewJgoodiesLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_2.setBounds(202, 281, 259, 29);
		add(lblNewJgoodiesLabel_2);

		
		JLabel lblContrasea = DefaultComponentFactory.getInstance().createLabel("CONTRASE\u00D1A:");
		lblContrasea.setForeground(new Color(0, 153, 204));
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
		lblFechaDeNacimiento.setForeground(new Color(0, 153, 204));
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
		
		lblRegistrateAhora = new JLabel("Registrate ahora :");
		lblRegistrateAhora.setForeground(new Color(0, 0, 0));
		lblRegistrateAhora.setOpaque(true);
		lblRegistrateAhora.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrateAhora.setFont(new Font("Dialog", Font.BOLD, 40));
		lblRegistrateAhora.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblRegistrateAhora.setBackground(Color.LIGHT_GRAY);
		lblRegistrateAhora.setBounds(188, 58, 713, 82);
		add(lblRegistrateAhora);
		
		label = new JLabel("");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		label.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(188, 152, 713, 317);
		add(label);
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);
		

		
	}
}
