package main;

public class volume extends Som{
	private int volumeAtual = volumeInicial;
	private String volume = "X[Volume]=";
	
	public String getVolume() {
		return volume;
	}
	
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	private int alteraVolume(int novoVolume)
	{
		int volume;
		
		if (novoVolume < volumeMaximo)
		{
			volume = novoVolume;
		}
		else
		{
			volume = volumeMaximo;
		}
		return volume;
	}
	
	private int alteraVolume(double novoVolume)
	{
		int volume;
		
		if (novoVolume < volumeMaximo)
		{
			volume = (int) novoVolume;
		}
		else
		{
			volume = volumeMaximo;
		}
		return volume;
	}
	
	public void dobraVolume()
	{
		final int dobraVolume = 2;
		int novoVolume; 
		
		novoVolume = this.volumeAtual * dobraVolume;
		novoVolume = alteraVolume(novoVolume);
	
		this.volumeAtual = novoVolume;
		
	}
	
	public void aumentaVolumeDezPorcento()
	{
		final double aumentoEmDezPorcento = 1.1;
		double novoVolume;
		
		novoVolume = this.volumeAtual * aumentoEmDezPorcento;
		
		this.volumeAtual = alteraVolume(novoVolume);
	}
	
	public int getVolumeAtual() {
		return volumeAtual;
	}

	public void setVolumeAtual(int volumeAtual) {
		this.volumeAtual = volumeAtual;
	}
}


