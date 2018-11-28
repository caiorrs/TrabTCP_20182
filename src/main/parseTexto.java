package main;

public class parseTexto{
	
	private static int volumeAtual = 10200;
	private static int instrumentoAtual = 0;
	private static int oitavaAtual = 5;

	public static StringBuilder parse(String texto) {
		
		boolean notaAnteriorValida = false;
		boolean caractereEhDigito = false;
		int digito = 0;
		int posicaoInicial = 0;
		char caractere = ' ';
		char caractereAnterior = ' ';
		
		int tamanhoEntrada = texto.length();
		StringBuilder parsedEntry = new StringBuilder();

		for (int i = posicaoInicial; i < tamanhoEntrada; i++)
		{
			caractereEhDigito = Character.isDigit(texto.charAt(i));
			digito = Character.getNumericValue(texto.charAt(i));
			
			if(caractereEhDigito)
			{
				
				parsedEntry.append("I");
				instrumentoAtual = Som.trocaInstrumento(instrumentoAtual, digito) ;
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
						volumeAtual = Som.dobraVolume(volumeAtual);
						parsedEntry.append("X[Volume]=");
						parsedEntry.append(volumeAtual);
						break;
					case 'i':
					case 'I':
					case 'o':
					case 'O':
					case 'u':
					case 'U':
						volumeAtual = Som.aumentaVolumeDezPorcento(volumeAtual);
						parsedEntry.append("X[Volume]=");
						parsedEntry.append(volumeAtual);
						break;
				// Oitavas
					case '?':
					case '.':
						oitavaAtual = Som.aumentaOitava(oitavaAtual);
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
		return parsedEntry;
	}
	
}