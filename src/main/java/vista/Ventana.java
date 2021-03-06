package vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

/**
 * Clase de la ventana principal de la aplicacion
 *
 */
public class Ventana extends JFrame { 

	private static final long serialVersionUID = 13L;

	private JPanel contentPane;

	//Instancias de todos los paneles de la aplicacion
	public PanelPago pago;
	public PanelResumen resumen;
	public PanelDevolucion devolucion;
	public PanelHotel hotel;
	public PanelDespedida despedida;
	public PanelSaludo saludo;
	public PanelEstanciasHotel estanciasHotel;
	public PanelLogin login;
	public PanelRegistro registro;
	public PanelUsuario usuario;
	public PanelElegirAlojamiento alojamiento;
	public PanelCasa casa;
	public PanelApartamento apartamento;
	public PanelResumenCasayApart resumenCyA;
	
	
	/**
	 * Create the frame.
	 */
	public Ventana() {
			
	        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	 
	        addWindowListener(new java.awt.event.WindowAdapter() {
	            @Override
	            public void windowClosing(java.awt.event.WindowEvent evt) {
	                close();
	            }
	        });
	    
	 
		setMaximumSize(new Dimension(800, 600)); 
		
		setTitle("Gestion de Compra de Alojamientos");
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBounds(100, 100, 1085, 696);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		saludo = new PanelSaludo();
		contentPane.add(saludo);
		saludo.setLayout(null);
		
		login = new PanelLogin();
		contentPane.add(login);
		login.setLayout(null);
		
		hotel = new PanelHotel();
		contentPane.add(hotel);
		hotel.setLayout(null);
		
		estanciasHotel = new PanelEstanciasHotel();
		contentPane.add(estanciasHotel);
		estanciasHotel.setLayout(null);
		
		resumen = new PanelResumen();
		contentPane.add(resumen);
		resumen.setLayout(null);
		
		pago = new PanelPago();
		contentPane.add(pago);
		pago.setLayout(null);
		
		devolucion = new PanelDevolucion();
		contentPane.add(devolucion);
		devolucion.setLayout(null);
		
		despedida = new PanelDespedida();
		contentPane.add(despedida);
		despedida.setLayout(null);
		
		registro = new PanelRegistro();
		contentPane.add(registro);
		registro.setLayout(null);
		
		usuario = new PanelUsuario();
		contentPane.add(usuario);
		usuario.setLayout(null);
		
		alojamiento=new PanelElegirAlojamiento();
		contentPane.add(alojamiento);
		alojamiento.setLayout(null);

		casa = new PanelCasa();
		contentPane.add(casa);
		casa.setLayout(null);
		
		apartamento = new PanelApartamento();
		contentPane.add(apartamento);
		apartamento.setLayout(null);
		
		resumenCyA=new  PanelResumenCasayApart();
		contentPane.add(resumenCyA);
		resumenCyA.setLayout(null);
	}
	
	  private void close(){
	        if (JOptionPane.showConfirmDialog(rootPane, "�Desea realmente salir del sistema?",
	                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
	        	System.exit(0);
	        }
	        else 
	        {
	        	  setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	        }
	  }
}
