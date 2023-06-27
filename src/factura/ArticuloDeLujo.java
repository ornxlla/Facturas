package factura;

public class ArticuloDeLujo extends Articulo {

	public ArticuloDeLujo(String codigo, Double precio, Integer cantidadDeUnidades) {
		super(codigo, precio, cantidadDeUnidades);
	}

	public Double calcularImpuesto() {
	this.precioConImpuesto = (((21 * this.precio) / 100) + ((15 * this.precio) / 100))  * this.cantidadDeUnidades;
	return this.precioConImpuesto;
	}
}
