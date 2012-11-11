/* 
 * Por el tema del resultSet que no podes sacar la cantidad de filas con el metodo tamanioFilas,
 * se me ocurre de hacer la cagada de llamar 2 veces al getRank, un rs lo usas para calcular
 * la cantidad de filas y el otro para llenar en la tabla, es una cagada porque estas llamando 2
 * veces al select. La otra es, dado que ya sabemos el tamaño maximo de filas del rs que es 10,
 * usarlo como constante y listo, si los datos son menores a 10, el resto se rellena con null o "" 
 */


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
	private static int tamanioFilas (ResultSet rs){
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
	private static Object[][] crearMatriz (int tamanioFilas, int tamanioColumnas, ResultSet rs){
		Object[][] matriz = new Object[tamanioFilas][tamanioColumnas];
		try {
		for (int f=0;f<tamanioFilas;f++){
			int indice =1; 
			for (int c=0;c<tamanioColumnas;c++){
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

		
		System.out.println("longitud: "+columNames.length);
		System.out.println("longitud: "+tamanioFilas(rs));
		
		Object [][] matriz = crearMatriz (tamanioFilas(rs),columNames.length,rs);
		
		System.out.println("saltaaaaa 1");
		
		int cont = 0;
		while (cont<10){
			System.out.println("saltaaaaa 2 "+cont);
			System.out.println(matriz[cont][0]);
			System.out.println("saltaaaaa 33");
			System.out.println(matriz[cont][1]);
			System.out.println("saltaaaaa 3");
			cont++;
		}
		System.out.println("saltaaaaa 14");
			
			
			
			
			
//=======
		Object [][] matriz = crearMatriz (tamanioFilas(rs),columNames.length,rs);
//>>>>>>> .r34
		tabla= new JTable(matriz,columNames);
		return tabla;
	}
}
