package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import database.connect.OracleConnection;
import model.dto.VisitDTO;


public class VisitDAO {
	
	/*
	 * 마이바티스 관련 라이브러리 필요
	 * 	1. ojdbc
	 *  2. mybatis
	 */
	private SqlSession session =OracleConnection.getSqlSession();
	
	public int insert(VisitDTO data) {
		int res= session.insert("visitMapper.insert",data);
		if(res==1) {
			session.commit();
		}
		return res;
	}
	
	public List<VisitDTO> select() {
		List<VisitDTO> dataList= session.selectList("visitMapper.select");
		return dataList;
	}
	public List<VisitDTO> selectId(VisitDTO data) {
		List<VisitDTO> dataList = session.selectList("visitMapper.selectId" , data);
		return dataList;
	}

	public int delete(VisitDTO dto) {
		int res=session.delete("visitMapper.delete",dto);
		return res;
	}

	public void commit() {
		session.commit();
	}

	public void close() {
		session.close();
		
	}

	public void rollback() {
		session.rollback();
	}

	public VisitDTO select(VisitDTO dto) {
		VisitDTO data= session.selectOne("visitMapper.selectOne",dto);
		return data;
	}

	public int update(VisitDTO dto) {
		int res = session.update("visitMapper.update",dto);
		return res;
	}
}
