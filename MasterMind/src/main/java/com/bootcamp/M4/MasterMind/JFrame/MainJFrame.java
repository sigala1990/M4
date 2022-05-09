package com.bootcamp.M4.MasterMind.JFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bootcamp.M4.MasterMind.AcercaDe.AcercaDe;
import com.bootcamp.M4.MasterMind.Ayuda.Ayuda;
import com.bootcamp.M4.MasterMind.ColoresDisponibles.ColoresDisponibles;
import com.bootcamp.M4.MasterMind.EleccionNivel.EleccionNivel;
import com.bootcamp.M4.MasterMind.Palette.Palette;

public class MainJFrame extends javax.swing.JFrame implements ActionListener {
	public EleccionNivel eleccionNivel;

	private static MainJFrame frame;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu archivo, ayuda, palette;
	private JMenuItem nuevoJuego, salir, nivel, comoJugar, acercaDe, cambiarPalette;
	// private String instrucciones = "COMO SE JUEGA\n\nEn Mastermind compiten 2
	// jugadores, uno de \nellos creará un código oculto con 5 clavijas de
	// \ncolores, pudiendo hacer las combinaciones con \nlos 8 colores disponibles e
	// incluso repitiendo \ncolor si lo desea. El código de colores debe de
	// \nocultarse con el escudo para que no pueda verlo \nel oponente, que deberá
	// acertar en el menor \nnúmero posible de jugadas la clave para obtener \nuna
	// buena puntuación. Para descifrar el código \nsecreto de colores el jugador
	// deberá ir probando \ncombinaciones aleatorias de colores, y en cada
	// \ncombinación, el jugador contrario debe darle \npistas mediante las espigas
	// blancas y negras. \nPor cada clavija acertada en color y posición, \ncolocará
	// una espiga negra, y por cada color \nacertado pero en un lugar equivocado
	// colocará \nuna espiga blanca.";
	private List<JButton> listBotonesColoresDisponibles = new ArrayList<JButton>();
	private List<Color> listColoresDisponibles = new ArrayList<Color>();
	private List<JButton> listBotonesCombinacionSecreta = new ArrayList<JButton>();
	private List<Color> listCombinacionSecreta = new ArrayList<Color>();
	private List<JButton> listBotonesIntento = new ArrayList<JButton>();
	private List<Integer> listBotonesIntentPosicion = new ArrayList<Integer>();
	private List<JButton> listBotonesBlanco = new ArrayList<JButton>();
	private List<JButton> listBotonesNegro = new ArrayList<JButton>();
	private List<JButton> listBotonesCheck = new ArrayList<JButton>();
	private boolean win;
	private boolean desbloquearPalette;
	private boolean mostrarCombinacionSecreta;
	private int numeroBottonesAMostrar = 4;
	private int cantidadColores, cantidadIntentos, cantidadIntentosContador;
	private int incrementoPosicion = 0;
	private int nombreBottonIntento = 0;
	private int xIntento = 50;
	private int yIntento = 50;
	private JLabel lblLeftRight;

	// Lanzar la aplicación
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

	// Crear el frame
	public MainJFrame(int cantidadColores, int cantidadIntentos) {
		setTitle("MasterMind");
		this.cantidadColores = cantidadColores;
		this.cantidadIntentos = cantidadIntentos;
		win = false;
		ColoresDisponibles coloresDisponibles = new ColoresDisponibles(cantidadColores);
		rellenarListColoresDisponibles(coloresDisponibles.getArrayColor());
		rellenarListaCombinacionSecreta();

		setDefaultCloseOperation(MainJFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);

		/* Creamos el JMenuBar y lo asociamos con el JFrame */
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		/*
		 * Creamos el primer JMenu y lo pasamos como parámetro al JMenuBar mediante el
		 * método add
		 */
		archivo = new JMenu("Archivo");
		menuBar.add(archivo);

		palette = new JMenu("Palette");
		menuBar.add(palette);

		ayuda = new JMenu("Ayuda");
		menuBar.add(ayuda);
		/*
		 * Creamos los objetos de la clase JMenuPalette y los asociamos con el JMenu
		 * Palette
		 */
		cambiarPalette = new JMenuItem("Cambiar colores");
		palette.add(cambiarPalette);
		palette.setVisible(false);
		cambiarPalette.addActionListener(this);
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
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblLeftRight = new JLabel("");
		lblLeftRight.setBounds(50, 30, 150, 20);
		contentPane.add(lblLeftRight);

		crearBottonesListaColoresDisponibles();
		crearBottonesCombinacionSecreta();
		crearBottonesIntento();

	}

