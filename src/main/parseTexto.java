package main;

public class parseTexto extends Texto{
	
	
	private static String separadorDeInstrucoes = " ";
	
	private static final int harpsichord = 7;
	private static final int tubularBells = 15;
	private static final int panFlute = 76;
	private static final int churchOrgan = 20;

	private static StringBuilder trocaInstrumento(int novoInstrumento, instrumento instrumento, StringBuilder parsedEntry)
	{
		parsedEntry.append(instrumento.toString(novoInstrumento));
		instrumento.setInstrumentoAtual(novoInstrumento);
		return parsedEntry;
	}
	
	private static StringBuilder alteraVolume(volume volume, StringBuilder parsedEntry)
	{
		int volumeAtual = 0;
	
		volume.dobraVolume();
		volumeAtual = volume.getVolumeAtual();
		parsedEntry.append(volume.getVolume());
		parsedEntry.append(volumeAtual);
		
		return parsedEntry;
	}
	
	public static StringBuilder parse(String texto) {
		
		boolean notaAnteriorValida = false;
		boolean caractereEhDigito = false;
		int digito = 0;
		int posicaoInicial = 0;
		char caractereNovo = ' ';
		char caractereAnterior = ' ';
		
		int tamanhoEntrada = texto.length();
		StringBuilder parsedEntry = new StringBuilder();

		for (int i = posicaoInicial; i < tamanhoEntrada; i++)
		{
			caractereEhDigito = Character.isDigit(texto.charAt(i));
			
			if(caractereEhDigito)
			{ 
				instrumento instrumento = new instrumento();
				digito = Character.getNumericValue(texto.charAt(i));
				int instrumentoAtual;
				int novoInstrumento = 0;
				
				instrumentoAtual = instrumento.getInstrumentoAtual();
				parsedEntry.append("I");
				
				instrumento.trocaInstrumento(digito);
				novoInstrumento = instrumento.getInstrumentoAtual();
				parsedEntry.append(novoInstrumento);
			}
			else
			{
				instrumento instrumento = new instrumento();
				volume volume = new volume();
				oitava Oitava = new oitava();
				caractereNovo = texto.charAt(i);
				switch(caractereNovo)
				{
				// Notas
					case 'A':
					case 'B':
					case 'C':
					case 'D':
					case 'E':
					case 'F':
					case 'G':
						
						oitava oitava = new oitava();
						int oitavaAtual = 0;
						
						oitavaAtual = oitava.getOitavaAtual();
						parsedEntry.append(caractereNovo);
						parsedEntry.append(oitavaAtual);
						break;

				// Instrumentos
					case '!':
						parsedEntry = trocaInstrumento(harpsichord,instrumento, parsedEntry);
						break;
					case ';':
						parsedEntry = trocaInstrumento(panFlute,instrumento, parsedEntry);
						break;
					case '\n':
						parsedEntry = trocaInstrumento(tubularBells,instrumento, parsedEntry);
						break;
					case ',':
						parsedEntry = trocaInstrumento(churchOrgan,instrumento, parsedEntry);
						break;
				// Volume
					case ' ':
						parsedEntry = alteraVolume(volume, parsedEntry);
						
						break;
					case 'i':
					case 'I':
					case 'o':
					case 'O':
					case 'u':
					case 'U':
						parsedEntry = alteraVolume(volume, parsedEntry);parsedEntry = alteraVolume(volume, parsedEntry);
						break;
				// Oitavas
					case '?':
					case '.':
						
						
						Oitava.aumentaOitava();
						break;
				// Else
					default: // Cobre minusculas, consoantes e qualquer outra coisa
						if (i > 0)
						{
							caractereAnterior = texto.charAt(i-1);
							notaAnteriorValida = caractereAnterior >= 'A' && caractereAnterior <= 'G';
							
							if (notaAnteriorValida)
							{
								int OitavaAtual = Oitava.getOitavaAtual();
								parsedEntry.append(texto.charAt(i-1));
								parsedEntry.append(OitavaAtual);
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
			}
			if(i != tamanhoEntrada - 1)
			{
				parsedEntry.append(separadorDeInstrucoes);
			}
		}
		return parsedEntry;
	}
	
}
