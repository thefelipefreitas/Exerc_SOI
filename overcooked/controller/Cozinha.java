package controller;

import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class Cozinha extends Thread {

	protected int idPrato;
	protected Semaphore semaforo;
	protected String nomePrato;

	public Cozinha(int idPrato, Semaphore semaforo) {
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}

	public void run() {
		cozinhando();
		try {
			entrega();
			semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	public void cozinhando() {
		double cozimento = 0.0;
		double percentual = 0.0;
		int tempo = 100;

		if (idPrato % 2 == 0) {
			nomePrato = "Lasanha à Bolonhesa";
			double tempoPreparo = ((Math.random() * 600) + 600);
			System.out.println(nomePrato + " #" + idPrato + " começou a ser preparada.");

			while (cozimento < tempoPreparo) {
				try {
					sleep(tempo);
					cozimento += 100;
					percentual = ((cozimento * 100) / tempoPreparo);

					if (percentual > 100.00) {
						percentual = 100.00;
					}

					String format = new DecimalFormat("###.##").format(percentual);
					System.out.println("Panela" + " #" + idPrato + " " + format + "%");

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(nomePrato + " #" + idPrato + " pronta!");

		} else {
			nomePrato = "Sopa de Cebola";
			double tempoPreparo = ((Math.random() * 500) + 800);
			System.out.println(nomePrato + " #" + idPrato + " começou a ser preparada.");

			while (cozimento < tempoPreparo) {
				try {
					sleep(tempo);
					cozimento += 100;
					percentual = ((cozimento * 100) / tempoPreparo);

					if (percentual > 100.00) {
						percentual = 100.00;
					}

					String format = new DecimalFormat("###.##").format(percentual);
					System.out.println("Panela" + " #" + idPrato + " " + format + "%");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(nomePrato + " #" + idPrato + " pronta!");

		}
	}

	public void entrega() {
		try {
			sleep(500);
			System.out.println(nomePrato + " #" + idPrato + " saiu para entrega.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}