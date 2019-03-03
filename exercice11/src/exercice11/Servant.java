package exercice11;

public class Servant implements Runnable{
	
	private ReponseRequete r ;
	private Client c;
	private int num;
	private int type;
	
	public Servant(ReponseRequete r, Client c, int num, int type) {
		this.r = r;
		this.c = c;
		this.num = num;
		this.type = type;
	}
	
	public void run() {
		System.out.println("Serveur traite la requete "+num+" du client "+c.getId());
		try{
			if (type == 1) {
				Thread.sleep((int)(Math.random()*1000+200));
			}
			else if (type == 2) {
				while(true);
			}
			r=new ReponseRequete(c, num, (int)(Math.random()*100));
			c.requeteServie(r);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
}
