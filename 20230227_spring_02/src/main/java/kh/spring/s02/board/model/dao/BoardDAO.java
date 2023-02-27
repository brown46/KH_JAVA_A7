package kh.spring.s02.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.s02.board.model.vo.BoardVO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	public int insert(BoardVO vo) {
		return sqlSession.insert("board.insert", vo);
	}

	public int update(BoardVO vo) {
		return sqlSession.update("board.update", vo);
	}
	public int updateReadCount (int boardNum) {
		return sqlSession.update("board.updateReadCount", boardNum);
	}
	public int updateForReply (int boardNum) {
		return sqlSession.update("board.updateForReply", boardNum);
	}

	public int delete(int boardNum /*BoardVO 또는 PK 또는 List<PK>*/) {
		return sqlSession.delete("board.delete", boardNum);
	}

	public BoardVO selectOne(int boardNum /*PK*/) {
		return sqlSession.selectOne("board.selectOne", boardNum);
	}

	public List<BoardVO> selectList() {
		return sqlSession.selectList("board.selectList");
	}
	public int selectOneCount() { 
		return sqlSession.selectOne("board.selectOneCount");
	}
}
