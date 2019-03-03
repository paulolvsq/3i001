package babouins_lock2;

import java.util.concurrent.Semaphore;

public class CordeSemaphore {
	
	private Semaphore mutex;
	private Semaphore etatOk;
	private Semaphore maxBabouins;
	private int cptCond;
	private Position etat;
	private int cpt;
	
	public CordeSemaphore() {
		mutex = new Semaphore(1);
		etatOk = new Semaphore(0);
		maxBabouins = new Semaphore(5);
		cptCond = 0;
		cpt = 0;
		etat = null;
	}
	
	public void prendreCorde(Position p) {
		try{
			mutex.acquire();
			cptCond++;
			while(p != etat && etat != null) {
				mutex.release();
				etatOk.acquire();
				mutex.acquire();
			}
			cptCond--;
			maxBabouins.acquire();
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
			maxBabouins.release();
			mutex.release();
		} catch (InterruptedException e) {
			
		}
	}

}
