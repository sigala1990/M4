package com.bootcamp.M4.MasterMind.JFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.bootcamp.M4.MasterMind.ColoresDisponibles.ColoresDisponibles;
import com.bootcamp.M4.MasterMind.EleccionNivel.EleccionNivel;

public class MainJFrame extends javax.swing.JFrame implements ActionListener {
	private static MainJFrame frame;
	private int cantidadColores, cantidadIntentos, cantidadIntentosContador;
	private int posicioColorBotonIntento1, posicioColorBotonIntento2, posicioColorBotonIntento3,
			posicioColorBotonIntento4;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu archivo, ayuda;
	private JMenuItem nuevoJuego, salir, nivel, comoJugar, acercaDe;
	public EleccionNivel eleccionNivel;
	private String instrucciones = "COMO SE JUEGA\n\nEn Mastermind compiten 2 jugadores, uno de \nellos creará un código oculto con 5 clavijas de \ncolores, pudiendo hacer las combinaciones con \nlos 8 colores disponibles e incluso repitiendo \ncolor si lo desea. El código de colores debe de \nocultarse con el escudo para que no pueda verlo \nel oponente, que deberá acertar en el menor \nnúmero posible de jugadas la clave para obtener \nuna buena puntuación. Para descifrar el código \nsecreto de colores el jugador deberá ir probando \ncombinaciones aleatorias de colores, y en cada \ncombinación, el jugador contrario debe darle \npistas mediante las espigas blancas y negras. \nPor cada clavija acertada en color y posición, \ncolocará una espiga negra, y por cada color \nacertado pero en un lugar equivocado colocará \nuna espiga blanca.";
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private List<JButton> listBotonesColoresDisponibles = new ArrayList<JButton>();
	private List<Color> listColoresDisponibles = new ArrayList<Color>();
	private List<JButton> listBotonesCombinacionSecreta = new ArrayList<JButton>();
	private List<Color> listCombinacionSecreta = new ArrayList<Color>();
	private List<JButton> listBotonesIntento = new ArrayList<JButton>();
	private List<Integer> listBotonesIntentPosicion = new ArrayList<Integer>(); 
	private int nombreBottonIntento = 0;

	int xIntento = 50;
	int yIntento = 50;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// frame = new MainJFrame();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainJFrame(int cantidadColores, int cantidadIntentos) {
		this.cantidadColores = cantidadColores;
		this.cantidadIntentos = cantidadIntentos;
		ColoresDisponibles coloresDisponibles = new ColoresDisponibles(cantidadColores);
		rellenarListColoresDisponibles(coloresDisponibles.getArrayColor());
		rellenarListaCombinacionSecreta();

		setDefaultCloseOperation(MainJFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);

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

		nivel = new JMenuItem("Nivel");
		archivo.add(nivel);
		nivel.addActionListener(this);

		salir = new JMenuItem("Salir");
		archivo.add(salir);
		salir.addActionListener(this);

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

		crearBottonesListaColoresDisponibles();
		crearBottonesCombinacionSecreta();
		crearBottonesIntento();
	//	crearBottonesIntento();
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

			eleccionNivel = new EleccionNivel();
			eleccionNivel.setFrame(eleccionNivel);
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

