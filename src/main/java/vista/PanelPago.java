package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Dimension;
import javax.swing.JTextField;


/** 
 * Clase del panel de pago
 *
 */
public class PanelPago extends JPanel {
	
	private static final long serialVersionUID = 4L;
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JButton btnCodigoDto = new JButton("Validar");
	
	public JLabel restante = new JLabel();
	public JLabel pagado = new JLabel();
	public JLabel total = new JLabel();

	public JButton btn500;
	public JButton btn200;
	public JButton btn100;
	public JButton btn50;
	public JButton btn20;
	public JButton btn10;
	public JButton btn5;
	public JButton btn2;
	public JButton btn1;
	public JButton btn050;
	public JButton btn020;
	public JButton btn010;
	public JButton btn005;
	public JButton btn002; 
	public JButton btn001;
	
	public JButton[] arrayBtn= new JButton[15];
	public JLabel etiqueta ;
	public JTextField textCodigo;
		

	/**
	 * Create the panel. 
	 */
	public PanelPago() {
		setForeground(Color.DARK_GRAY);
		setMaximumSize(new Dimension(800, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(176, 224, 230));
		setLayout(null);
		
		btnCodigoDto.setName("btnCodigoDto");
		btnCodigoDto.setBounds(609, 567, 89, 23);
		add(btnCodigoDto);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(493, 570, 106, 20);
		textCodigo.setColumns(10);
		add(textCodigo);
	
		
		JLabel lblCodigoPromocinal = DefaultComponentFactory.getInstance().createTitle("Codigo promocinal: ");
		lblCodigoPromocinal.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCodigoPromocinal.setBounds(297, 569, 194, 21);
		add(lblCodigoPromocinal);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("PAGO");
		lblNewJgoodiesLabel.setBackground(new Color(70, 130, 180));
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Aharoni", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 52, 1065, 48);
		add(lblNewJgoodiesLabel);
		
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCancelar.setName("btnCancelarPago");
		btnCancelar.setBounds(60, 556, 151, 48);
		add(btnCancelar);
		
		btnSiguiente.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSiguiente.setName("btnSiguientePago");
		btnSiguiente.setBounds(874, 556, 156, 48);
		add(btnSiguiente);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("TOTAL:");
		lblNewJgoodiesLabel_1.setForeground(Color.DARK_GRAY);
		lblNewJgoodiesLabel_1.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewJgoodiesLabel_1.setFont(new Font("Aharoni", Font.PLAIN, 35));
		lblNewJgoodiesLabel_1.setBounds(658, 214, 178, 35);
		add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("PAGADO:");
		lblNewJgoodiesLabel_2.setForeground(Color.DARK_GRAY);
		lblNewJgoodiesLabel_2.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewJgoodiesLabel_2.setFont(new Font("Aharoni", Font.PLAIN, 35));
		lblNewJgoodiesLabel_2.setBounds(658, 321, 178, 30);
		add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("RESTANTE:");
		lblNewJgoodiesLabel_3.setForeground(Color.DARK_GRAY);
		lblNewJgoodiesLabel_3.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewJgoodiesLabel_3.setFont(new Font("Aharoni", Font.PLAIN, 35));
		lblNewJgoodiesLabel_3.setBounds(658, 435, 209, 35);
		add(lblNewJgoodiesLabel_3);		
		restante.setForeground(Color.RED);
		
		
		restante.setHorizontalAlignment(SwingConstants.RIGHT);
		restante.setFont(new Font("Tahoma", Font.PLAIN, 30));	
	    restante.setBounds(888, 435, 135, 35);
		add(restante);
		pagado.setForeground(Color.RED);
		
		
		pagado.setHorizontalAlignment(SwingConstants.RIGHT);
		pagado.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pagado.setBounds(889, 321, 135, 35);
		add(pagado);
		total.setForeground(Color.RED);
		
		
		total.setHorizontalAlignment(SwingConstants.RIGHT);
		total.setToolTipText("");
		total.setFont(new Font("Tahoma", Font.PLAIN, 30));	
		total.setBounds(888, 214, 135, 35);
		add(total);
		


		btn5 = new JButton("");
		btn5.setName("5");
		btn5.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/5euros.jpg")));
		btn5.setBounds(58, 321, 123, 54);
		add(btn5);

		btn2 = new JButton("");
		btn2.setName("2");
		btn2.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/2euros.png")));
		btn2.setBounds(218, 321, 123, 54);
		add(btn2);

		btn10 = new JButton("");
		btn10.setName("10");
		btn10.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/10euros.jpg")));
		btn10.setBounds(378, 257, 123, 54);
		add(btn10);

		btn200 = new JButton("");
		btn200.setName("200");
		btn200.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/200euros.jpg")));
		btn200.setBounds(218, 193, 123, 54);
		add(btn200);

		btn20 = new JButton("");
		btn20.setName("20");
		btn20.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/20euros.jpg")));
		btn20.setBounds(218, 257, 123, 54);
		add(btn20);

		btn500 = new JButton("");
		btn500.setName("500");
		btn500.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/500euros.jpg")));
		btn500.setBounds(58, 193, 123, 54);
		add(btn500);
		
		btn100 = new JButton("");
		btn100.setName("100");
		btn100.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/100euros.jpg")));
		btn100.setBounds(378, 193, 123, 54);
		add(btn100);

		btn50 = new JButton("");
		btn50.setName("50");
		btn50.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/50euros.jpg")));
		btn50.setBounds(58, 257, 123, 54);
		add(btn50);

		btn1 = new JButton("");
		btn1.setName("1");
		btn1.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/1euro.png")));
		btn1.setBounds(378, 321, 123, 54);
		add(btn1);

		btn050 = new JButton("");
		btn050.setName("0.5");
		btn050.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/50centimos.png")));
		btn050.setBounds(58, 383, 123, 54);
		add(btn050);

		btn020 = new JButton("");
		btn020.setName("0.2");
		btn020.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/20centimos.png")));
		btn020.setBounds(218, 383, 123, 54);
		add(btn020);

		btn010 = new JButton("");
		btn010.setName("0.1");
		btn010.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/10centimos.png")));
		btn010.setBounds(378, 383, 123, 54);
		add(btn010);

		btn005 = new JButton("");
		btn005.setName("0.05");
		btn005.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/5centimos.png")));
		btn005.setBounds(58, 448, 123, 54);
		add(btn005);

		btn002 = new JButton("");
		btn002.setName("0.02");
		btn002.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/2centimos.png")));
		btn002.setBounds(218, 448, 123, 54);
		add(btn002);

		btn001 = new JButton("");
		btn001.setName("0.01");
		btn001.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/1centimo.png")));
		btn001.setBounds(378, 448, 123, 54);
		add(btn001);
		
		arrayBtn[0]=btn500;
		arrayBtn[1]=btn200;
		arrayBtn[2]=btn100;
		arrayBtn[3]=btn50;
		arrayBtn[4]=btn20;
		arrayBtn[5]=btn10;
		arrayBtn[6]=btn5;
		arrayBtn[7]=btn2;
		arrayBtn[8]=btn1;
		arrayBtn[9]=btn050;
		arrayBtn[10]=btn020;
		arrayBtn[11]=btn010;
		arrayBtn[12]=btn005;
		arrayBtn[13]=btn002;
		arrayBtn[14]=btn001;
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Haz clic en los billetes o monedas para introducir el dinero");
		lblNewJgoodiesLabel_4.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel_4.setFont(new Font("Aharoni", Font.PLAIN, 20));
		lblNewJgoodiesLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_4.setBounds(10, 127, 1065, 26);
		add(lblNewJgoodiesLabel_4);
		

		ImageIcon imagen=new ImageIcon(PanelLogin.class.getResource("/imagenes/pattern.jpg"));
		etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0, -58, 1075, 773);
		add(etiqueta);

	}
}
