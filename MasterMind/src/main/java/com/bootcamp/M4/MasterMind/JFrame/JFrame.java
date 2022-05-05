package com.bootcamp.M4.MasterMind.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class JFrame extends javax.swing.JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu archivo, ayuda;
	private JMenuItem nuevoJuego, salir, nivel, comoJugar, acercaDe;
	private JLabel etiqueta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		/* Creamos el JMenuBar y lo asociamos con el JFrame */
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		/*
		 * Creamos el primer JMenu y lo pasamos como parámetro al JMenuBar mediante el
		 * método add
		 */
		archivo = new JMenu("Archivo");
		menuBar.add(archivo);

		ayuda = new JMenu("Ayuda");
		menuBar.add(ayuda);

		/*
		 * Creamos los objetos de la clase JMenuItem y los asociamos con el JMenu
		 * Archivo
		 */
		nuevoJuego = new JMenuItem("Nuevo Juego");
		archivo.add(nuevoJuego);
		nuevoJuego.addActionListener(this);

		salir = new JMenuItem("Salir");
		archivo.add(salir);
		salir.addActionListener(this);

		nivel = new JMenuItem("Nivel");
		archivo.add(nivel);
		nivel.addActionListener(this);

		/*
		 * Creamos los objetos de la clase JMenuItem y los asociamos con el JMenu Ayuda
		 */
		comoJugar = new JMenuItem("Cómo Jugar");
		ayuda.add(comoJugar);
		nuevoJuego.addActionListener(this);

		acercaDe = new JMenuItem("Acerca De");
		ayuda.add(acercaDe);
		acercaDe.addActionListener(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}

	/* Método que implementa las acciones de cada ítem de menú */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nuevoJuego) {
			getContentPane().setBackground(new Color(2, 0, 0));
		}
		if (e.getSource() == salir) {

		}
		if (e.getSource() == nivel) {

		}
		if (e.getSource() == comoJugar) {

		}
		if (e.getSource() == acercaDe) {
			JOptionPane.showMessageDialog(acercaDe, "Desarrolladores: Adrià Queralt, Marc Padrell e Ixabel Justo");

		}
	}
}