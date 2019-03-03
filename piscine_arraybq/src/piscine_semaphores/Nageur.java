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
		try {
			System.out.println("Nageur "+id+" rentre dans la piscine");
			System.out.println("Nageur "+id+" veut prendre un panier");
			Panier panier = p.prendrePanier();
			System.out.println("Nageur "+id+" veut prendre une cabine");
			Cabine cabine = p.prendreCabine();
			p.rendreCabine(cabine);
			System.out.println("Nageur "+id+" nage");
		    Thread.sleep((int) (Math.random()*800 + 200));
			System.out.println("Nageur "+id+" veut reprendre une cabine");
			cabine = p.prendreCabine();
			p.rendreCabine(cabine);
			p.rendrePanier(panier);
			System.out.println("Nageur "+id+" quitte la piscine");
		} catch (InterruptedException e) {
			
		}
		
	}
	
}
