package com.bootcamp.M4.MasterMind;

import com.bootcamp.M4.MasterMind.EleccionNivel.EleccionNivel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       	EleccionNivel eleccionNivel = new EleccionNivel();
    	eleccionNivel.setFrame(eleccionNivel);
    	eleccionNivel.setVisible(true);
    }
}
