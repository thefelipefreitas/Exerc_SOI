package view;

import java.util.concurrent.Semaphore;
import controller.Cruzamento;

public class Main {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int tCarro = 0; tCarro < 4; tCarro++) {
			if (tCarro == 0) {
				Thread threadCarro = new Cruzamento(1, semaforo, "Sul para Norte", 5, 0);
				threadCarro.start();
			} else if (tCarro == 1) {
				Thread threadCarro = new Cruzamento(2, semaforo, "Norte para Sul", -5, 0);
				threadCarro.start();
			} else if (tCarro == 2) {
				Thread threadCarro = new Cruzamento(3, semaforo, "Oeste para Leste", 0, 5);
				threadCarro.start();
			} else {
				Thread threadCarro = new Cruzamento(4, semaforo, "Leste para Oeste", 0, -5);
				threadCarro.start();
			}
		}
	}
}
