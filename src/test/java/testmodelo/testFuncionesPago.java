package testmodelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.FuncionesPago;

public class testFuncionesPago {
	FuncionesPago fpago=new FuncionesPago();
	@Test
	public void test() {
		double esperado=13d;
		double resultado=fpago.sumarDineroPago("12", 1);
		assertEquals(resultado,esperado,0);

	}

}
