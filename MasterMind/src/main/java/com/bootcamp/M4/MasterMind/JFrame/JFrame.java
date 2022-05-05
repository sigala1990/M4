package com.bootcamp.M4.MasterMind.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.bootcamp.M4.MasterMind.EleccionNivel.EleccionNivel;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class JFrame extends javax.swing.JFrame implements ActionListener {
	private static JFrame frame;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu archivo, ayuda;
	private JMenuItem nuevoJuego, salir, nivel, comoJugar, acercaDe;
	private String instrucciones = "COMO SE JUEGA\n\nEn Mastermind compiten 2 jugadores, uno de \nellos creará un código oculto con 5 clavijas de \ncolores, pudiendo hacer las combinaciones con \nlos 8 colores disponibles e incluso repitiendo \ncolor si lo desea. El código de colores debe de \nocultarse con el escudo para que no pueda verlo \nel oponente, que deberá acertar en el menor \nnúmero posible de jugadas la clave para obtener \nuna buena puntuación. Para descifrar el código \nsecreto de colores el jugador deberá ir probando \ncombinaciones aleatorias de colores, y en cada \ncombinación, el jugador contrario debe darle \npistas mediante las espigas blancas y negras. \nPor cada clavija acertada en color y posición, \ncolocará una espiga negra, y por cada color \nacertado pero en un lugar equivocado colocará \nuna espiga blanca.";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JFrame();
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
		comoJugar.addActionListener(this);

		acercaDe = new JMenuItem("Acerca De");
		ayuda.add(acercaDe);
		acercaDe.addActionListener(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	/* Método que implementa las acciones de cada ítem de menú */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nuevoJuego) {
			// JuegoNuevo juegonuevo = new JuegoNuevo();
			// juegoNuevo.setVisible(true);
		}
		if (e.getSource() == salir) {
			System.exit(0);
			// Salir del juego
		}
		if (e.getSource() == nivel) {

			EleccionNivel eleccionNivel = new EleccionNivel();
			eleccionNivel.setVisible(true); // Abre una ventana para seleccionar nivel

		}
		
		if (e.getSource() == acercaDe) {
			JOptionPane.showMessageDialog(null, "Desarrolladores: Adrià Queralt, Marc Padrell e Ixabel Justo");
			// Muestra nuestros nombres
		}
		
		if (e.getSource() == comoJugar) {
		
		  // create a JTextArea
	      JTextArea textArea = new JTextArea(6, 25);
	      textArea.setText(instrucciones);
	      textArea.setEditable(false);
	      
	      // wrap a scrollpane around it
	      JScrollPane scrollPane = new JScrollPane(textArea);
	      
	      // display them in a message dialog
	      JOptionPane.showMessageDialog(frame, scrollPane);
		}
	}
}