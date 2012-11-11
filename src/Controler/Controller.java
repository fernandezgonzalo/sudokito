package Controler;

import java.sql.ResultSet;

import db.dbAPI;
import Model.Sudoku;
import Model.Parser;
import View.InterfaceUno.*;

public class Controller {

	private View1 vista; 
	private Sudoku juego;
	
	public Controller(){
		vista=new View1();
		vista.setVisible(true);
		//vista.addActionListener(this);
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
	
	
	
	public void topten (){
		ResultSet rs = null;
		rs = dbAPI.getRank();
		
	}
	
}
