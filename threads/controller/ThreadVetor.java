package controller;

public class ThreadVetor extends Thread {

	protected int opc, vetor[] = new int[1000];

	public ThreadVetor(int opc, int[] vetor) {
		this.opc = opc;
		this.vetor = vetor;
	}

	public void run() {
		calcTempo();
	}

	private void calcTempo() {
		switch (opc) {

		case 0:
			double tempoInicial = System.nanoTime();
			
			for (int i = 0; i < vetor.length; i++) {
				int x = vetor[i];
			}
			
			double tempoFinal = System.nanoTime();
			double tempoTotal = tempoFinal - tempoInicial;
			tempoTotal = tempoTotal / Math.pow(10, 9);
			System.out.println("For: " + tempoTotal + "s.");
			break;

		case 1:
			double tempoInicio = System.nanoTime();
			
			for (int valores : vetor) {
				int x = valores;
			}
			
			double tempoFim = System.nanoTime();
			double tempoTot = tempoFim - tempoInicio;
			tempoTot = tempoTot / Math.pow(10, 9);
			System.out.println("For-each: " + tempoTot + "s.");
			break;
		}
	}
}