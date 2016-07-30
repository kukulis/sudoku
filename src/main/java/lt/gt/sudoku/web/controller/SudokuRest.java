package lt.gt.sudoku.web.controller;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	
	
	public SudokuData getSudokuData() {
		SudokuData sudokuData = applicationContext.getBean( SudokuData.class );
		System.out.println( "SudokuRest.getSudokuData sudokuData.hash="+sudokuData.hashCode() );
		return sudokuData;
	}
}
