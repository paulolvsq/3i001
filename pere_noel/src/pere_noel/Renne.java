package pere_noel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Renne implements Runnable {
	
	private int id;
	private static int cpt = 1;
	private PereNoel pn;
	private CyclicBarrier cb;
	private Object mutex = new Object();
	
	public Renne(PereNoel pn, CyclicBarrier cb) {
		synchronized(mutex) {
			id = cpt++;
		}
		this.pn = pn;
		this.cb = cb;
	}
	
	public void run() {
		try {
			System.out.println("Renne "+id+" veut dire bonjour au Pere Noel");
			pn.sayHello();
			System.out.println("Renne "+id+" dit bonjour au Pere Noel");
			System.out.println("Renne "+id+" attend les autres rennes");
			cb.await();
		} catch (BrokenBarrierException e) {
			System.out.println("Il manque un ou plusieurs rennes");
		} catch (InterruptedException e) {
			System.out.println("Thread interrompu");
		}
	}

}
