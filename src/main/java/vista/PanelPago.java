package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import com.jgoodies.forms.factories.DefaultComponentFactory;


/** 
 * Clase del panel de pago
 *
 */
public class PanelPago extends JPanel {
	
	private static final long serialVersionUID = 4L;
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	
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
		

	/**
	 * Create the panel. 
	 */
	public PanelPago() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(SystemColor.controlHighlight);
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("PAGO");
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(Color.BLUE);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		add(lblNewJgoodiesLabel);
		
		btnCancelar.setName("btnCancelarPago");
		btnCancelar.setBackground(new Color(248, 248, 255));
		btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(48, 551, 195, 70);
		add(btnCancelar);
		
		btnSiguiente.setName("btnSiguientePago");
		btnSiguiente.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnSiguiente.setBackground(new Color(248, 248, 255));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(837, 551, 195, 70);
		add(btnSiguiente);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("TOTAL:");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewJgoodiesLabel_1.setBounds(690, 210, 115, 35);
		add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("PAGADO:");
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewJgoodiesLabel_2.setBounds(659, 303, 145, 30);
		add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("RESTANTE:");
		lblNewJgoodiesLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewJgoodiesLabel_3.setBounds(629, 390, 185, 35);
		add(lblNewJgoodiesLabel_3);		
		
		
		restante.setHorizontalAlignment(SwingConstants.RIGHT);
		restante.setFont(new Font("Tahoma", Font.PLAIN, 30));	
	    restante.setBounds(819, 390, 162, 35);
		add(restante);
		
		
		pagado.setHorizontalAlignment(SwingConstants.RIGHT);
		pagado.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pagado.setBounds(819, 303, 162, 35);
		add(pagado);
		
		
		total.setHorizontalAlignment(SwingConstants.RIGHT);
		total.setToolTipText("");
		total.setFont(new Font("Tahoma", Font.PLAIN, 30));	
		total.setBounds(819, 210, 162, 35);
		add(total);
		


		btn5 = new JButton("");
		btn5.setName("5");
		btn5.setBackground(SystemColor.controlShadow);
		btn5.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn5.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn5.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/5euros.jpg")));
		btn5.setBounds(100, 321, 123, 54);
		add(btn5);

		btn2 = new JButton("");
		btn2.setName("2");
		btn2.setBackground(SystemColor.controlShadow);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn2.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/2euros.png")));
		btn2.setBounds(260, 321, 123, 54);
		add(btn2);

		btn10 = new JButton("");
		btn10.setName("10");
		btn10.setBackground(SystemColor.controlShadow);
		btn10.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn10.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn10.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/10euros.jpg")));
		btn10.setBounds(420, 257, 123, 54);
		add(btn10);

		btn200 = new JButton("");
		btn200.setName("200");
		btn200.setBackground(SystemColor.controlShadow);
		btn200.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn200.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn200.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/200euros.jpg")));
		btn200.setBounds(260, 193, 123, 54);
		add(btn200);

		btn20 = new JButton("");
		btn20.setName("20");
		btn20.setBackground(SystemColor.controlShadow);
		btn20.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn20.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn20.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/20euros.jpg")));
		btn20.setBounds(260, 257, 123, 54);
		add(btn20);

		btn500 = new JButton("");
		btn500.setName("500");
		btn500.setBackground(SystemColor.controlShadow);
		btn500.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn500.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn500.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/500euros.jpg")));
		btn500.setBounds(100, 193, 123, 54);
		add(btn500);
		
		btn100 = new JButton("");
		btn100.setName("100");
		btn100.setBackground(SystemColor.controlShadow);
		btn100.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn100.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn100.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/100euros.jpg")));
		btn100.setBounds(420, 193, 123, 54);
		add(btn100);

		btn50 = new JButton("");
		btn50.setName("50");
		btn50.setBackground(SystemColor.controlShadow);
		btn50.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn50.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn50.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/50euros.jpg")));
		btn50.setBounds(100, 257, 123, 54);
		add(btn50);

		btn1 = new JButton("");
		btn1.setName("1");
		btn1.setBackground(SystemColor.controlShadow);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn1.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/1euro.png")));
		btn1.setBounds(420, 321, 123, 54);
		add(btn1);

		btn050 = new JButton("");
		btn050.setName("0.5");
		btn050.setBackground(SystemColor.controlShadow);
		btn050.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn050.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn050.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/50centimos.png")));
		btn050.setBounds(100, 383, 123, 54);
		add(btn050);

		btn020 = new JButton("");
		btn020.setName("0.2");
		btn020.setBackground(SystemColor.controlShadow);
		btn020.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn020.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn020.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/20centimos.png")));
		btn020.setBounds(260, 383, 123, 54);
		add(btn020);

		btn010 = new JButton("");
		btn010.setName("0.1");
		btn010.setBackground(SystemColor.controlShadow);
		btn010.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn010.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn010.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/10centimos.png")));
		btn010.setBounds(420, 383, 123, 54);
		add(btn010);

		btn005 = new JButton("");
		btn005.setName("0.05");
		btn005.setBackground(SystemColor.controlShadow);
		btn005.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn005.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn005.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/5centimos.png")));
		btn005.setBounds(100, 448, 123, 54);
		add(btn005);

		btn002 = new JButton("");
		btn002.setName("0.02");
		btn002.setBackground(SystemColor.controlShadow);
		btn002.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn002.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn002.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/2centimos.png")));
		btn002.setBounds(260, 448, 123, 54);
		add(btn002);

		btn001 = new JButton("");
		btn001.setName("0.01");
		btn001.setBackground(SystemColor.controlShadow);
		btn001.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn001.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btn001.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/1centimo.png")));
		btn001.setBounds(420, 448, 123, 54);
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
		lblNewJgoodiesLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_4.setBounds(20, 131, 1065, 26);
		add(lblNewJgoodiesLabel_4);
	
	

	}
}
