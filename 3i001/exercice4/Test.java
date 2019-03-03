//3670631
//3670460

public class Test {

	public static void main(String[] args) {
		Salle s = new Salle(5,5);
		Groupe g1 = new Groupe(4, s);
		Groupe g2 = new Groupe(3, s);
		Groupe g3 = new Groupe(3, s);
		Groupe g4 = new Groupe(6, s);
		
		Thread t1 = new Thread(g1);
		Thread t2 = new Thread(g2);
		Thread t3 = new Thread(g3);
		Thread t4 = new Thread(g4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(s);
		g3.annulation();
		System.out.println(s);
	}

}
