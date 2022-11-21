package kr.co.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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
		Scanner sc= new Scanner(System.in);
		deptName= deptName.toLowerCase();
		
		
		String query1 = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, LOCATION_ID, MANAGER_ID FROM DEPARTMENTS WHERE LOWER(DEPARTMENT_NAME) LIKE ?";
		
			PreparedStatement pstat;
			try {
				pstat = oc.getPrepared(query1);
				pstat.setString(1,"%"+deptName+"%");
				ResultSet rs = oc.sendSelect();
				
				ArrayList<DepartmentVO> deptArray= new ArrayList<DepartmentVO>();
				while(rs.next()) {
					DepartmentVO dept= new DepartmentVO();
					dept.setDeptName(rs.getString("DEPARTMENT_NAME"));
					dept.setDeptId(rs.getInt("DEPARTMENT_ID"));
					dept.setLocationId(rs.getInt("LOCATION_ID"));
					dept.setManagerId(rs.getInt("MANAGER_ID"));
					deptArray.add(dept);
				}
//				if(deptArray.size()==1)
				for(DepartmentVO dept: deptArray) {
					System.out.println(dept);
				}
				System.out.println("부서코드 입력");
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			int input = sc.nextInt();
			String query2="SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID =?";
			try {
				pstat = oc.getPrepared(query2);
				pstat.setInt(1,input);
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
//				if(deptArray.size()==1)
				for(EmployeeVO emp: empArray) {
					System.out.println(emp);
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		//String query2 = "SELECT * FROM EMPLOYEES WHERE LOWER(DEPARTMENT_ID) =(SELECT DEPARTMENT_ID  FROM DEPARTMENTS WHERE LOWER(DEPARTMENT_NAME) LIKE  ?	)";
//		String query2 = "SELECT * FROM EMPLOYEES E FULL OUTER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID=D.DEPARTMENT_ID WHERE LOWER(D.DEPARTMENT_NAME) LIKE ?";
//		PreparedStatement pstat;
//		try {
//			pstat=oc.getPrepared(query2);
//			pstat.setString(1,"%"+deptName+"%");
//			ResultSet rs = oc.sendSelect();
//			
//			ArrayList<EmployeeVO> empArray= new ArrayList<EmployeeVO>();
//			while(rs.next()) {
//				EmployeeVO emp = new EmployeeVO();
//				emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
//				emp.setFirstName(rs.getString("FIRST_NAME"));
//				emp.setLastName(rs.getString("LAST_NAME"));
//				emp.setEmail(rs.getString("EMAIL"));
//				emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
//				emp.setHireDate(rs.getDate("HIRE_DATE"));			
//				emp.setJobId(rs.getString("JOB_ID"));
//				emp.setCommission(rs.getDouble("COMMISSION_PCT"));
//				emp.setManagerId(rs.getInt("MANAGER_ID"));
//				emp.setDeptId(rs.getInt("DEPARTMENT_ID"));
//				empArray.add(emp);
//			}
//			return empArray;
//		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		return null;
	}

}
