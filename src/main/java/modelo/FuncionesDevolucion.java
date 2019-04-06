package modelo;

public class FuncionesDevolucion {
	
	/**
	 * Metodo para realizar los cambios en las menores monedas y billetes posibles.	
	 * @param dinero cantidad a devolver para calcular las monedas y billetes de la devolucion
	 * @return array con la cantidad de cada billete o moneda, segun su posicion en el array
	 */
	public int[] cambios(double dinero) {
		
		// Declaracion e inicializacion de variables
		int euros = (int) Math.floor(dinero);
		int decimales = (int) Math.round((dinero - euros) * 100);
		int[] billetesMonedas = {500, 200, 100, 50, 20, 10, 5, 2, 1}; 
		int[] cambios = new int[15];
		
		//Inicio del programa
		for (int i = 0, f = 0, fake = 1; i < billetesMonedas.length + fake; i++, f++) {
			//Mira si tiene que pasar a calcular los decimales
			if (f == 9) {
				i = 3;
				fake = 0;
			}
			//Calcula los euros
			if (euros >= billetesMonedas[i] && f < 9) {
				cambios[f] = (int) (euros / billetesMonedas[i]);
				euros = euros % billetesMonedas[i];
			}
			//Calcula los centimos si ha acabado con los euros
			else if (decimales >= billetesMonedas[i] && f >= 9) {
				cambios[f] = (int) ((billetesMonedas[i]/100f) + (decimales / billetesMonedas[i]));
				decimales = decimales % billetesMonedas[i];
			}
		}
		return cambios;
	}
	

	

}
