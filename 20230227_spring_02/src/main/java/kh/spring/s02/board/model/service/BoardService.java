package kh.spring.s02.board.model.service;

import java.util.List;

import kh.spring.s02.board.model.vo.BoardVO;

public interface BoardService {
	public int insert(BoardVO vo) ;
//	public int updateForReply (int boardNum);
	public int update(BoardVO vo);
//	public int updateReadCount (int boardNum) ;
	public int delete(int boardNum /*BoardVO 또는 PK 또는 List<PK>*/);
//	public BoardVO selectOne(int boardNum /*PK*/);
	public BoardVO selectOne(int boardNum, String writer);
	public List<BoardVO> selectList();
	public int selectOneCount();

}
