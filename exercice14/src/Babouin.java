
public class Babouin implements Runnable{

	private static int cpt = 0;
	private int id;
	private Corde c;
	private Position p;
	
	public Babouin(Corde c, Position p) {
		id = cpt++;
		this.c = c;
		this.p = p;
	}
	
	public void run() {
		try {
			System.out.println("Babouin "+id+" arrive devant la corde");
			c.acceder(p);
			System.out.println("Babouin "+id+" va prendre la corde");
			Thread.sleep((long) (100 + Math.random() + 500));
			System.out.println("Babouin "+id+" traverse le pont");
			c.relacher(p);
			System.out.println("Babouin "+id+" relache la corde");
		} catch (InterruptedException e) {
			
		}
	}
}
