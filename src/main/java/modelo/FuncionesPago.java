package modelo;

public class FuncionesPago {

	
	public double sumarDineroPago(String valor, double pagado) {

		pagado = pagado + Double.parseDouble(valor);

		return pagado;
			
	}
	

}
