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
	
	public static void reproduzir(String texto)
	{		
		try
		{
			StringBuilder parsedEntry = new StringBuilder();
			parsingTexto parsing = new parsingTexto();
			
			parsedEntry = parsing.parsing(parsedEntry);
			

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

	public static boolean isStarted() {
		
		return player.isStarted();
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
	
	public static boolean isPlaying()
	{
		return player.isPlaying();
	}

	public static long getPosition()
	{
		return player.getTickPosition();
	}

}