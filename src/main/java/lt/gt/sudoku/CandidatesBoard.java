package lt.gt.sudoku;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CandidatesBoard {
	private Candidates[] candidates;

	public CandidatesBoard() {
		candidates = new Candidates[81];
		for (int i = 0; i < 81; i++)
			candidates[i] = new Candidates();
	}

	public void initializeCandidates(Board b) {
		for (int y = 0; y < 9; y++)
			for (int x = 0; x < 9; x++)
				if (b.getB(x, y) == 0)
					getCandidates(x, y).getCandidatesSet().addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	}

	public Candidates getCandidates(int x, int y) {
		return candidates[y * 9 + x];
	}
	public Candidates getCandidates(Coordinates c ) {
		return getCandidates( c.getX(), c.getY() );
	}

	public void filterCandidates(Board b) {
		// get sections
		for (Sections sections : Sections.values()) {
			// calculate set of each section
			Set<Integer> sectionSet = sections.getSection().getCoordinates().stream().filter(c -> b.getB(c) != 0)
					.map(c -> b.getB(c)).collect(Collectors.toSet());
			// remove that set from candidates
			sections.getSection().getCoordinates().stream().filter( c -> b.getB(c) == 0 ).forEach( c -> {
				getCandidates(c).getCandidatesSet().removeAll( sectionSet );
			});
		}
	}
}
