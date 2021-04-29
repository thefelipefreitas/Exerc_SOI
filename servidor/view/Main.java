package view;

import java.util.concurrent.Semaphore;
import controller.Servidor;

public class Main {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idThread = 1; idThread < 22; idThread++) {
			Thread tThread = new Servidor(idThread, semaforo);
			tThread.start();
		}
	}
}