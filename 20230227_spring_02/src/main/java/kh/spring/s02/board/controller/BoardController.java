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
	@GetMapping("/list")
//	public ModelAndView viewInsertBoard(
	public ModelAndView viewInsertBoard(
			ModelAndView mv
//			Model mo
		  ,	HttpServletRequest request
		  , HttpSession session
		  , BoardVO vo
		    ) {
		System.out.println("board List Controller!");
		request.setAttribute("request", "request");
//		mv.addObject("test", "test value");
//		mo.addAttribute("test","test");
		mv.setViewName("board/list");
		mv.addObject("boardList", service.selectList()); 
		return mv;
	}
//	@RequestMapping(value ="/boardinsert", method =RequestMethod.Post)
	@GetMapping("/insert")
	public ModelAndView doInsertBoard(ModelAndView mv, HttpSession session, BoardVO vo) {
		mv.setViewName("board/insert");
		return mv;
	}
	
	//TODO
//	@PostMapping("/insert")
	@GetMapping("/insertTest")
	public ModelAndView doInsertBoard(ModelAndView mv, BoardVO vo) {
		vo.setBoardContent("임시내용");
		vo.setBoardTitle("임시제목");
		vo.setBoardWriter("user22");
		mv.setViewName("board/insert");
		
		int result= service.insert(vo);
		return mv;
	}
	

	@GetMapping("/update")
	public void viewUpdateBoard() {
		return ;
	}
	
	@GetMapping("/delete")
	public void viewDeleteBoard() {
		int boardNum=13;
		int result= service.delete(boardNum);
		
	}
//	@GetMapping("/delete")
//	public void viewDeleteBoard() {
//	}
//	@GetMapping("/read")
//	public void viewReadBoard() {
//		int boardNum=1;
//		String writer = "user11";
//		BoardVO vo=  service.selectOne(boardNum, writer);
//		
//		
//	}
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
