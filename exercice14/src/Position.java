
public enum Position {
	
	NORD(0), SUD(1);
	final int index;

	private Position(int index) {
		this.index = index;
	}
		
	public int getIndex() {
		return this.index;
	}
	
}
