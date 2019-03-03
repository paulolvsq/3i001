//3670631 3670460
public class MoteurVitre implements Runnable {
	private Cote cote;
	private Position position;
	private Operation derniereOpDemandee;
	
	public MoteurVitre(Cote c) {
		this.cote = c;
		this.position = Position.HAUTE;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public synchronized void demander(Operation operation) {
		derniereOpDemandee = operation;
	}
	
	public void run() {
		show(position.toString());
		while(true) {
			try {
				endormir();
			} catch (InterruptedException e) {e.printStackTrace();}
			
			int val = (int)(Math.random()*1000);
			try {
				Thread.sleep(val);
			} catch (InterruptedException e) {e.printStackTrace();}
			
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
		}
	}
	
	public synchronized void endormir() throws InterruptedException {
		wait();
	}
	
	public synchronized void reveiller() {
		notify();
	}
	
	public void show(String s) {
		System.out.println("MoteurVitre "+cote+" : "+s);
	}
}
