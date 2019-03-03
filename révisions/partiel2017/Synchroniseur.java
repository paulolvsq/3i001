public class Synchroniseur{

	private int n; //taille du tableau
	private int cpt = 0;

	public Synchroniseur(int n){
		this.n = n;
	}

	public void tousPasses(){
		synchronized(this){
			cpt++;
			if(cpt == n) notifyAll();
			cpt = 0;
		}
	}
}
