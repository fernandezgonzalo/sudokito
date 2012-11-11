package Principal;


import java.lang.reflect.Array;
import java.sql.ResultSet;

  import org.sqlite.*;

import javax.swing.JOptionPane;

import db.dbAPI;

import Controler.Controller;
import ManejoTablas.Tablas;

public class Principal {

	public static void main(String[] args) {
		
		ResultSet rs = null;
		rs = dbAPI.getRank();
	}
}