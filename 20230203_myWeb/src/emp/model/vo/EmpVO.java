package emp.model.vo;

import java.sql.Date;

public class EmpVO {
	//SELECT * 
	//SELECT ename, job, dname, loc, deptno 
	//	FROM emp JOIN dept USING(deptno);
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	private Dept dept;
	
}
