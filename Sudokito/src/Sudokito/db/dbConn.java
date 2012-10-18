package Sudokito.db;

import java.sql.*;

public class dbConn {

	private static String dbName = "sudoku.db";
	private static String url = "jdbc:sqlite:" + dbName;
	private static dbConn instance;
	private static Connection conn;


	public synchronized static Connection getInstance() {
		if (instance == null)
			instance = new dbConn();
		return conn;
	}

	public dbConn() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
			if (conn != null)
				System.out.println(":: Database " + dbName + " Connected");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void closeConn() {
		conn = null;
	}

}