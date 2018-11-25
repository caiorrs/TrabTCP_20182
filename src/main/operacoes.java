package main;

import org.jfugue.player.ManagedPlayer;
import org.jfugue.player.ManagedPlayerListener;
import org.staccato.StaccatoParser;
import org.jfugue.midi.MidiParserListener;


import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;

public class operacoes {

	private static ManagedPlayer player = new ManagedPlayer();
	private static boolean isPlaying = false;
	private static int volumeAtual = 10200;
	private static int instrumentoAtual = 0;
	private static int oitavaAtual = 5;
	/**
	 * @param args
	 */
		public static void reproduzir(String texto) {
			
			int posicao = 0;
			try {
				System.out.print("reproduzindo: ");
				int tamanhoEntrada = texto.length();
				StringBuilder parsedEntry = new StringBuilder();

				for (int i = posicaoInicial; i < tamanhoEntrada; i++) {
					
					if(Character.isDigit(texto.charAt(i)))
					{
						parsedEntry.append("I");
						instrumentoAtual+= Character.getNumericValue(texto.charAt(i));
						parsedEntry.append(instrumentoAtual);
					}
					else
					{
						switch(texto.charAt(i)) {
						// Notas
							case 'A':
							case 'B':
							case 'C':
							case 'D':
							case 'E':
							case 'F':
							case 'G':
								parsedEntry.append(texto.charAt(i));
								parsedEntry.append(oitavaAtual);
								break;

						// Instrumentos
							case '!':
								parsedEntry.append("I7");
								instrumentoAtual = 7;
								break;
							case ';':
								parsedEntry.append("I76");
								instrumentoAtual = 76;
								break;
							case '\n':
								parsedEntry.append("I15");
								instrumentoAtual = 15;
								break;
							case ',':
								parsedEntry.append("I20");
								instrumentoAtual = 20;
								break;
						// Volume
							case ' ':
								volumeAtual = volumeAtual  * 2;
								parsedEntry.append("X[Volume]=");
								parsedEntry.append(volumeAtual);
								break;
							case 'i':
							case 'I':
							case 'o':
							case 'O':
							case 'u':
							case 'U':
								volumeAtual += volumeAtual  * 0.1;
								parsedEntry.append("X[Volume]=");
								parsedEntry.append(volumeAtual);
								break;

						// Oitavas
							case '?':
							case '.':
								oitavaAtual = som.aumentaOitava(oitavaAtual);
								break;

						// Else
							default: // Cobre tanto minusculas, quanto consoantes quanto qualquer outra coisa
								if (i > 0)
								{
									if ( 'A' <= texto.charAt(i-1) && 'G' >= texto.charAt(i-1))
									{
										parsedEntry.append(texto.charAt(i-1));
										parsedEntry.append(oitavaAtual);
									}
									else
									{
										parsedEntry.append('R');
									}
								}
								else
								{
									parsedEntry.append('R');
								}
								break;
						}

						if(i != tamanhoEntrada - 1)
						{
							parsedEntry.append(" ");
						}
					}
					}
					
					

				System.out.print(parsedEntry);

				StaccatoParser parser = new StaccatoParser();
				Sequence sequence = new Sequence(Sequence.PPQ, 10);
				MidiParserListener listener = new MidiParserListener();
				parser.addParserListener(listener);
				parser.parse(parsedEntry.toString());
				sequence = listener.getSequence();

				player.addManagedPlayerListener(new ManagedPlayerListener() {
					@Override
					public void onFinished() {
						System.out.println("Finished");					
					}

					@Override
					public void onPaused() {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onReset() {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onResumed() {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSeek(long arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onStarted(Sequence arg0) {
						// TODO Auto-generated method stub
						System.out.println("\nStarted");
						
					}
				});
				
				player.start(sequence);
				isPlaying = true;
				System.out.print(player.isPlaying());
				System.out.print("\nfinishing execution\n");
			} catch(InvalidMidiDataException imde) {
				imde.printStackTrace();
				System.out.print("imde");
			} catch(MidiUnavailableException mue) {
				mue.printStackTrace();
				System.out.print("mue");
			}

		}

		public static int pausar() {
			if(isPlaying == true)
			{
				player.pause();
				isPlaying = false;
			}
			else
			{
				player.resume();
				isPlaying = true;
			}
			int posicaoAtual = 5;

			return posicaoAtual;
		}
		public static void reiniciarReproducao(String[] args, String texto) {

		public static void parar(String[] args, String[] texto) {

		}

		public static boolean isFinished()
		{
			return player.isFinished();
		}

		public static long getPosition()
		{
			return player.getTickPosition();
		}


	public static void reproduzirDoComeco(String texto) {
		reproduzir(texto, 0);
	}


}
