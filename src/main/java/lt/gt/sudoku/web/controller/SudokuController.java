package lt.gt.sudoku.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SudokuController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String sudokuRoot(ModelMap model) {
		return "sudoku";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewBoard(@RequestParam(name = "id") int id,  ModelMap model) {
		model.addAttribute( "id", id );
		return "view";
	}
	
}
