package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class arquivo extends texto
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
}
