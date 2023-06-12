package deustorepara;

public class Averia {
	protected Reparable queHayQueReparar;

	public Averia(Reparable reparable) {
		super();
		this.queHayQueReparar = reparable;
	}
	
	public Averia() {
		super();
		this.queHayQueReparar = null;
	}

	public Reparable getQueHayQueReparar() {
		return queHayQueReparar;
	}

	public void setQueHayQueReparar(Reparable reparable) {
		this.queHayQueReparar = reparable;
	}

	@Override
	public String toString() {
		return "Averia " + queHayQueReparar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((queHayQueReparar == null) ? 0 : queHayQueReparar.hashCode());
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
		Averia other = (Averia) obj;
		if (queHayQueReparar == null) {
			if (other.queHayQueReparar != null)
				return false;
		} else if (!queHayQueReparar.equals(other.queHayQueReparar))
			return false;
		return true;
	}
	
}
