package exercice11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Serveur implements Runnable{

	private Lock l = new ReentrantLock();
	private Condition sortie = l.newCondition();
	private boolean travail = false;
	private ReponseRequete r ;
	private Client c;
	private int num;
	private int type;

	public void attendreRequete() throws InterruptedException{
		l.lock();
		try {
			while(!travail) {
				System.out.println("Serveur en attente...");
				sortie.await();
			}

		}finally {
			l.unlock();
		}
	}

	public void traiterRequete() {
		new Thread(new Servant(r, c, num, type));
		synchronized(this) {
			travail = false;
		}
	}

	public void soumettre(Client c, int num, int type) {
		l.lock();
		try {
			while(travail) {
				System.out.println("Client "+c.getId()+" attend de soumettre la requete "+num);

				//entree.await();
			}
			System.out.println("Client "+c.getId()+" soumet la requete "+num);
			travail = true;
			this.c = c;
			this.num=num;
			this.type=type;
			sortie.signalAll();
		}
		finally {
			l.unlock();
		}
	}

	public void run() {
		try {
			while(true) {
				attendreRequete();
				traiterRequete();
			}
		}
		catch (InterruptedException e) {
			System.out.println("Serveur interrompu");
		}
	}
}
