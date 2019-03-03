import java.util.concurrent.Semaphore;

public class Corde2 {

	private Semaphore mutex;
	private Semaphore etatOk;
	private int cptCond;
	private int cpt;
	private Position etat;
	
	public Corde2() {
		mutex = new Semaphore(1);
		etatOk = new Semaphore(0);
		cptCond = 0;
		cpt = 0;
		etat = null;
	}
	
	public void acceder(Position p) {
		try {
			mutex.acquire();
			cptCond++;
			mutex.release();
			etatOk.acquire();
			while(etat != null && p != etat) {
				mutex.acquire();
				cptCond--;
			}
			etat = p;
			cpt++;
		} catch (InterruptedException e) {
			
		} finally {
			mutex.release();
		}
		
	}
	
	public void relacher(Position p) {
		try{
			mutex.acquire();
			cpt--;
			if(cpt == 0) {
				etat = null;
				while(cptCond)
			}
		} catch (InterruptedException e) {
			
		} finally {
			mutex.release();
		}
	}
	
}
