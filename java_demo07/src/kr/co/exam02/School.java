package kr.co.exam02;

public class School {
	
	private int grade;
	private int cls;
	public String subArr[]=new String[0];
	public School(int grade, int cls){
		this.grade=grade;
		this.cls=cls;
	}
	public School() {
		subArr = new String[0];
	}
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getCls() {
		return cls;
	}

	public void setCls(int cls) {
		this.cls = cls;
	}
	public void setSubject(String subject) {}
	
	


}
