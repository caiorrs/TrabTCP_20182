package main;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Commit Inicial");
		
		String texto = "CDE?CDE?CDE?CDE";
		
		operacoes.reproduzir(null, texto, 0); // reproduzir a partir da posicao 0
		System.out.println("\nVoltou\n");

		
		while(!operacoes.isFinished())
		{
			System.out.print(" ");
		}
		
		//System.out.println("REINICIOU");
		
		//operacoes.reiniciarReproducao(null, texto);
		
		System.out.println("\nFin*");
	}

}
