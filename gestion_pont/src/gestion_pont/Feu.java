package gestion_pont;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Feu {

	private Couleur couleur;
	private ReentrantReadWriteLock lock;
	
	public Feu(Couleur couleur) {
		this.couleur = couleur;
		lock = new ReentrantReadWriteLock();
	}
	
	public Feu() {
		this(Couleur.ROUGE);
	}
	
	public void attendreFeuVert() {
		lock.readLock().lock();
		try {
			while(couleur == Couleur.ROUGE) {
				synchronized(this) {
					lock.readLock().unlock();
					wait();
					lock.readLock().lock();
				}
			}
		} catch (InterruptedException e) {
			
		} finally {
			lock.readLock().unlock();
		}
	}
	
	public void changerCouleur() {
		lock.writeLock().lock();
		try {
			if(couleur == Couleur.ROUGE) {
				couleur = Couleur.VERT;
				synchronized(this) {
					notifyAll();
				}
			}
			else {
				couleur = Couleur.ROUGE;
			}
		} finally {
			lock.writeLock().unlock();
		}
	}
	
}
