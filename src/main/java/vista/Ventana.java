package vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Clase de la ventana principarl de la aplicacion
 *
 */
public class Ventana extends JFrame { 

	private static final long serialVersionUID = 12L;

	private JPanel contentPane;

	//Instancias de todos los paneles de la aplicacion
	public PanelPago pago;
	public PanelResumen resumen;
	public PanelDevolucion devolucion;
	
	/**
	 * Create the frame.
	 */
	public Ventana() { 
		
		setTitle("Gestion de Compra de Alojamientos");
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBounds(100, 100, 1085, 696);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		
		
		pago = new PanelPago();
		contentPane.add(pago);
		pago.setLayout(null);
		
		resumen = new PanelResumen();
		contentPane.add(resumen);
		resumen.setLayout(null);
		
		devolucion = new PanelDevolucion();
		contentPane.add(devolucion);
		devolucion.setLayout(null);

		
	}
}