	/* Método que implementa las acciones de cada ítem de menú */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cambiarPalette) {
			Palette palette = new Palette(listColoresDisponibles, cantidadColores, this);
			palette.setVisible(true);
		}

		if (e.getSource() == nuevoJuego) {
			nuevoJuego();
		}
		if (e.getSource() == salir) {
			System.exit(0);
			// Salir del juego
		}
		if (e.getSource() == nivel) {
			nivel();// Abre una ventana para seleccionar nivel
		}

		if (e.getSource() == acercaDe) {

			AcercaDe acercaDe = new AcercaDe();
			acercaDe.setVisible(true);
		}

		if (e.getSource() == comoJugar) {
			Ayuda ayuda = new Ayuda();
			ayuda.setVisible(true);

		}
	}

	public void crearBottonesIntento() {
		for (int i = incrementoPosicion; i < incrementoPosicion + numeroBottonesAMostrar; i++) {
			JButton btnIntento = new JButton();
			listBotonesIntento.add(btnIntento);
			listBotonesIntentPosicion.add(0);// lista que sirve para validarlo
			listBotonesIntento.get(i).setBackground(Color.white);
			listBotonesIntento.get(i).setName("" + nombreBottonIntento);
			nombreBottonIntento++;
			listBotonesIntento.get(i).setBounds(xIntento, yIntento, 20, 20);
			listBotonesIntento.get(i).addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseClicked(MouseEvent e) {

					if (e.getButton() == MouseEvent.BUTTON1) {// izq click
						seleccionarColorIntentoBottonIzquierdo(((JComponent) e.getSource()).getName());
						lblLeftRight.setText("Boton izq");

					}
					if (e.getButton() == MouseEvent.BUTTON3) {// derecha click
						seleccionarColorIntentoBottonDerecho(((JComponent) e.getSource()).getName());
						lblLeftRight.setText("Boton derecha");
					}
				}
			});
			contentPane.add(listBotonesIntento.get(i));
			xIntento += 25;

		}

		crearBottonComprobar();

		// Inicialiar los ejes X e Y en una posición concreta
		xIntento = 50;
		yIntento = (yIntento + 25);
		repaint();

	}

	public void crearBottonComprobar() {

		JButton btnComprobarIntento = new JButton();
		listBotonesCheck.add(btnComprobarIntento);
		btnComprobarIntento.setText("Check");
		btnComprobarIntento.setBounds(xIntento, yIntento, 80, 20);
		btnComprobarIntento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Control de intentos
				boolean noEsWhite = true;
				for (int i = 0; i < listBotonesIntento.size(); i++) {
					if (listBotonesIntento.get(i).getBackground() == Color.white) {
						noEsWhite = false;
					}
				}
				if (noEsWhite) {// control todos los colores seleccionados

					if (cantidadIntentos > cantidadIntentosContador) {

						/*
						 * Bucle para comprobar los colores que se han acertado, estén o no en la
						 * posición correcta
						 */
						for (int i = 0; i < comprobarColoresBlancos(); i++) {
							JButton btn = new JButton();
							listBotonesBlanco.add(btn);
							btn.setBackground(Color.white);
							btn.setEnabled(false);
							contentPane.add(btn);
							contentPane.setComponentZOrder(btn, 2);
							btn.setBounds((xIntento + 250), yIntento - 20, 20, 20);
							xIntento += 25;
						}
						xIntento = xIntento - (25 * comprobarColoresBlancos());

						/*
						 * Bucle para comprobar los colores que se han acertado, y que además están en
						 * la posición correcta
						 */
						for (int i = 0; i < comprobarColoresNegros(); i++) {
							JButton btn = new JButton();
							listBotonesNegro.add(btn);
							btn.setEnabled(false);
							btn.setBackground(Color.black);
							contentPane.add(btn);
							contentPane.setComponentZOrder(btn, 1);
							btn.setBounds((xIntento + 250), yIntento - 20, 20, 20);
							xIntento += 25;
						}
						xIntento = xIntento - (25 * comprobarColoresNegros());

						/*
						 * Cuando ganas por primera vez, se desbloquea la opción de utilizar la paleta
						 * de colores
						 */
						if (win) {
							String msgPalette = "";
							if (!desbloquearPalette) {
								desbloquearPalette = true;
								msgPalette = "\nHAS DESBLOQUEADO LA NUEVA OPCION PALETTE";
							} else {
								msgPalette = "";
							}

							JOptionPane.showMessageDialog(null, "¡¡VICTORIA!!" + msgPalette);
							mostrarCombinacionSecreta = false;
							nuevoJuego();
						} else {

							cantidadIntentosContador++;
							incrementoPosicion = incrementoPosicion + numeroBottonesAMostrar;
							crearBottonesIntento();
							btnComprobarIntento.setVisible(false);
						}
					} else {
						JOptionPane.showMessageDialog(null, "GAME OVER");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debes poner todos los colores");
				}
			}
		});

		contentPane.add(btnComprobarIntento);

		// Botón de información
		JButton btnInfo1 = new JButton("Info1");

		btnInfo1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				System.out.println("________________INTENTO" + cantidadIntentosContador + "____________________");

				// Bucle para mostrar la cantidad de intentos que se han hecho
				for (int i = 0; i < listBotonesIntento.size(); i++) {
					System.out.print(listBotonesIntento.get(i).getName() + " "
							+ listBotonesIntento.get(i).getBackground() + "\t");
				}
				System.out.println(
						"\nIncremento posicion = " + incrementoPosicion + "CantidadColores = " + cantidadColores);
				System.out.println("\nx" + xIntento + " \ty" + yIntento + "\n" + "CantidadIntentos = "
						+ cantidadIntentos + " cantidadIntentosContador = " + cantidadIntentosContador);
				System.out.println("_________________________________________________________________________");

				// Bucle para ocultar los botones blancos
				for (int j = 0; j < listBotonesBlanco.size(); j++) {
					listBotonesBlanco.get(j).setVisible(false);
				}
			}
		});

		btnInfo1.setBounds(251, 300, 89, 23);
		contentPane.add(btnInfo1);

		JButton btnInfo2 = new JButton("Info2");

		btnInfo2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("blanco " + comprobarColoresBlancos());
				System.out.println("negro" + comprobarColoresNegros());
			}
		});

		btnInfo2.setBounds(356, 300, 89, 23);
		contentPane.add(btnInfo2);
		repaint();
	}

	/*
	 * Método que devuelve un int que equivale a los botones blancos, es decir, los
	 * que se ha acertado el color, esté o no en la posición correcta
	 */
	public int comprobarColoresBlancos() {
		int contadorBlanco = 0;
		boolean encontrado = false;

		// Bucle anidado para comprobar que el color sea correcto en cualquier posición
		for (int i = 0; i < listCombinacionSecreta.size(); i++) {
			encontrado = false;

			for (int j = incrementoPosicion; j < incrementoPosicion + listCombinacionSecreta.size(); j++) {
				if (listCombinacionSecreta.get(i) == listBotonesIntento.get(j).getBackground() && encontrado == false) {
					contadorBlanco++;
					encontrado = true;
				}
			}
		}

		repaint();
		return contadorBlanco;
	}

	/*
	 * Método que devuelve un int que equivale a los botones negros, es decir, los
	 * que se ha acertado el color y además está en la posición correcta
	 */
		public int comprobarColoresNegros() {
			
		//Inicialiar los contadores a 0
		int contadorNegro = 0;
		int contadorI = 0;
		
		//Bucle para comprobar
		for (int i = incrementoPosicion; i < incrementoPosicion + listCombinacionSecreta.size(); i++) {
			if (listBotonesIntento.get(i).getBackground() == listCombinacionSecreta.get(contadorI)) {
				contadorNegro++;
			}
			contadorI++;
		}

		if (contadorNegro == numeroBottonesAMostrar) {
			win = true;
			palette.setVisible(true);
		}
		repaint();
		return contadorNegro;
	}

	
	public void seleccionarColorIntentoBottonIzquierdo(String StringIDButton) {
		
		int posicionButton = Integer.parseInt(StringIDButton);
		
		// Igualar el contador a la posición que esté
		int contadorPosicion = listBotonesIntentPosicion.get(posicionButton);
		contadorPosicion++;

		if (contadorPosicion > cantidadColores - 1) {
			//Contador dentro de la lista (buttonposition)
			listBotonesIntentPosicion.set(posicionButton, 0);
			contadorPosicion = 0;
		} else {
			listBotonesIntentPosicion.set(posicionButton, contadorPosicion);
		}
		// Mostrar
		listBotonesIntento.get(posicionButton).setBackground(listColoresDisponibles.get(contadorPosicion)); 
	}

	public void seleccionarColorIntentoBottonDerecho(String StringIDButton) {
		int posicionButton = Integer.parseInt(StringIDButton);

		// Igualar el contador a la posición que está
		int contadorPosicion = listBotonesIntentPosicion.get(posicionButton);
		contadorPosicion--;
		
		//Contador dentro de la lista (buttonposition)
		if (contadorPosicion < 0) {
			listBotonesIntentPosicion.set(posicionButton, cantidadColores - 1);
			contadorPosicion = cantidadColores - 1;
		} else {
			listBotonesIntentPosicion.set(posicionButton, contadorPosicion);
		}
		//Mostrar
		listBotonesIntento.get(posicionButton).setBackground(listColoresDisponibles.get(contadorPosicion)); 
	}

	//Método para crear una lista con los colores disponibles
	public void crearBottonesListaColoresDisponibles() {
		
		//Inicializar los ejes X e Y en una posición concreta
		int x = 500;
		int y = 50;
		
		//Etiqueta para los colores disponibles
		JLabel lbl_coloresDisponibles = new JLabel();
		lbl_coloresDisponibles.setText("Colores Disponibles");
		lbl_coloresDisponibles.setBounds((x - 40), (y - 40), 150, 50);
		//Añadir la etiqueta al panel
		contentPane.add(lbl_coloresDisponibles);
		
		//Bucle de colores disponibles según la cantidad de colores (que dependerá de la dificultad)
		for (int i = 0; i < cantidadColores; i++) {
			
			//Crear botón de Color Disponible
			JButton btnColorDisponible = new JButton();
			
			listBotonesColoresDisponibles.add(btnColorDisponible);
			listBotonesColoresDisponibles.get(i).setBounds(x, y, 20, 20);
			listBotonesColoresDisponibles.get(i).setEnabled(false);
			listBotonesColoresDisponibles.get(i).setBackground(listColoresDisponibles.get(i));
			contentPane.add(listBotonesColoresDisponibles.get(i));
			x += 25;
		}
	}

	//Método para crear los botones de la combinación secreta
	public void crearBottonesCombinacionSecreta() {
		
		//Inicializar los ejes X e Y en una posición concreta
		int x = 500;
		int y = 100;
		
		//Etiqueta para la combinación secreta
		JLabel lbl_CombinacionSecreta = new JLabel();
		lbl_CombinacionSecreta.setText("Combinacion Secreta");
		lbl_CombinacionSecreta.setBounds((x - 40), (y - 40), 150, 50);
		
		//Añadir la etiqueta al panel
		contentPane.add(lbl_CombinacionSecreta);

		/*Bucle para mostrar los colores de la combinación secreta dependiendo de la 
		cantidad de colores que sean (según la dificultad)*/
		for (int i = 0; i < numeroBottonesAMostrar; i++) {
			JButton btnCombinacionSecreta = new JButton();
			btnCombinacionSecreta.setVisible(false);
			listBotonesCombinacionSecreta.add(btnCombinacionSecreta);
			listBotonesCombinacionSecreta.get(i).setBounds(x, y, 20, 20);
			listBotonesCombinacionSecreta.get(i).setEnabled(false);
			listBotonesCombinacionSecreta.get(i).setBackground(listCombinacionSecreta.get(i));
			contentPane.add(listBotonesCombinacionSecreta.get(i));
			x += 25;
		}
		
		//Añadir botón de Pista
		JButton btnPista = new JButton();
		//Añadir un icono al botón de Pista que activará el método mostrarCombinacionSecreta()
		btnPista.setIcon(new ImageIcon(
				MainJFrame.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-information.png")));
		btnPista.setBounds(x + 30, y - 20, 40, 40);
		btnPista.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarCombinacionSecreta();
			}
		});
		contentPane.add(btnPista);
	}

	//Método para mostrar la combinación secreta
	public void mostrarCombinacionSecreta() {
		for (int i = 0; i < listBotonesCombinacionSecreta.size(); i++) {
			listBotonesCombinacionSecreta.get(i).setVisible(!mostrarCombinacionSecreta);
		}
		mostrarCombinacionSecreta = !mostrarCombinacionSecreta;
	}

	//Método para rellenar la lista de colores disponibles
	public void rellenarListColoresDisponibles(List<String> listColoresDisponibles) {/// OJO con el this, son variables
																						/// distintas
		for (int i = 0; i < listColoresDisponibles.size(); i++) {
			switch (listColoresDisponibles.get(i).toString().toLowerCase()) {
			case "yellow":
				this.listColoresDisponibles.add(Color.yellow);
				break;
			case "magenta":
				this.listColoresDisponibles.add(Color.magenta);
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

	//Método para rellenar la lista de la combinación secreta
	public void rellenarListaCombinacionSecreta() {
		
		//Bucle que ubica los colores en posición aleatoria
		for (int i = 0; i < numeroBottonesAMostrar; i++) {
			int posicionRandom = numRandom(0, listColoresDisponibles.size());
			listCombinacionSecreta.add(listColoresDisponibles.get(posicionRandom));
		}
	}

	//Método para resetear la lista de botones
	public void limpiezaListBotones(List<JButton> list) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setVisible(false);
		}
		list.clear();
	}

	//Método para seleccionar el nivel de dificultad
	public void nivel() {
		
		//Crear un objeto de la clase EleccionNivel
		EleccionNivel eleccionNivel = new EleccionNivel();
		
		eleccionNivel.setFrame(eleccionNivel);
		eleccionNivel.setVisible(true);
		frame.setVisible(false);
	}

	//Método para iniciar una nueva partida
	public void nuevoJuego() {
		//Se terminará la partida actual
		reset();

		//Se volverán a generar todos los colores, botones, etc
		actualizarColoresDisponibles();
		rellenarListaCombinacionSecreta();
		crearBottonesListaColoresDisponibles();
		crearBottonesCombinacionSecreta();
		crearBottonesIntento();
	}

	//Método para actualizar los colores escogidos por el usuario
	public void actualizarColoresPersonalizados() {
		//Eliminar la selección que había
		reset();

		//Volver a rellenar las listas
		rellenarListaCombinacionSecreta();
		crearBottonesListaColoresDisponibles();
		crearBottonesCombinacionSecreta();
		crearBottonesIntento();
	}

	//Método para resetear los valores asignados previamente
	public void reset() {
		limpiezaListBotones(listBotonesColoresDisponibles);
		limpiezaListBotones(listBotonesCombinacionSecreta);
		limpiezaListBotones(listBotonesIntento);
		limpiezaListBotones(listBotonesBlanco);
		limpiezaListBotones(listBotonesNegro);
		limpiezaListBotones(listBotonesCheck);
		
		listCombinacionSecreta.clear();
		listBotonesIntentPosicion.clear();

		win = false;
		mostrarCombinacionSecreta = false;
		incrementoPosicion = 0;
		nombreBottonIntento = 0;
		cantidadIntentosContador = 0;
		yIntento = 50;
		xIntento = 50;
		lblLeftRight.setText("");
	}

	//Método para actualizar los colores disponibles
	public void actualizarColoresDisponibles() {
		listColoresDisponibles.clear();
		ColoresDisponibles coloresDisponibles = new ColoresDisponibles(cantidadColores);
		rellenarListColoresDisponibles(coloresDisponibles.getArrayColor());
	}

	
	//Método para obtener la cantidad de colores
	public int getCantidadColores() {
		return cantidadColores;
	}

	//Método para definir la cantidad de colores
	public void setCantidadColores(int cantidadColores) {
		this.cantidadColores = cantidadColores;
	}

	//Método para obtener la cantidad de intentos
	public int getCantidadIntentos() {
		return cantidadIntentos;
	}

	public void setCantidadIntentos(int cantidadIntentos) {
		this.cantidadIntentos = cantidadIntentos;
	}

	
	//Método que devuelve un número aleatorio
	public static int numRandom(int min, int max) { 
		return (int) (Math.random() * (max - min) + min);
	}

	
	//Método que retorna el frame
	public static MainJFrame getFrame() {
		return frame;
	}

	//Método que define el frame
	public void setFrame(MainJFrame frame) {
		MainJFrame.frame = frame;
	}

	//Método que retorna la lista de colores disponibles
	public List<Color> getListColoresDisponibles() {
		return listColoresDisponibles;
	}

	//Método que define la lista de colores disponibles
	public void setListColoresDisponibles(List<Color> listColoresDisponibles) {
		this.listColoresDisponibles = listColoresDisponibles;
	}
}