package Principal;

import db.dbConn;
import InterfaceUno.viewOne;

public class Principal {
	
	public static void main(String[] args) {
		db.dbConn.getInstance();
		viewOne vista1 = new viewOne();
		
	}
}