package babouins_lock2;

import java.util.concurrent.CyclicBarrier;

public class TestBabouins {
	
	public static void main(String[] args) {
		
		final int NB_BABOUINS = 12;
		CordeCyclicBarrier c = new CordeCyclicBarrier();
		CyclicBarrier b = new CyclicBarrier(5);
		
		for(int i = 0; i < NB_BABOUINS; i++)
			if(i%2 == 0)
				new Thread(new Babouin(Position.NORD, c, b)).start();
			else
				new Thread(new Babouin(Position.SUD, c, b)).start();
		
	}

}
