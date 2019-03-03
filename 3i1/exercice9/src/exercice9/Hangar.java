package exercice9;

public class Hangar {
	int id;
	private static int cpt = 1;
	private static Object m = new Object();
	
	private boolean occupe = false;
	private int trainID = -1;
	
	public Hangar() {
		synchronized(m) {
			id = cpt++;
		}
	}
	
	public synchronized void entrer(int id) {
		occupe = true;
		trainID= id;
	}
	
	public synchronized int sortie() {
		occupe = false;
		return trainID;
	}
	
	public boolean getOccupe() {
		return occupe;
	}
	
}
