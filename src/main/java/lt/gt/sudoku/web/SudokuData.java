package lt.gt.sudoku.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import lt.gt.sudoku.Board;
import lt.gt.sudoku.BoardLoader;
import lt.gt.sudoku.Solver;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION) // ConfigurableBeanFactory.SCOPE_SINGLETON
public class SudokuData {

	private List<Board> boards = new ArrayList<>();
	private int nextBoardId = 1;

	public SudokuData() {

	}

	@PostConstruct
	public void initData() {
		Board b = new Board();
		b.setId(nextBoardId++);
		b.setB(0, 0, 7);
		boards.add(b);
		Board b2= BoardLoader.loadBoard( 
				9,0,6,0,0,2,0,0,0,
				7,0,4,0,0,1,0,0,5,
				1,3,2,0,0,7,0,0,8,
				0,9,0,0,4,0,0,0,2,
				0,0,1,0,0,0,6,0,0,
				6,0,0,0,3,0,0,7,0,
				2,0,0,7,0,0,9,8,4,
				8,0,0,5,0,0,7,0,6,
				0,0,0,6,0,0,1,0,3 );
		b2.setId( nextBoardId++);
		boards.add( b2 );
	}

	public List<Board> getBoards() {
		return boards;
	}

	public int addBoard(int values[]) {
		Board b = BoardLoader.loadBoard(values);
		boards.add(b);
		b.setId(nextBoardId++);
		return b.getId();
	}

	public Board getBoard(int id) {
		return boards.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
	}

	public boolean updateBoard(int id, int[] data) {
		Board board = boards.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
		if (board == null)
			return false;

		// if (data.length != 81)
		// throw new RuntimeException("Data must be 81 digits, and we received "
		// + data.length);
		//
		Board b = BoardLoader.loadBoard(data);
		board.copyValuesFrom(b);

		return true;
	}

	public int createEmpty() {
		Board b = new Board();
		b.setId(nextBoardId++);
		boards.add(b);
		return b.getId();
	}

	public Board solveBoard(int id) {
		Board board = boards.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
		if (board == null)
			return null;

		Solver solver = new Solver();

		return solver.solveBoard(board);
	}
}
