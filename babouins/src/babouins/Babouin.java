package babouins;

public class Babouin implements Runnable {
	
	private int id;
	private static int cpt = 0;
	private Object mutex = new Object();
	private Position p;
	private Corde c;
	
	public Babouin(Position p, Corde c) {
		synchronized(mutex) {
			id = ++cpt;
		}
		this.p = p;
		this.c = c;
	}
	
	public void traverser() {
		try {
			Thread.sleep((long) (Math.random()*1000 + 200));
		} catch (InterruptedException e) {
			
		}
	}
	
	public void run() {
		System.out.println("Babouin "+id+" veut prendre la corde en venant du "+p);
		c.prendreCorde(p);
		System.out.println("Babouin "+id+" a pris la corde en venant du "+p);
		System.out.println("Babouin "+id+" traverse depuis le "+p);
		traverser();
		System.out.println("Babouin "+id+" relache la corde");
		c.relacherCorde();
	}

}
