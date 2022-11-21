package kr.co.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.db.connection.OracleConnection;
import kr.co.vo.DepartmentVO;
import kr.co.vo.EmployeeVO;

public class EmployeeDAO {
	
	private OracleConnection oc;
	public EmployeeDAO() throws ClassNotFoundException, SQLException {
		oc = new OracleConnection("localhost:1521/XEPDB1","dev01");
	}
	
	public ArrayList<EmployeeVO> selectAll() {
		String query = "SELECT * FROM EMPLOYEES";
		ArrayList<EmployeeVO> empArray= new ArrayList<EmployeeVO>();
		try {
			oc.getPrepared(query);
			ResultSet rs =oc.sendSelect();
			
			while(rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				emp.setHireDate(rs.getDate("HIRE_DATE"));			
				emp.setJobId(rs.getString("JOB_ID"));
				emp.setCommission(rs.getDouble("COMMISSION_PCT"));
				emp.setManagerId(rs.getInt("MANAGER_ID"));
				emp.setDeptId(rs.getInt("DEPARTMENT_ID"));
				empArray.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empArray;
	}

	public EmployeeVO selectId(int id) {
		String query = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		try {
			PreparedStatement pstat=oc.getPrepared(query);
			pstat.setInt(1, id);
			
			ResultSet rs = oc.sendSelect();
			
			if(rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				emp.setHireDate(rs.getDate("HIRE_DATE"));			
				emp.setJobId(rs.getString("JOB_ID"));
				emp.setCommission(rs.getDouble("COMMISSION_PCT"));
				emp.setManagerId(rs.getInt("MANAGER_ID"));
				emp.setDeptId(rs.getInt("DEPARTMENT_ID"));
				return emp;
			}else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<EmployeeVO> selectName(String name) {
		name = name.toLowerCase();
		String query = "SELECT * FROM EMPLOYEES WHERE LOWER( CONCAT(FIRST_NAME,LAST_NAME)) LIKE ?";
		try {
			PreparedStatement pstat= oc.getPrepared(query);
			pstat.setString(1, "%"+name.replace(" ", "")+"%");
			
			ResultSet rs = oc.sendSelect();
			ArrayList<EmployeeVO> empArray= new ArrayList<EmployeeVO>();
			while(rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				emp.setHireDate(rs.getDate("HIRE_DATE"));			
				emp.setJobId(rs.getString("JOB_ID"));
				emp.setCommission(rs.getDouble("COMMISSION_PCT"));
				emp.setManagerId(rs.getInt("MANAGER_ID"));
				emp.setDeptId(rs.getInt("DEPARTMENT_ID"));
				empArray.add(emp);
			}
			return empArray;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<EmployeeVO> selectJobName(String jobName) {
		jobName= jobName.toLowerCase();
		String query = "SELECT * FROM EMPLOYEES WHERE LOWER(JOB_ID) LIKE ?";
		try {
			PreparedStatement pstat= oc.getPrepared(query);
			pstat.setString(1,"%"+jobName+"%");
			ResultSet rs = oc.sendSelect();
			
			ArrayList<EmployeeVO> empArray= new ArrayList<EmployeeVO>();
			while(rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				emp.setHireDate(rs.getDate("HIRE_DATE"));			
				emp.setJobId(rs.getString("JOB_ID"));
				emp.setCommission(rs.getDouble("COMMISSION_PCT"));
				emp.setManagerId(rs.getInt("MANAGER_ID"));
				emp.setDeptId(rs.getInt("DEPARTMENT_ID"));
				empArray.add(emp);
			}
			return empArray;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<EmployeeVO> selectDeptName(String deptName) {
		deptName= deptName.toLowerCase();
		
		
		String query1 = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME FROM DEPARTMENTS WHERE LOWER(DEPARTMENT_NAME)=  ?";
		
			PreparedStatement pstat;
			try {
				pstat = oc.getPrepared(query1);
				pstat.setString(1,"%"+deptName+"%");
				ResultSet rs = oc.sendSelect();
				
				ArrayList<DepartmentVO> empArray= new ArrayList<DepartmentVO>();
				while(rs.next()) {
					DepartmentVO dept= new DepartmentVO();
					dept.setDeptName(rs.getString("DEPARTMENT_NAME"));
					dept.setDeptId(rs.getInt("))
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		String query2 = "SELECT * FROM EMPLOYEES WHERE LOWER(DEPARTMENT_ID) =(SELECT DEPARTMENT_ID  FROM DEPARTMENTS WHERE LOWER(DEPARTMENT_NAME)=  ?	)";
		try {
			pstat=oc.getPrepared(query2);
			pstat.setString(1,"%"+deptName+"%");
			ResultSet rs = oc.sendSelect();
			
			ArrayList<EmployeeVO> empArray= new ArrayList<EmployeeVO>();
			while(rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				emp.setHireDate(rs.getDate("HIRE_DATE"));			
				emp.setJobId(rs.getString("JOB_ID"));
				emp.setCommission(rs.getDouble("COMMISSION_PCT"));
				emp.setManagerId(rs.getInt("MANAGER_ID"));
				emp.setDeptId(rs.getInt("DEPARTMENT_ID"));
				empArray.add(emp);
			}
			return empArray;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
