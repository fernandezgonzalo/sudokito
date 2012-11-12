package Model;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Sudoku{
	private String[] strAux;
	private String semilla;
	private String resuelto;
	private String[][] tablero;
	private Timer tiempoInicial;
	private Timer tiemoTranscurrido;
	private String dificultad; // Easy, Medium, Hard
	private String facil ="http://buurentriko.pythonanywhere.com/Easy/solve";
	private String medio ="http://buurentriko.pythonanywhere.com/Medium/solve";
	private String dificil ="http://buurentriko.pythonanywhere.com/Hard/solve";
	
	
	public Sudoku (){
		dificultad = "Easy";
		strAux = Descarga.obtenerSemilla(facil);
		semilla = strAux[0];
		resuelto = strAux[1];
		tablero=Parser.importar(semilla);
		tiempoInicial = new Timer();
		tiempoInicial.obtenerHoraSys();
		tiemoTranscurrido = new Timer ();
	}
	
	public Sudoku(String dif){
		dificultad=dif;
		if (dif=="Easy")strAux=Descarga.obtenerSemilla(facil);
		if (dif=="Medium")strAux=Descarga.obtenerSemilla(medio);
		if (dif=="Hard")strAux=Descarga.obtenerSemilla(dificil);
		semilla = strAux[0];
		resuelto = strAux[1];
		tablero=Parser.importar(semilla);
		tiempoInicial = new Timer();
		tiempoInicial.obtenerHoraSys();
		tiemoTranscurrido = new Timer ();
	}
	
	public Sudoku (String sem, String res, String[][] tab, String tiempo, String dif){
		semilla = sem;
		resuelto = res;
		tablero = tab;
		tiemoTranscurrido = new Timer (tiempo);
		tiempoInicial = new Timer();
	}
	
////////////////////////////////////////////////////////////////////////

	public int[] comprobarTablero(){
		int cont=0;
		
		int[] result = {1,0,0};
		String[][] mAux = Parser.importar(resuelto);
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				if (tablero[i][j].compareTo("0")!=0){
					if (tablero[i][j].compareTo(mAux[i][j])!=0){
						result[0]=0;result[1]=i+1;result[2]=j+1;
					}
				}
				cont++;
			}
		}
		return result;
	}
			int[] result={1,0,0,0,0};
	private int[] comprobarTablero (String[][] m){
		int[] result={1,0,0,0,0};
		result= compCuadrados(m);
		if (result[0]==1) result=compColumnas(m);
		if (result[0]==1) result=compFilas(m);
		return result;
	}
	
	private int[] compCuadrados (String[][] m){
		int[] result = {1,0,0,0,0};
		for (int x=0; (x<=8)&&(result[0]==1); x=x+3){
			for (int y=0; (y<=8)&&(result[0]==1); y=y+3){
				result = cuadrado(m,x,y);
			}
		}
		return result;
	}
	
	private int[] cuadrado (String[][] m, int x, int y){
		int[] result = {1,0,0,0,0};
		LinkedList aux = new LinkedList();
		int auxX=0;
		int auxY=0;
		for (int x1=x; (x1<=x+2)&&(result[0]==1); x1++){
			for (int y1=y; (y1<=y+2)&&(result[0]==1); y1++){
				if (!(aux.contains(m[x1][y1]))){
					if (m[x1][y1].compareTo("0")!=0)
						aux.add(m[x1][y1]);
				}else{
					result[0]=0;
					result[1]=x1;
					result[2]=y1;
					auxX=x1;
					auxY=y1;
				}
			}
		}
		if (result[0]==0){
			boolean salida=false;
			for (int x1=x; (x1<=x+2)&&(!salida); x1++){
				for (int y1=y; (y1<=y+2)&&(!salida); y1++){
					if (m[x1][y1]==m[auxX][auxY]){
						result[3]=x1;
						result[4]=y1;
						salida=true;
					}
				}
			}
		}
		return result;
	}
	
	private int[] compColumnas (String[][] m){
		int[] result={1,0,0,0,0};
		for (int y=0; (y<=8)&&(result[0]==1); y++){
				result = columna(m,y);
		}
		return result;
	}
	
	private int[] columna (String[][] m, int y){
		int[] result = {1,0,0,0,0};
		int x,x1;
		x=0;
		while ((x<8)&&(result[0]==1)){
			x1=x+1;
			while ((x1<=8)&&(result[0]==1)){
				if (m[x1][y] == m[x][y]){
					result[0]=0;result[1]=x1;result[2]=y;result[3]=x;result[4]=y;
				}
				x1++;
			}
			x++;
		}
		return result;
	}
	
	private int[] compFilas (String[][] m){
		int[] result={1,0,0,0,0};
		for (int x=0; (x<=8)&&(result[0]==1); x++){
				result = fila(m,x);
		}
		return result;
	}
	
	private int[] fila (String[][] m, int x){
		int[] result = {1,0,0,0,0};
		int y,y1;
		y=0;
		while ((y<8)&&(result[0]==1)){
			y1=y+1;
			while ((y1<=8)&&(result[0]==1)){
				if (m[x][y1] == m[x][y]){
					result[0]=0;result[1]=x;result[2]=y1;result[3]=x;result[4]=y;
				}
				y1++;
			}
			y++;
		}
		return result;
	}
////////////////////////////////////////////////////////////////////////
	public String[][] getTablero(){
		return tablero;
	}
	
	public String getSemilla(){
		return semilla;
	}
	
	public String getResuelto(){
		return resuelto;
	}
	
	public String getDif (){
		return dificultad;
	}
	
	public String getTrans(){
		return tiemoTranscurrido.toString();
	}
	
	public void setTime (String time){
		tiemoTranscurrido = new Timer(time);
	}
////////////////////////////////////////////////////////////////////////	
	public void restartTimeInic (){
		tiempoInicial.obtenerHoraSys();
	}
		
	public String calcularTiempo (){
		Timer aux = new Timer();
		aux.obtenerHoraSys();
		String tiempo = tiempoInicial.calcularDiferencia(aux);
		if (!tiemoTranscurrido.esCero()){
			Timer tiempo1 = new Timer(tiempo);
			return tiemoTranscurrido.suma(tiempo1);
		}else
			return tiempo;
	}

////////////////////////////////////////////////////////////////////////
	public void setTablero(String[][] tab){
		tablero = tab;
	}
	
	public void restart (){
		tablero=Parser.importar(semilla);
	}
////////////////////////////////////////////////////////////////////////
	public String [][] sugerencia (){
		int aux=0;
		boolean a =true;
		for(int i=0;i<=8 && a;i++){
			for(int j=0; j<=8 && a;j++){
				if (tablero[i][j].compareTo("0")==0){
					tablero[i][j]=""+resuelto.charAt(aux);
					a=false;
				}
				aux++;
			}
		}
		return tablero;
	}

}



