package ventanas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import deustorepara.DeustoRepara;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	protected DeustoRepara datos;
	protected JButton botonEspecialistas;
	protected JButton botonAverias;
	protected JButton botonReparaciones;
	protected JLabel labelLogo;
	protected VentanaPlantilla ventanaPlantilla;
	protected VentanaAverias ventanaAverias;
	protected VentanaAsignaciones ventanaAsignaciones;
	
	public VentanaPrincipal() {
		this.datos = new DeustoRepara();
		this.ventanaPlantilla = new VentanaPlantilla(datos);
		this.ventanaAverias = new VentanaAverias(datos);
		this.ventanaAsignaciones = new VentanaAsignaciones(datos);
				
		JPanel panelBotonesVentanas = new JPanel();
		
		botonEspecialistas = new JButton("Gestionar especialistas");
		botonAverias = new JButton("Ver averías");
		botonReparaciones = new JButton("Asignar reparaciones");
		
		botonEspecialistas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPlantilla.actualizarLista();
				ventanaPlantilla.setVisible(true);
			}
		});
		
		botonAverias.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaAverias.actualizarLista();
				ventanaAverias.setVisible(true);
			}
		});
		
		botonReparaciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaAsignaciones.actualizarListas();
				ventanaAsignaciones.setVisible(true);
			}
		});
		
		panelBotonesVentanas.add(botonEspecialistas);
		panelBotonesVentanas.add(botonAverias);
		panelBotonesVentanas.add(botonReparaciones);
		
		labelLogo = new JLabel(new ImageIcon("deustorepara.png"));
		
		this.add(panelBotonesVentanas, BorderLayout.NORTH);
		this.add(labelLogo, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("DeustoRepara");
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
}

