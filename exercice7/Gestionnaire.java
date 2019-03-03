//3670631 3670460
public class Gestionnaire implements Runnable{
	
	private MoteurVitre mvG;
	private MoteurVitre mvD;
	private boolean[] eteint;
	
	public Gestionnaire() {
		mvG = new MoteurVitre(Cote.GAUCHE, this);
		mvD = new MoteurVitre(Cote.DROITE, this);
		eteint = new boolean[2];
		eteint[0] = false;
		eteint[1] = false;
	}
	
	public void run() {
		Thread t1 = new Thread(mvG);
		Thread t2 = new Thread(mvD);
		
		t1.start();
		t2.start();
		
		mvG.demander(Operation.DESCENDRE);
		mvD.demander(Operation.DESCENDRE);
		
		try {
			endormir();
		} catch (InterruptedException e) {e.printStackTrace();}
		
		System.out.println("la capote se plie");
		
		mvG.returnToPositionInitiale();
		mvD.returnToPositionInitiale();
		
		mvG.couper();
		mvD.couper();
	}
	
	public synchronized void endormir() throws InterruptedException {
		wait();
	}
	
	public synchronized void reveiller(int num) {
		eteint[num] = true;
		if (eteint[0]==true && eteint[1]==true)
			notify();
	}
}
