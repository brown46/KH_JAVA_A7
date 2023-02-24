package kh.memeber.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kh.common.jdbc.JDBCTemplate;
import kh.memeber.model.vo.MemberVO;

public class MemberDAO {
	//회원가입
	public int enroll(Connection conn, MemberVO vo) {
		int result=-1;
		String query= "insert into TEST_MEMBER values";
		query+=" (?,?,?,?)";
		
		PreparedStatement pstmt= null;
		try {
			pstmt= conn.prepareStatement(query);
			//? 채우기
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			result= pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);			
		}
		System.out.println("DAO enroll() return: "+result);
		return result;
	}
	
}
