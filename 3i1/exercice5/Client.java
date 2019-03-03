//3670631 3670460
public class Client implements Runnable{
	
	private Salon s;
	private static int cpt = 0;
	public int id;
	
	public Client(Salon s) {
		this.s = s;
		cpt++;
		id=cpt;
	}
	
	public void run() {
		try {
			if (s.entrerClient(this))
				attendre();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public synchronized void attendre() throws InterruptedException {
		wait();
	}
	
	public synchronized void reveiller() {
		notify();
	}
}
