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
//on cr�e autant de threads qu'il y a de comparaisons -> pas optimal et de plus on doit attendre que les pr�c�dentes soient termin�es, �a revient quasiment � faire de la programmation s�quentielle
