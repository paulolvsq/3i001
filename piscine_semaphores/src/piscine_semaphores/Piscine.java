package piscine_semaphores;

import java.util.concurrent.Semaphore;

public class Piscine {
	
	private Semaphore cabines;
	private Semaphore paniers;
	
	public Piscine(int nbCabines, int nbPaniers) {
		cabines = new Semaphore(nbCabines);
		paniers = new Semaphore(nbPaniers);
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
	
	public void rendreCabine() {
		cabines.release();
	}
	
	public void rendrePanier() {
		paniers.release();
	}

}
