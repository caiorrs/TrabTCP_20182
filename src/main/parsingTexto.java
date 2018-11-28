package main;

public class parsingTexto extends texto{
	
	boolean notaAnteriorValida = false;
	boolean caractereEhDigito = false;
	int digito = 0;
	int posicaoInicial = 0;
	char caractere = ' ';
	char caractereAnterior = ' ';

	
	public static StringBuilder alteraIntrumento(String instrumento, StringBuilder parsedEntry, int numero_instrumento)
	{
		parsedEntry.append(instrumento);
		main.som.setInstrumentoAtual(numero_instrumento);
		return parsedEntry;
	}
	
	public static StringBuilder alteraVolume(StringBuilder parsedEntry, int novoVolume)
	{
		main.som.setVolumeAtual(novoVolume);
		parsedEntry.append("X[Volume]=");
		parsedEntry.append(main.som.getVolumeAtual());
		return parsedEntry;
	}
	
	public static StringBuilder alteraVolume(StringBuilder parsedEntry, double novoVolume)
	{
		main.som.setVolumeAtual(novoVolume);
		parsedEntry.append("X[Volume]=");
		parsedEntry.append(main.som.getVolumeAtual());
		
		return parsedEntry;
	}
	
	
	public static StringBuilder Default(StringBuilder parsedEntry, int i, String texto)
	{
		if (i > 0)
		{
			if ( 'A' <= texto.charAt(i-1) && 'G' >= texto.charAt(i-1))
			{
				parsedEntry.append(texto.charAt(i-1));
				parsedEntry.append(main.som.getOitavaAtual());
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
		return parsedEntry;
	}
	
	
	public StringBuilder parsing(StringBuilder parsedEntry ) {
		
		String texto = main.texto.getTexto();
		
		System.out.print("reproduzindo: ");
		int tamanhoEntrada = texto.length();
		
		int posicaoInicial = 0;
		
		for (int i = posicaoInicial; i < tamanhoEntrada; i++) {
			
			if(Character.isDigit(texto.charAt(i)))
			{
				parsedEntry.append("I");
				main.som.setInstrumentoAtual(main.som.getInstrumentoAtual()+Character.getNumericValue(texto.charAt(i)));
				parsedEntry.append(main.som.getInstrumentoAtual());
			}
			else
			{
				if ('A' >= texto.charAt(i-1) && 'G' <= texto.charAt(i-1))
				{
					parsedEntry.append(texto.charAt(i));
					parsedEntry.append(main.som.getOitavaAtual());
				}
				else
				{
					switch(texto.charAt(i)) {
					// Instrumentos
						case '!':
							parsedEntry = alteraIntrumento("I7", parsedEntry, 7);
							break;
						case ';':
							parsedEntry = alteraIntrumento("I76", parsedEntry, 76);
							break;
						case '\n':
							parsedEntry = alteraIntrumento("I15", parsedEntry, 15);
							break;
						case ',':
							parsedEntry = alteraIntrumento("I20", parsedEntry, 20);
							break;
					// Volume
						case ' ':
							parsedEntry = alteraVolume(parsedEntry, main.som.getVolumeAtual()*2);
							break;
						case 'i':
						case 'I':
						case 'o':
						case 'O':
						case 'u':
						case 'U':
							parsedEntry = alteraVolume(parsedEntry, main.som.getVolumeAtual()*0.1);
							break;

					// Oitavas
						case '?':
						case '.':
							main.som.aumentaOitava(main.som.getOitavaAtual());
							break;

					// Else
						default: // Cobre tanto minusculas, quanto consoantes quanto qualquer outra coisa
							parsedEntry = Default(parsedEntry, i, texto);
					}

					if(i != tamanhoEntrada - 1)
					{
						parsedEntry.append(" ");
					}
				}
				}
				}
		return parsedEntry;
	}

}
