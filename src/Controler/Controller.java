package Controler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import db.dbAPI;
import ManejoTablas.Tablas;
import Model.Sudoku;
import Model.Parser;
import View.InterfaceUno.*;

import javax.swing.JTable;

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
	
	
	
	public void topTen (){
		ResultSet rs = null;
		rs = dbAPI.getRank(); 
		ResulsetToArray(){
			
		}
		//String[] columNames = {"name","points"};	
		//JTable table = Tablas.crearTabla(rs,columNames);
		//vista.setTable(table);
	}
	 private Object[][] ResultSetToArray(ResultSet rs) {
		 Object obj[][]=null;
		 try{
			 rs.last();
			 ResultSetMetaData rsmd = rs.getMetaData();
			 int numCols = rsmd.getColumnCount();
			 int numFils =rs.getRow();
			 obj=new Object[numFils][numCols];
			 int j = 0;
			 rs.beforeFirst();
			 while (rs.next()){
				 for (int i=0;i<numCols;i++){
					 obj[j][i]=rs.getObject(i+1);
				 }
				 j++;
			 }
		 }catch(Exception e){}
		 return obj;
		}

	
}
