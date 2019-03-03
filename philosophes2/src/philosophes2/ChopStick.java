package philosophes2;

import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {

	private int id;
	private static int cpt = 0;
	private Object mutex = new Object();
	private ReentrantLock lock;
	
	public ChopStick() {
		synchronized(mutex) {
			id = ++cpt;
		}
		lock = new ReentrantLock();
	}
	
	public boolean prendreBaguette() {
		return lock.tryLock();
	}
	
	public void relacherBaguette() {
		lock.unlock();
	}
	
}
