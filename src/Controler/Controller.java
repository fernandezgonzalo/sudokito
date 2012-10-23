package Controler;

import Model.Sudoku;
import Model.Parser;
import View.ViewOne;

public class Controller {

	private ViewOne vista;
	private Sudoku juego;
	
	public void iniciarTablero (){
		juego = new Sudoku (vista.dificultad());
		vista.setTablero(juego.getTablero());
	}
	
	public restart (){
		vista.setTablero(Parser.importar(juego.getSemilla()));
		juego.restartTimeInic();
	}
}
