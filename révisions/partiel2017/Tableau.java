public class Tableau{

	private int[] tab; //obligé de le protéger car le tableau sera partagé avec toutes les instances de Comparateur -> conflits de lecture/écriture
	private int n;
	private Random r = new Random();

	public Tableau(int n){
		this.n = n;
		tab = new int[n];
		for(int i = 0; i < n; i++){
			tab[i] = r.nextInt(100);
		}
	}

	public void permuterAvecSuivant(int i){
		synchronized(this){
			if(tab[i] > tab[i+1]){
				int tmp = tab[i];
				tab[i] = tab[i+1];
				tab[i+1] = tmp;
			}
		}
	}

}
		
