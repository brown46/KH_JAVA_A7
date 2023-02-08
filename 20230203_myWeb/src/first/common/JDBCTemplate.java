package first.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//현재 프로젝트와 오라클DB 계정 KH와 연결하고 그 결과 Connection을 만들어내기 
public class JDBCTemplate {
	private static JDBCTemplate instance;
	
	private JDBCTemplate() {
	}
	
	public static JDBCTemplate getInstance() {
		if(instance ==null) {			
			instance = new JDBCTemplate();
		}
		return instance;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
//		Class.forName("oracle.jdbc.driver.OracleDriver"); //둘중 아무거나 사용해도 된다.
			Class.forName("oracle.jdbc.OracleDriver");//JDBC 클래스 로드
			conn= DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:XE","KH","KH");
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc jar 이 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}  finally {
			if(conn==null) {
				System.out.println("연결 실패!");
			}else {
				System.out.println("연결 성공");
			}
		}
		return conn;
	}
	
	public static void close(Connection conn) {
	
		try {
			if(conn!=null && !conn.isClosed()) {				
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
