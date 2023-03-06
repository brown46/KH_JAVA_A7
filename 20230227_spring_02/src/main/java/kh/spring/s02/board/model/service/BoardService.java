package kh.spring.s02.board.model.service;

import java.util.List;

import kh.spring.s02.board.model.vo.BoardVO;

public interface BoardService {
	//서비스의 역할 - Transaction 기능:  Dao의 여러 메소드를 하나의 기능으로 묶어서 처리함
	public int insert(BoardVO vo) ;
//	public int updateForReply (int boardNum);
	public int update(BoardVO vo);
//	public int updateReadCount (int boardNum) ;
	public int delete(int boardNum /*BoardVO 또는 PK 또는 List<PK>*/);
//	public BoardVO selectOne(int boardNum /*PK*/);
	public BoardVO selectOne(int boardNum, String writer);
	public List<BoardVO> selectList(); //전체 읽기
	public List<BoardVO> selectList(int currentPage,int limit); //paging 처리
	public Object selectList(int currentPage, int boardLimit, String searchWord);//String으로 검색
	public int selectOneCount();
	public int selectOneCount(String searchWord);
	
}
