//3670631 3670460
public class Gestionnaire implements Runnable{
	
	private MoteurVitre mvG;
	private MoteurVitre mvD;
	
	public Gestionnaire() {
		mvG = new MoteurVitre(Cote.GAUCHE);
		mvD = new MoteurVitre(Cote.DROITE);
	}
	
	public void run() {
		Thread t1 = new Thread(mvG);
		Thread t2 = new Thread(mvD);
		
		t1.start();
		t2.start();
		
		mvG.demander(Operation.DESCENDRE);
		mvD.demander(Operation.DESCENDRE);
		
		mvG.reveiller();
		mvD.reveiller();
	}
}
