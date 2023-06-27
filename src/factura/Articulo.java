package factura;

import java.util.Objects;

public class Articulo {

	protected Double precioConImpuesto = 0.0;
	protected String codigo;
	protected Double precio;
	protected Integer cantidadDeUnidades;

	public Articulo(String codigo, Double precio, Integer cantidadDeUnidades) {
		this.codigo = codigo;
		this.precio = precio;
		this.cantidadDeUnidades = cantidadDeUnidades;
	}
	
	public Double getPrecioConImpuesto() {
		return precioConImpuesto;
	}

	public String getCodigo() {
		return codigo;
	}

	public Double getPrecio() {
		return precio;
	}



	public Integer getCantidadDeUnidades() {
		return cantidadDeUnidades;
	}

	public Double calcularImpuesto() {
		this.precioConImpuesto = ((21 * this.precio) / 100) * this.cantidadDeUnidades;
		return this.precioConImpuesto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
