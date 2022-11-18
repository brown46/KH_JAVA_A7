package kr.co.demo03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		

		// Oracle Drive 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	// Database Connection 생성
		String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
//		String url="jdbc:oracle:thin:@IP주소:Port/ServiceName";
		String username= "dev01";
		String password= "dev01";
		Connection conn=DriverManager.getConnection(url,username,password);
//		Connection conn=DriverManager.getConnection("ORACLE DB접속정보","계정","암호");
		
		
		
	// Query 작성(쿼리 문자열에 세미콜론은 넣지 마세요.)
		int empId= 207;
		String jobId="IT_PROG";
		String query = "INSERT INTO EMPLOYEES VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		Date hireDate = new Date( new java.util.Date().getTime());
		
	// Statement 또는 PreparedStatement 객체 생성
	  //holder에 하나씩 대응됨
	  PreparedStatement pstat = conn.prepareStatement(query);
	  pstat.setInt(1, empId);
	  pstat.setString(2, "길동");
	  pstat.setString(3, "홍");
	  pstat.setString(4, "HGILDONG");
	  pstat.setString(5, "515.123");
	  pstat.setDate(6, hireDate);
	  pstat.setString(7, jobId);
	  pstat.setInt(8, 2800);
	  pstat.setDouble(9, 0);
	  pstat.setInt(10, 103);
	  pstat.setInt(11, 60);
		//UPDATE와 DELETE도 같은방법으로 하면된다.
	// Query 전송 후 결과 저장
		int rs=pstat.executeUpdate();
		//insert, update, delete를 사용할때는 executeUpdate. 반영된 행의 갯수를 int로 반환.
		
		if(rs >= 1 ) {
			System.out.println(rs+ "개 행이 반영되었습니다.");
		} else {
			System.out.println("0개 행이 반영되었습니다.(쿼리에 문제가 있는것 같습니다.)");
		}
		//DEMO1에서 결과 확인
	// Database 관련 연결 정보 Close (역순으로)
		pstat.close();
		conn.close();
		
		
	}

}
