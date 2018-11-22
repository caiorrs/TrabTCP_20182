/**
 * 
 */
package main;

/**
 * @author caiorrs
 *
 */
public class trataSom {

	/**
	 * @param args
	 */
	public static void posicaoReproducao(String[] args, int posicao) {
		// TODO Auto-generated method stub

	}
	
	public static int aumentaOitava(int oitava) {
		
		if (oitava < 10) {
			oitava++;
		}
			
		return oitava;
		
	}
	
	public static int diminuiOitava(int oitava) {
		
		if (oitava > 0) {
			oitava--;
		}
		
		return oitava;
		
	}
	
	public static int dobraVolume(int volume) {
		return volume * 2;
	}
	
	public static int metadeVolume(int volume) {
		return volume / 2;
	}

	public static int aumentaBPM(int bpm) {
		return bpm += 50;
	}
	
	public static int diminuiBPM(int bpm) {
		return bpm -= 50;
	}
	
	public static void trocaInstrumento() {
		// usar um random entre os instrumentos disponiveis
	}
	
}
