package kh.spring.s02.board.controller;



import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.s02.board.model.service.BoardService;
import kh.spring.s02.board.model.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {	
	@Autowired BoardService service;
	
	
	private static final int BOARD_LIMIT=5;
	private static final int Page_LIMIT=3;
	@GetMapping("/list")
	public ModelAndView viewInsertBoard(
			ModelAndView mv
		  ,	HttpServletRequest request
		  , HttpSession session
		  , BoardVO vo
		    ) {
		
		//TODO
		//검색단어는 제목, 내용, 작성자에서 포함되어있으면 찾기
		//null 또는 ''은 검색하지 않음 
//		String searchword= null;
//		String searchword= "";
//		String searchWord= "답";//임시 테스트용
		//12345
		int currentPage= 1;		
//		int totalCnt= service.selectOneCount(searchWord);
		int totalCnt= service.selectOneCount();
		int totalPage = (totalCnt%BOARD_LIMIT==0) ?  (totalCnt/BOARD_LIMIT): (totalCnt/BOARD_LIMIT+1);
		int startPage=currentPage%Page_LIMIT==0 ? 
						(currentPage/Page_LIMIT-1)*Page_LIMIT+1
						:(currentPage/Page_LIMIT)*Page_LIMIT+1 ;
		int endPage=startPage+Page_LIMIT<totalPage? startPage+Page_LIMIT: totalPage ;
		
		Map<String, Integer> map = new HashMap();

		map.put("totalPage", totalPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("currentPage", currentPage);
		
//		mv.addObject("totalCnt",totalCnt); 
//		mv.addObject("totalPage",totalPage); 
//		mv.addObject("startPage",startPage); 
//		mv.addObject("currentPage",currentPage); 
		mv.addObject("pageInfo",map);
		
		

		
		
//		mv.addObject("boardList",service.selectList(currentPage,BOARD_LIMIT, searchWord)); 
		mv.addObject("boardList",service.selectList(currentPage,BOARD_LIMIT)); 
//		mv.addObject("boardList", service.selectList()); 
		mv.setViewName("board/list");
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
	
//답글 작성 페이지 이동
	@GetMapping("/insertReply")
	public ModelAndView viewInsertReply(ModelAndView mv, int boardNum) {
		
		return mv;
	}
//답글 작성
//	@PostMapping("/insertReply")
	@GetMapping("/insertPostReply")
	public ModelAndView viewInsertReply(ModelAndView mv, BoardVO vo) {
		//TODO
		int boardNum =4;
		vo.setBoardNum(boardNum);
		vo.setBoardContent("임시4답글내용");
		vo.setBoardTitle("임시4답글제목");
		vo.setBoardWriter("user22");
		
		service.insert(vo);
		
		return mv;
	}	
	
	
	@GetMapping("/update")
	public void viewUpdateBoard() {
		
	}
	
//	@PostMapping("/update")
	@GetMapping("/updatePostTest")
	public void UpdateBoard() {
		int boardNum=1;
		String title= "수정제목";
		String content= "수정내용";
		String boardOriginalFilename="";//"" 파일없음
		String boardRenameFilename="";//"" 파일없음
		
		BoardVO vo = new BoardVO();
		vo.setBoardTitle(title);
		vo.setBoardContent(content);
		vo.setBoardOriginalFilename(boardOriginalFilename);
		vo.setBoardRenameFilename(boardRenameFilename);
		
		int result= service.update(vo);
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
	public ModelAndView viewReadBoard(ModelAndView mv 
			, @RequestParam(required = false, defaultValue ="5") int boardNum) {
		//TODO
		String writer="user22";
		
		mv.addObject("board", service.selectOne(boardNum, writer));
		mv.setViewName("board/read");
		return mv ;
	}
	
	@PostMapping("/insertReplyAjax")
	@ResponseBody
	public String insertReplyAjax(BoardVO vo) {
//		int boardNum =5;
//		vo.setBoardNum(boardNum);
//		vo.setBoardContent("임시5답글내용");
//		vo.setBoardTitle("임시5답글제목");
		vo.setBoardWriter("user22");
		
		service.insert(vo);
		return "ok"; //ajax로 왔으므로 다른 페이지로 이동하지않는다. ajax의 success가 실행됨
		
	}
	
//	@ExceptionHandler(Exception.class)
//	public String exceptionHandler() {
//		return "error";
//	}
	
}
