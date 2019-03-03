package philosophes;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {

	private boolean dispo;
	private int id;
	private static int cpt = 0;
	private Object mutex = new Object();
	private ReentrantLock lock;
	private Condition estDispo;
	
	public ChopStick() {
		dispo = true;
		synchronized(mutex) {
			id = ++cpt;
		}
		lock = new ReentrantLock();
		estDispo = lock.newCondition();
	}
	
	public void prendreBaguette() {
		lock.lock();
		try {
			while(!dispo)
				estDispo.await();
			dispo = false;
		} catch (InterruptedException e) {
			
		} finally {
			lock.unlock();
		}
	}
	
	public void relacherBaguette() {
		lock.lock();
		try {
			dispo = true;
			estDispo.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
}
