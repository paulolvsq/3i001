public class Tableau{

	private int[] tab; //oblig� de le prot�ger car le tableau sera partag� avec toutes les instances de Comparateur -> conflits de lecture/�criture
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
		
