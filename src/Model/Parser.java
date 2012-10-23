package Model;

import java.util.*;

public class Parser {
	public static String[][] importar(String str) {
		String[][] m = new String[9][9];
		int cont = 0;
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				if (str.charAt(cont) != 0)
					m[i][j] = String.valueOf(str.charAt(cont));
				cont++;
			}
		}
		return m;
	}

	public static String exportar(String[][] m) {
		String str = new String ();
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				if (m[i][j] != null)
					str=str+m[i][j];
				else
					str=str+"0";
			}
		}
		return str;
	}
}
