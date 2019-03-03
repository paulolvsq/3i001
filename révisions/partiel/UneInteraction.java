public class UneInteraction{

	private ReentrantLock l = new ReentrantLock();
	private Condition ecrire = l.newCondition();
	private Condition lire = l.newCondition();
	private String message = "";
	private boolean plein = false;

	public void envoyerMessage(String s){
		l.lock();
		try{
			while(plein){
				ecrire.await();
			}
			lire.signalAll();
			message = s;
			plein = true;
		} catch (InterruptedException e){}
		finally{
			l.unlock();
		}
	}

	public void lireMessage(){
		l.lock();
		try{
			while(!plein){
				lire.await();
			}
			ecrire.signalAll();
			plein = true;
			System.out.println(message);
		} catch (InterruptedException e){}
		finally{
			l.unlock();
		}
	}
	
}		
