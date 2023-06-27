package factura;

import static org.junit.Assert.*;

import org.junit.Test;

public class FacturaTest {

	@Test
	public void queSePuedaPedirImpuestoSobreArticulo() {
		Articulo art = new Articulo("AB395", 200.0, 1);
		assertEquals((Double)42.0, art.calcularImpuesto()); 
	}
	
	@Test
	public void queSePuedaPedirImpuestoSobreArticuloDeLujo() {
		Articulo art = new ArticuloDeLujo ("DJ457", 500.0, 2);
		assertEquals((Double)360.0, art.calcularImpuesto());
	}

	@Test
	public void queSePuedaCalcularElTotalPorDetalle() {
		Factura factura = new Factura();
		Articulo art = new Articulo("AB395", 200.0, 1); //242
		Articulo art2 = new ArticuloDeLujo ("DJ457", 500.0,2); //1360
		factura.agregarArticulo(art);
		factura.agregarArticulo(art2);
		assertEquals((Double)242.0, factura.calcularTotalPorDetalle(art));
		assertEquals((Double)1360.0, factura.calcularTotalPorDetalle(art2));
	}
	
	@Test
	public void queSePuedaCalcularElTotalDeLaFactura() {
		Factura factura = new Factura();
		Articulo art = new Articulo("AB395", 200.0, 1); //242
		Articulo art2 = new ArticuloDeLujo ("DJ457", 500.0,2); //1360
		factura.agregarArticulo(art);
		factura.agregarArticulo(art2);
		assertEquals((Double)1602.0, factura.calcularTotalDeFactura());
	}
	
	@Test
	public void quePuedaReportarseBasico() {
	Factura factura = new Factura();
	Articulo art = new Articulo("AB395", 200.0, 1); //242
	Articulo art2 = new ArticuloDeLujo ("DJ457", 500.0,2); //1360
	factura.agregarArticulo(art);
	factura.agregarArticulo(art2);
	assertEquals("Codigo articulo: AB395 Precio detalle: 242.0 Cantidad de unidades: 1"
			+ "Codigo articulo: DJ457 Precio detalle: 1360.0 Cantidad de unidades: 2Precio a pagar: 1602.0", 
			factura.reportar(factura));
	}
}
