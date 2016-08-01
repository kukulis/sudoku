package lt.gt.sudoku;

import java.io.Serializable;

public class Board implements Serializable {
	private static final long serialVersionUID = 6515811564706347263L;

	private int id = 0;

	private int b[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public void setB(int x, int y, int value) {
		b[y * 9 + x] = value;
	}

	public int getB(int x, int y) {
		return b[y * 9 + x];
	}

	public int getB(Coordinates c) {
		return getB(c.getX(), c.getY());
	}

	public int[] getValues() {
		return b;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void copyValuesFrom(Board b) {
		for ( int i=0; i <81; i++ )
			this.b[i]=b.getValues()[i];
	}
}
