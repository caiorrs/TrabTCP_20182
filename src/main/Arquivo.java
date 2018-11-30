package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;

public class Arquivo extends Texto
{
	public static void leArquivo(File localArquivo)
	{
		String tempTexto = "";
		final int fimArquivo = -1;
		final FileInputStream arquivoVazio = null;
		FileInputStream arquivo = arquivoVazio;
		
		try 
		{
			arquivo = new FileInputStream(localArquivo);
			int posicaoArquivo = 0;
			
			posicaoArquivo = arquivo.read();
			
			while(posicaoArquivo != fimArquivo)
			{
				tempTexto += (char) posicaoArquivo;
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
				if(arquivo != null)
				{
					arquivo.close();
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
		try {
			MidiFileManager.savePatternToMidi(pattern, arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
