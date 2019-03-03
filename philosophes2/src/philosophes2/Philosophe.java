package philosophes2;

public class Philosophe implements Runnable {

	private int id;
	private static int cpt = 0;
	private Object mutex = new Object();
	private ChopStick left, right;

	public Philosophe(ChopStick left, ChopStick right) {
		synchronized(mutex) {
			id = ++cpt;
		}
		this.left = left;
		this.right = right;
	}

	public void run() {
		boolean leftLock = false;
		boolean rightLock = false;
		System.out.println("Philosophe "+id+" pense");
		while(!leftLock && !rightLock) {
			try {
				try {
					leftLock = left.prendreBaguette();
					rightLock = right.prendreBaguette();
				} finally {
					if(leftLock && rightLock) {
						if(leftLock)
							left.relacherBaguette();
						if(rightLock)
							right.relacherBaguette();
						System.out.println("Philosophe "+id+" réessaie");
						Thread.sleep((long) (Math.random()*1000 + 200));
					}
				}
				System.out.println("Philosophe "+id+" mange");
			} catch (InterruptedException e) {

			} finally {
				left.relacherBaguette();
				right.relacherBaguette();
			}
		}

	}

}
