package exercice9;

public class PoolHangars {

	private Hangar[] pool;
	private final int N;
	
	public PoolHangars(int n) {
		N = n;
		pool = new Hangar[N];
		for(int i = 0; i< N; i++)
			pool[i] = new Hangar();
	}
	
	public Hangar getHangarDisponible() {
		for (Hangar h:pool) {
			if (h.getOccupe() == false)
				return h;
		}
		return null;
	}
	
	public Hangar getHangar(int id) {
		return pool[id - 1];
	}
	
}
