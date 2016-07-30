package lt.gt.sudoku;

public class CoordinatesAndValue extends Coordinates {
	private int value;
	
	public CoordinatesAndValue ( Coordinates c ) {
		super ( c.getX(), c.getY() );
	}
	public CoordinatesAndValue ( Coordinates c, int v ) {
		super ( c.getX(), c.getY() );
		this.value=v;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
