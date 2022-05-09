package com.bootcamp.M4.MasterMind.AcercaDe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bootcamp.M4.MasterMind.JFrame.MainJFrame;
import java.awt.Color;

public class AcercaDe extends JFrame {

	private JPanel contentPane;

	//Lanzar la aplicación 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaDe frame = new AcercaDe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Crear el Frame
	public AcercaDe() {
		setBackground(Color.WHITE);
		setTitle("AcercaDe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_volver = new JButton("Volver");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		
		btn_volver.setBounds(200, 270, 89, 23);
		contentPane.add(btn_volver);

		JLabel picLabel = new JLabel(new ImageIcon(
				MainJFrame.class.getClassLoader().getResource("com/bootcamp/M4/MasterMind/img/aboutus.png")));
		picLabel.setBounds(0, 0, 480, 230);
		contentPane.add(picLabel);
		picLabel.setLayout(new FlowLayout());

		JLabel lblName1 = new JLabel("Marc Padrell");
		lblName1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblName1.setBounds(41, 241, 109, 27);
		contentPane.add(lblName1);

		JLabel lblName2 = new JLabel("Ixabel Justo");
		lblName2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblName2.setBounds(214, 241, 85, 27);
		contentPane.add(lblName2);

		JLabel lblName3 = new JLabel("Adria Queralt");
		lblName3.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblName3.setBounds(383, 241, 85, 27);
		contentPane.add(lblName3);

	}
}
