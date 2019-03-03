package exercice9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SegTournant implements Runnable{
	
	private ReentrantLock lock = new ReentrantLock();
	
	private Condition entree = lock.newCondition();
	private Condition vide = lock.newCondition();
	
	private Condition disponible = lock.newCondition();
	private boolean occupe = false;
	private int pos = 0;
	
	public void run() {
		try {
			while (true) {
				attendreAppel();
				seDeplacer();
				attendreEntree();
				seDeplacer();
				attendreVide();
			}
		}
		catch (InterruptedException e) {
			System.out.println("Terminaison sur interruption du segment tournant");
		}
	}
	
	public void appeler(int id) throws InterruptedException{
		lock.lock();
		try {
			while (occupe)
				disponible.await();
			pos = id;
		}
		finally {
			lock.unlock();
		}
	}
	
	public void attendreAppel(){
		lock.lock();
		disponible.signalAll();
		System.out.println("il a bougé à la position: "+pos);
		lock.unlock();
	}
	
	
	
	public void seDeplacer() throws InterruptedException{
	}
	
	public void attendrePositionOK() throws InterruptedException {
		Thread.sleep(100);
	}
	
	
	
	public void entrer(int id) {
	}
	
	public void attendreEntree() throws InterruptedException{
	}
	
	
	
	public void sortir(int id) {
	}
	
	public void attendreVide() throws InterruptedException{
	}
	
	
	
	public int getPosition() {
		return pos;
	}
}
