package kh.spring.s02.member.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView insert(ModelAndView mv,MemberVO vo) {
		
		int result= service.insert(vo);
		mv.setViewName("member/signUp");
		if(result>0) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/member/signUp");			
		}
		return mv;
	}
	@GetMapping("/update")
	public ModelAndView  viewUpdate(ModelAndView mv, String id) {
		MemberVO vo = service.selectOne(id);
		mv.addObject("memberVO", vo);
		mv.setViewName("/member/update");
		return mv;
	}
//	@GetMapping("/testUpdate")
	@PostMapping("/update")
	public ModelAndView viewUpdate(ModelAndView mv, MemberVO vo) {
		service.update(vo);
		mv.setViewName("redirect:/");
		return mv;
	}
	

	@GetMapping("/delete")
//	public ModelAndView delete(ModelAndView mv, String id) {
	public ModelAndView delete(ModelAndView mv) {
		String id = "idd";
		int result=service.delete(id);
		return mv;
	}
	
	@GetMapping("/info")
	public ModelAndView selectOne(ModelAndView mv,String id) {
//	public ModelAndView selectOne(ModelAndView mv) {
//		String id= "user3";
		if(id==null) {
			mv.setViewName("redirect:/");			
			return mv;
		}
		MemberVO vo= service.selectOne(id);
		return mv;
	}
	@GetMapping("/list")
	public ModelAndView selectList(ModelAndView mv) {
		List<MemberVO> result= service.selectList();
		return mv;
		
	}
}
