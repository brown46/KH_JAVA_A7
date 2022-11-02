package kr.co.exam04;

public class Subject {

	private char grade;
	private double score;
	public char getGrade() {
		return grade;
	}
	public void setGrade() {
		switch ((int)(score/10)) {
		case 10: 
		case 9: 
			grade='A';
			break;
		case 8: 
			grade='B';
			break;
		case 7: 
			grade='C';
			break;
		case 6: 
			grade='D';
			break;
		case 5: 
			grade='E';
			break;
	
		}
		
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Subject(char grade, double score) {
		super();
		this.grade = grade;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Subject [grade=" + grade + ", score=" + score + "]";
	}
	
}
