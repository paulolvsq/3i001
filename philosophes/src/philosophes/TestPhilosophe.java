package philosophes;

public class TestPhilosophe {

	public static void main(String[] args) {
		
		final int NB_PHILOSOPHES = 5;
		Thread[] philosophes = new Thread[NB_PHILOSOPHES];
		ChopStick[] baguettes = new ChopStick[NB_PHILOSOPHES];
		
		for(int i = 0; i < NB_PHILOSOPHES; i++) {
			baguettes[i] = new ChopStick();
		}
		
		for(int j = 0; j < NB_PHILOSOPHES; j++) {
			philosophes[j] = new Thread(new Philosophe(baguettes[j], baguettes[(j+1)%NB_PHILOSOPHES]));
			philosophes[j].start();
		}

	}

}
