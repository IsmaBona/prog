package deustorepara;

public abstract class Producto implements Reparable {
	protected String modeloProd;
	protected String marcaProd;

	public Producto(String modelo, String marca) {
		super();
		this.modeloProd = modelo;
		this.marcaProd = marca;
	}

	public Producto() {
		super();
		this.modeloProd = "Modelo desconocido";
		this.marcaProd = "Marca desconocida";
	}

	public String getModeloProd() {
		return modeloProd;
	}

	public void setModeloProd(String modelo) {
		this.modeloProd = modelo;
	}

	public String getMarcaProd() {
		return marcaProd;
	}

	public void setMarcaProd(String marca) {
		this.marcaProd = marca;
	}

	@Override
	public String toString() {
		return "Producto " + modeloProd + ", " + marcaProd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marcaProd == null) ? 0 : marcaProd.hashCode());
		result = prime * result + ((modeloProd == null) ? 0 : modeloProd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (marcaProd == null) {
			if (other.marcaProd != null)
				return false;
		} else if (!marcaProd.equals(other.marcaProd))
			return false;
		if (modeloProd == null) {
			if (other.modeloProd != null)
				return false;
		} else if (!modeloProd.equals(other.modeloProd))
			return false;
		return true;
	}
	
}
