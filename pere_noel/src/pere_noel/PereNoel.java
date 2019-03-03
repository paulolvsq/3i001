package pere_noel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PereNoel implements Runnable {
	
	private final int NB_TOTAL_RENNES;
	private int nbRennesAtteles = 0;
	private boolean busy = false;
	private ReentrantLock lock;
	private Condition pereNoelDispo;
	private Condition renneDispo;
	
	public PereNoel(int nb) {
		NB_TOTAL_RENNES = nb;
		lock = new ReentrantLock();
		pereNoelDispo = lock.newCondition();
		renneDispo = lock.newCondition();
	}
	
	public void sayHello() {
		lock.lock();
		try {
			while(busy)
				pereNoelDispo.await();
			busy = true;
			pereNoelDispo.signalAll();
		} catch (InterruptedException e) {
			
		} finally {
			lock.unlock();
		}
	}
	
	public void attelerRenne() {
		lock.lock();
		try {
			while(!busy)
				renneDispo.await();
			Thread.sleep(300);
			nbRennesAtteles++;
			System.out.println("Encore un renne attele");
			System.out.println("Il y a maintenant "+nbRennesAtteles+" rennes atteles");
			busy = false;
			pereNoelDispo.signalAll();
		} catch (InterruptedException e) {
			
		} finally {
			lock.unlock();
		}
	}
	
	public void run() {
		try {
			System.out.println("J'attends mes rennes");
			while(nbRennesAtteles != NB_TOTAL_RENNES)
				attelerRenne();
			Thread.sleep(100);
			System.out.println("Je monte dans le traineau");
		} catch (InterruptedException e) {
			
		}
	}

}
