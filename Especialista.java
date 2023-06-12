package deustorepara;

public class Especialista {
	protected String nom;
	protected int reparaPC;
	protected int reparaMovil;
	protected int reparaTV;
	protected double bonificacion;

	public Especialista(String nom, int reparaPC, int reparaMovil, int reparaTV, double bonificacion) {
		super();
		this.nom = nom;
		this.reparaPC = reparaPC;
		this.reparaMovil = reparaMovil;
		this.reparaTV = reparaTV;
		this.bonificacion = bonificacion;
	}
	
	public Especialista() {
		super();
		this.nom = "";
		this.reparaPC = 0;
		this.reparaMovil = 0;
		this.reparaTV = 0;
		this.bonificacion = 0.0;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nombre) {
		this.nom = nombre;
	}

	public int getReparaPC() {
		return reparaPC;
	}

	public void setReparaPC(int reparaPC) {
		this.reparaPC = reparaPC;
	}

	public int getReparaMovil() {
		return reparaMovil;
	}

	public void setReparaMovil(int reparaMovil) {
		this.reparaMovil = reparaMovil;
	}

	public int getReparaTV() {
		return reparaTV;
	}

	public void setReparaTV(int reparaTV) {
		this.reparaTV = reparaTV;
	}

	public double getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(double bonificacion) {
		this.bonificacion = bonificacion;
	}

	@Override
	public String toString() {
		return nom + ", (PC:" + reparaPC + ", movil:" + reparaMovil
				+ ", TV:" + reparaTV + "), bonificacion:" + bonificacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + reparaMovil;
		result = prime * result + reparaPC;
		result = prime * result + reparaTV;
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
		Especialista other = (Especialista) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (reparaMovil != other.reparaMovil)
			return false;
		if (reparaPC != other.reparaPC)
			return false;
		if (reparaTV != other.reparaTV)
			return false;
		return true;
	}
	
}
