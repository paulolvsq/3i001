package babouins;

import java.util.concurrent.Semaphore;

public class Corde2 {
	//concerne uniquement les semaphores
	private Semaphore mutex;
	private Semaphore condition;
	private int cptCond;
	//attributs generaux
	private int cpt;
	private Position etat;
	
	public Corde2() {
		mutex = new Semaphore(1); //lock
		condition = new Semaphore(0); //condition
		cptCond = 0;
		cpt = 0;
		etat = null;
	}
	
	public void prendreCorde(Position p) {
		try {
			mutex.acquire(); //lock.lock()
			cptCond++; //incrémente le compteur de condition
			while(etat != null && etat != p && cpt > 5) {
				mutex.release(); //on relache le verrou
				condition.acquire(); //verrou sur la condition
				mutex.acquire(); //on reprend le verrou 
			}
			cptCond--; //décrémente le compteur de condition
			cpt++;
			etat = p;
			mutex.release(); //on relache le verrou
		} catch (InterruptedException e) {
			
		}
	}
	
	public void relacherCorde() {
		try {
			mutex.acquire(); //on prend le verrou
			cpt--; 
			if(cpt == 0) {
				etat = null;
				while(cptCond > 0) {
					cptCond--;
					condition.release();
				}
			}
			mutex.release();
		} catch (InterruptedException e) {
			
		}
	}

}
