package kh.member.model.service;

import java.sql.Connection;

import kh.common.jdbc.JDBCTemplate;
import kh.memeber.model.dao.MemberDAO;
import kh.memeber.model.vo.MemberVO;

public class MemberService {
	
	public int enroll(MemberVO vo) {
		Connection conn= JDBCTemplate.getConnection();
		int result=-1;
		result= new MemberDAO().enroll(conn, vo);	
		JDBCTemplate.close(conn);
		return result;
	}
}
