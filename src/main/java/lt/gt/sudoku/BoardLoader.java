package lt.gt.sudoku;

public class BoardLoader {
	public static Board loadBoard(int... values) {
		if (values.length < 81)
			throw new RuntimeException("Need 81 values, but received only " + values.length);

		Board b = new Board();
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				int value = values[y * 9 + x];
				validateValue(value);
				b.setB(x, y, value );
			}
		}

		return b;
	}
	
	private static void validateValue ( int value ) {
		if ( value > 9 )
			throw new RuntimeException ( "Value can't be greater than 9 (received  "+value+")" );
		if ( value < 0 )
			throw new RuntimeException ( "Value can't be negative (received  "+value+")" );
	}
}
