package ManejoTablas;
/**
 * En esta clase se definen e implementan todos los metos necesarios para la creacion 
 * e instansicion de objetos del tipo JTable.
 *
 *@author Mariano
 */
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.swing.JTable;

public class Tablas {
	private static JTable tabla;
	
	/**
	 * Calcula la cantidad de filas que tiene el resultSet pasado por parametro.
	 * @param rs "Consulta"
	 * @return numRows "Cantidad de filas"
	 */
	private static int tama�oFilas (ResultSet rs){
		int numRows = 0;
		try {
			rs.last();
			numRows = rs.getRow();
			rs.first();
		} catch(SQLException e){
			
		}
		return numRows;
	}
	
	/**
	 * Crea uan matriz con las dimensiones pasadas por parametro y los datos 
	 * del objeto ResulSet
	 * @param tama�oFilas
	 * @param tama�oColumnas
	 * @param rs
	 * @return matriz
	 */
	private static Object[][] crearMatriz (int tama�oFilas, int tama�oColumnas, ResultSet rs){
		Object[][] matriz = new Object[tama�oFilas][tama�oColumnas];
		try {
		for (int f=0;f<tama�oFilas;f++){
			int indice =1; 
			for (int c=0;c<tama�oColumnas;c++){
				matriz[f][c]=rs.getString(indice);
				indice++;
			}
			rs.next();
		}
		rs.first();
		
		}catch (SQLException a){
			
		}
		return matriz;
	}
	
	/**
	 * Metodo encargado de crear un objeto JTable dada una matriz (creada con el metodo
	 * crearMatriz) y el nombre de las columnas  
	 * @param rs "ResultSet"
	 * @param columNames "Nombre de las columnas que contendra el objeto JTable
	 * @return tabla "objeto JTable ya instanciado"
	 */
	public static JTable crearTabla (ResultSet rs, String columNames[]){
		Object [][] matriz = crearMatriz (tama�oFilas(rs),columNames.length,rs);
		tabla= new JTable(matriz,columNames);
		return tabla;
	}
}
