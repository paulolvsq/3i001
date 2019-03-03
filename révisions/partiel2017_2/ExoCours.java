public class ExoCours{

	public static void main(String[] args){

		Travail[5] tab = new Travail[5];

		for(int i = 0; i < 5; i++){
			tab[i] = new Travail();
			tab[i].start();
		}
		for(i = 0; i < 5; i++)
			tab[i].join();

		System.out.println("Tout est terminé");

	}
}
