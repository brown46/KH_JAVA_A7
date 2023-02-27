package kh.spring.s02.board.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.s02.board.model.service.BoardService;
import kh.spring.s02.board.model.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {	
	@Autowired BoardService service;
//	@GetMapping("/boardinsert")
//	@RequestMapping(value ="/boardinsert", method =RequestMethod.GET)
	@GetMapping("/insert")
//	public ModelAndView viewInsertBoard(
	public void viewInsertBoard(
//			ModelAndView mv
			Model mo
		  ,	HttpServletRequest request
		  , HttpSession session
		  , BoardVO vo
		    ) {
		request.setAttribute("request", "request");
//		mv.addObject("test", "test value");
		mo.addAttribute("test","test");
//		mv.setViewName("boardinsert");
		mo.addAttribute("boardList", service.selectList()); 
		return;
	}
	@PostMapping("/insert")
//	@RequestMapping(value ="/boardinsert", method =RequestMethod.Post)
	public ModelAndView doInsertBoard(ModelAndView mv) {
		return mv;
//		return ;
	}

	@GetMapping("/update")
	public void viewUpdateBoard() {
		return ;
	}
	
	@GetMapping("/delete")
	public void viewDeleteBoard() {
		return ;
	}
	@GetMapping("/read")
	public void viewReadBoard(Model m 
		, @RequestParam(required = false, defaultValue ="5") int param1) {
		
		m.addAttribute("param1", param1);
		m.addAttribute("boardList", service.selectList());
		return ;
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler() {
		return "error";
	}
	
}
