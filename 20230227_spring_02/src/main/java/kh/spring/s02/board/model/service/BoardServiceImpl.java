package kh.spring.s02.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.s02.board.model.dao.BoardDAO;
import kh.spring.s02.board.model.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;
	@Override
	public int insert(BoardVO vo) {
		
		return dao.insert(vo);
	}

	@Override
	public int update(BoardVO vo) {
		
		return dao.update(vo);
	}

	@Override
	public int delete(int boardNum) {
		
		return dao.delete(boardNum);
	}

	@Override
	public BoardVO selectOne(int boardNum, String writer) {
		BoardVO result= dao.selectOne(boardNum);
		if(!result.getBoardWriter().contentEquals(writer)) {
			dao.updateReadCount(boardNum);
		}
		return result;
//		if(dao.updateReadCount(boardNum)>0) {
//			return dao.selectOne(boardNum);			
//		}else {
//			return null;
//		}
	}

	@Override
	public List<BoardVO> selectList() {
		return dao.selectList();
	}

	@Override
	public int selectOneCount() {
		return dao.selectOneCount();
	}

}
