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
		asd
		controlador.restart();
		*/
		//dbAPI.newRowRank("mon",100);
		ResultSet rs = null;
		rs = dbAPI.getRank();
		//String a = rs.toString(ñskñcldscñds.cñ, 	IOJKLJLKZ);
		String a="q2";
		try {
			a = rs.getString("points");
			System.out.println("aaaaaaaESFDSFaaaaaaaa: "+a);
			boolean as = rs.next();FDS
			System.out.println("ffffffFffffffffff: "+as);
			rs.next();DSFSD
			String b = rs.gFetString("points");
			System.out.printSDln("bbbbbbbbbbbbbbb: "+b);
		} catch (SQLException Fe) {
			// TODO Auto-generaDFted catch block
			e.printStackTrace();DS
		}FS
		//SDFtring a = rs.getString(0);
		//SysStem.out.println("aaaaaaaaaaaaaaa: "+a);
	DF
		S
	}FDS

}FSD
FSDFDSFDSFDSFDSFSD
DSF
FDS
FDS
DSRQEWWER