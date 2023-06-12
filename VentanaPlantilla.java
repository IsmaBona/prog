package ventanas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import deustorepara.DeustoRepara;
import deustorepara.Especialista;

public class VentanaPlantilla extends JFrame {
	private static final long serialVersionUID = 1L;
	protected DeustoRepara datos;
	protected JButton botonAnadir;
	protected JButton botonBorrar;
	protected DefaultListModel<Especialista> modeloPlantilla;
	protected JList<Especialista> listaPlantilla;
	
	public void actualizarLista() {
		modeloPlantilla.clear();
		for (Especialista especialista : datos.getEspecialistas()) {
			modeloPlantilla.addElement(especialista);	
		}
	}

	public VentanaPlantilla(DeustoRepara datos) {
		this.datos = datos;
		
		JPanel panelBotones = new JPanel();
		
		botonAnadir = new JButton("Añadir");
		botonBorrar = new JButton("Borrar");
		
		botonAnadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Especialista especialista = new Especialista("Especialista", (int)(Math.random()*5), (int)(Math.random()*5), (int)(Math.random()*5), 0.0);
				datos.getEspecialistas().add(especialista);
				actualizarLista();
			}
		});
		
		botonBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Especialista especialista = listaPlantilla.getSelectedValue();
				if (especialista != null) { 
					datos.getEspecialistas().remove(especialista);
					actualizarLista();
				} else {
					JOptionPane.showMessageDialog(null, "No has seleccionado especialista", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		panelBotones.add(botonAnadir);
		panelBotones.add(botonBorrar);
			
		modeloPlantilla = new DefaultListModel<Especialista>();
		listaPlantilla = new JList<Especialista>(modeloPlantilla);
		JScrollPane scrollPlantilla = new JScrollPane(listaPlantilla);
		actualizarLista();
		
		this.add(scrollPlantilla, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Plantilla");
		this.setSize(850, 350);
		this.setVisible(false);
	}

}
