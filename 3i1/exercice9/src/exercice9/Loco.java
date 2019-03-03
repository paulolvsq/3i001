package exercice9;

public class Loco implements Runnable{

	int id;
	private static int cpt = 0;
	private static Object m = new Object();
	private SegAccueil sAccueil;
	private SegTournant sTournant;
	private PoolHangars pHangars;
	
	public Loco(SegAccueil sa, SegTournant st, PoolHangars ph) {
		synchronized(m) {
			id = cpt++;
		}
		sAccueil = sa;
		sTournant = st;
		pHangars = ph;
	}
	
	public void run() {
		try
		{
			sAccueil.reserver();
			sTournant.appeler(0);
			sTournant.attendrePositionOK();
			sTournant.entrer(id);
			sAccueil.liberer();
			sTournant.attendrePositionOK();
			pHangars.getHangar( sTournant.getPosition() ).entrer(id);
			sTournant.sortir(id);
		}
		catch
		(InterruptedException e) {
			System.out.println("Loco " + id + " interrompue (ne devrait pas arriver)");
		}
	}
}
