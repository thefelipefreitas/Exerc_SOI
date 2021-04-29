package controller;

import java.util.concurrent.Semaphore;

public class Servidor extends Thread {

	protected int idThread;
	protected Semaphore semaforo;

	public Servidor(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}

	public void run() {
		calculos();
		try {
			transacao(idThread);
			semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	public void calculos() {

		if (idThread % 3 == 1) {
			int tempoCalc = (int) ((Math.random() * 200) + 800);
			for (int i = 0; i < 2; i++) {
				try {
					sleep(tempoCalc);
					System.out.println("Thread" + " #" + idThread + " calculando...");
					transacao(idThread);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		if (idThread % 3 == 2) {
			int tempoCalc = (int) ((Math.random() * 500) + 1000);
			for (int i = 0; i < 3; i++) {
				try {
					sleep(tempoCalc);
					System.out.println("Thread" + " #" + idThread + " calculando...");
					transacao(idThread);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		if (idThread % 3 == 0) {
			int tempoCalc = (int) ((Math.random() * 1000) + 1000);
			for (int i = 0; i < 3; i++) {
				try {
					sleep(tempoCalc);
					System.out.println("Thread" + " #" + idThread + " calculando...");
					transacao(idThread);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void transacao(int id) {

		int opc = (id % 3);

		switch (opc) {

		case 1:
			int tempo = (int) ((Math.random() * 1000));
			try {
				sleep(tempo);
				System.out.println("Thread" + " #" + idThread + " fez uma transação de banco de dados.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;

		case 2:
			int tempo1 = (int) ((Math.random() * 1500));
			try {
				sleep(tempo1);
				System.out.println("Thread" + " #" + idThread + " fez uma transação de banco de dados.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;

		case 0:
			int tempo2 = (int) ((Math.random() * 1500));
			try {
				sleep(tempo2);
				System.out.println("Thread" + " #" + idThread + " fez uma transação de banco de dados.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;

		}
	}
}