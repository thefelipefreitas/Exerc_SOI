package controller;

import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class Caixa extends Thread {

	protected int idConta;
	protected Semaphore semaforoSaque;
	protected Semaphore semaforoDeposito;
	protected double saldoConta;
	protected double valorTrans;

	public Caixa(int idConta, Semaphore semaforoSaque, Semaphore semaforoDeposito) {
		this.idConta = idConta;
		this.semaforoSaque = semaforoSaque;
		this.semaforoDeposito = semaforoDeposito;
	}

	public void run() {
		recebe();
		transacao();
	}

	public void recebe() {
		saldoConta = ((Math.random() * 4000) + 1000);
		valorTrans = ((Math.random() * 2000) + 500);
	}

	public void transacao() {
		int tipoTransacao = (int) ((Math.random() * 2) + 1);
		if (tipoTransacao == 1) {
			try {
				semaforoSaque.acquire();
				saque();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoSaque.release();
			}
		} else {
			try {
				semaforoDeposito.acquire();
				deposito();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoDeposito.release();
			}
		}

	}

	public void saque() {
		saldoConta -= valorTrans;
		String format = new DecimalFormat("###.##").format(valorTrans);
		String format1 = new DecimalFormat("###.##").format(saldoConta);
		System.out.println(
				"#Conta " + idConta + " realizou um saque no valor de R$" + format + ". Saldo atual: " + format1);
	}

	public void deposito() {
		saldoConta += valorTrans;
		String format = new DecimalFormat("###.##").format(valorTrans);
		String format1 = new DecimalFormat("###.##").format(saldoConta);
		System.out.println(
				"#Conta " + idConta + " realizou um deposito no valor de R$" + format + ". Saldo atual: " + format1);
	}
}
