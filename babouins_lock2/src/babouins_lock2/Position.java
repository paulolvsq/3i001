package babouins_lock2;

public enum Position {
	
	NORD(0), SUD(0);
	
	private Position(int index) {
		this.index = index;
	}
	
	private final int index;
	
	public int getIndex() {
		return this.index;
	}

}
