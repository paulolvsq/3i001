public class ExoCours{

	public static void main(String[] args){

		Travail[] tab = new Travail[5];

		for(int i = 0; i < 5; i++){
			tab[i] = new Travail();
			tab[i].start();
		}
		for(int j = 0; j < 5; j++){
			tab[j].join();
		}

		System.out.println("Travail terminé");

	}
}
