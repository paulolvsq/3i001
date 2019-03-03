package piscine2;

import java.util.concurrent.Semaphore;

public class Piscine {
	
	private Semaphore paniers;
	private Semaphore cabines;
	
	public Piscine(int nbCabines, int nbPaniers) {
		paniers = new Semaphore(nbPaniers);
		cabines = new Semaphore(nbCabines);
	}
	
	public void prendreCabine() {
		try {
			cabines.acquire();
		} catch (InterruptedException e) {
			
		}
	}
	
	public void prendrePanier() {
		try {
			paniers.acquire();
		} catch (InterruptedException e) {
			
		}
	}
	
	public void rendrePanier() {
		paniers.release();
	}
	
	public void rendreCabine() {
		cabines.release();
	}

}
