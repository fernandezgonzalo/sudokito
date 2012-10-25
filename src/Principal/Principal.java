package Principal;


import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import db.dbAPI;

import Controler.Controller;

public class Principal {

	public static void main(String[] args) {
		/*Controller controlador = new Controller();
		controlador.iniciarTablero();
		
		JOptionPane.showMessageDialog(null, "Hola mundo!!!");
		
		controlador.resolver();

		 JOptionPane.showMessageDialog(null, "Hola mundo!!!");
		
		controlador.restart();
		*/
		//dbAPI.newRowRank("mon",100);
		ResultSet rs = null;
		rs = dbAPI.getRank();
		//String a = rs.toString();
		String a="q2";
		try {
			a = rs.getString(2);
			System.out.println("aaaaaaaaaaaaaaa: "+a);
			boolean as = rs.next();
			System.out.println("ffffffffffffffff: "+as);
			String b = rs.getString(2);
			System.out.println("bbbbbbbbbbbbbbb: "+b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String a = rs.getString(0);
		//System.out.println("aaaaaaaaaaaaaaa: "+a);
	
		
	}

}
