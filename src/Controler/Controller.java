package Controler;

import Model.Sudoku;
import Model.Parser;

public class Controller {
	//falta inicializar la vista
	private Sudoku juego;
	
	public void iniciarTablero (){
		juego = new Sudoku (vista.dificultad());
		vista.setTablero(juego.getTablero());
	}
	
	public restart (){
		vista.setTablero(Parser.importar(juego.getSemilla()));
	}
}
