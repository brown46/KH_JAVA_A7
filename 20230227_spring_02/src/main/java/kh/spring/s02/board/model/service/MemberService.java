package kh.spring.s02.board.model.service;

import java.util.List;

import kh.spring.s02.board.model.vo.BoardVO;
import kh.spring.s02.board.model.vo.MemberVO;

public interface MemberService {
	
	
	public int insert(MemberVO vo) throws Exception;
	
	public int update(MemberVO vo) throws Exception;
	
	public int delete(String id ) throws Exception;
	
	public MemberVO selectOne(String id) throws Exception ;
	public List<MemberVO> selectList() throws Exception;
}
