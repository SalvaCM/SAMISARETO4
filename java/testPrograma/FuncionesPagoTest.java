package testPrograma;
import static org.junit.Assert.*;

import org.junit.Test;

import funcionesYObjetos.*;

public class FuncionesPagoTest {

	@Test
	public void testPrecioAPagar1() {
		Producto[] testInventario = new Producto[3];
		FuncionesPago funPago = new FuncionesPago();
		//Declaracion de variables
		String nombreProductoTest1 = "Lacasitos";
		int codigoProductoTest1 = 3;
		float precioProductoTest1 = 2;

		String nombreProductoTest2 = "Cocacola";
		int codigoProductoTest2 = 3;
		float precioProductoTest2 = 2;

		String nombreProductoTest3 = "Agua";
		int codigoProductoTest3 = 3;
		float precioProductoTest3 = 2;
		
        //Test
		testInventario[0] = new Producto(nombreProductoTest1, codigoProductoTest1, precioProductoTest1);
		testInventario[1] = new Producto(nombreProductoTest2, codigoProductoTest2, precioProductoTest2);
		testInventario[2] = new Producto(nombreProductoTest3, codigoProductoTest3, precioProductoTest3);
          
		//El resultado debe ser 0 porque la cantidad es 0.
		assertEquals(funPago.PrecioAPagar(testInventario),0,0);
	
	}

	
	
	@Test
	public void testPrecioAPagar2() {
		Producto[] testInventario = new Producto[3];
		FuncionesPago funPago = new FuncionesPago();
		
		// declaracion de variables
		String nombreProductoTest1 = "Lacasitos";
		int codigoProductoTest1 = 1;
		float precioProductoTest1 = 2;

		String nombreProductoTest2 = "Cocacola";
		int codigoProductoTest2 = 2;
		float precioProductoTest2 = 3;

		String nombreProductoTest3 = "Fanta";
		int codigoProductoTest3 = 3;
		float precioProductoTest3 = 1;
		
		
		
        // Test
		testInventario[0] = new Producto(nombreProductoTest1, codigoProductoTest1, precioProductoTest1);
		testInventario[1] = new Producto(nombreProductoTest2, codigoProductoTest2, precioProductoTest2);
		testInventario[2] = new Producto(nombreProductoTest3, codigoProductoTest3, precioProductoTest3);

	    
		testInventario[0].cantidad = 1;
		testInventario[1].cantidad = 2;
		testInventario[2].cantidad = 3;
		
        // El resultado debe dar 11. Porque es 2*1 + 3*2 + 1*3
		assertEquals(funPago.PrecioAPagar(testInventario), 11, 0);
	}
	@Test
	public void testPrecioAPagarConIva1() {
		
		Producto[] testInventario = new Producto[3];
		FuncionesPago funcionPagoConIva = new FuncionesPago();
		
		// declaracion de variables
		String nombreProductoTest1 = "Lacasitos";
		int codigoProductoTest1 = 1;
		float precioProductoTest1 = 2;
		float precioIvaTest1 = (Math.round((precioProductoTest1 * (1f + 0.21f)) * 100f)) / 100f;
		
		String nombreProductoTest2 = "Lacasitos";
		int codigoProductoTest2 = 1;
		float precioProductoTest2 = 2;
		float precioIvaTest2 = (Math.round((precioProductoTest2 * (1f + 0.21f)) * 100f)) / 100f;
		
		String nombreProductoTest3 = "Lacasitos";
		int codigoProductoTest3 = 1;
		float precioProductoTest3 = 2;
		float precioIvaTest3 = (Math.round((precioProductoTest3 * (1f + 0.21f)) * 100f)) / 100f;
        
		//Test
		testInventario[0] = new Producto(nombreProductoTest1, codigoProductoTest1, precioProductoTest1*precioIvaTest1);
		testInventario[1] = new Producto(nombreProductoTest2, codigoProductoTest2, precioProductoTest2*precioIvaTest2);
		testInventario[2] = new Producto(nombreProductoTest3, codigoProductoTest3, precioProductoTest3*precioIvaTest3);
		
		//El resultado debe ser 0 porque la cantidad es 0.
		assertEquals(funcionPagoConIva.PrecioAPagarConIva(testInventario), 0, 0);
		
	}
	
	@Test
	public void testPrecioAPagarConIva2() {
		
		Producto[] testInventario = new Producto[3];
		FuncionesPago funcionPagoConIva = new FuncionesPago();
		
		// declaracion de variables
		String nombreProductoTest1 = "Lacasitos";
		int codigoProductoTest1 = 1;
		float precioProductoTest1 = 3;
	
		
		String nombreProductoTest2 = "Cocacola";
		int codigoProductoTest2 = 2;
		float precioProductoTest2 = 2;
		
		
		String nombreProductoTest3 = "Fanta";
		int codigoProductoTest3 = 3;
		float precioProductoTest3 = 1;
		
        
		//Test
		testInventario[0] = new Producto(nombreProductoTest1, codigoProductoTest1, precioProductoTest1);
		testInventario[1] = new Producto(nombreProductoTest2, codigoProductoTest2, precioProductoTest2);
		testInventario[2] = new Producto(nombreProductoTest3, codigoProductoTest3, precioProductoTest3);
		
		testInventario[0].cantidad = 1;
		testInventario[1].cantidad = 2;
		testInventario[2].cantidad = 3;
		
        // El resultado debe ser 0 .Porque es 3,63 + 4,84 + 3,63																								
		assertEquals(funcionPagoConIva.PrecioAPagarConIva(testInventario),12.1, 0.1);
		
	}



}
