package view;

import java.util.concurrent.Semaphore;

import controller.Transacao;

public class Main {

	public static void main(String[] args) {
		int qntThreads = 3;
		Semaphore fila = new Semaphore(1);
		
		for (int i = 0; i < qntThreads; i++) {
			new Transacao(i, fila).start();
		}

	}

}
