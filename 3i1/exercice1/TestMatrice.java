import java.io.*;

public class TestMatrice{
	public static void main(String[] args){
		try {
			File f1 = new File("donnees_produit1");

			MatriceEntiere m1 = new MatriceEntiere(f1);

			System.out.println(m1);
			System.out.println(m1.somme(m1));
			System.out.println(m1.scalaire(2));
			System.out.println(m1.transposee());
			System.out.println(m1.produit(m1.transposee()));
		} catch(Exception e){return ;}
	}
}
