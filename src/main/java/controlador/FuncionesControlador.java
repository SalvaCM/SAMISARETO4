package controlador;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class FuncionesControlador {
	
    /**
     * Metodo para cambiar de paneles ,es decir, muestra la que desee y oculta en la que estes
     * @param ocultar panel a ocultar
     * @param mostrar panel a mostrar
     */
	public void cambiarDePanel(JPanel ocultar, JPanel mostrar) { 
		ocultar.setVisible(false);
		mostrar.setVisible(true); 
	}
	
	/**
	 * Metodo que activa el boton que se desee de las ventanas
	 * @param boton a activar
	 */
	public void actBotones(JButton boton) {   
			boton.setEnabled(true);
		 
	}
	
	/**
	 * Metodo que desactiva el boton que se desee de las ventanas
	 * @param boton a desactivar
	 */
	public void desBotones(JButton boton) {   
		boton.setEnabled(false);
	
	}

	public void limpiarTabla(JTable table,TableModel tableModel)
	{
		int rows=tableModel.getRowCount();
		for (int i = rows; i > 0; i--) {
			((DefaultTableModel) tableModel).removeRow(i-1);
		}	
	}
	
	

	
	

			
			
}



