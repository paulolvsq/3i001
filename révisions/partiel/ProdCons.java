public class ProdCons{
	
	public static void main(String[] args){

		try{
			int nbProd = Integer.parseInt(args[0]);
			int nbCons = Integer.parseInt(args[1]);
		} catch (Exception e) {
			System.out.println("Erreur d'arguments");
		}

		UneInteraction i = new UneInteraction();
	    
		for(int i = 0; i < nbProd; i++){
			Prod p = new Prod(i);
			p.start();
		}
		for(int j = 0; j < nbCons; j++){
			Cons c = new Cons(i);
			c.start();
		}

	}

}
		
		
