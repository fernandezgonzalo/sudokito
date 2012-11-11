package ManejoTablas;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

public class Tablas{
	public static JTable crearTabla (ResultSet rs, String[] columNames){
		JTable tabla;
		String [][] matriz = crearMatriz (rs,columNames.length, columNames);
		tabla= new JTable(matriz,columNames);
		return tabla;
	}
	
	private static String[][] crearMatriz (ResultSet rs, int filas, String[] columNames){
		String[][] m = new String[10][filas];
		int cont = 0;
		try {
			while (rs.next()){
				m[cont][0] = rs.getString(columNames[0]);
				m[cont][1] = ((Integer)(rs.getInt(columNames[1]))).toString();
				cont++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}


}
