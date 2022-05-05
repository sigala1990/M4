package com.bootcamp.M4.MasterMind.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
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
	private JLabel lblMensajes;
	private String instrucciones = "COMO SE JUEGA\nEn Mastermind compiten 2 jugadores, uno de ellos creará un código oculto con 5 clavijas de colores, pudiendo hacer las combinaciones con los 8 colores disponibles e incluso repitiendo color si lo desea. El código de colores debe de ocultarse con el escudo para que no pueda verlo el oponente, que deberá acertar en el menor número posible de jugadas la clave para obtener una buena puntuación. Para descifrar el código secreto de colores el jugador deberá ir probando combinaciones aleatorias de colores, y en cada combinación, el jugador contrario debe darle pistas mediante las espigas blancas y negras. Por cada clavija acertada en color y posición, colocará una espiga negra, y por cada color acertado pero en un lugar equivocado colocara una espiga blanca.";

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
		nuevoJuego.addActionListener(this);

		acercaDe = new JMenuItem("Acerca De");
		ayuda.add(acercaDe);
		acercaDe.addActionListener(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMensajes = new JLabel("");
		lblMensajes.setBounds(48, 35, 363, 193);
		contentPane.add(lblMensajes);

	}

	/* Método que implementa las acciones de cada ítem de menú */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nuevoJuego) {
			getContentPane().setBackground(new Color(2, 0, 0));
		}
		if (e.getSource() == salir) {
			System.exit(0);
			//Salir del juego
		}
		if (e.getSource() == nivel) {
			
			EleccionNivel eleccionNivel = new EleccionNivel();
			eleccionNivel.setVisible(true); //Abre una ventana para seleccionar nivel

		}
		if (e.getSource() == comoJugar) {
			lblMensajes.setText("Cómo se juega"); 
			//Muestra las instrucciones
		}
		if (e.getSource() == acercaDe) {
			lblMensajes.setText("Desarrolladores: Adrià Queralt, Marc Padrell e Ixabel Justo");
			//Muestra nuestros nombres
		}
	}
}