package kh.spring.s02.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.s02.board.controller.BoardController;
import kh.spring.s02.board.model.vo.BoardVO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	
	public int insert(BoardVO vo) {
		return sqlSession.insert("board.insert", vo);
	}
	//sequence 사용 버전
	public int insert(Map<String, Object> map) {
		return sqlSession.insert("board.insert", map);
	}
	//sequence 사용 버전
	public int insertFile(Map<String, Object> map) {
		return sqlSession.insert("board.insertFile", map);
	}
	public int getSeqBoardNum() {
		return sqlSession.selectOne("boardMapper.getSeqBoardNum");
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
	public List<BoardVO> selectList(int currentPage, int limit) {
//		int offset = (currentPage-1)*limit;
//		RowBounds rb = new RowBounds(offset, limit);
//		return sqlSession.selectList("board.selectList",null,rb);
		return sqlSession.selectList("board.selectList",null,new RowBounds((currentPage-1)*limit, limit));
	}
	
	public List<BoardVO> selectList(int currentPage, int limit, String searchWord) {
		
		return sqlSession.selectList("board.selectList",searchWord,new RowBounds((currentPage-1)*limit, limit));
	}
	
	public int selectOneCount() { 
		return sqlSession.selectOne("board.selectOneCount");
	}
	public int selectOneCount(String searchWord) { 
		return sqlSession.selectOne("board.selectOneCount",searchWord);
	}
	public List<BoardVO> selectReplyList(int boardNum) {
		return sqlSession.selectList("board.selectReplyList",boardNum);
	}
//	public List<HashMap<String, Object>> tempSelect() {
//		List<HashMap<String, Object>> listmap = sqlSession.selectList("board.tempSelect");
//		for(HashMap<String, Object> map : listmap) {
//			System.out.println((String)map.get("boardDate"));
//			//property = key = attribute = column = field 
//		}
//		return listmap;
////		return sqlSession.selectList("board.tempSelect");
//	}
}
