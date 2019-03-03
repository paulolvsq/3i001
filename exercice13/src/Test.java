import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		
		final int NB_CLIENTS = 5;
		ArrayList<Thread> tclients= new ArrayList<Thread>();
		
		Serveur s = new Serveur();
		Thread ts = new Thread(s);
		ts.start();
		
		for(int i = 0; i < NB_CLIENTS; i++) {
			Thread tc = new Thread(new Client(s));
			tclients.add(tc);
			tc.start();
		}
		
		for(Thread tc: tclients) {
			try {
				tc.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		ts.interrupt();
		
	}
}
