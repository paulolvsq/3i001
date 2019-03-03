package exercice9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SegAccueil {
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition entree = lock.newCondition();

	
	private boolean occupe = false;
	
	private SegAccueil() {
	}
	
	public void reserver() throws InterruptedException{
		lock.lock();
		try {
			while(occupe) {
				entree.await();
			}
			occupe = true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void liberer(){
		lock.lock();
		occupe = false;
		entree.signalAll();
		lock.unlock();
	}
}
