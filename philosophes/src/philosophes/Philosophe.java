package philosophes;

public class Philosophe implements Runnable {

	private int id;
	private static int cpt = 0;
	private Object mutex = new Object();
	private ChopStick left, right;
	
	public Philosophe(ChopStick left, ChopStick right) {
		synchronized(mutex) {
			id = ++cpt;
		}
		this.left = left;
		this.right = right;
	}
	
	public void run() {
		try {
			System.out.println("Philosophe "+id+" pense");
			Thread.sleep((long) (Math.random()*1000 + 200));
			System.out.println("Philosophe "+id+" veut prendre la baguette de gauche");
			left.prendreBaguette();
			System.out.println("Philosophe "+id+" a pris la baguette de gauche. Essaie droite");
			Thread.sleep((long) (Math.random()*1000 + 200));
			right.prendreBaguette();
			System.out.println("Philosophe "+id+" mange");
			System.out.println("Philosophe "+id+" repose la baguette de droite");
			right.relacherBaguette();
			System.out.println("Philosophe "+id+" repose la baguette de gauche");
			left.relacherBaguette();
		} catch (InterruptedException e) {
			
		}
	}
	
}
