package piscine_semaphores;

public class Ressource {
	
	private int id;
	
	public Ressource(String nom, int id) {
		this.id = id;
		System.out.println(nom + " " + id);
	}


}
