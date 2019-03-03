package piscine;

import java.util.concurrent.ArrayBlockingQueue;

public class Piscine {
	
	private ArrayBlockingQueue<Panier> listePaniers;
	private ArrayBlockingQueue<Cabine> listeCabines;
	
	public Piscine(int nbCabines, int nbPaniers) {
		listePaniers = new ArrayBlockingQueue<Panier>(nbPaniers, true);
		listeCabines = new ArrayBlockingQueue<Cabine>(nbCabines, true);
		for(int i = 0; i < nbPaniers; i++)
			listePaniers.add(new Panier(i));
		for(int j = 0; j < nbCabines; j++)
			listeCabines.add(new Cabine(j));
	}
	
	public Panier prendrePanier() throws InterruptedException {
		return listePaniers.take();
	}
	
	public Cabine prendreCabine() throws InterruptedException {
		return listeCabines.take();
	}
	
	public void rendrePanier(Panier p) {
		listePaniers.add(p);
	}
	
	public void rendreCabine(Cabine c) {
		listeCabines.add(c);
	}
}
