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
		
		int oitavaPadrao = 5;
		
		// todas as notas tem 10 oitavas, nem todas tem 11 (0-9, 0-10)
		
		if (oitava < 9) {
			oitava++;
		}
		else {
			oitava = oitavaPadrao;
		}
			
		return oitava;
		
	}
	
	public static int dobraVolume(int volume) {
		return volume * 2;
	}
	
	public static String trocaInstrumento(int instrumento) {
		
		final String piano = "PIANO";
		final String harpsichord = "HARPSICHORD"; 
		final String tubularBells = "TUBULAR_BELLS";
		final String panFlute = "PAN_FLUTE";
		final String churchOrgan = "CHURCH_ORGAN";
		
		String novoInstrumento = piano;
		
		switch(instrumento) {
			case 0:
				novoInstrumento = piano;
				break;
			case 7:
				novoInstrumento = harpsichord;
				break;
			case 15:
				novoInstrumento = tubularBells;
				break;
			case 76:
				novoInstrumento = panFlute;
				break;
			case 20:
				novoInstrumento = churchOrgan;
				break;
			default:
				novoInstrumento = piano;
				break;
		}
			
		return novoInstrumento;
	}

	public static int volumeMaisDezPorcento(int volume) {
		// TODO Auto-generated method stub
		volume = (int) (1.1 * volume);
		return volume;
	}
	
}
