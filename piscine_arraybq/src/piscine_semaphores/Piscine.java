package piscine_semaphores;

import java.util.concurrent.ArrayBlockingQueue;

public class Piscine {
	
	private ArrayBlockingQueue<Cabine> cabines;
	private ArrayBlockingQueue<Panier> paniers;
	
	public Piscine(int nbCabines, int nbPaniers) {
		cabines = new ArrayBlockingQueue<Cabine>(nbCabines);
		paniers = new ArrayBlockingQueue<Panier>(nbPaniers);
		for(int i = 0; i < nbCabines; i++)
			cabines.add(new Cabine(i));
		for(int j = 0; j < nbPaniers; j++)
			paniers.add(new Panier(j));
	}
	
	public Cabine prendreCabine() throws InterruptedException {
		return cabines.take();
	}
	
	public Panier prendrePanier() throws InterruptedException {
		return paniers.take();
	}
	
	public void rendreCabine(Cabine c) {
		cabines.add(c);
	}
	
	public void rendrePanier(Panier p) {
		paniers.add(p);
	}

}
