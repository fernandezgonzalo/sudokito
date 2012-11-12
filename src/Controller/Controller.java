package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import db.dbAPI;
import ManejoTablas.Tablas;
import Model.Sudoku;
import Model.Parser;


public class Controller {

	private Sudoku juego;

	
	
	public String[][] nuevoJuego(String dificultad){
		juego = new Sudoku (dificultad);
		return juego.getTablero();
	}
	
	public String[][] restart(){
		juego.restartTimeInic();
		juego.restart(); 
		return juego.getTablero();
	}
	
	public String[][] resolver(){
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
	
	public String[][] sugerirJugada(String[][] tab){
		juego.setTablero(tab);
		return juego.sugerencia();
	}
	
	public String[][] cargar (){
		ResultSet rs = dbAPI.getSave();
		try {
			String tab = (rs.getString("sudokuActual"));
			String tiempo = (rs.getString("time"));
			String sem = (rs.getString("semilla"));
			String dif = (rs.getString("dif"));
			String res = (rs.getString("resuelto"));
			String[][] m = Parser.importar(tab);
			juego = new Sudoku (sem,res,m,tiempo,dif);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return juego.getTablero();
	}
	
	public int[] compobar (String[][] m){
		juego.setTablero(m);
		return juego.comprobarTablero();
	}
}
