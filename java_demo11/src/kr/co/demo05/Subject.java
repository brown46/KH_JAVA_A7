package kr.co.demo05;

public class Subject implements Comparable<Subject> {

	private String name;
	private double score;
	private char grade;

	public String getname() {
		return name;
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
	public String toString() {
		return "Subject [name=" + name + ", score=" + score + ", grade=" + grade + "]";
	}

	public void setname(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Subject(String name, double score) {
		super();
		this.name = name;
		this.score = score;
		this.setGrade();
	}

	@Override
	public int compareTo(Subject o) {

		if (score > o.score) {
			return 1;

		} else if (score < o.score) {
			return -1;
		}
		return 0;

	}

}