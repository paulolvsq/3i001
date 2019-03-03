//3670631
//3670460

public class Groupe implements Runnable{
	
	private static int cpt = 1;
	private int id;
	private int nb;
	private Salle salle;
	private int[][] pos;
	
	public Groupe(int nb, Salle s){
		this.nb = nb;
		id = cpt;
		cpt++;
		salle = s;
		pos = new int[nb][2];
	}
	
	public int getNb(){
		return nb;
	}
	
	public int getId() {
		return id;
	}
	
	public void setPos(int place, int[] position) {
		pos[place] = position;
	}
	
	public int[] getPos(int place) {
		return pos[place];
	}
	
	public void annulation() {
		salle.annuler(this, nb);
	}
	
	public void run(){
		salle.reserver(this);
	}
}
