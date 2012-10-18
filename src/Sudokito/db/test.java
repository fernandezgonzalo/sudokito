package Sudokito.db;

import java.sql.ResultSet;
import java.sql.SQLException;
public class test {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		//dbAPI.newRowRank("pepe", 123);
//		dbAPI.newRowRank("jesu", 5);
//		dbAPI.newRowRank("juan", 18);
		dbAPI.newSave("010101010", 15);
//		ResultSet rs = dbAPI.getRank();
//		while (rs.next()) {
//			System.out.println("name: " + rs.getString("name"));
//			System.out.println("points: " + rs.getInt("points"));
//			System.out.println("·······························");
//			
//		}
		
		ResultSet rs = dbAPI.getSave();
		System.out.println("sudoku: " + rs.getString("sudoku"));
		System.out.println("time: " + rs.getInt("time"));
		System.out.println("··························");
		dbAPI.newSave("123", 14);
		
	}

}
