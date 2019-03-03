public class Prod implements Runnable{

	private UneInteraction i;
	private int id;
	private static final Object mutex = new Object(); 
	private static int cpt = 0;

	public Prod(UneInteraction i){
		this.i = i;
		synchronized(mutex){
			cpt++;
			id = cpt;
		}
	}

	public void run(){
		for(int i = 0; i < 3; i++){
			this.i.envoyerMessage("message " + id + "." + x , id);
		}
	}
	   
}
