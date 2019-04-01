package testPrograma;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import funcionesYObjetos.FuncionesCompra;
import funcionesYObjetos.Producto;

public class FuncionesCompraTest {

	@Test
	public void testInicializarProductos()
	{
		Producto[] testInicializarProductos = new Producto[8];
		Producto[] testInicializarProductosVacio = new Producto[8];
		FuncionesCompra testInicializar   = new FuncionesCompra();
		
		//declaracion de variables
		String nombreProductoTest1 = "Agua";
		int codigoProductoTest1 = 1;
		float precioProductoTest1 = 1.5f;
		
		String nombreProductoTest2 = "Cocacola";
		int codigoProductoTest2 = 2;
		float precioProductoTest2 = 2f;
		
		
		String nombreProductoTest3 = "Refresco de naranja";
		int codigoProductoTest3 = 3;
		float precioProductoTest3 = 2f;
		
		String nombreProductoTest4 = "Refresco de limon";
		int codigoProductoTest4 = 4;
		float precioProductoTest4 = 2f;
		
		String nombreProductoTest5 = "Nestea";
		int codigoProductoTest5 = 5;
		float precioProductoTest5 = 1.8f;
		
		
		String nombreProductoTest6 = "Kit-kat";
		int codigoProductoTest6 = 6;
		float precioProductoTest6 = 1.5f;
		
		String nombreProductoTest7 = "Toblerone";
		int codigoProductoTest7 = 7;
		float precioProductoTest7 = 2f;
		
		String nombreProductoTest8 = "Frutos secos";
		int codigoProductoTest8 = 8;
		float precioProductoTest8 = 1f;
		
		//Test
		testInicializarProductos[0] = new Producto(nombreProductoTest1, codigoProductoTest1, precioProductoTest1);
		testInicializarProductos[1] = new Producto(nombreProductoTest2, codigoProductoTest2, precioProductoTest2);
		testInicializarProductos[2] = new Producto(nombreProductoTest3, codigoProductoTest3, precioProductoTest3);
		testInicializarProductos[3] = new Producto(nombreProductoTest4, codigoProductoTest4, precioProductoTest4);
		testInicializarProductos[4] = new Producto(nombreProductoTest5, codigoProductoTest5, precioProductoTest5);
		testInicializarProductos[5] = new Producto(nombreProductoTest6, codigoProductoTest6, precioProductoTest6);
		testInicializarProductos[6] = new Producto(nombreProductoTest7, codigoProductoTest7, precioProductoTest7);
		testInicializarProductos[7] = new Producto(nombreProductoTest8, codigoProductoTest8, precioProductoTest8);
	
	 																							
		equals(testInicializar.InicializarProdutos(testInicializarProductos));

    }
	
	@Test
	public void TestCantidadA0 ()
	{
		Producto [] inventario = new Producto[1];
		Producto [] inventarioVacio = new Producto[1];
		FuncionesCompra funcionesCompra = new FuncionesCompra();
		
		//Declaraciones de variables
		String nombreProductoTest1 = "Agua";
		int codigoProductoTest1 = 1;
		float precioProductoTest1 = 1.5f;
		
			
		inventario[0] = new Producto(nombreProductoTest1, codigoProductoTest1, precioProductoTest1);
		
		inventarioVacio[0] = new Producto(nombreProductoTest1, codigoProductoTest1, precioProductoTest1);
		
		inventario[0].cantidad = 1;

		
		funcionesCompra.CantidadA0(inventario);
		
		assertEquals(inventario[0].cantidad, inventarioVacio[0].cantidad);
		
	}

}
