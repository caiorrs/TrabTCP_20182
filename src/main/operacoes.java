package main;

import org.jfugue.player.ManagedPlayer;
import org.jfugue.player.ManagedPlayerListener;
import org.staccato.StaccatoParser;
import org.jfugue.midi.MidiParserListener;


import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;

public class operacoes
{
	private static ManagedPlayer player = new ManagedPlayer();
	private static boolean isPlaying = false;
	private static int volumeAtual = 10200;
	private static int instrumentoAtual = 0;
	private static int oitavaAtual = 5;

	public static void reproduzir(String texto, int posicaoInicial)
	{
		
		boolean notaAnteriorValida = false;
		boolean caractereEhDigito = false;
		int digito = 0;
		char caractere = ' ';
		char caractereAnterior = ' ';
		
		try
		{
			System.out.print("reproduzindo: ");
			int tamanhoEntrada = texto.length();
			StringBuilder parsedEntry = new StringBuilder();

			for (int i = posicaoInicial; i < tamanhoEntrada; i++)
			{
				caractereEhDigito = Character.isDigit(texto.charAt(i));
				digito = Character.getNumericValue(texto.charAt(i));
				
				if(caractereEhDigito)
				{
					
					parsedEntry.append("I");
					instrumentoAtual = som.trocaInstrumento(instrumentoAtual, digito) ;
					parsedEntry.append(instrumentoAtual);
				}
				else
				{
					caractere = texto.charAt(i);
					switch(caractere)
					{
					// Notas
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
						case 'G':
							parsedEntry.append(caractere);
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
							volumeAtual = som.dobraVolume(volumeAtual);
							parsedEntry.append("X[Volume]=");
							parsedEntry.append(volumeAtual);
							break;
						case 'i':
						case 'I':
						case 'o':
						case 'O':
						case 'u':
						case 'U':
							volumeAtual = som.aumentaVolumeDezPorcento(volumeAtual);
							parsedEntry.append("X[Volume]=");
							parsedEntry.append(volumeAtual);
							break;
					// Oitavas
						case '?':
						case '.':
							oitavaAtual = som.aumentaOitava(oitavaAtual);
							break;
					// Else
						default: // Cobre minusculas, consoantes e qualquer outra coisa
							if (i > 0)
							{
								caractereAnterior = texto.charAt(i-1);
								notaAnteriorValida = caractereAnterior >= 'A' && caractereAnterior <= 'G';
								if (notaAnteriorValida)
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

			player.addManagedPlayerListener(new ManagedPlayerListener()
			{
				@Override
				public void onFinished()
				{
					System.out.println("Finished");					
				}

				@Override
				public void onPaused()
				{
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onReset()
				{
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onResumed()
				{
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSeek(long arg0)
				{
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onStarted(Sequence arg0)
				{
					// TODO Auto-generated method stub
					System.out.println("\nStarted");
				}
			});
			
			player.start(sequence);
			isPlaying = true;
			System.out.print(player.isPlaying());
			System.out.print("\nfinishing execution\n");
		}
		catch(InvalidMidiDataException imde)
		{
			imde.printStackTrace();
			System.out.print("imde");
		}
		catch(MidiUnavailableException mue)
		{
			mue.printStackTrace();
			System.out.print("mue");
		}

	}

	public static void pausar() {
		
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
	}


	public static void reiniciarReproducao(String texto)
	{
		player.reset();
	}

	public static void parar(String[] args, String[] texto)
	{
		
	}

	public static boolean isFinished()
	{
		return player.isFinished();
	}

	public static long getPosition()
	{
		return player.getTickPosition();
	}

}