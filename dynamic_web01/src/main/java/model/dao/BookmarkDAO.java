package model.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import database.connect.OracleConnection;
import model.dto.BookmarkDTO;

public class BookmarkDAO {
	private SqlSession session = OracleConnection.getSqlSession();

	public List<BookmarkDTO> selectAll() {
		List<BookmarkDTO> data = session.selectList("bookmarkMapper.selectAll");
		return data;
	}

	public BookmarkDTO selectId(int id) {
		BookmarkDTO data = session.selectOne("bookmarkMapper.selectId",id);
		return data;
	}

	public int insert(BookmarkDTO dto) {
		int count = session.insert("bookmarkMapper.insert", dto);
		return count;
	}

	public void commit() {
		session.commit();
	}

	public void rollback() {
		session.rollback();
	}

	public void close() {
		session.close();
	}

	public int update(BookmarkDTO dto) {
		int count= session.update("bookmarkMapper.update",dto);
		return count;
	}

	public int delete(BookmarkDTO dto) {
		int count= session.delete("bookmarkMapper.delete",dto);
		return count;
	}

	/**
	 * 데이터베이스에 저장할 데이터의 식별값을 생성하기 위한 메서드
	 * @return id
	 */
	public int getNextId() {
		int id = session.selectOne("bookmarkMapper.getNextId");
		return id;
	}

}
