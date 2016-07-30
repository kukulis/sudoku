package lt.gt.sudoku.test;

import org.junit.Test;

import lt.gt.sudoku.Board;
import lt.gt.sudoku.BoardLoader;
import lt.gt.sudoku.Solver;
import lt.gt.sudoku.Util;

public class TestBoard {

	// @Test
	public void testLoad() {
		/* @formatter:off */
		Board b= BoardLoader.loadBoard(
				1,2,3,4,5,6,7,8,9,
				1,2,3,4,5,6,7,8,9,
				1,2,3,4,5,6,7,8,9,
				1,2,3,4,5,6,7,8,9,
				1,2,3,4,5,6,7,8,9,
				1,2,3,4,5,6,7,8,9,
				1,2,3,4,5,6,7,8,9,
				1,2,3,4,5,6,7,8,9,
				1,2,3,4,5,6,7,8,9
				);
		/* @formatter:on */

		System.out.println("Board loaded");
	}

	@Test
	public void testSolve() {
		/* @formatter:off */
		Board b= BoardLoader.loadBoard(
				9,0,6,0,0,2,0,0,0,
				7,0,4,0,0,1,0,0,5,
				1,3,2,0,0,7,0,0,8,
				0,9,0,0,4,0,0,0,2,
				0,0,1,0,0,0,6,0,0,
				6,0,0,0,3,0,0,7,0,
				2,0,0,7,0,0,9,8,4,
				8,0,0,5,0,0,7,0,6,
				0,0,0,6,0,0,1,0,3
				);
		/* @formatter:on */

		String boardStr = Util.printBoard(b);
		System.out.println("The board:\n" + boardStr);

		// CandidatesBoard cBoard = new CandidatesBoard();
		// cBoard.initializeCandidates( b );
		// cBoard.filterCandidates( b);
		//
		// String candidatesStr = Util.printCandidates( cBoard );
		// System.out.println( "The candidates:\n"+candidatesStr);

		Solver solver = new Solver();

		// solver.doOneStep( b );
		Board solvedBoard = solver.solveBoard(b);

		System.out.println("After solving board=\n" + Util.printBoard(solvedBoard));

	}
}
