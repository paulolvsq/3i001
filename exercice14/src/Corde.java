import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Corde {

	private ReentrantLock lock;
	private Condition etatOk;
	private Position etat;
	private int cpt;
	
	public Corde() {
		lock  = new ReentrantLock();
		etatOk = lock.newCondition();
		etat = null;
		cpt = 0;
	}
	
	public void acceder(Position p) {
		lock.lock();
		try {
			while(etat != null && p != etat && cpt > 5) {
				etatOk.await();
			}
			etat = p;
			cpt++;
		} catch (InterruptedException e) {
			
		} finally {
			lock.unlock();
		}
	}
	
	public void relacher(Position p) {
		lock.lock();
		try {
			cpt--;
			if(cpt == 0) {
				etat = null;
				etatOk.signalAll();
			}
		} finally {
			lock.unlock();
		}
	}
	
	public void accederKong(Position p) {
		
	}
	
}
