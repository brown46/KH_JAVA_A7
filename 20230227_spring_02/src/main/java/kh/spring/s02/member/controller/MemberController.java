package kh.spring.s02.member.controller;



import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.s02.board.model.service.MemberService;
import kh.spring.s02.board.model.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {	
	@Autowired 
	private MemberService service;
	
	@GetMapping("/signUp")
	public ModelAndView viewInsert(ModelAndView mv) {
		
		mv.setViewName("member/signUp");
		return mv;
		
	}

	@PostMapping("/signUp")
	public ModelAndView insert(ModelAndView mv
			                  ,MemberVO vo
			                  , String id
			                  ,RedirectAttributes rttr ) throws Exception{
		
		int result = -1;
			result = service.insert(vo);
		if(result>0) {//회원 가입성공
			rttr.addFlashAttribute("msg","회원가입 성공");
			mv.setViewName("redirect:/");
		}else {//회원 가입실패 
			rttr.addFlashAttribute("msg","회원가입 실패");
			mv.setViewName("redirect:/member/signUp");			
		}
		return mv;
	}
	@GetMapping("/update")
	public ModelAndView  viewUpdate(ModelAndView mv
					              , @RequestParam("id") String id
//					              , @RequestParam(name="ccc", required = false, defaultValue = "100") int aa
					              ) throws Exception {
		
		MemberVO vo = service.selectOne(id);
		mv.addObject("memberVO", vo);
		mv.setViewName("/member/update");
		return mv;
	}
//	@GetMapping("/testUpdate")
	@PostMapping("/update")
	public ModelAndView viewUpdate(ModelAndView mv, MemberVO vo)throws Exception {
		service.update(vo);
		mv.setViewName("redirect:/");
		return mv;
	}
	

	@GetMapping("/delete")
//	public ModelAndView delete(ModelAndView mv, String id) {
	public ModelAndView delete(ModelAndView mv, String id)throws Exception {
		int result=service.delete(id);
		return mv;
	}
	
	@GetMapping("/info")
	public ModelAndView selectOne(ModelAndView mv,String id)throws Exception {
//	public ModelAndView selectOne(ModelAndView mv) {
//		String id= "user3";
		if(id==null) {
			mv.setViewName("redirect:/");			
			return mv;
		}
		MemberVO vo= service.selectOne(id);
		mv.addObject("MemberVO",vo);
		mv.setViewName("member/info");
		return mv;
	}
	@GetMapping("/list")
	public ModelAndView selectList(ModelAndView mv)throws Exception {
		List<MemberVO> result= service.selectList();
		mv.addObject("memberList", result);
		return mv;
		
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView MemberNullPointerExceptionHandler(NullPointerException e ) {
		e.printStackTrace();
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","NullPointer예외발생");
		mv.setViewName("error/error500");	
		return mv;
	}
	@ExceptionHandler(SQLException.class)
	public ModelAndView MemberSQLExceptionHandler(SQLException e ) {
		e.printStackTrace();
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","SQL예외발생");
		mv.setViewName("error/error500");	
		return mv;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView MemberExceptionHandler(Exception e) {
		e.printStackTrace();
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","예외발생");
		mv.setViewName("error/error500");	
		return mv;
	}
}
