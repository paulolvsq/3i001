package gestion_pont;

public class Vehicule implements Runnable {
	
	private static int cptNS = 0;
	private static int cptSN = 0;
	private int id;
	private Sens sens;
	private Feu feu;
	private Pont pont;
	private Object mutex = new Object();
	
	public Vehicule(Pont pont, Feu feu, Sens sens) {
		this.pont = pont;
		this.feu = feu;
		this.sens = sens;
		if(sens == Sens.NORD_SUD) {
			synchronized(mutex) {
				id = ++cptNS;
			}
		}
		else {
			synchronized(mutex) {
				id = ++cptSN;
			}
		}
	}
	
	public void traverser() {
		int min = 400, max = 600;
		try {
			Thread.sleep((long) (Math.random()*(max - min) + min));
		} catch (InterruptedException e) {
			
		}
	}
	
	public void run() {
		System.out.println("Voiture "+id+" attend le feu vert dans le sens "+sens);
		feu.attendreFeuVert();
		System.out.println("Voiture "+id+" entre sur le pont dans le sens "+sens);
		pont.entrer();
		System.out.println("Voiture "+id+" traverse le pont dans le sens "+sens);
		traverser();
		System.out.println("Voiture "+id+" sort du pont dans le sens "+sens);
		pont.sortir();
	}

}
