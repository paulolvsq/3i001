//num: 3670631 & 3670460
import java.io.File;

public class TestProduitParallele {

	public static void main(String[] args) {
		
		MatriceEntiere m1 = new MatriceEntiere(new File("m1"));
		MatriceEntiere m2 = m1.transposee();
		
		System.out.println(m1);
		System.out.println(m2);

		MatriceEntiere res = new MatriceEntiere(m1.getNbLignes(), m2.getNbColonnes());
		
		for(int i = 0; i < res.getNbLignes(); i++) {
			for(int j = 0; j < res.getNbColonnes(); j++) {
				new Thread(new CalculeElem(m1, m2, i, j, res)).start();
			}
		}
		
		System.out.println(res);

	}
	
}
