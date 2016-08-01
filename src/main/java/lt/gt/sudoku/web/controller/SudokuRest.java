package lt.gt.sudoku.web.controller;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lt.gt.sudoku.Board;
import lt.gt.sudoku.web.SudokuData;

@RestController
public class SudokuRest implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	@RequestMapping(value = "/rest/list")
	public List<Board> getList() {
		return getSudokuData().getBoards();
	}
	
	@RequestMapping(path = "/rest/add", method = RequestMethod.PUT, consumes = "application/json")
	public int addBoard( @RequestBody int [] values ) {
		return getSudokuData().addBoard( values );
	}
	
	@RequestMapping(path = "/rest/new", method = RequestMethod.PUT)
	public int addEmpty() {
		return getSudokuData().createEmpty();
	}
	
	@RequestMapping(path = "/rest/get", method = RequestMethod.GET)
	public Board getBoard ( int id ) {
		return getSudokuData().getBoard(id);
	}
	
	
	@RequestMapping(path = "/rest/update", method = RequestMethod.POST, consumes = "application/json")
	public boolean updateBoard (@RequestParam(name = "id") int id, @RequestBody int [] data ) {
		return getSudokuData().updateBoard( id, data );
	}
	
	@RequestMapping(path = "/rest/solve", method = RequestMethod.GET)
	public Board solveBoard ( @RequestParam(name = "id") int id ) {
		return getSudokuData().solveBoard(id);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	
	/**
	 * Session bean getter.
	 * @return
	 */
	public SudokuData getSudokuData() {
		SudokuData sudokuData = applicationContext.getBean( SudokuData.class );
		System.out.println( "SudokuRest.getSudokuData sudokuData.hash="+sudokuData.hashCode() );
		return sudokuData;
	}
}
