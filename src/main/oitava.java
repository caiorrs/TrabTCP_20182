package main;

public class oitava extends Som{

	Som som = new Som();
	
	private int oitavaAtual = oitavaInicial;
	

	public int getOitavaAtual() {
		return oitavaAtual;
	}

	public void setOitavaAtual(int oitavaAtual) {
		this.oitavaAtual = oitavaAtual;
	}
	
	public void aumentaOitava()
	{
		final int aumentoDaOitava = 1;
		int novaOitava;
		
		novaOitava = this.oitavaAtual + aumentoDaOitava;
		
		if(novaOitava  < maiorOitava)
		{
			this.oitavaAtual = novaOitava;
		}
		else
		{
			this.oitavaAtual = maiorOitava;
		}	
	}
}
