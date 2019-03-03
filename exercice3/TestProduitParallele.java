//num: 3670631 & 3670460
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestProduitParallele {

	public static void main(String[] args) {

		
		final int NB_THREADS = 10;
		MatriceEntiere m1 = new MatriceEntiere(new File("m1"));
		MatriceEntiere m2 = m1.transposee();
		System.out.println(m1);
		System.out.println(m2);
		MatriceEntiere res = new MatriceEntiere(m1.getNbLignes(), m2.getNbColonnes());
		
		ExecutorService exec = Executors.newFixedThreadPool(NB_THREADS);
		ArrayList<Future<Integer>> l = new ArrayList<Future<Integer>>();
		
		try {
		
			for(int i = 0; i < res.getNbLignes(); i++) {
				for(int j = 0; j < res.getNbColonnes(); j++) {
					//new Thread(new CalculeElem(m1, m2, i, j, res)).start();
					//exec.execute(new CalculeElem(m1, m2, i, j, res));
					l.add(exec.submit(new q4td9(m1, m2, i, j, res)));
				}
			}
			exec.shutdown();
			//while (!exec.isTerminated());
			
			for(int i = 0; i < res.getNbLignes(); i++) {
				for(int j = 0; j < res.getNbColonnes(); j++) {
					Integer v = l.get(i*res.getNbLignes()+j).get();
					res.setElem(i, j, v.intValue());
				}
			}
	
		} catch (Exception e) {e.printStackTrace();}
		System.out.println(res);

	}
	
}
