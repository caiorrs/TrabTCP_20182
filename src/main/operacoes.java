/**
 * 
 */
package main;

import org.jfugue.player.ManagedPlayer;

/**
 * @author caiorrs
 *
 */

import org.jfugue.player.Player;
import org.jfugue.pattern.*;

public class operacoes {

	/**
	 * @param args
	 */
		public static void reproduzir(String[] args, String texto, int posicao) {
		
			final int piano = 0;
			final int harpsichord = 7; 
			final int tubularBells = 15;
			final int panFlute = 76;
			final int churchOrgan = 20;
			final int oitavaPadrao = 5;
			
			boolean eh_consoante = false;
			
			String notaAnterior = "";
			String notaAtual = "";
			
			String instrumentoAtual = "PIANO";
			int volumeAtual = 0;
			int oitavaAtual = oitavaPadrao;
			
			Player player = new Player();

			int tamanhoEntrada = texto.length();

			for (int i = posicao; i < tamanhoEntrada; i++) {
				
				char caractere = texto.charAt(i);
				
				switch(caractere) {
					// NOTAS
					case 'A':
					case 'B':
					case 'C':
					case 'D':
					case 'E':
					case 'F':
					case 'G':
						notaAtual = String.valueOf(caractere);
						Pattern pattern = new Pattern();
						pattern.add("I[" + instrumentoAtual + "] " + notaAtual + String.valueOf(oitavaAtual));
						System.out.println(pattern.toString());
						player.play(pattern);
						break;
					
					// troca para harpischord
					case '!':
						instrumentoAtual = trataSom.trocaInstrumento(harpsichord);
						break;
					
					// Aumenta o volume em 10%
					case 'O':
					case 'o':
					case 'I':
					case 'i':
					case 'U':
					case 'u':
						volumeAtual = trataSom.volumeMaisDezPorcento(volumeAtual);
						break;
					case '.':
					case '?':
						oitavaAtual = trataSom.aumentaOitava(oitavaAtual);
						break;
					case ';':
						instrumentoAtual = trataSom.trocaInstrumento(panFlute);
						break;
					case ',':
						instrumentoAtual = trataSom.trocaInstrumento(churchOrgan);
						break;
					case '\n':
						instrumentoAtual = trataSom.trocaInstrumento(tubularBells);
						break;
					case ' ':
						trataSom.dobraVolume(volumeAtual);
						break;
					default:
						eh_consoante = i > 0 && (texto.charAt(i-1) <= 'G' && texto.charAt(i-1) >= 'A');
						if (eh_consoante) {
							notaAnterior = String.valueOf(texto.charAt(i-1));
							Pattern pattern2 = new Pattern();
							pattern2.add("I[" + instrumentoAtual + "] " + notaAnterior + String.valueOf(oitavaAtual));
							System.out.println(pattern2.toString());
							player.play(pattern2);
						}
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
