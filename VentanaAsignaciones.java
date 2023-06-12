package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.Border;

import deustorepara.*;

public class VentanaAsignaciones extends JFrame {
	private static final long serialVersionUID = 1L;
	protected DeustoRepara datos;
	protected JComboBox<Averia> comboAverias;
	protected JComboBox<Especialista> comboEspecialistas;
	protected JComboBox<Reparacion> comboReparaciones;
	protected JButton botonAsignar;
	
	public static boolean esApto(Especialista especialista, Averia averia) {
		Reparable reparable = averia.getQueHayQueReparar();
		int dificultad = reparable.getDificultad();
		
		if ( (reparable instanceof PC && especialista.getReparaPC() < dificultad) 
			 || (reparable instanceof Movil && especialista.getReparaMovil() < dificultad) 
			 || (reparable instanceof TV && especialista.getReparaTV() < dificultad) ) {
			return false;
		} else {
			return true;
		}
	}
	
	public void actualizarListas() {
		comboAverias.removeAllItems();
		for(Averia averia : datos.getAverias()) {
			comboAverias.addItem(averia);
		}
		comboEspecialistas.removeAllItems();
		for (Especialista especialista : datos.getEspecialistas()) {
			comboEspecialistas.addItem(especialista);	
		}
		comboReparaciones.removeAllItems();
		for (Reparacion reparacion : datos.getReparaciones()) {
			comboReparaciones.addItem(reparacion);
		}
	}
	
	public VentanaAsignaciones(DeustoRepara datos) {
		this.datos = datos;
		
		JPanel panelAsignaciones = new JPanel();
		panelAsignaciones.setLayout(new GridLayout(1,3));
		JPanel panelReparaciones = new JPanel();
		panelReparaciones.setLayout(new BorderLayout());
		
		comboAverias = new JComboBox<Averia>();
		panelAsignaciones.add(comboAverias, BorderLayout.NORTH);
		Border bordeAverias = BorderFactory.createTitledBorder("Averías pendientes...");
		comboAverias.setBorder(bordeAverias);
		
		comboEspecialistas = new JComboBox<Especialista>();
		panelAsignaciones.add(comboEspecialistas, BorderLayout.NORTH);
		Border bordeEspecialistas = BorderFactory.createTitledBorder("Especialistas...");
		comboEspecialistas.setBorder(bordeEspecialistas);

		comboReparaciones = new JComboBox<Reparacion>();
		panelReparaciones.add(comboReparaciones, BorderLayout.NORTH);
		Border bordeReparaciones = BorderFactory.createTitledBorder("Reparaciones pendientes...");
		panelReparaciones.setBorder(bordeReparaciones);
		
		botonAsignar = new JButton("Asignar");
		
		botonAsignar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Averia averia = (Averia) comboAverias.getSelectedItem();
				Especialista especialista = (Especialista) comboEspecialistas.getSelectedItem();
				
				if (averia != null && especialista != null && esApto(especialista, averia)) {
					Reparacion nueva = new Reparacion();
					nueva.setAveria(averia);
					nueva.setEspecialista(especialista);
					nueva.setFecha(new Date());
					comboReparaciones.addItem(nueva);
					datos.getReparaciones().add(nueva);
					comboAverias.removeItem(averia);
					datos.getAverias().remove(averia);
				} else {
					JOptionPane.showMessageDialog(null, "No se ha podido realizar la asignación", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JPanel panelBotones = new JPanel();
		
		panelBotones.add(botonAsignar);
		
		Border bordeAsignaciones = BorderFactory.createTitledBorder("Asignaciones...");
		panelBotones.setBorder(bordeAsignaciones);
		
		panelAsignaciones.add(panelBotones);
			
		this.add(panelAsignaciones, BorderLayout.NORTH);
		this.add(panelReparaciones, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Asignaciones");
		this.setSize(1000, 200);
		this.setVisible(false);
	}

}
