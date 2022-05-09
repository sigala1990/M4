package com.bootcamp.M4.MasterMind.EleccionNivel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import com.bootcamp.M4.MasterMind.JFrame.MainJFrame;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EleccionNivel extends JFrame {

	//Definir los atributos
	public static EleccionNivel frame;
	private JPanel contentPane;
	private int cantidadColores = 4;
	private int cantidadIntentos = 10;
	private JButton btnCancelar;
	private boolean mainJframeOpen = false;

	
	//Lanzar la aplicación
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EleccionNivel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Crear el Frame
	public EleccionNivel() {
		setTitle("Seleccion de dificultad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Grupo de niveles de selección de dificultad, que englobará los tres botones siguientes
		ButtonGroup nivelesDificultad = new ButtonGroup();

		//Botón de nivel Principiante
		JRadioButton rdbtnNivelPrincipiante = new JRadioButton("Principiante");
		rdbtnNivelPrincipiante.setBackground(SystemColor.activeCaption);
		
		rdbtnNivelPrincipiante.setBounds(120, 66, 109, 23);
		contentPane.add(rdbtnNivelPrincipiante);

		//Botón de nivel Intermedio
		JRadioButton rdbtnNivelMedio = new JRadioButton("Medio");
		rdbtnNivelMedio.setBackground(SystemColor.activeCaption);
		rdbtnNivelMedio.setBounds(120, 94, 109, 23);
		
		contentPane.add(rdbtnNivelMedio);
		rdbtnNivelMedio.setSelected(true);

		//Botón de nivel Avanzado
		JRadioButton rdbtnNivelAvanzado = new JRadioButton("Avanzado");
		rdbtnNivelAvanzado.setBackground(SystemColor.activeCaption);
		rdbtnNivelAvanzado.setBounds(120, 120, 109, 23);
		contentPane.add(rdbtnNivelAvanzado);

		
		//Añadir los tres botones de dificultad al grupo de botones de nivel
		nivelesDificultad.add(rdbtnNivelPrincipiante);
		nivelesDificultad.add(rdbtnNivelMedio);
		nivelesDificultad.add(rdbtnNivelAvanzado);

		//Botón para aceptar la selección del usuario
		JButton btnAceptar = new JButton("Aceptar");
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*Si se selecciona el nivel Principiante, los valores
				serán por defecto (4 colores, 10 intentos)*/

				//Si se selecciona el nivel medio, 5 colores y 8 intentos
				if (rdbtnNivelMedio.isSelected()) {
					cantidadColores = 5;
					cantidadIntentos = 8;

				//Si se selecciona el nivel avanzado, 6 colores y 6 intentos
				} else if (rdbtnNivelAvanzado.isSelected()) {
					cantidadColores = 6;
					cantidadIntentos = 6;
				}
	
				
				MainJFrame jframe = new MainJFrame(cantidadColores, cantidadIntentos);
				jframe.setFrame(jframe);
				jframe.setVisible(true);
				
					frame.setVisible(false);
				
			}
		});

		
		//Al darle al botón de aceptar, se definirán los valores de nºcolores y nºintentos
		btnAceptar.setBounds(60, 165, 89, 23);
		contentPane.add(btnAceptar);

		/*Botón "Cancelar". Si le damos a cancelar, el número de intentos y el número de colores
		 * serán por defecto, es decir, 4 colores y 10 intentos.
		 * */
		
		JButton btnCancelar = new JButton("Cancelar");
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainJFrame jframe = new MainJFrame(cantidadColores, cantidadIntentos);
				jframe.setFrame(jframe);
				jframe.setVisible(true);			
				frame.setVisible(false);
			}

		});

		btnCancelar.setBounds(170, 165, 89, 23);
		contentPane.add(btnCancelar);
		
		
	}

	//Método que retorna el frame
	public static EleccionNivel getFrame() {
		return frame;
	}

	
	//Método que define el frame
	public void setFrame(EleccionNivel frame) {
		EleccionNivel.frame = frame;
	}

	//Método que obtiene y retorna la cantidad de colores
	public int getCantidadColores() {

		return cantidadColores;
	}

	//Método que obtiene y retorna la cantidad de intentos
	public int getCantidadIntentos() {

		return cantidadIntentos;
	}

}