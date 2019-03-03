public class Cons implements Runnable{

    private UneInteraction i;
	private int id;
	private static final Object mutex = new Object(); 
	private static int cpt = 0;

	public Cons(UneInteraction i){
		this.i = i;
		synchronized(mutex){
			cpt++;
			id = cpt;
		}
	}

	public void run(){
		while(true){
			this.i.lireMessage();
		}
	}

}
