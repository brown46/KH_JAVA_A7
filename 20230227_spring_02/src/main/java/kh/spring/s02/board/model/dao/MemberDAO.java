package kh.spring.s02.board.model.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.s02.board.model.vo.MemberVO;


@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	public int insert(MemberVO vo) {		
		return sqlSession.insert("memberMapper.insertId",vo);
	}
	
	public int update(MemberVO vo) {
		return sqlSession.update("memberMapper.updateId",vo);
		
	}
	
	public int delete(String id ) {
		return sqlSession.delete("memberMapper.deleteId",id);
		
	}
	
	public MemberVO selectOne(String id) {
		return sqlSession.selectOne("memberMapper.selectOneId",id);
		
	}
	public List<MemberVO> selectList() {
		return sqlSession.selectList("memberMapper.selectListId");
		
	}
}
