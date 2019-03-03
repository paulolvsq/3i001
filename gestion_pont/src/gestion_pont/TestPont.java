package gestion_pont;

public class TestPont {
	
	public static void main(String[] args) {
		
		final int NB_VOITURES = 5;
		Feu feuNS = new Feu();
		Feu feuSN = new Feu();
		Pont pont = new Pont();
		Thread[] tNS = new Thread[NB_VOITURES];
		Thread[] tSN = new Thread[NB_VOITURES];
		
		for(int i = 0; i < NB_VOITURES; i++) {
			tNS[i] = new Thread(new Vehicule(pont, feuNS, Sens.NORD_SUD));
			tSN[i] = new Thread(new Vehicule(pont, feuSN, Sens.SUD_NORD));
			tNS[i].start();
			tSN[i].start();
		}
		
		Thread t = new Thread(new Controleur(pont, feuNS, feuSN));
		t.start();
	}

}
