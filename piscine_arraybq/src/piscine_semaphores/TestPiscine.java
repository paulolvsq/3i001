package piscine_semaphores;

public class TestPiscine {
	
	public static void main(String[] args) {
		
		final int NB_NAGEURS = 10;
		final int NB_CABINES = 3;
		final int NB_PANIERS = 5;
		
		Piscine p = new Piscine(NB_CABINES, NB_PANIERS);
		
		for(int i = 0; i < NB_NAGEURS; i++)
			new Thread(new Nageur(p)).start();
		
	}

}
