package utilidades;

import java.io.*;

public class LeeFicheroSuper {

	private String[] textoComando = new String[8];
	File archivo;
	FileReader fr;
	BufferedReader br;
	private String valorPerfil;
	private String valorKDBG;
	private static  String letraDisco;

	public LeeFicheroSuper() {

		archivo = null;
		fr = null;
		br = null;
		letraDisco = "";

	}

	public void capturarDatos() {

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(letraDisco + ":\\Volatility\\\\informacion_memoria.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			for (int i = 0; i < 8; i++) {
				textoComando[i] = br.readLine();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public String getValorPerfil() {
		valorPerfil = textoComando[2].substring(45, 55);
		System.out.println("perfil: " + valorPerfil);
		return valorPerfil;
	}

	public void setValorPerfil(String valorPerfil) {
		this.valorPerfil = valorPerfil;
	}

	public String getValorKDBG() {

		valorKDBG = textoComando[7].substring(33, 43);
		System.out.println("KDBG: " + valorKDBG);
		return valorKDBG;
	}

	public void setValorKDBG(String valorKDBG) {
		this.valorKDBG = valorKDBG;
	}

	public  String getLetraDisco() {
		return letraDisco;
	}

	public  void setLetraDisco(String letraDisco) {
		LeeFicheroSuper.letraDisco = letraDisco;
	}
	
	

}
