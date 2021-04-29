package controller;

import java.util.concurrent.Semaphore;

public class Cruzamento extends Thread {

	protected int idCarro;
	protected Semaphore semaforo;
	protected String sentido;
	protected int eixoY;
	protected int eixoX;

	public Cruzamento(int idCarro, Semaphore semaforo, String sentido, int eixoY, int eixoX) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
		this.sentido = sentido;
		this.eixoY = eixoY;
		this.eixoX = eixoX;
	}

	public void run() {
		try {
			semaforo.acquire();
			carroAndando();
			carroCruzou();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void carroAndando() {
		int distTotal = 10;
		int distPercorrida = 0;
		int deslocamento;
		while (distPercorrida < distTotal) {
			deslocamento = (int) (Math.random() * 3) + 1;
			distPercorrida += deslocamento;
			if (sentido == "Sul para Norte") {
				eixoY -= deslocamento;
			} else if (sentido == "Norte para Sul") {
				eixoY += deslocamento;
			} else if (sentido == "Oeste para Leste") {
				eixoX -= deslocamento;
			} else if (sentido == "Leste para Oeste") {
				eixoX += deslocamento;
			}
			System.out.println("#Carro " + idCarro + " passando de  " + sentido);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void carroCruzou() {
		System.out.println("#Carro " + idCarro + " cruzou de " + sentido);
	}
}