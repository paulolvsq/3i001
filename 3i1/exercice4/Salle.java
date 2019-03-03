//3670631
//3670460

public class Salle {
	
	private int nbRangs;
	private int nbPlacesParRang;
	private boolean[][] placesLibres;
	
	public Salle(int nbRangs, int nbPlacesParRang){
		this.nbRangs = nbRangs;
		this.nbPlacesParRang = nbPlacesParRang;
		placesLibres = new boolean[nbRangs][nbPlacesParRang];
		for (int i = 0; i < nbRangs; i++){
			for (int j = 0; j < nbPlacesParRang; j++){
				placesLibres[i][j] = true;
			}
		}
	}
	
	
	private boolean capaciteOK(int n){
		int somme = 0;
		for (int i = 0; i < nbRangs; i++){
			for (int j = 0; j < nbPlacesParRang; j++){
				if (placesLibres[i][j])
					somme++;
				if (somme>=n)
					return true;
			}
		}
		return false;
	}
	
	private int nContiguesAuRangI(int n, int i){
		for (int j=0; j<nbPlacesParRang; j++){
			int somme = 0;
			while ((j+somme) < placesLibres[i].length && placesLibres[i][j+somme]){
				somme++;
				if (somme == n)
					return j;
			}
		}
		return -1;
	}
	
	private boolean reserverContigues(Groupe g){
		int n = g.getNb();
		if (n >= nbPlacesParRang)
			return false;
		for (int i=0; i<nbRangs; i++){
			int j = nContiguesAuRangI(n, i);
			if (j != -1){
				for (int y=0 ; y<n; y++){
					placesLibres[i][j+y] = false;
					int[] pos = {i, j+y};
					g.setPos(y, pos);
				}
				return true;
			}
		}
		return false;
	}
	
	//on a modifié le prototype pour Groupe au lieu
	//de n (on a besoin d'un groupe pour setPos et n = la taille d'un groupe (supposons)
	public synchronized boolean reserver(Groupe g){
		int n = g.getNb();
		if (capaciteOK(n)){
			if (reserverContigues(g))
				return true;
			int toAdd = n;
			for (int i = 0; i < nbRangs; i++){
				for (int j = 0; j < nbPlacesParRang; j++){
					if (placesLibres[i][j]){
						placesLibres[i][j] = false;
						int[] pos = {i,j};
						g.setPos(i, pos);
						toAdd--;
					}
					if (toAdd==0)
						return true;
				}
			}
		}
		return false;
	}
	
	public synchronized boolean annuler(Groupe g, int n) {
		for (int i=0; i< n; i++) {
			int[] pos = g.getPos(i);
			placesLibres[pos[0]][pos[1]] = true;
			//il faut supprimer pos[i] mais on ne peut pas car c'est un tableau .. il aurait fallu
			//passer par une ArrayList et pop l'élement correspondant
		}
		return true;
	}
	
	public String toString(){
		String s = "";
		for (int i = 0; i < nbRangs; i++){
			for (int j = 0; j < nbPlacesParRang; j++){
				if (placesLibres[i][j]) s+=" 0";
				else s+= " 1";
			}
			s+="\n";
		}
		return s;
	}
	
}
