package ex14_2;

import java.util.concurrent.Semaphore;

public class Corde2 {
	
	private Semaphore mutex;
	private Semaphore etatOk;
	private int cptCond;
	private int cpt;
	private Position etat;
	
	public Corde2(){
		mutex = new Semaphore(1);
		cptCond = 0;
		etatOk = new Semaphore(0);
		cpt = 0;
		etat = null;
	}
	
	public void prendreCorde(Position p){
		try{
			mutex.acquire();
			cptCond++;
			mutex.release();
			etatOk.acquire();
			while(etat != p && etat != null && cpt > 5){
				mutex.acquire();
				cptCond--;
			}
			cpt++;
			etat = p;
		} catch (InterruptedException e){
			
		} finally {
			mutex.release();
		}
	}
	
	public void relacherCorde(Position p){
		try{
			mutex.acquire();
			cpt--;
			if(cpt == 0){
				etat = null;
				if(cptCond > 0){
					for(int i = 0; i < cptCond; i++){
						etatOk.release();
					}
				}
			}
		} catch(InterruptedException e){
			
		} finally {
			mutex.release();
		}
	}
	

}
