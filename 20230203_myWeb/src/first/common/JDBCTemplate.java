package first.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Currency;
import java.util.Properties;

//현재 프로젝트와 오라클DB 계정 KH와 연결하고 그 결과 Connection을 만들어내기 
public class JDBCTemplate {
	private static JDBCTemplate instance;

	private JDBCTemplate() {
	}

	public static JDBCTemplate getInstance() {
		if (instance == null) {
			instance = new JDBCTemplate();
		}
		return instance;
	}

	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();		
		
		String currentPath=JDBCTemplate.class.getResource("./").getPath();
//		URL url = JDBCTemplate.class.getResource("./");
		try {
			//C: \workspace\java\20230203_myWeb\src\first\common\driver.properties
//			prop.load(new BufferedReader(new FileReader(new File("C:\\Users\\user1\\Desktop\\refactored-rotary-phone\\20230203_myWeb\\src\\first\\common\\driver.properties"))));
			prop.load(new BufferedReader(new FileReader(new File(currentPath+"driver.properties"))));

			Class.forName(prop.getProperty("lh.driver"));// JDBC 클래스 로드
			conn = DriverManager.getConnection(prop.getProperty("lh.url"), prop.getProperty("lh.username"), prop.getProperty("lh.password"));
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc jar 이 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		finally {
			if (conn == null) {
				System.out.println("연결 실패!");
			} else {
				System.out.println("연결 성공");
			}
		}
		return conn;
	}

	public static void close(Connection conn) {

		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void close(ResultSet rs) {

		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {

		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
