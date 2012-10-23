package Controler;

import Model.Sudoku;
import Model.Parser;
import View.Interface1.*;

public class Controller {

	private View1 vista;
	private Sudoku juego;
	
	public void iniciarTablero(){
		juego = new Sudoku (vista.dificultad());
		vista.setTablero(juego.getTablero());
	}
	
	public void restart(){
		vista.setTablero(Parser.importar(juego.getSemilla()));
		juego.restartTimeInic();
	}
}
