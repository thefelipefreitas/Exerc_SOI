package view;

import controller.ImprimeThreads;

public class Main {

	public static void main(String[] args) {

		for (int idThread = 0; idThread < 5; idThread++) {
			Thread t = new ImprimeThreads(idThread);
			t.start();
		}
	}
}
