//num: 3670631 & 3670460
public class CalculeElem implements Runnable {
	
	private MatriceEntiere m1,m2,m3;
	private int i,j;
	
	public CalculeElem(MatriceEntiere m1, MatriceEntiere m2, int i, int j,
			MatriceEntiere m3){
		this.m1 = m1;
		this.m2 = m2;
		this.i = i;
		this.j = j;
		this.m3 = m3;
	}
	
	public void run() {
		int produit;
		try {
			produit = MatriceEntiere.produitLigneColonne(m1, i, m2, j);
			m3.setElem(i, j, produit);
		} catch (TaillesNonConcordantesException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
