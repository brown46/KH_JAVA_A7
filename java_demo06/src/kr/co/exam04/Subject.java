package kr.co.exam04;

public class Subject {
		
	private String sName;
	private double score;
	private String sGrade;
	Subject(String sName, int score ){
		this.sName=sName;
		this.score=score;
		setGrade();
	}
	
	public String getName() {
		return this.sName;
	}
	public double getScore() {
		return this.score;
	}
	public void setScore(double score) {
		this.score = score;
		setGrade();	
	}
	public String getGrade() {
		return sGrade;
	}
	public void modGrade(String grade) {
		this.sGrade=grade;
	}
	private void setGrade() {
		if(90<score&&score<=100) {
			sGrade= "A";
		}else if(80<score&&score<=90) {
			sGrade="B";
		}else if(70<score&&score<=80) {
			sGrade="C";
		}else if(60<score&&score<=70) {
			sGrade="D";
		}else
			sGrade="F";
	}	
}
