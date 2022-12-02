package kr.co.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.main.OracleConnection;
import kr.co.vo.AccountVO;

public class AccountDAO {

	private SqlSession sess = OracleConnection.getSqlSession();
	
	public List<AccountVO> selectReqAccount(){
		List<AccountVO> result = new ArrayList<AccountVO>();
		result = sess.selectList("test.reqAccount"); //mapper.xml이 먼저 만들어져 있어야 함
//   <select id="reqAccount" resultType="kr.co.vo.AccountVO">
		return result;
		
	}
}
