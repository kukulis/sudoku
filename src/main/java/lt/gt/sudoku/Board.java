package lt.gt.sudoku;

public class Board {
	private int b [][] = {
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0}
	};
	
	public void setB( int x, int y, int value ) {
		b[y][x]=value;
	}
	
	public int getB( int x, int y) {
		return b[y][x];
	}
	
	public int getB( Coordinates c ) {
		return getB( c.getX(), c.getY() );
	}
}
