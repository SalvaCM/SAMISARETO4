package modelo;

public class FuncionesPago {
	
	public double sumarDineroPago(String valor, double pagado) {
		//Declaracion e inicializacion de variables

		//Inicio del programa
		pagado = pagado + Double.parseDouble(valor);

		return pagado;
			
	}

}
