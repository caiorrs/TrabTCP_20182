/**
 * 
 */
package main;

import org.jfugue.player.Player;

/**
 * @author caiorrs
 *
 */

import org.jfugue.player.Player;


public class operacoes {

	private static String La = "A";
	private static String Si = "B";
	private static String Do = "C";
	private static String Re = "D";
	private static String Mi = "E";
	private static String Fa = "F";
	private static String Sol = "G";
	
	/**
	 * @param args
	 */
		public static void reproduzir(String[] args, String texto, int posicao) {
			
			Player player = new Player();

			int tamanhoEntrada = texto.length();
			
			//ENTRADA  = "BAGFEDC";
			
			for (int i = posicao; i < tamanhoEntrada; i++) {
				switch(texto.charAt(i)) {
					case 'A':
						player.play("A");
						break;
					case 'B':
						player.play("B");
						break;
					case 'C':
						player.play("C");
						break;
					case 'D':
						player.play("D");
						break;
					case 'E':
						player.play("E");
						break;
					case 'F':
						player.play("F");
						break;
					case 'G':
						player.play("G");
						break;
					default:
						break;
				}
			}
		}
		
		public static int pausar(String[] args, String[] texto) {
			
			int posicaoAtual = 5;
			
			return posicaoAtual;
		}

		public static void reiniciarReproducao(String[] args, String texto) {
			
			int posicaoAtual = 0;
			
			reproduzir(null, texto, posicaoAtual);
					
			
		}
		
		public static void parar(String[] args, String[] texto) {
			
		}

}
