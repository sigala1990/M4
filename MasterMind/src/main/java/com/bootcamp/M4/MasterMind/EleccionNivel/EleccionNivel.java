package com.bootcamp.M4.MasterMind.EleccionNivel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EleccionNivel extends JFrame {

	private static EleccionNivel JEleccionNivel;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JEleccionNivel = new EleccionNivel();
					JEleccionNivel.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(24, 11, 400, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNivelPrincipiante = new JRadioButton("Principiante");
		rdbtnNivelPrincipiante.setBounds(141, 66, 109, 23);
		panel.add(rdbtnNivelPrincipiante);
		
		JRadioButton rdbtnNivelMedio = new JRadioButton("Medio");
		rdbtnNivelMedio.setBounds(141, 94, 109, 23);
		panel.add(rdbtnNivelMedio);
		
		JRadioButton rdbtnNivelAvanzado = new JRadioButton("Avanzado");
		rdbtnNivelAvanzado.setBounds(141, 120, 109, 23);
		panel.add(rdbtnNivelAvanzado);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(91, 165, 89, 23);
		panel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	panel.close();
				//JEleccionNivel.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					JEleccionNivel.setVisible(false);
					JEleccionNivel.dispose();
				
				//System.exit(0);
			}
		});
		btnCancelar.setBounds(189, 165, 89, 23);
		panel.add(btnCancelar);

	}
}