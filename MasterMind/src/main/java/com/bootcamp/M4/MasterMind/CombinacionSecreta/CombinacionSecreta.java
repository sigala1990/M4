package com.bootcamp.M4.MasterMind.CombinacionSecreta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bootcamp.M4.MasterMind.ColoresDisponibles.ColoresDisponibles;

public class CombinacionSecreta {

	int numColor;
	int list_int_random[] = new int[numColor];
	// Lista que contendra los colores de la combinacion secreta
	List<String> arrayColor_Secret = new ArrayList<String>(); 
	// Lista con los colores disponibles
	List<String> arrayColor_Disp = new ArrayList<String>(); 
	
	// Constructor Combinación Secreta
	public CombinacionSecreta(int numColor, ColoresDisponibles array_colores_disp){
		
		this.numColor = numColor;
		
		// Cogemos el array de colores disponbiles
		arrayColor_Disp = array_colores_disp.getArrayColor();
		
		for (int i = 0; i < arrayColor_Disp.size(); i++) { 
		
			// Acceder a un color aleatorio dentro de los disponibles
			String color = arrayColor_Disp.get(numRandom(0, numColor)); 
			
			//Añadir el color al array secreto
			arrayColor_Secret.add(color);
			
		}
				
	}

	//Método que devuelve un número random
	public static int numRandom(int min, int max) { 
		return (int) (Math.random() * (max - min) + min);
	}

	//Método que devuelve el array de colores secretos
	public List<String> getArrayColor_Secret() {
		return arrayColor_Secret;
	}
		
	//Método para mostrar el array de colores secretos
	public void mostrarArray() {
		for (int i = 0; i < arrayColor_Secret.size(); i++) {
			System.out.println(arrayColor_Secret.get(i).toString());
		}
		
	}
	

}
