/**
 * 
 */
package main;

import org.jfugue.player.Player;

/**
 * @author blackbeard
 *
 */
public class jfugueInicio {
	private static String La = " A ";
	private static String Si = " B ";
	private static String Do = " C ";
	private static String Re = " D ";
	private static String Mi = " E ";
	private static String Fa = " F ";
	private static String Sol = " G ";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ENTRADA = "ABCDE DCB ABCDE DCB A";
		
		System.out.println("HELLO WORLD");
		Player player = new Player();
	    //player.play("C D E F G A B");
		//String saida = "";
		//player.play(saida);

		int tamanhoEntrada = ENTRADA.length();
		
		String saida = "";
		
		for (int i = 0; i < tamanhoEntrada; i++) {
			switch(ENTRADA.charAt(i)) {
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
			}
		}
	}

}
