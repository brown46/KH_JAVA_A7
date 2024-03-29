package kh.spring.s02.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.s02.board.model.dao.BoardDAO;
import kh.spring.s02.board.model.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	
	
	@Override
	@Transactional
	public int insert(BoardVO vo) {
		int seqBoardNum = dao.getSeqBoardNum();
		if(vo.getBoardNum()!=0) { //답글 //원글은 0 
			dao.updateForReply(vo.getBoardNum());
		}
		
		
		Map<String ,Object> map = new HashMap<>();	
		map.put("bvo", vo);
		map.put("seqBoardNum", seqBoardNum);
		dao.insert(vo);
		return dao.insertFile(map);
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
		if(result!=null&&!result.getBoardWriter().equals(writer)) {
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
	public List<BoardVO> selectList(int currentPage, int limit) {
		return dao.selectList(currentPage, limit);
	}
	@Override
	public int selectOneCount() {
		return dao.selectOneCount();
	}
	@Override
	public int selectOneCount(String searchWord) {
		return dao.selectOneCount(searchWord);
	}



	@Override
	public List<BoardVO> selectList(int currentPage, int boardLimit, String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectReplyList(int boardNum) {
		
		return dao.selectReplyList(boardNum);
	}

	@Override
	public List<BoardVO> selectReplyList(int boardNum, int currentPage, int limit) {
		// TODO Auto-generated method stub
		return null;
	}



}
