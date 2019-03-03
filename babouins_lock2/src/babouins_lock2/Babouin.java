package babouins_lock2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Babouin implements Runnable {
	
	private Position p;
	private CordeCyclicBarrier c;
	private int id;
	private static int cpt = 1;
	private Object mutex = new Object();
	private CyclicBarrier b;
	
	public Babouin(Position p, CordeCyclicBarrier c, CyclicBarrier b) {
		synchronized(mutex) {
			id = cpt++;
		}
		this.p = p;
		this.c = c;
		this.b = b;
	}
	
	public void traverser() {
		try {
			Thread.sleep((int) (Math.random()*800 + 200));
		} catch (InterruptedException e) {
			
		}
	}
	
	public void run() {
		try {
			b.await();
		} catch (InterruptedException e) {
			
		} catch (BrokenBarrierException e) {
			
		}
		System.out.println("Babouin "+id+" veut prendre la corde et vient du "+p);
		c.prendreCorde(p);
		System.out.println("Babouin "+id+" a pris la corde en venant du "+p);
		System.out.println("Babouin "+id+" traverse en venant du "+p);
		traverser();
		System.out.println("Babouin "+id+" a traversé en venant du "+p);
		c.relacherCorde();
		System.out.println("Babouin "+id+" relache la corde en venant du "+p);
	}

}
