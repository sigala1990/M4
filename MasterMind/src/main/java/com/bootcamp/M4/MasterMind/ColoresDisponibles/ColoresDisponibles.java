package com.bootcamp.M4.MasterMind.ColoresDisponibles;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColoresDisponibles {

	List<String> listaColores = new ArrayList<String>();
	List<String> arrayColor = new ArrayList<String>();
	int numColor;
	
	
	//Método para generar colores por defecto en posición aleatoria
	public ColoresDisponibles(int numColor) {
		this.numColor = numColor;
		boolean repetido = true;
		
		listaColores.add("yellow");
		listaColores.add("magenta");
		listaColores.add("blue");
		listaColores.add("red");
		listaColores.add("green");
		listaColores.add("pink");
		
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
	
		
	}
	
	
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
			return "magenta";
		default:
			return null;			
		}
	}

	//Método que devuelve boolean dependiendo si se ha usado el colorRandom 
	private boolean controlColorRepetido(String randomColor) {
		int contadorColorRepetido = 0;
		for (int i = 0; i < arrayColor.size(); i++) {
			if (arrayColor.get(i).equals((randomColor))) {
				contadorColorRepetido++;
			}
		}
		
		//Color repetido mas de 2 veces, vamos a seguir buscando
		if (contadorColorRepetido == 1) {
			return false;
		}
		return true;
	}
	
	//Método devuelve num random
	public static int numRandom(int min, int max) { 

		return (int) (Math.random() * (max - min) + min);
	}
	
	
	//Método para mostrr el contenido de la matriz de colores
	public void mostrarArray() {
		for (int i = 0; i < arrayColor.size(); i++) {
			System.out.println(arrayColor.get(i).toString());
		}
		
	}

	//Método para acceder al array de colores
	public List<String> getArrayColor() {
		return arrayColor;
	}


	//Método para definir la lista de colores
	public void setArrayColor(List<String> arrayColor) {
		this.arrayColor = arrayColor;
	}

}