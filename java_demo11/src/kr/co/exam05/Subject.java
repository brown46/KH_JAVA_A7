package kr.co.exam05;

public class Subject implements Comparable<Subject> {

	private String sbname;
	private double score;
	private char grade;
	
	public Subject(String sbname, double score) {
		super();
		this.sbname = sbname;
		this.score = score;
		setGrade();
	}
	@Override
	public String toString() {
		return sbname + "=" + score;
	}
	public String getSbname() {
		return sbname;
	}
	public void setSbname(String sbname) {
		this.sbname = sbname;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
		setGrade();
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade() {
		switch ((int) (score / 10)) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		case 5:
			grade = 'E';
			break;
		}
	}
	@Override
	public int compareTo(Subject o) {
			
		return sbname.compareTo(o.getSbname());
	}
	
	
	
}
