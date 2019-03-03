import java.util.concurrent.Callable;

public class q4td9 implements Callable<Integer>{
	
	private MatriceEntiere m1,m2,m3;
	private int i,j;
	
	public q4td9(MatriceEntiere m1, MatriceEntiere m2, int i, int j,MatriceEntiere m3){
		this.m1 = m1;
		this.m2 = m2;
		this.i = i;
		this.j = j;
		this.m3 = m3;
	}
	
	public Integer call(){
		Integer v = 0;
		try {
			v =  (Integer)(MatriceEntiere.produitLigneColonne(m1, i, m2, j));
		} catch (TaillesNonConcordantesException e) {
			e.printStackTrace();
		}
		return v;
		
	}
	
}
