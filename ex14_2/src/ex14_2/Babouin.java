package ex14_2;

public class Babouin implements Runnable{

	private Corde c;
	private Position p;
	private int id;
	private static int cpt = 0;
	
	public Babouin(Position p, Corde c){
		this.c = c;
		this.p = p;
		id = ++cpt;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void run() {
		try {
			System.out.println("Babouin "+id+" arrive devant la corde");
			c.prendreCorde(p);
			System.out.println("Babouin "+id+" prend la corde");
			Thread.sleep((long) (100 + Math.random() + 500));
			System.out.println("Babouin "+id+" traverse le pont");
			c.relacherCorde(p);
			System.out.println("Babouin "+id+" relache la corde");
		} catch (InterruptedException e) {
			
		}
	}
	
}
