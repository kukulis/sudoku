package lt.gt.sudoku.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import lt.gt.sudoku.Board;
import lt.gt.sudoku.BoardLoader;

@Component
@Scope (WebApplicationContext.SCOPE_SESSION ) // ConfigurableBeanFactory.SCOPE_SINGLETON
public class SudokuData {
	
	private List<Board> boards=new ArrayList<>();
	private int nextBoardId=1;

	public SudokuData () {
		
	}
	
	@PostConstruct
	public void initData() {
		Board b = new Board();
		b.setB(0, 0, 7);
		boards.add( b );
	}

	public List<Board> getBoards() {
		return boards;
	}
	
	public int addBoard ( int values[] ) {
		Board b = BoardLoader.loadBoard( values );
		boards.add( b );
		b.setId( nextBoardId ++ );
		return b.getId();
	}
}
