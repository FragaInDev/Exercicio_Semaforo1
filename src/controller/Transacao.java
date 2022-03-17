package controller;

import java.util.concurrent.Semaphore;

public class Transacao extends Thread{
	private int tId;
	private Semaphore semaforo;
	
	public Transacao(int id, Semaphore smf) {
		tId = id;
		semaforo = smf;
	}
	
	@Override
	public void run() {
		switch (tId % 3) {
		case 1:
			exeTransacao(1000, 200, 801); break;
		}
	}
	
	private void exeTransacao(int time, int t_min, int t_max) {
		for (int i = 0; i<2; i++) {
			int t_calc = (int) ((Math.random() * t_max) + t_min);
			try {
				System.out.println("Thread " + tId + ": efetuando calculos...");
				sleep(t_calc);
				
				semaforo.acquire();
				System.out.println("Thread " + tId + ": Transação concluída :)");
				sleep(time);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
	}
}
