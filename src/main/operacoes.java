/**
 * 
 */
package main;

/**
 * @author caiorrs
 *
 */

import org.jfugue.player.Player;
import org.jfugue.pattern.*;

public class operacoes extends controleSom{
	/**
	 * @param args
	 */
	public static void reproduzir(String texto) {
		trataTexto parsing = new trataTexto();
		
		parsing.parsing_texto(texto);
	}
	
	public static int pausar(String[] args, String[] texto) {

		int posicaoAtual = 5;

		return posicaoAtual;
	}

	public static void reiniciarReproducao(String[] args, String texto) {
		
	}

	public static void parar(String[] args, String[] texto) {

	}
	
	public static void reproduzir_Comecor(String[] args, String[] texto) {

	}
	
}