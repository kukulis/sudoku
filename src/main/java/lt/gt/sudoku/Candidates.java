package lt.gt.sudoku;

import java.util.HashSet;
import java.util.Set;

public class Candidates {
	private Set<Integer> candidates = new HashSet<>();

	public Set<Integer> getCandidatesSet() {
		return candidates;
	}

	public void setCandidatesSet(Set<Integer> candidates) {
		this.candidates = candidates;
	}
}
