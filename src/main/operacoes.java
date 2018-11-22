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

public class operacoes {

//	private static String La = "A";
//	private static String Si = "B";
//	private static String Do = "C";
//	private static String Re = "D";
//	private static String Mi = "E";
//	private static String Fa = "F";
//	private static String Sol = "G";
	
	/**
	 * @param args
	 */
		public static void reproduzir(String[] args, String texto, int posicao) {
			
			Player player = new Player();

			int tamanhoEntrada = texto.length();
			
			texto = texto.toUpperCase();
			
			int j = 0;
			
			for (int i = posicao; i < tamanhoEntrada; i++) {
				
				char caractere = texto.charAt(i);
				j++; 
				
				switch(caractere) {
					case 'A':
					case 'a':
						player.play("A");
						break;
					case 'B':
					case 'b':
						player.play("B");
						break;
					case 'C':
					case 'c':
						player.play("C");
						break;
					case 'D':
					case 'd':
						player.play("D");
						break;
					case 'E':
					case 'e':
						player.play("E");
						break;
					case 'F':
					case 'f':
						player.play("F");
						break;
					case 'G':
					case 'g':
						player.play("G");
						break;
					case '!':
						trataSom.dobraVolume(volumeAtual);
						break;
					case 'O':
					case 'o':
					case 'I':
					case 'i':
					case 'U':
					case 'u':
						trataSom.metadeVolume(volumeAtual);
						break;
					case '1':
					case '3':
					case '5':
					case '7':
					case '9':
						trataSom.aumentaOitava(oitavaAtual);
						break;
					case '0':
					case '2':
					case '4':
					case '6':
					case '8':
						trataSom.diminuiOitava(oitavaAtual);
						break;
					case ';':
						trataSom.aumentaBPM(bpmAtual);
						break;
					case ',':
						trataSom.diminuiBPM(bpmAtual);
						break;
					case '\n':
						trataSom.trocaInstrumento();
						break;
					default:
						player.play(" ");
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
			
			//reproduzir(null, texto, posicaoAtual);
			Player player = new Player();
			Pattern pattern = new Pattern("X[Volume]=20200 C0 C1 C2 C3 C4 C5 C6 C7");
			
			player.play(pattern);
			
		}
		
		public static void parar(String[] args, String[] texto) {
			
		}
		
}
