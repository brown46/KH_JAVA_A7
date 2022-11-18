package kr.co.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.db.connection.OracleConnection;
import kr.co.vo.DepartmentVO;
import kr.co.vo.EmployeeVO;

public class DepartmentDAO {
	
	private OracleConnection oc;
	public DepartmentDAO() throws ClassNotFoundException, SQLException {
		oc = new OracleConnection("localhost:1521/XEPDB1","dev01");
	}
	
	public ArrayList<DepartmentVO> selectAll() {
		String query = "SELECT * FROM DEPARTMENTS";
		ArrayList<DepartmentVO> DeptArray= new ArrayList<DepartmentVO>();
		try {
			oc.getPrepared(query);
			ResultSet rs =oc.sendSelect();
			
			while(rs.next()) {
				DepartmentVO dept = new DepartmentVO();
				dept.setDeptName(rs.getString("DEPARTMENT_NAME"));
				dept.setDeptId(rs.getInt("DEPARTMENT_ID"));
				dept.setManagerId(rs.getInt("MANAGER_ID"));
				dept.setLocationId(rs.getInt("LOCATION_ID"));
				DeptArray.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DeptArray;
	}

}
