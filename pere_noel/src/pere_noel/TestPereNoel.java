package pere_noel;

import java.util.concurrent.CyclicBarrier;

public class TestPereNoel {
	
	public static void main(String[] args) {
		
		final int NB_RENNES = 9;
		PereNoel pn = new PereNoel(NB_RENNES);
		CyclicBarrier cb = new CyclicBarrier(NB_RENNES);
		new Thread(pn).start();
		for(int i = 0; i < NB_RENNES; i++) {
			new Thread(new Renne(pn, cb)).start();
		}
	}

}
