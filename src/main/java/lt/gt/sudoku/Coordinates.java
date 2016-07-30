package lt.gt.sudoku;

public class Coordinates {
	// column
	protected int x;
	// row
	protected int y;
	
	public Coordinates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
