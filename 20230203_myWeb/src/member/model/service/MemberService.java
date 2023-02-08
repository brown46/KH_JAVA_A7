package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import first.common.JDBCTemplate;

public class MemberService {
	//1. Connection 생성
	//2. Autocommit 설정 + commit + rollback(select문 제외, DML여러개일때) 
	//3. DAO 메소드 호출 + 결과값
	//4. Connection close
	
	//login
	public int login(String id, String pw) {
		int result =0;
		Connection conn= JDBCTemplate.getConnection();
		//TODO: DAO 메서드 호출
		
		JDBCTemplate.close(conn);
		return result;
	}
}
