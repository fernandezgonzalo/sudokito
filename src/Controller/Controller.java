package Controller;
import java.sql.ResultSet;

import javax.swing.JTable;

import db.dbAPI;
import ManejoTablas.Tablas;
import Model.Sudoku;
import Model.Parser;

/*
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import db.dbAPI;
import ManejoTablas.Tablas;
import Model.Sudoku;

import View.InterfaceUno.*;

import javax.swing.JTable;*/


public class Controller {

	//private viewOne vista; 
	private Sudoku juego;
	
/*	public Controller(){
		//vista=new View1();
		//vista.setVisible(true);
		//vista.addActionListener(this);
		juego = new Sudoku
	}
*/	
	
	
	public String[][] nuevoJuego(String dificultad){
		juego = new Sudoku (dificultad);
		//vista.setTablero(juego.getTablero());
		return juego.getTablero();
	}
	
	public String[][] restart(){
		//vista.setTablero(Parser.importar(juego.getSemilla()));
		juego.restartTimeInic();
		return (Parser.importar(juego.getSemilla()));
	}
	
	public String[][] resolver(){
		//vista.setTablero(Parser.importar(juego.getResuelto()));
		return (Parser.importar(juego.getResuelto()));
	}
	
	
	public void guardarPartida (String[][] tablero, String dificultad){
		String sudokuActual = Parser.exportar(tablero);
		dbAPI.newSave(sudokuActual, juego.calcularTiempo(), juego.getSemilla(), dificultad, juego.getResuelto());
	}
	
	
	
	public JTable topTen (){
		ResultSet rs = null;
		rs = dbAPI.getRank();
		String[] names = {"name", "points"};
		return Tablas.crearTabla(rs, names);
	}	
}
