
public class Parser {
	
		
	static String[][] importar(String str) {
		String[][] m = new String[9][9];
		int i = 0;
		int j = 0;
		
		while (i < 9) {
			while (j < 9) {
				if (str.charAt(i+j) == 0) 
					m[i][j] = String.valueOf("");
				else
					m[i][j] = String.valueOf(str.charAt(i+j));
				j++;
			}
			i++;
		}
		return m;
	}
	
	static String exportar(String[][] m) {
		// Al reves
		return "A re loco";
	}
}