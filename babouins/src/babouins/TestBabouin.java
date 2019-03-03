package babouins;

public class TestBabouin {

	public static void main(String[] args) {
		
		final int NB_BABOUINS = 16;
		Corde c = new Corde();
		
		for(int i = 0; i < NB_BABOUINS; i++) {
			if(i%2 == 0)
				new Thread(new Babouin(Position.SUD, c)).start();
			else
				new Thread(new Babouin(Position.NORD, c)).start();
		}

	}

}
