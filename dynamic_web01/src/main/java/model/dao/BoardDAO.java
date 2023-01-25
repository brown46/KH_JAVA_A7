package model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import database.connect.OracleConnection;
import model.dto.BoardDTO;

public class BoardDAO {
	
	private SqlSession session = OracleConnection.getSqlSession();
	
	public void commit() {
		session.commit();
	}
	public void rollback() {
		session.rollback();
	}
	public void close() {
		session.close();
	}
	public List<BoardDTO> selectPage(Map<String, Integer> page) {
		List<BoardDTO> data = session.selectList("boardMapper.selectPage", page);
		return data;
	}
	public int selectTotalRowCount() {
		int count = session.selectOne("boardMapper.selectTotalRowCount");
		return count;
	}
	public BoardDTO getDetail(BoardDTO dto) {
		dto = session.selectOne("boardMapper.selectDetail",dto);
		return dto;
	}
}
