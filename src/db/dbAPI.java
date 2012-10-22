package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
//import java.sql.Statement;
//import org.sqlite.*;

public class dbAPI {

	public static void newRowRank(String nombre, int puntos) {
		String query = "";
		Statement stat = null;
		try {
			query = "INSERT INTO Rank(name, points) VALUES ('" + nombre + "', " + puntos + ")";
			//System.out.println(query);
			stat = dbConn.getInstance().createStatement();
			stat.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println(":: ERROR newRowRank");
			ex.printStackTrace();
		}
	}

	public static void newSave(String sudokuActual, int time, String semilla, int dif, String resuelto) {
		String query = "";
		Statement stat = null;
		try {
			query = "INSERT INTO Save(sudokuActual, time, semilla, dif, resuelto) VALUES('" + sudokuActual + "', " + time + ", '" + semilla + "', " + dif + ", '" + resuelto + "');";
			stat = dbConn.getInstance().createStatement();
			stat.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println(":: ERROR newSave");
			ex.printStackTrace();
		}
	}

	public static ResultSet getSave() {
		String query = "";
		Statement stat = null;
		ResultSet rs = null;
		try {
			query = "SELECT sudokuActual, time, semilla, dif, resuelto FROM Save";
			stat = dbConn.getInstance().createStatement();
			rs = stat.executeQuery(query);
			// SELECT sudoku, time FROM Save;
			// DELETE from SavSavee;
		} catch (Exception ex) {
			System.out.println(":: ERROR getSave-SELECT");
			ex.printStackTrace();
		}
		try {
			query = "DELETE FROM Save";
			stat = dbConn.getInstance().createStatement();
			stat.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println(":: ERROR getSave-DELETE");
			ex.printStackTrace();
		}
		return rs;
	}

	public static ResultSet getRank() {
		// SELECT name, points from Rank ORDER BY points LIMIT 10;
		String query = "";
		ResultSet rs = null;
		Statement stat;

		try {
			query = "SELECT name, points FROM Rank ORDER BY points DESC LIMIT 10";
			stat = dbConn.getInstance().createStatement();
			rs = stat.executeQuery(query);
		} catch (Exception ex) {
			System.out.println(":: ERROR getRank");
			ex.printStackTrace();
		}
		return rs;
	}
}