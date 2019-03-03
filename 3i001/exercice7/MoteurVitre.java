//3670631 3670460
public class MoteurVitre implements Runnable {
	private Cote cote;
	private Position position;
	private Position positionInitiale;
	private Operation derniereOpDemandee;
	private boolean allume;
	private Gestionnaire g;
	
	public MoteurVitre(Cote c, Gestionnaire g) {
		this.cote = c;
		this.position = Position.HAUTE;
		this.positionInitiale = position;
		this.g = g;
		allume = true;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public synchronized void demander(Operation operation) {
		derniereOpDemandee = operation;
		reveiller();
	}
	
	public void run() {
		show(position.toString());
		while (allume) {
			try {
				endormir();
				int val = (int)(Math.random()*1000);
				Thread.sleep(val);
				positionInitiale = position;
				switch (derniereOpDemandee) {
					case MONTER:
						this.position = Position.HAUTE;
						break;
					case DESCENDRE:
						this.position = Position.BASSE;
						break;
					case NIL:
						break;
				}
				show(position.toString());
				g.reveiller(cote.ordinal());
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	public synchronized void endormir() throws InterruptedException {
		wait();
	}
	
	public synchronized void reveiller() {
		notify();
	}
	
	public synchronized void couper() {
		allume = false;
	}
	
	public synchronized void returnToPositionInitiale() {
		if (positionInitiale == Position.HAUTE)
			this.demander(Operation.MONTER);
		else ;
	}
	
	public void show(String s) {
		System.out.println("MoteurVitre "+cote+" : "+s);
	}
}
