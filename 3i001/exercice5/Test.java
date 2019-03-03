//3670631 3670460
public class Test {
	
	public static void main(String[] args) {
		
		Salon s = new Salon(4);
		int nbClient = 10;
		Thread[] tab = new Thread[nbClient];
		
		Barbier b = new Barbier(s);
		Thread bt = new Thread(b);
		bt.start();

		
		for(int i = 0; i < nbClient; i++) {
			tab[i] = new Thread(new Client(s));
			tab[i].start();
		}
		
		for(int i = 0; i < nbClient; i++) {
			try {
				tab[i].join();
			} catch (InterruptedException e) {}
		}
		
		
		try {
			bt.interrupt();
		} catch (Exception e) {}
		
		
	}
	
	
}
