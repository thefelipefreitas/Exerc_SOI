package view;

import controller.Corrida;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread corrida = new Corrida(i + 1);
			corrida.start();
		}
	}
}