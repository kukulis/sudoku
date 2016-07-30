package lt.gt.sudoku;

import java.util.Set;

public class Solver {
	public Board solveBoard(Board board) {
		Board solvingBoard = cloneBoard(board);

		while( doOneStep(solvingBoard) );

		return solvingBoard;
	}

	public static Board cloneBoard(Board b) {
		Board newBoard = new Board();
		for (int y = 0; y < 9; y++)
			for (int x = 0; x < 9; x++)
				newBoard.setB(x, y, b.getB(x, y));
		return newBoard;
	}

	public boolean doOneStep(Board b) {

		boolean anyWriting = false;

		CandidatesBoard cBoard = new CandidatesBoard();
		cBoard.initializeCandidates(b);
		cBoard.filterCandidates(b);

		// search single occurences of each digit for each Section
		for (Sections sections : Sections.values()) {

			/*
			 * use indexes from 1 to 9 index means value, and the value of array
			 * means occurences amount of that value
			 */
			int occurences[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			sections.getSection().getCoordinates().stream().map(cBoard::getCandidates).forEach(candidates -> {
				candidates.getCandidatesSet().forEach(e -> {
					occurences[e]++;
				});
			});

			// now we calculated occurences, we write value for each occurence
			// which value is 1 , to the board
			for (Coordinates c : sections.getSection().getCoordinates()) {
				Set<Integer> candidatesSet = cBoard.getCandidates(c).getCandidatesSet();
				for (int v = 1; v < occurences.length; v++)
					if (occurences[v] == 1 && candidatesSet.contains(v)) {
						b.setB(c.getX(), c.getY(), v);
						anyWriting = true;
					}
			}
		}

		return anyWriting;
	}
}
