package ex14_2;

public class TestBabouin {
	
	public static void main(String[] args){
		
		int nb_babouins = 10;
		Corde c = new Corde();
		Position p1 = Position.NORD; 
		Position p2 = Position.SUD;
		Babouin[] b = new Babouin[nb_babouins];
		
		for(int i = 0; i < nb_babouins; i++){
			if(i%2 == 0)
				b[i] = new Babouin(p1, c);
			else
				b[i] = new Babouin(p2, c);
			Thread t = new Thread(b[i]);
			t.start();
		}
		
	}

}
