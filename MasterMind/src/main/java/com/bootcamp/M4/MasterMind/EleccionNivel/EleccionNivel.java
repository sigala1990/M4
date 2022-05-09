package com.bootcamp.M4.MasterMind.EleccionNivel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JRadioButton;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EleccionNivel extends JFrame {

	public static EleccionNivel frame;
	private JPanel contentPane;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public EleccionNivel() {
		setTitle("Seleccion de dificultad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JRadioButton rdbtnNivelPrincipiante = new JRadioButton("Principiante");
		rdbtnNivelPrincipiante.setBackground(SystemColor.activeCaption);
		
		rdbtnNivelPrincipiante.setBounds(120, 66, 109, 23);
		contentPane.add(rdbtnNivelPrincipiante);

		JRadioButton rdbtnNivelMedio = new JRadioButton("Medio");
		rdbtnNivelMedio.setBackground(SystemColor.activeCaption);
		rdbtnNivelMedio.setBounds(120, 94, 109, 23);
		
		contentPane.add(rdbtnNivelMedio);
		rdbtnNivelMedio.setSelected(true);

		JRadioButton rdbtnNivelAvanzado = new JRadioButton("Avanzado");
		rdbtnNivelAvanzado.setBackground(SystemColor.activeCaption);
		rdbtnNivelAvanzado.setBounds(120, 120, 109, 23);
		contentPane.add(rdbtnNivelAvanzado);

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

		btnAceptar.setBounds(60, 165, 89, 23);
		contentPane.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//MainJFrame.mainJFrameOpen();
				MainJFrame jframe = new MainJFrame(cantidadColores, cantidadIntentos);
				jframe.setFrame(jframe);
				jframe.setVisible(true);			
				frame.setVisible(false);
			}
		});
		// panel.close();
		// JEleccionNivel.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// JEleccionNivel.setVisible(false);

		btnCancelar.setBounds(170, 165, 89, 23);
		contentPane.add(btnCancelar);
		
		
	}


	

}