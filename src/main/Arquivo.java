package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.swing.JOptionPane;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;

public class Arquivo extends Texto
{
	public static void leArquivo(File arquivo)
	{
		FileInputStream bufferfile = null;
		String tempTexto = "";
		
		try 
		{
			bufferfile = new FileInputStream(arquivo);
			int content = 0;
			
			while((content = bufferfile.read()) != -1)
			{
				tempTexto += (char) content;
			}
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Erro na abertura do arquivo");
		}
		finally
		{
			try
			{
				if(bufferfile != null)
				{
					bufferfile.close();
				}
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "Erro ao fechar o arquivo");
			}
		}
	setTexto(tempTexto);
	}
	
	public static void escreveMIDI(Pattern pattern, File arquivo)
	{
		String caminho = arquivo.getAbsolutePath();
		if(!caminho.endsWith(".midi"))
		{
			arquivo = new File(caminho + ".midi");
		}
		try {
			MidiFileManager.savePatternToMidi(pattern, arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
