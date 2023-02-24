package member.model.service;

import java.sql.Connection;
import java.util.List;

import first.common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.MemberVO;

public class MemberService {
	//1. Connection 생성
	//2. Autocommit 설정 + commit + rollback(select문 제외, DML여러개일때) 
	//3. DAO 메소드 호출 + 결과값
	//4. Connection close
	
	//login
	public List<MemberVO> selectMemberList(){
		List<MemberVO> result =null;
		Connection conn= JDBCTemplate.getConnection();
		result= new MemberDAO().selectMemberList(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	
	
	public int login(String id, String pw) {
		int result =0;
		Connection conn= JDBCTemplate.getConnection();
		//TODO: DAO 메서드 호출
		
		MemberDAO m = new MemberDAO();
		result= m.login(conn ,id, pw);
		JDBCTemplate.close(conn);
		return result;
	}
}
