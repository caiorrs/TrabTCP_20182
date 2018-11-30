package main;

public class instrumento extends Som{
	Som som = new Som();
	private int instrumentoAtual = 0;
	
	
	
	public int getInstrumentoAtual() {
		return instrumentoAtual;
	}

	public void setInstrumentoAtual(int instrumentoAtual) {
		this.instrumentoAtual = instrumentoAtual;
	}
	
	private int calculaPosicaoDoNovoInstrumento(int instrumento, int numeroDaPosicaoDoNovoInstrumento)
	{
		return instrumento + numeroDaPosicaoDoNovoInstrumento;
	}
	
	private int calculaNovoInstrumento(int PosicaoDoNovoInstrumento)
	{
		final int mapeadorDeInstrumento = 128;
		
		return PosicaoDoNovoInstrumento % mapeadorDeInstrumento;
	}
	
	public void trocaInstrumento(int numeroDaPosicaoDoNovoInstrumento)
	{
		final int posicaoDoUltimoInstrumento = 127;
		
		int PosicaoDoNovoInstrumento;
		int novoInstrumento;
		
		PosicaoDoNovoInstrumento = calculaPosicaoDoNovoInstrumento(this.instrumentoAtual, numeroDaPosicaoDoNovoInstrumento);
		
		if(PosicaoDoNovoInstrumento > posicaoDoUltimoInstrumento)
			novoInstrumento = calculaNovoInstrumento(PosicaoDoNovoInstrumento);
			// se estiver no instrumento 125 e o digito for 9 -> 134%128 = instrumento 6
		else
			novoInstrumento = PosicaoDoNovoInstrumento;
		
		this.instrumentoAtual = (novoInstrumento);
	}
	
	public String toString(int novoInstrumento) {
		return "i" + novoInstrumento;
	}
	
	
	
	
	
	///public void trocaInstrumento(int instrumento)
	//{
	//	 this.instrumentoAtual = instrumento;
	//}

}
