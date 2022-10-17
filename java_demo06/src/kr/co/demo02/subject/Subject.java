package kr.co.demo02.subject;

public class Subject {
	private String name;
	private double score;
	
	public Subject(String name, double score) {
		this.name=name;
		this.score=score;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setScore(double score) {
		this.score=score;
	}
	public double getScore() {
		return this.score;
	}
	
	public String getGrade() {
		if(this.score>=90&&this.score<=100) {
			return "A";
		}else if(this.score>=80&&this.score<90) {
			return "B";
		}else if(this.score>=70&&this.score<80) {
			return "C";
		}else if(this.score>=60&&this.score<70) {
			return "D";
		}else {
			return "F";
		}
	}
}
