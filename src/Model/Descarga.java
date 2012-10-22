package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Descarga {
	public static String[] obtenerSemilla (String pag){
		String[] result = new String[2];
		String aux = obtenerStr(pag);
		result[0] = aux.substring(0,81);
		result[1] = aux.substring(81,162);
		return result;
	}
	
	private static String obtenerStr(String pagina){
		URL urlPag = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String aux;
		StringBuffer buffer = new StringBuffer();

		try {
			urlPag = new URL(pagina);
			isr = new InputStreamReader(urlPag.openStream());
			br = new BufferedReader(isr);
			while ((aux = br.readLine()) != null){
				buffer.append(aux);
			}
			br.close();
			isr.close();
		} catch (MalformedURLException e) {
			System.out.println("Error en la url");
		} catch (IOException e) {
			System.out.println("Error de lectura");
		}

		return buffer.toString();
	}
}

