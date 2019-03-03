//3670631 3670460
public class Barbier implements Runnable{
	
	Salon s;
	
	public Barbier(Salon s) {
		this.s = s;
	}
	
	public void run(){
		try {
			while(true) {
				Client c;
				c = s.coifferClient();
				c.reveiller();
				System.out.println("le barbier coiffe le client "+c.id+"");
			}
		} catch (InterruptedException e) {}
	}
}
