package gestion_pont;

public class Controleur implements Runnable {

	private Pont pont;
	private Feu[] feux;
	
	public Controleur(Pont pont, Feu f1, Feu f2) {
		this.pont = pont;
		feux = new Feu[2];
		feux[0] = f1;
		feux[1] = f2;
	}
	
	public void laisserPasser() {
		int min = 400, max = 600;
		try {
			Thread.sleep((long) (Math.random()*(max - min) + min));
		} catch (InterruptedException e) {
			
		}
	}
	
	public void run() {
		int i = 0;
		while(true) {
			feux[i].changerCouleur();
			laisserPasser();
			feux[i].changerCouleur();
			pont.attendreVide();
			i = (i+1)%2;
		}
	}

}
