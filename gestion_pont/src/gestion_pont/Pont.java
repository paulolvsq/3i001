package gestion_pont;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Pont {

	private int nbOn;
	private ReentrantLock lock;
	private Condition vide;
	private Condition enAttenteSens;
	
	public Pont() {
		nbOn = 0;
		lock = new ReentrantLock();
		vide = lock.newCondition();
		enAttenteSens = lock.newCondition();
	}
	
	public void attendreVide() {
		lock.lock();
		try {
			while(nbOn > 0)
				vide.await();
		} catch (InterruptedException e) {
			
		} finally {
			lock.unlock();
		}
	}
	
	public void entrer() {
		lock.lock();
		try {
			nbOn++;
		} finally {
			lock.unlock();
		}
	}
	
	public void sortir() {
		lock.lock();
		try {
			nbOn--;
			if(nbOn == 0) {
				vide.signalAll();
				enAttenteSens.signalAll();
			}
		} finally {
			lock.unlock();
		}
	}
	
}
