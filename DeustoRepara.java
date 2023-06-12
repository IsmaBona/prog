package deustorepara;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeustoRepara {
	protected ArrayList<Especialista> listaEspecialistas;
	protected ArrayList<Averia> listaAverias;
	protected ArrayList<Reparacion> listaReparaciones;
	
	public DeustoRepara(ArrayList<Especialista> especialistas, ArrayList<Averia> averias, ArrayList<Reparacion> reparaciones) {
		super();
		this.listaEspecialistas = new ArrayList<Especialista>();
		for (Especialista especialista : especialistas) {
			this.listaEspecialistas.add(especialista);
		}
		this.listaAverias = new ArrayList<Averia>();
		for (Averia averia : averias) {
			this.listaAverias.add(averia);
		}
		this.listaReparaciones = new ArrayList<Reparacion>();
		for (Reparacion reparacion : reparaciones) {
			this.listaReparaciones.add(reparacion);
		}
	}
	
	public DeustoRepara() {
		super();
		this.listaEspecialistas = new ArrayList<Especialista>();
		this.listaAverias = new ArrayList<Averia>();
		this.listaReparaciones = new ArrayList<Reparacion>();
	}

	public ArrayList<Especialista> getEspecialistas() {
		return listaEspecialistas;
	}

	public void setEspecialistas(ArrayList<Especialista> especialistas) {
		this.listaEspecialistas = especialistas;
	}

	public ArrayList<Averia> getAverias() {
		return listaAverias;
	}

	public void setAverias(ArrayList<Averia> averias) {
		this.listaAverias = averias;
	}
	
	public ArrayList<Reparacion> getReparaciones() {
		return listaReparaciones;
	}

	public void setReparaciones(ArrayList<Reparacion> reparaciones) {
		this.listaReparaciones = reparaciones;
	}

	@Override
	public String toString() {
		return "DeustoRepara [especialistas=" + listaEspecialistas + ", averias=" + listaAverias + ", reparaciones="
				+ listaReparaciones + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaAverias == null) ? 0 : listaAverias.hashCode());
		result = prime * result + ((listaEspecialistas == null) ? 0 : listaEspecialistas.hashCode());
		result = prime * result + ((listaReparaciones == null) ? 0 : listaReparaciones.hashCode());
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
		DeustoRepara other = (DeustoRepara) obj;
		if (listaAverias == null) {
			if (other.listaAverias != null)
				return false;
		} else if (!listaAverias.equals(other.listaAverias))
			return false;
		if (listaEspecialistas == null) {
			if (other.listaEspecialistas != null)
				return false;
		} else if (!listaEspecialistas.equals(other.listaEspecialistas))
			return false;
		if (listaReparaciones == null) {
			if (other.listaReparaciones != null)
				return false;
		} else if (!listaReparaciones.equals(other.listaReparaciones))
			return false;
		return true;
	}

	public void cargaAverias(String fichero) {
		/*
		 * Formato del fichero:
		 * reparable;propiedades
		 * PC;Aspire;Acer;Intel i5;16;512;
		 * Movil;iPhone 14;Apple;A16;6.7;
		 * TV;Smart TV P1;Xiaomi;55;
		 * Software;Windows;11;
		 */
		try {
			Scanner sc = new Scanner(new File(fichero));
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				Averia averia = new Averia();
				Reparable reparable;
				if (campos[0].equals("PC")) {
					reparable = new PC();
					((Producto) reparable).setModeloProd(campos[1]);
					((Producto) reparable).setMarcaProd(campos[2]);
					((PC) reparable).setProcesador(campos[3]);
					((PC) reparable).setRam(Integer.parseInt(campos[4]));
					((PC) reparable).setDisco(Integer.parseInt(campos[5]));
				} else if (campos[0].equals("Movil")) {
					reparable = new Movil();
					((Producto) reparable).setModeloProd(campos[1]);
					((Producto) reparable).setMarcaProd(campos[2]);
					((Movil) reparable).setTipoProcesador(campos[3]);
					((Movil) reparable).setPulgadas(Double.parseDouble(campos[4]));
				} else {
					reparable = new TV();
					((Producto) reparable).setModeloProd(campos[1]);
					((Producto) reparable).setMarcaProd(campos[2]);
					((TV) reparable).setPulgadas(Double.parseDouble(campos[3]));
				} // TAREA 1
				averia.setQueHayQueReparar(reparable);
				this.listaAverias.add(averia);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error al cargar averías");
		}
	}
	
}
