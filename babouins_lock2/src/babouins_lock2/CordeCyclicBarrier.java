package babouins_lock2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class CordeCyclicBarrier {
	
	private Semaphore mutex;
	private Semaphore etatOk;
	private CyclicBarrier b;
	private int cptCond;
	private Position etat;
	private int cpt;
	
	public CordeCyclicBarrier() {
		mutex = new Semaphore(1);
		etatOk = new Semaphore(0);
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
