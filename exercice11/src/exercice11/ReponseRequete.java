package exercice11;

public class ReponseRequete {

	private Client emetteur;
	private int id;
	private int val;
	
	public ReponseRequete(Client c, int i, int t) {
		emetteur = c;
		id = i;
		val = t;
	}
	
	public int getVal() {
		return val;
	}
	
	public String toString() {
		String s = "emetteur: "+emetteur.getId()+" id: "+id+" val: "+val;
		return s;
	}
}