	public void crearBottonesIntento() {

	
		for (int i = 0; i < cantidadColores; i++) {
			JButton btnIntento = new JButton();
			listBotonesIntento.add(btnIntento);
			listBotonesIntentPosicion.add(0);
			listBotonesIntento.get(i).setName("" + nombreBottonIntento);
			listBotonesIntento.get(i).setBounds(xIntento, yIntento, 20, 20);
			
			listBotonesIntento.get(i).addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if (e.getButton() == MouseEvent.BUTTON1) {// izq click
						//System.out.println(((JComponent) e.getSource()).getName()+" Click");
						seleccionarColorIntentoBottonIzquierdo(((JComponent) e.getSource()).getName());
					
					}
					if (e.getButton() == MouseEvent.BUTTON3) {// derecha click
						seleccionarColorIntentoBottonDerecho(((JComponent) e.getSource()).getName());
					}
				}
			});
			{
				contentPane.add(listBotonesIntento.get(i));
				xIntento += 25;
			}
			nombreBottonIntento++;
		} 
		//listBotonesIntento.clear();
		//listBotonesIntentPosicion.clear();
		xIntento = 50;
		yIntento = (yIntento + 20);
		
	}
	public void seleccionarColorIntentoBottonIzquierdo(String StringIDButton) {
		int posicionButton = Integer.parseInt(StringIDButton);
		//listColoresDisponibles
	
		 int contadorPosicion  = listBotonesIntentPosicion.get(posicionButton);// igualem el contador a la posicio que esta
		
		 listBotonesIntento.get(posicionButton).setBackground(listColoresDisponibles.get(contadorPosicion)); //mostrar
		 contadorPosicion++;

		 if(contadorPosicion > cantidadColores-1) {
			 listBotonesIntentPosicion.set(posicionButton, 0);//contador dins de llista (buttonposition)
			 contadorPosicion = 0;
		 }else {
			 listBotonesIntentPosicion.set(posicionButton, contadorPosicion);
		 }
	}
	
	public void seleccionarColorIntentoBottonDerecho(String StringIDButton) {
		int posicionButton = Integer.parseInt(StringIDButton);
		//listColoresDisponibles
	
		 int contadorPosicion  = listBotonesIntentPosicion.get(posicionButton);// igualem el contador a la posicio que esta

		 listBotonesIntento.get(posicionButton).setBackground(listColoresDisponibles.get(contadorPosicion)); //mostrar
		 contadorPosicion--;

		 if(contadorPosicion < 0) {
			 listBotonesIntentPosicion.set(posicionButton, cantidadColores-1);//contador dins de llista (buttonposition)
			 contadorPosicion = cantidadColores-1;
		 }else {
			 listBotonesIntentPosicion.set(posicionButton, contadorPosicion);
		 }
	}
	public void crearBottonesListaColoresDisponibles() {
		int x = 400;
		int y = 50;
		JLabel lbl_coloresDisponibles = new JLabel();
		lbl_coloresDisponibles.setText("Colores Disponibles");
		lbl_coloresDisponibles.setBounds((x - 40), (y - 40), 150, 50);
		contentPane.add(lbl_coloresDisponibles);
		for (int i = 0; i < cantidadColores; i++) {
			JButton btnColorDisponible = new JButton();
			listBotonesColoresDisponibles.add(btnColorDisponible);
			listBotonesColoresDisponibles.get(i).setBounds(x, y, 20, 20);
			listBotonesColoresDisponibles.get(i).setEnabled(false);
			listBotonesColoresDisponibles.get(i).setBackground(listColoresDisponibles.get(i));
			contentPane.add(listBotonesColoresDisponibles.get(i));
			x += 25;
		}
	}

	public void crearBottonesCombinacionSecreta() {
		int x = 400;
		int y = 100;
		JLabel lbl_CombinacionSecreta = new JLabel();
		lbl_CombinacionSecreta.setText("Combinacion Secreta");
		lbl_CombinacionSecreta.setBounds((x - 40), (y - 40), 150, 50);
		contentPane.add(lbl_CombinacionSecreta);
		for (int i = 0; i < cantidadColores; i++) {
			JButton btnCombinacionSecreta = new JButton();
			listBotonesCombinacionSecreta.add(btnCombinacionSecreta);
			listBotonesCombinacionSecreta.get(i).setBounds(x, y, 20, 20);
			listBotonesCombinacionSecreta.get(i).setEnabled(false);
			listBotonesCombinacionSecreta.get(i).setBackground(listCombinacionSecreta.get(i));
			contentPane.add(listBotonesCombinacionSecreta.get(i));
			x += 25;
		}
	}

	public void rellenarListColoresDisponibles(List<String> listColoresDisponibles) {/// OJO con el this, son variables
																						/// distintas
		for (int i = 0; i < listColoresDisponibles.size(); i++) {
			switch (listColoresDisponibles.get(i).toString().toLowerCase()) {
			case "yellow":
				this.listColoresDisponibles.add(Color.yellow);
				break;
			case "white":
				this.listColoresDisponibles.add(Color.white);
				break;
			case "blue":
				this.listColoresDisponibles.add(Color.blue);
				break;
			case "red":
				this.listColoresDisponibles.add(Color.red);
				break;
			case "green":
				this.listColoresDisponibles.add(Color.green);
				break;
			case "pink":
				this.listColoresDisponibles.add(Color.pink);
				break;

			default:
				break;
			}
		}

	}

	public void rellenarListaCombinacionSecreta() {
		for (int i = 0; i < listColoresDisponibles.size(); i++) {
			int posicionRandom = numRandom(0, listColoresDisponibles.size());
			listCombinacionSecreta.add(listColoresDisponibles.get(posicionRandom));
		}
	}

	public int getCantidadColores() {
		return cantidadColores;
	}

	public void setCantidadColores(int cantidadColores) {
		this.cantidadColores = cantidadColores;
	}

	public int getCantidadIntentos() {
		return cantidadIntentos;
	}

	public void setCantidadIntentos(int cantidadIntentos) {
		this.cantidadIntentos = cantidadIntentos;
	}

	public static int numRandom(int min, int max) { // metodo devuelve num random
		return (int) (Math.random() * (max - min) + min);
	}
}