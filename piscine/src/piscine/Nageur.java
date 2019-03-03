package piscine;

public class Nageur implements Runnable {
	
	private int id;
	private Piscine p;
	private static int cpt = 0;
	private Object mutex = new Object();
	
	public Nageur(Piscine p) {
		this.p = p;
		synchronized(mutex) {
			id = ++cpt;
		}
	}
	
	public void run() {
		try {
			System.out.println("Nageur "+id+" arrive à la piscine");
			System.out.println("Nageur "+id+" veut prendre un panier et une cabine");
			Panier panier = p.prendrePanier();
			Cabine cabine = p.prendreCabine();
			System.out.println("Nageur "+id+" va rentrer dans la piscine");
			p.rendreCabine(cabine);
			System.out.println("Nageur "+id+" nage");
			Thread.sleep((long) (Math.random()*1000 + 200));
			System.out.println("Nageur "+id+" va quitter la piscine");
			cabine = p.prendreCabine();
			p.rendreCabine(cabine);
			p.rendrePanier(panier);
		} catch (InterruptedException e) {
			
		}
	}

}
