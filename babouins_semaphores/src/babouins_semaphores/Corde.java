package babouins_semaphores;

import java.util.concurrent.Semaphore;

public class Corde {
	
	private Semaphore mutex;
	private Semaphore etatOk;
	private Position etat;
	private int cpt;
	private int cptCond;
	
	public Corde() {
		mutex = new Semaphore(1);
		etatOk = new Semaphore(0);
		cpt = 0;
		cptCond = 0;
		etat = null;
	}
	
	public void prendreCorde(Position p) {
		try {
			mutex.acquire();
			cptCond++;
			while(etat != null && p != etat && cpt > 5) {
				mutex.release();
				etatOk.acquire();
				mutex.acquire();
			}
			cptCond--;
			cpt++;
			etat = p;
			mutex.release();
		} catch (InterruptedException e) {
			
		}
		
	}
	
	public void relacherCorde() {
		try {
			mutex.acquire();
			cpt--;
			if(cpt == 0) {
				etat = null;
				while(cptCond > 0) {
					etatOk.release();
					cptCond--;
				}
			}
			mutex.release();
		} catch (InterruptedException e) {
			
		}
	}

}
