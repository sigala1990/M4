package com.bootcamp.M4.MasterMind.ColoresDisponibles;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColoresDisponibles {
	//List<Color> listaColores = new ArrayList<Color>();
	List<String> listaColores = new ArrayList<String>();
	List<String> arrayColor = new ArrayList<String>();
	
	int numColor;
	public ColoresDisponibles() {
		numColor = 5;
		boolean repetido = true;
		
		/*listaColores.add(Color.yellow);
		listaColores.add(Color.white);
		listaColores.add(Color.blue);
		listaColores.add(Color.red);
		listaColores.add(Color.green);
		listaColores.add(Color.pink);*/
		
		listaColores.add("yellow");
		listaColores.add("white");
		listaColores.add("blue");
		listaColores.add("red");
		listaColores.add("green");
		listaColores.add("pink");
		
		//Color color = null;
		String color = null;
		for (int i = 0; i < numColor; i++) {
			repetido = true;
			while(repetido) {
				color = randomColor();
				if(controlColorRepetido(color)) {
					repetido = false;
				}
			}arrayColor.add(color); 
		}
	//	System.out.println(arrayColor.toString());
		
	}
	/*public Color randomColor() {
		switch (numRandom(0,6)) {
		case 0:
			return Color.pink;
		case 1:
			return Color.yellow;
		case 2:
			return Color.blue;
		case 3:
			return Color.red;
		case 4:
			return Color.green;
		case 5:
			return Color.white;
		default:
			return null;			
		}
	}*/
	
	public String randomColor() {
		switch (numRandom(0,6)) {
		case 0:
			return "pink";
		case 1:
			return "yellow";
		case 2:
			return "blue";
		case 3:
			return "red";
		case 4:
			return "green";
		case 5:
			return "white";
		default:
			return null;			
		}
	}

	private boolean controlColorRepetido(String randomColor) {//metodo que devuelve boolean dependiendo si se ha usado el colorRandom 
		int contadorColorRepetido = 0;
		for (int i = 0; i < arrayColor.size(); i++) {
			if (arrayColor.get(i).equals((randomColor))) {
				contadorColorRepetido++;
			}
		}
		if (contadorColorRepetido == 1) {// color repetido mas de 2 veces, vamos a seguir buscando
			return false;
		}
		return true;
	}
	
	public static int numRandom(int min, int max) { // metodo devuelve num random
		return (int) (Math.random() * (max - min) + min);
	}
	public void mostrarArray() {
		for (int i = 0; i < arrayColor.size(); i++) {
			System.out.println(arrayColor.get(i).toString());
		}
		
	}
	
	

}
