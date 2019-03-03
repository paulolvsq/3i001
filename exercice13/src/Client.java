public class Client implements Runnable{

	private Serveur s;
	private int id;
	private static int cpt = 1;
	private static Object m = new Object();
	
	public Client(Serveur s) {
		synchronized(m) {
			id = cpt++;
		}
		this.s = s;
	}
	
	public synchronized void requeteServie(ReponseRequete r) {
		System.out.println(r);
		notify();
	}
	
	public int getId() {
		return id;
	}
	
	public void run() {
		synchronized(this) {
			int type = (id % 3 != 0) ? 1 : 2;
			for (int i = 0; i < 5; i++) {
				System.out.println("Client "+id+" essaie de soumettre la requete "+i);
				s.soumettre(this, i, type);
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
