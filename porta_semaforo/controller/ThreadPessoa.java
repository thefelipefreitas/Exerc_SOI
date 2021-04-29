package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {

	protected int idPessoa;
	protected static int posChegada;
	protected static int posSaida;
	protected Semaphore semaforo;

	public ThreadPessoa(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	public void run() {
		pessoaAndando();
		// ------Inicio Seção Crítica--------
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			// ------Fim Seção Crítica--------
			pessoaSaindo();
		}
	}

	private void pessoaAndando() {
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 5) + 2);
		int tempo = 1000;
		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idPessoa + " já caminhou " + distanciaPercorrida + "m.");
		}
		posChegada++;
		System.out.println("#" + idPessoa + " foi o " + posChegada + "o. a chegar.");
	}

	private void pessoaSaindo() {
		posSaida++;
		System.out.println("#" + idPessoa + " foi o " + posSaida + " o. a cruzar a porta.");
	}
}