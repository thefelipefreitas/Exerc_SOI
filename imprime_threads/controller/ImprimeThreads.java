package controller;

public class ImprimeThreads extends Thread {

	protected int idThread;

	public ImprimeThreads(int t) {
		this.idThread = t;
	}

	public void run() {
		System.out.println(this.idThread);
	}

}