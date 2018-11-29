package main;

import org.jfugue.player.ManagedPlayer;
import org.staccato.StaccatoParser;
import org.jfugue.midi.MidiParserListener;


import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;

public class Operacoes
{
	private static ManagedPlayer player = new ManagedPlayer();

	public static void reproduzir(String texto)
	{
		
		StringBuilder parsedEntry = parseTexto.parse(texto);
		
		try
		{
			System.out.print("reproduzindo: ");

			System.out.print(parsedEntry);

			StaccatoParser parser = new StaccatoParser();
			Sequence sequence = new Sequence(Sequence.PPQ, 10);
			MidiParserListener listener = new MidiParserListener();
			parser.addParserListener(listener);
			parser.parse(parsedEntry.toString());
			sequence = listener.getSequence();
			
			player.start(sequence);
			//System.out.print(player.isPlaying());
			//System.out.print("\nfinishing execution\n");
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

	public static void pausar()
	{		
		if(player.isPlaying())
		{
			player.pause();
		}
		else
		{
			player.resume();
		}
	}

	public static boolean isStarted()
	{
		return player.isStarted();
	}
	
	public static void parar()
	{
		player.reset();
	}

	public static boolean isFinished()
	{
		return player.isFinished();
	}
	
	public static boolean isPlaying()
	{
		return player.isPlaying();
	}

	public static boolean isPaused()
	{
		return player.isPaused();
	}
}