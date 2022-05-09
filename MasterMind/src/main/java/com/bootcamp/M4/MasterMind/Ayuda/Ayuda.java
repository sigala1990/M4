package com.bootcamp.M4.MasterMind.Ayuda;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bootcamp.M4.MasterMind.JFrame.MainJFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ayuda extends JFrame {

	
//	private String text = "\"COMO SE JUEGA\n\n<html> En <br>Mastermind<html> compiten 2 jugadores, uno de \nellos creará un código oculto con 5 clavijas de \ncolores, pudiendo hacer las combinaciones con \nlos 8 colores disponibles e incluso repitiendo \ncolor si lo desea. El código de colores debe de \nocultarse con el escudo para que no pueda verlo \nel oponente, que deberá acertar en el menor \nnúmero posible de jugadas la clave para obtener \nuna buena puntuación. Para descifrar el código \nsecreto de colores el jugador deberá ir probando \ncombinaciones aleatorias de colores, y en cada \ncombinación, el jugador contrario debe darle \npistas mediante las espigas blancas y negras. \nPor cada clavija acertada en color y posición, \ncolocará una espiga negra, y por cada color \nacertado pero en un lugar equivocado colocará \nuna espiga blanca.";
	private String text = "<html>COMO SE JUEGA<br><br>En Mastermind compiten 2 jugadores, uno de <br>ellos creará un código oculto con 5 clavijas de <br>	colores, pudiendo hacer las combinaciones con <br>	los 8 colores disponibles e incluso repitiendo <br>	color si lo desea. El código de colores debe de <br>	ocultarse con el escudo para que no pueda verlo <br>	el oponente, que deberá acertar en el menor <br>	número posible de jugadas la clave para obtener <br>	una buena puntuación. Para descifrar el código <br>	secreto de colores el jugador deberá ir probando <br>	combinaciones aleatorias de colores, y en cada <br>	combinación, el jugador contrario debe darle <br>	pistas mediante las espigas blancas y negras. <br>	Por cada clavija acertada en color y posición, <br>	colocará una espiga negra, y por cada color <br>	acertado pero en un lugar equivocado colocará <br>	una espiga blanca.</html>";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda frame = new Ayuda();
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
	public Ayuda() {
		setTitle("Como se juega");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Instrucciones");
		lblTitle.setFont(new Font("Alef", Font.PLAIN, 16));
		lblTitle.setBounds(141, 221, 150, 22);
		contentPane.add(lblTitle);
		
		JLabel txtComoSeJuega = new JLabel(text);
		txtComoSeJuega.setFont(new Font("Alef", Font.PLAIN, 11));
		//txtComoSeJuega.setText(text);
		txtComoSeJuega.setBounds(374, 190, 300, 350);
		contentPane.add(txtComoSeJuega);
		
		JLabel lblpag = new JLabel("1");
		lblpag.setBounds(605, 509, 18, 31);
		contentPane.add(lblpag);
		
		JLabel lblMasterMind = new JLabel("MasterMind                                   1");
		lblMasterMind.setBounds(129, 269, 195, 47);
		contentPane.add(lblMasterMind);
		
		JLabel lblenlinea = new JLabel("3En Linea                                      2");
		lblenlinea.setBounds(129, 314, 195, 47);
		contentPane.add(lblenlinea);
	
		JLabel lblahorcado = new JLabel("El ahorcado                                    3");
		lblahorcado.setBounds(129, 354, 195, 47);
		contentPane.add(lblahorcado);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btn_volver.setBounds(161, 494, 89, 23);
		contentPane.add(btn_volver);
		
		JLabel picLabel = new JLabel(new ImageIcon(MainJFrame.class.getClassLoader().getResource("com/bootcamp/M4/MasterMind/img/AyudaBackground.png")));
		picLabel.setBounds(0, 0, 700, 650);
		contentPane.add(picLabel);	
		picLabel.setLayout(new FlowLayout());

		
	
		
	
	}
}
