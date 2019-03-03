
public class TestBabouin {

	public static void main(String[] args) {
		
		Corde c = new Corde();
		Position p1 = Position.NORD;
		Position p2 = Position.SUD;
		Babouin[] b = new Babouin[10];
		
		for(int i = 0; i < 10; i++) {
			if(i%2 == 0)
				b[i] = new Babouin(c, p1);
			else
				b[i] = new Babouin(c, p2);
			Thread t = new Thread(b[i]);
			t.start();
		}

	}

}
