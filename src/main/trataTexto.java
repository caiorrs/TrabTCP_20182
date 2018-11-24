/**
 * 
 */
package main;

import org.jfugue.player.Player;

/**
 * @author caiorrs
 *
 */
public class trataTexto extends texto {

	/**
	 * @param args
	 */
	

	public static void parsing_texto(String texto)
	{
		Player player = new Player();
		controleSom trataSom = new controleSom();
		
		int tamanhoEntrada = texto.length();
		texto = texto.toUpperCase();

		int j = 0;

		int posicao = 0;

		for(int i = posicao;i<tamanhoEntrada;i++)
		{

			char caractere = texto.charAt(i);
			j++;

			if (Character.isDigit(caractere)) {
				int numero = Integer.parseInt(Character.toString(caractere));

				if (numero % 2 == 0) {
					trataSom.diminuiOitava(trataSom.getOitava());
				} else {
					trataSom.aumentaOitava(trataSom.getOitava());
				}
			} else {
				switch (caractere) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'G':
					player.play(Character.toString(caractere));
					break;
				case '!':
					trataSom.dobraVolume(trataSom.getVolume());
					break;
				case 'O':
				case 'I':
				case 'U':
					trataSom.metadeVolume(trataSom.getVolume());
					break;

				case ';':
					trataSom.aumentaBPM(trataSom.getBPM());
					break;
				case ',':
					trataSom.diminuiBPM(trataSom.getBPM());
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
	}
}