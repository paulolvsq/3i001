public class Comparateur implements Runnable{

	private Tableau t;
	private int i;
	private Synchroniseur s;

	public Comparateur(Tableau t; int i; Synchronoseur s){
		this.t = t;
		this.i = i;
		this.s = s;
	}

	public void run(){
	}

}
//on crée autant de threads qu'il y a de comparaisons -> pas optimal et de plus on doit attendre que les précédentes soient terminées, ça revient quasiment à faire de la programmation séquentielle
