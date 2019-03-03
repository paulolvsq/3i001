//3670631 3670460
import java.util.ArrayList;

public class Salon {
	
	private ArrayList<Client> places;
	private int taille;
	
	public Salon(int taille) {
		this.taille = taille;
		places = new ArrayList<Client>();
	}
	
	public synchronized boolean entrerClient(Client c) throws InterruptedException{
		if (places.size() < taille) {
			places.add(c);
			notifyAll();
			System.out.println("client "+c.id+" arrive");
			return true;
		}
		System.out.println("client "+c.id+" ne peut pas rentrer");
		return false;
	}
	
	public synchronized void attendreClient() throws InterruptedException{
		while(places.size()==0) {
			wait();
		}
	}
	
	public synchronized Client coifferClient() throws InterruptedException{
		attendreClient();
		Client c = places.remove(0);
		return c;
	}
		
	
	
}
