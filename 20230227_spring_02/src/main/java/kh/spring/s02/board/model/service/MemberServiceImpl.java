package kh.spring.s02.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.s02.board.model.dao.MemberDAO;
import kh.spring.s02.board.model.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;

	@Override
	public int insert(MemberVO vo) throws Exception {	
		return dao.insert(vo); 
	}

	@Override
	public int update(MemberVO vo) throws Exception {
		return dao.update(vo);
	}

	@Override
	public int delete(String id) throws Exception {
		return dao.delete(id);
	}

	@Override
	public MemberVO selectOne(String id) throws Exception {
		return dao.selectOne(id);
	}

	@Override
	public List<MemberVO> selectList() throws Exception {
		
		return dao.selectList();
	}
	
	
}
