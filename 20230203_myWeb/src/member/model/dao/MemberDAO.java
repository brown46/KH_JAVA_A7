package member.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	public int login(Connection conn,String id, String pw) {
		int result =0;
		String query ="SELECT COUNT(*) FROM TEST_MEMBER WHERE ID=#{id} AND PASSWD=#{pw}";
		
		//query문 실행
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);//SELECT문(DQL) 실행
			//return으로 ResultSet을 받는다. 
			if(rs.next()) {
				
			}
			
//			stmt.executeUpdate(INSERT); ("INSERT/ UPDATE/ DELETE 명령문을 실행할때(DML)
			//return으로 변경된 행의 갯수를 받는다.
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
}
