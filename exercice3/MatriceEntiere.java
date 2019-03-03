//num: 3670631 & 3670460
import java.io.*;
import java.util.Scanner;

public class MatriceEntiere{

	private int lignes;
	private int colonnes;
	private int[][] matrice;

	public MatriceEntiere(int lignes, int colonnes){
		this.lignes = lignes;
		this.colonnes = colonnes;
		this.matrice = new int[lignes][colonnes];
	}

	public MatriceEntiere(File fichier){
		try {
			BufferedReader in = new BufferedReader(new FileReader(fichier));
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(in);
			this.lignes = sc.nextInt();
			this.colonnes = sc.nextInt();
			this.matrice = new int[this.lignes][this.colonnes];
			for(int i = 0; i < lignes; i++){
				for(int j = 0; j < colonnes; j++){
					this.matrice[i][j] = sc.nextInt();
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public int getElem(int i, int j){
		return this.matrice[i][j];
	}

	public void setElem(int i, int j, int val){
		this.matrice[i][j] = val;
	}

	public int getColonnes(){
		return this.colonnes;
	}

	public int getLignes(){
		return this.lignes;
	}

	public int getNbLignes() {
		return lignes;
	}
	
	public int getNbColonnes() {
		return colonnes;
	}

	public String toString(){
		String str = "";
		str += lignes+" "+colonnes+"\n";
		for(int i = 0; i < lignes; i++){
			for(int j = 0; j < colonnes; j++){
				str += this.matrice[i][j] + "\t";
			}
			str += "\n";
		}
		return str;
	}

	public void initZero(){
		for(int i = 0; i < lignes; i++){
			for(int j = 0; j < colonnes; j++){
				this.matrice[i][j] = 0;
			}
		}
	}

	public MatriceEntiere transposee(){
		MatriceEntiere trans = new MatriceEntiere(colonnes, lignes);
		for(int i = 0; i < lignes; i++){
			for(int j = 0; j < colonnes; j++){
				trans.setElem(j, i, matrice[i][j]);
			}
		}
		return trans;
	}

	public MatriceEntiere somme(MatriceEntiere m) throws TaillesNonConcordantesException {

		if ((this.lignes != m.getLignes()) || (this.colonnes != m.getColonnes()))
			throw new TaillesNonConcordantesException("les tailles ne correspondent pas");

		MatriceEntiere res = new MatriceEntiere(lignes, colonnes);
		for(int i = 0; i < lignes; i++){
			for(int j = 0; j < colonnes; j++){
				res.setElem(i, j, this.matrice[i][j] + m.getElem(i, j));
			}
		}
		return res;
	}

	public MatriceEntiere scalaire(int s){
		MatriceEntiere res = new MatriceEntiere(lignes, colonnes);
		for(int i = 0; i < lignes; i++){
			for(int j = 0; j < colonnes; j++){
				res.setElem(i, j, this.getElem(i, j)*s);
			}
		}
		return res;
	}

	public MatriceEntiere produit(MatriceEntiere m) throws TaillesNonConcordantesException {

		if (this.lignes != m.getColonnes())
			throw new TaillesNonConcordantesException("les tailles ne correspondent pas");

		MatriceEntiere res = new MatriceEntiere(this.lignes, m.getColonnes());
		int s;
		for(int i = 0; i < lignes; i++) {
			for(int j = 0; j < m.getColonnes(); j++){
				s = 0;
				for (int x = 0; x < this.colonnes; x++){
					s += this.matrice[i][x] * m.getElem(x, j);
				}
				res.setElem(i, j, s);
			}
		}
		return res;
	}
	
	public static int produitLigneColonne(MatriceEntiere m1, int i, MatriceEntiere m2, int j) throws TaillesNonConcordantesException {
		
		if (m2.getNbLignes() != m1.getNbColonnes())
			throw new TaillesNonConcordantesException("les tailles ne correspondent pas");
		
		int produit = 0;
		for(int x = 0; x < m1.getColonnes(); x++) {
			produit += m1.getElem(i, x) * m2.getElem(x, j);
		}
		return produit;
	}
	
}

