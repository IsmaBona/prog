package deustorepara;

public class Movil extends Producto {
	protected String tipoProcesador;
	protected double pulgadas;
	
	public Movil(String modelo, String marca, String procesador, double pulgadas) {
		super(modelo, marca);
		this.tipoProcesador = procesador;
		this.pulgadas = pulgadas;
	}
	
	public Movil() {
		super();
		this.tipoProcesador = "N/A";
		this.pulgadas = 0.0;
	}

	public String getTipoProcesador() {
		return tipoProcesador;
	}

	public void setTipoProcesador(String tipoProcesador) {
		this.tipoProcesador = tipoProcesador;
	}

	public double getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}

	@Override
	public String toString() {
		return  "Móvil " + modeloProd + " - " + marcaProd + " (procesador:" + tipoProcesador + ", " + pulgadas + "\")";
	}

	@Override
	public int getDificultad() {
		int dif = (int) this.pulgadas;
		if (dif > 5) {
			dif = 5;
		}
		return dif;
	}
	
}
