package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import first.common.JDBCTemplate;
import member.model.vo.MemberVO;

public class MemberDAO {
	
	public List<MemberVO> selectMemberList(Connection conn){
		List<MemberVO> result =null;
		 
		String query = "SELECT * FROM test_member";
		PreparedStatement pstmt= null;
		ResultSet rset= null;
		
		try {
			pstmt=conn.prepareStatement(query);
//			pstmt.setString(parameterIndex, x);//? 가 없음
			rset= pstmt.executeQuery();
			result= new ArrayList<MemberVO>();
			
			if(rset.next()) {
				result = new ArrayList<MemberVO>();
				do {
					String id = rset.getString("id");
					String passwd = rset.getString("passwd");
					String name = rset.getString("name");
					String email = rset.getString("email");
					MemberVO vo = new MemberVO();
					vo.setEmail(email);
					vo.setId(id);
					vo.setName(name);
					vo.setPasswd(passwd);
					result.add(vo);
				}while(rset.next());				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);	
		}
		return result;
	}
	
	
	
	public int login(Connection conn,String id, String pw) {
		int result =-1;//
//		String query ="SELECT COUNT(*) cnt FROM TEST_MEMBER WHERE ID=#{id} AND PASSWD=#{pw}";	//마이바티스	
		String query ="SELECT COUNT(*) cnt FROM TEST_MEMBER WHERE ID='"+id+"' AND PASSWD='"+pw+"'";		
		String queryForPrepareStatement ="SELECT COUNT(*) cnt FROM TEST_MEMBER WHERE ID=? AND PASSWD=?";		
		
		ResultSet rs =null;
		PreparedStatement pstmt =null;
		Statement stmt =null;
		//query문 실행
		try {
			//Statement 방식
//			stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(query);//SELECT문(DQL) 실행
			//return으로 ResultSet을 받는다. 
			
			
			//PrepareStatement 방식
			pstmt = conn.prepareStatement(queryForPrepareStatement);
			//placeholder :? 가 있다면 값을 채워준다.
			pstmt.setString(1, id);//0부터 시작
			pstmt.setString(2, pw);
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				result= rs.getInt("cnt");
//				rs.getInt(1);
			}
//			stmt.executeUpdate(INSERT); ("INSERT/ UPDATE/ DELETE 명령문을 실행할때(DML)
			//return으로 변경된 행의 갯수를 받는다.
			while(rs.next()) {
				result= rs.getInt("cnt");
				result= rs.getInt("cnt");
				result= rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			
			JDBCTemplate.close(rs);//select문 실행시에만 실행되게한다
			JDBCTemplate.close(pstmt);
//			JDBCTemplate.close(stmt);
		}
		return result;
	}
}
