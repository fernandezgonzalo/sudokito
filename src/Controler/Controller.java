package Controler;

import Model.Sudoku;
import Model.Parser;
import View.Interface1.*;

public class Controller {

	private View1 vista; 
	private Sudoku juego;
	
	public Controller(){
		vista=new View1();
		vista.setVisible(true);
	}
	
	public void iniciarTablero(){
		juego = new Sudoku (vista.getDificultad());
		vista.setTablero(juego.getTablero());
	}
	
	public void restart(){
		vista.setTablero(Parser.importar(juego.getSemilla()));
		juego.restartTimeInic();
	}
	
	public void resolver(){
		vista.setTablero(Parser.importar(juego.getResuelto()));
	}
}
