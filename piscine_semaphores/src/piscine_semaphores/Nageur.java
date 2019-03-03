package piscine_semaphores;

public class Nageur implements Runnable {
	
	private int id;
	private static int cpt = 1;
	private Object mutex = new Object();
	private Piscine p;
	
	public Nageur(Piscine p) {
		this.p = p;
		synchronized(mutex) {
			id = cpt++;
		}
	}
	
	public void run() {
		System.out.println("Nageur "+id+" rentre dans la piscine");
		System.out.println("Nageur "+id+" veut prendre un panier");
		p.prendrePanier();
		System.out.println("Nageur "+id+" veut prendre une cabine");
		p.prendreCabine();
		p.rendreCabine();
		System.out.println("Nageur "+id+" nage");
		try {
			Thread.sleep((int) (Math.random()*800 + 200));
		} catch (InterruptedException e) {
			
		}
		System.out.println("Nageur "+id+" veut reprendre une cabine");
		p.prendreCabine();
		p.rendreCabine();
		p.rendrePanier();
		System.out.println("Nageur "+id+" quitte la piscine");
	}
	
}
