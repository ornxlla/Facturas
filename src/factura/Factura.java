package factura;

import java.util.HashSet;

public class Factura implements Reportable{
	private Double precioTotal = 0.0;
	private Double precioPorDetalle = 0.0;
	private HashSet <Articulo>articulos = new HashSet<Articulo>();
	
	public void agregarArticulo(Articulo articulo) {
		this.articulos.add(articulo);
	}

	public Double calcularTotalPorDetalle(Articulo articulo) {
		this.precioPorDetalle = (articulo.getPrecio() * articulo.getCantidadDeUnidades()) + articulo.calcularImpuesto();
		return this.precioPorDetalle;
	}

	public Double calcularTotalDeFactura() {
		for(Articulo art :articulos) {
			this.precioTotal += this.calcularTotalPorDetalle(art);
		}
		return this.precioTotal;
	}

	@Override
	public String reportar(Factura factura) {
		String linea = "";
		String precioTotal = "";
		for(Articulo art :articulos) {
			linea += "Codigo articulo: " + art.getCodigo() + " Precio detalle: " + this.calcularTotalPorDetalle(art) + " Cantidad de unidades: " + art.getCantidadDeUnidades();	
		}
		precioTotal = "Precio a pagar: " + this.calcularTotalDeFactura();
		return linea + precioTotal;
	}

	

}
