package deustorepara;

public class TV extends Producto implements Reparable {
	protected double pulgadasTV;

	public TV(String modelo, String marca, double pulgadas) {
		super(modelo, marca);
		this.pulgadasTV = pulgadas;
	}
	
	public TV() {
		super();
	}

	public double getPulgadasTV() {
		return pulgadasTV;
	}

	public void setPulgadas(double pulgadas) {
		this.pulgadasTV = pulgadas;
	}

	@Override
	public String toString() {
		return "TV " + modeloProd + " - " + marcaProd + "(" + pulgadasTV + "\")";
	}

	@Override
	public int getDificultad() {
		int dif = (int) (this.pulgadasTV / 20);
		if (dif > 5) {
			dif = 5;
		}
		return dif;
	}
	
}
