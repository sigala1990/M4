package com.bootcamp.M4.MasterMind.Palette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bootcamp.M4.MasterMind.JFrame.MainJFrame;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  

public class Palette extends JFrame implements ActionListener {

	private JPanel contentPane;
	public MainJFrame mainJFrame;
	private List<JButton> listBotones = new ArrayList<JButton>();
	private List<Color> listColorACambiar = new ArrayList<Color>();
	private List<Color> listColoresAntiguos = new ArrayList<Color>();
	private int cantidadColores;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Palette frame = new Palette();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Palette(List<Color> ListColoresDisponibles,int cantidadColores, MainJFrame mainJFrame) {
		setTitle("Cambiar color");
		this.listColoresAntiguos = ListColoresDisponibles;
		this.cantidadColores = cantidadColores;
		this.mainJFrame = mainJFrame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pulsarAceptar();
			}
		});
		btnAceptar.setBounds(100, 212, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(246, 212, 89, 23);
		contentPane.add(btnCancelar);
		
		mostrarBotones();
	}
	
	public void mostrarBotones() {
		int x = 90;
		int y = 100;
		for (int i = 0; i < cantidadColores; i++) {
			JButton btn = new JButton(""+i);
			listBotones.add(btn);
			listBotones.get(i).addActionListener(this);
			listBotones.get(i).setBackground(listColoresAntiguos.get(i));
			contentPane.add(listBotones.get(i));
			btn.setBounds(x, y, 50, 50);
			x = x + 60;
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < listBotones.size(); i++) {
			if(e.getSource() == listBotones.get(i)) {
				Color color = JColorChooser.showDialog(this,"Escoge",listBotones.get(i).getBackground());	
				listBotones.get(i).setBackground(color);
			}
		}	
	}
	public void pulsarAceptar() {
		for (int i = 0; i < listBotones.size(); i++) {
			listColorACambiar.add( listBotones.get(i).getBackground());
		}
		//listColoresDisponibles
		mainJFrame.setListColoresDisponibles(listColorACambiar);
		mainJFrame.actualizarColoresPersonalizados();
		setVisible(false);
		
	}
}
