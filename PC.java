package deustorepara;

public class PC extends Producto {
	protected String tipoProcesador;
	protected int ram;
	protected int disco;

	public PC(String modelo, String marca, String procesador, int ram, int disco) {
		super(modelo, marca);
		this.tipoProcesador = procesador;
		this.ram = ram;
		this.disco = disco;
	}
	
	public PC() {
		super();
		this.tipoProcesador = "N/A";
		this.ram = 0;
		this.disco = 0;
	}

	public String getTipoProcesador() {
		return tipoProcesador;
	}

	public void setProcesador(String procesador) {
		this.tipoProcesador = procesador;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getDisco() {
		return disco;
	}

	public void setDisco(int disco) {
		this.disco = disco;
	}

	@Override
	public String toString() {
		return "PC " + modeloProd + " - " + marcaProd + " (procesador:" + tipoProcesador + ", " + ram + " GB de RAM, " + disco + " GB de disco)";
	}

	@Override
	public int getDificultad() {
		if (ram <= 1) {
			return 5;
		} else if (ram <= 2) {
			return 4;
		} else if (ram <= 4) {
			return 3;
		} else if (ram <= 8) {
			return 2;
		} else {
			return 1;
		} 
	}
	
}
