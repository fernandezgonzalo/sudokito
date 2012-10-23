package Principal;


import javax.swing.JOptionPane;

import Controler.Controller;

public class Principal {

	public static void main(String[] args) {
		Controller controlador = new Controller();
		controlador.iniciarTablero();
		
		JOptionPane.showMessageDialog(null, "Hola mundo!!!");
		
		controlador.resolver();

		 JOptionPane.showMessageDialog(null, "Hola mundo!!!");
		
		controlador.restart();
		
		
	
		
	}

}
