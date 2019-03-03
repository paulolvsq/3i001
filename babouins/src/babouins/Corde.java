package babouins;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Corde {
	
	private ReentrantLock lock;
	private Condition etatOk;
	private Position etat;
	private int cpt;
	
	public Corde() {
		lock = new ReentrantLock();
		etatOk = lock.newCondition();
		etat = null;
		cpt = 0;
	}
	
	public void prendreCorde(Position p) {
		lock.lock();
		try {
			while(etat != null && etat != p && cpt > 5)
				etatOk.await();
			cpt++;
			etat = p;
		} catch (InterruptedException e) {
			
		} finally {
			lock.unlock();
		}
	}
	
	public void relacherCorde() {
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

}
