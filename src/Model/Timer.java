package Model;

import java.util.Calendar;

public class Timer{
	private int hora, minutos, segundos;
	
	public Timer (){
		hora = 0;
		minutos = 0;
		segundos = 0;
	}
	
	public Timer (String h){
		String hs = "";
		String min = "";
		String seg = "";
		int cont=0;
		while (h.charAt(cont)!=':'){
			hs=hs+h.charAt(cont);
			cont++;
		}
		hora = Integer.parseInt(hs);
		cont++;
		
		while (h.charAt(cont)!=':'){
			min=min+h.charAt(cont);
			cont++;
		}
		minutos = Integer.parseInt(min);
		cont++;
		
		while (cont<h.length()){
			seg=seg+h.charAt(cont);
			cont++;
		}
		segundos = Integer.parseInt(seg);
	}
////////////////////////////////////////////////////////////////////////
	public void obtenerHoraSys(){
		Calendar calendario = Calendar.getInstance();
		hora =calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
	}
////////////////////////////////////////////////////////////////////////
	public int getHora (){
		return hora;
	}
	
	public int getMinutos (){
		return minutos;
	}
	
	public int getSegundos(){
		return segundos;
	}
////////////////////////////////////////////////////////////////////////
	public String toString (){
		return (hora+":"+minutos+":"+segundos);
	}
////////////////////////////////////////////////////////////////////////	
	public String calcularDiferencia (Timer inicial){
		String result="";
		int seg = calcularDif(inicial);
		int hs = seg/3600;
		result = result+hs+":";
		seg = seg-(hs*3600);
		int m = seg/60;
		result = result+m+":";
		seg = seg-(m*60);
		result = result+seg;
		return result;
	}
	
	private int calcularDif (Timer inicial){
		int segs1 = segundos;
		segs1 = segs1+horaASeg(hora);
		segs1 = segs1+minASeg(minutos);
		
		int segs2 = inicial.getSegundos();
		segs2 = segs2+horaASeg(inicial.getHora());
		segs2 = segs2+minASeg(inicial.getMinutos());
		int res;
		if (segs1>segs2) res=segs1-segs2; else res=segs2-segs1;
		return res;
	}
////////////////////////////////////////////////////////////////////////
	private int horaASeg (int h){
		return h*3600;
	}
	
	private int minASeg (int m){
		return m*60;
	}	
}
