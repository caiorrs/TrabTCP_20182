package main;

public class som
{	
	private static int volumeMaximo = 16383;
	private static int maiorOitava = 9; // todas as notas tem oitavas de 0 a 9 mas nem todas tem 0 a 10
	private static int oitavaPadrao = 5; // segundo a biblioteca (na versao 4)
	
	public static int aumentaOitava(int oitava)
	{
		if(oitava  < maiorOitava)
		{
			oitava = oitava + 1;
		}
		else
		{
			oitava = oitavaPadrao;
		}
		
		return oitava;
	}
	
	public static int dobraVolume(int volume)
	{
		if (volume * 2 < volumeMaximo)
		{
			volume = volume  * 2;
		}
		else
		{
			volume = volumeMaximo;
		}
		
		return volume;
	}
	
	public static int aumentaVolumeDezPorcento(int volume)
	{
		if (volume * 1.1 < volumeMaximo)
		{
			volume = (int) 1.1 * volume;
		}
		else
		{
			volume = volumeMaximo;
		}
		
		return volume;
	}
	
	public static int trocaInstrumento(int instrumento, int digito)
	{
		if((instrumento + digito) > 127)
			instrumento = (instrumento + digito) % 128;
			// se estiver no instrumento 125 e o digito for 9 -> 134%128 = instrumento 6
		else
			instrumento = instrumento + digito;
		
		return instrumento;
	}
	
	public static int trocaInstrumento(int instrumento)
	{
		return instrumento;
	}
}
