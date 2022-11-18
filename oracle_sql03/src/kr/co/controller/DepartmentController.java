package kr.co.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.dao.DepartmentDAO;
import kr.co.view.DepartmentView;
import kr.co.vo.DepartmentVO;
import kr.co.vo.EmployeeVO;

public class DepartmentController {
	
	private DepartmentView dv = new DepartmentView();
	private DepartmentDAO deptDao;
	
	public DepartmentController() throws ClassNotFoundException, SQLException {
		deptDao= new DepartmentDAO();
	}
	public void getAll() {
		ArrayList<DepartmentVO> datas = deptDao.selectAll();
		dv.print(datas);
	}



}
