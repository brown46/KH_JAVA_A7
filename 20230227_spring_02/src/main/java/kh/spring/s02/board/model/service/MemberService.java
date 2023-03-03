package kh.spring.s02.board.model.service;

import java.util.List;

import kh.spring.s02.board.model.vo.BoardVO;
import kh.spring.s02.board.model.vo.MemberVO;

public interface MemberService {
	
	
	public int insert(MemberVO vo);
	
	public int update(MemberVO vo);
	
	public int delete(String id );
	
	public MemberVO selectOne(String id) ;
	public List<MemberVO> selectList();
}
