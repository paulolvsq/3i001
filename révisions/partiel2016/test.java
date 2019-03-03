public synchronized boolean sInscrire(int id){
    if(this.ouvert == true){
		liste.add(id);
		return true;
	}
	return false;
}

public synchronized void attendrePremA2() throws InterruptedException{
    while(liste.size() == 0){
	    wait();
	}
	ouvert = false;
						 }

private ReentrantLock l = new ReentrantLock();
private Condition ecrire = l.newCondition();
private Condition lire = l.newCondition();	
private boolean plein = false;
private int val;

public void ecrire(int x){
	l.lock();
	try{
		while(ouvert){
			ecrire.await();
		}
		lire.signalAll();
		val = x;
		ouvert = false;
	} catch (InterruptedException e){}
	finally{
		l.unlock();
	}
}

public int lire(){
	int x;
	l.lock();
	try{
		while(!ouvert){
			lire.await();
		}
	    ecrire.signalAll();
	    x = val;
		ouvert = false;
		return val;
	} catch (InterruptedException e){}
	finally{
		l.unlock();
	}
}
