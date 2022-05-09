package com.bootcamp.M4.MasterMind.EleccionNivel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import com.bootcamp.M4.MasterMind.JFrame.MainJFrame;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EleccionNivel extends JFrame {

	public static EleccionNivel frame;
	private JPanel contentPane;
	private int cantidadColores = 4;
	private int cantidadIntentos = 10;
	private JButton btnCancelar;
	private boolean mainJframeOpen = false;

	// Lanzar la aplicación

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

	// Crear el frame

	public EleccionNivel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		//Crear y definir el panel
		JPanel panel = new JPanel();
		panel.setBounds(24, 11, 400, 239);
		contentPane.add(panel);
		panel.setLayout(null);

		//Botones para escoger el nivel
		
		//Botón nivel Principiante

		ButtonGroup nivelesDificultad = new ButtonGroup();

		JRadioButton rdbtnNivelPrincipiante = new JRadioButton("Principiante");
		rdbtnNivelPrincipiante.setBounds(141, 66, 109, 23);
		panel.add(rdbtnNivelPrincipiante);

		
		//Botón nivel Medio
		JRadioButton rdbtnNivelMedio = new JRadioButton("Medio");
		rdbtnNivelMedio.setBounds(141, 94, 109, 23);
		panel.add(rdbtnNivelMedio);
		rdbtnNivelMedio.setSelected(true);

		
		//Botón nivel Avanzado
		JRadioButton rdbtnNivelAvanzado = new JRadioButton("Avanzado");
		rdbtnNivelAvanzado.setBounds(141, 120, 109, 23);
		panel.add(rdbtnNivelAvanzado);


		//Botón para aceptar cuando hayas escogido el nivel

		nivelesDificultad.add(rdbtnNivelPrincipiante);
		nivelesDificultad.add(rdbtnNivelMedio);
		nivelesDificultad.add(rdbtnNivelAvanzado);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnNivelMedio.isSelected()) {
					cantidadColores = 5;
					cantidadIntentos = 8;

				} else if (rdbtnNivelAvanzado.isSelected()) {
					cantidadColores = 6;
					cantidadIntentos = 6;
				}
				MainJFrame jframe = new MainJFrame(cantidadColores, cantidadIntentos);
				jframe.setFrame(jframe);
				jframe.setVisible(true);
				
					frame.setVisible(false);
				// System.out.println(getCantidadColores());
				// System.out.println(getCantidadIntentos());
			}
		});

		btnAceptar.setBounds(91, 165, 89, 23);
		panel.add(btnAceptar);

		//Botón para cancelar
		JButton btnCancelar = new JButton("Cancelar");

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if(frame != null) {
					frame.setVisible(false);
				}			

				MainJFrame jframe = new MainJFrame(cantidadColores, cantidadIntentos);
				jframe.setFrame(jframe);
				jframe.setVisible(true);
			
				frame.setVisible(false);
			}

		});

		btnCancelar.setBounds(189, 165, 89, 23);
		panel.add(btnCancelar);

	}

	public static EleccionNivel getFrame() {
		return frame;
	}

	public void setFrame(EleccionNivel frame) {
		EleccionNivel.frame = frame;
	}

	public int getCantidadColores() {

		return cantidadColores;
	}

	public int getCantidadIntentos() {

		return cantidadIntentos;
	}

}