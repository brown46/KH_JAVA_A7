package kh.spring.s02.member.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.s02.board.model.service.MemberService;
import kh.spring.s02.board.model.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {	
	@Autowired 
	private MemberService service;
	
//	@GetMapping("/signUp")
	@GetMapping("/testSignUp")
	public ModelAndView viewInsert(ModelAndView mv,MemberVO vo) {
		vo.setEmail("emailadd");
		vo.setId("idd");
		vo.setName("namee");
		vo.setPasswd("passswd");
		int result= service.insert(vo);
		return mv;
		//TODO
	}
	@PostMapping("/signUp")
	public ModelAndView insert(ModelAndView mv,MemberVO vo) {
		return mv;
	}
	@GetMapping("/update")
	public ModelAndView  viewUpdate(ModelAndView mv) {
		return mv;
	}
//	@PostMapping("/update")
	@GetMapping("/testUpdate")
	public ModelAndView viewUpdate(ModelAndView mv, MemberVO vo) {
		vo.setEmail("user333@email");
		vo.setId("user3");
		vo.setPasswd("pass333");
		int result=service.update(vo);
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
//	public ModelAndView selectOne(ModelAndView mv,String id) {
	public ModelAndView selectOne(ModelAndView mv) {
		String id= "user3";
		MemberVO vo= service.selectOne(id);
		return mv;
	}
	@GetMapping("/list")
	public ModelAndView selectList(ModelAndView mv) {
		List<MemberVO> result= service.selectList();
		return mv;
		
	}
}
