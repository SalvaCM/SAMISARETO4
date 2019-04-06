package controlador;

import javax.swing.JPanel;

/**
 * Clase con controla el cambio entre paneles
 *
 */
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
	
	
	

	
	

			
			
}



