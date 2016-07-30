package lt.gt.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Section {
	private Collection<Coordinates> c;

	public Section(Coordinates... coordinates) {
		c = Arrays.asList(coordinates);
	}

	public Section(List<Coordinates> coordinates) {
		c = coordinates;
	}

	public Collection<Coordinates> getCoordinates() {
		return c;
	}

	/**
	 * For lazy initialization.
	 *
	 */
	private static class All {
		private static Collection<Coordinates> ALL = createAllCoordinates();

		private static List<Coordinates> createAllCoordinates() {
//			System.out.println( "createAllCoordinates called");
			List<Coordinates> coordinates = new ArrayList<>();
			for (int y = 0; y < 9; y++) {
				for (int x = 0; x < 9; x++) {
					coordinates.add(new Coordinates(x, y));
				}
			}
			return coordinates;
		}
	}
	
	public static Collection<Coordinates> getAll() {
//		System.out.println( "getAll called");
		return All.ALL;
	}

}
