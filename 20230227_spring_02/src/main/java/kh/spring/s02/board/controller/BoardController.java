package kh.spring.s02.board.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kh.spring.s02.board.model.service.BoardService;
import kh.spring.s02.board.model.vo.BoardVO;
import kh.spring.s02.common.file.FileUtil;

@Controller
@RequestMapping("/board")
public class BoardController {	
	@Autowired
	BoardService service;
	@Autowired 
	@Qualifier("fileUtil")
	private FileUtil fileUtil;
	
	private static final int BOARD_LIMIT=5;
	private static final int Page_LIMIT=3;

	private static final String UPLOAD_FOLDER ="\\resources\\uploadfiles";
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
	
	@PostMapping("/insert")
	public ModelAndView doInsertBoard(ModelAndView mv
			, MultipartHttpServletRequest multiReq
			, MultipartFile report  //jsp의 input type="file" name과 같은이름. 다른 이름을 쓰고 싶다면 @RequestParam(name="report", required = false)
			, HttpServletRequest request
			, BoardVO vo) {
		Map<String, String> filePath;
		List<Map<String, String>> fileListPath;
		try {
			//fileListPath = fileUtil.saveFileList(multiReq, request, null);
			filePath = fileUtil.saveFile(report, request, null);
			vo.setBoardOriginalFilename(filePath.get("original"));
			vo.setBoardRenameFilename(filePath.get("rename"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		vo.setBoardWriter("user22");//TODO
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
	
	//URL
	//  /board/read?boardNum=27&replyPage=3
		// location.href="board/read?boardNum=${elboardNum}&replyPage=${elreplyPage}"
	//  /board/read/27/3
		// location.href="board/read/27/3"
	@GetMapping("/read/{boardNum}/{replyPage}")
	public ModelAndView viewReadBoard(ModelAndView mv 
//			, @RequestParam(required = false, defaultValue ="5") int boardNum) {
			, @PathVariable int replyPage
			, @PathVariable int boardNum
			) {
		//TODO
		String writer="user22";
		
		mv.addObject("board", service.selectOne(boardNum, writer));
		mv.setViewName("board/read");
		
		List<BoardVO> replyList = service.selectReplyList(boardNum);
		mv.addObject("replyList", replyList);
		
		return mv ;
	}
	
	@PostMapping("/insertReplyAjax")
	@ResponseBody
	public String insertReplyAjax(BoardVO vo
			, MultipartFile report
			) {
		
		if(report !=null) {
			System.out.println(report.getOriginalFilename());
		}else {
			System.out.println("파일 없음");
		}
//		int boardNum =5;
//		vo.setBoardNum(boardNum);
//		vo.setBoardContent("임시5답글내용");
//		vo.setBoardTitle("임시5답글제목");
		vo.setBoardWriter("user22");
		
		
		
		//답글 작성
		service.insert(vo);
		//연관 답글들을 조회해서 ajax로 return 해야함
		List<BoardVO> replyList = service.selectReplyList(vo.getBoardNum());
//		mv.addObject("replyList", replyList); //ajax는 mv로 전달 할 수 없음
		//
		return new Gson().toJson(replyList); //ajax로 왔으므로 다른 페이지로 이동하지않는다. ajax의 success가 실행됨
		
	}
	
//	@ExceptionHandler(Exception.class)
//	public String exceptionHandler() {
//		return "error";
//	}
	
}
