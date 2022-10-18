package practice;

class Subject {

	private String subName;
	private int score = 0;
	private String grade;

	Subject(String subName, int score) {
		this.subName = subName;
		this.score = score;
		if (90 < score && score <= 100) {
			this.grade = "A";
		} else if (80 < score && score <= 90) {
			this.grade = "B";
		} else if (70 < score && score <= 80) {
			this.grade = "C";
		} else if (60 < score && score <= 70) {
			this.grade = "D";
		} else {
			this.grade = "F";
		}

	}

	public void setScore(int score) {
		if (0 <= score && score <= 100)
			this.score = score;
		else {
			System.out.println("다시입력");
		}
	}

	public int getScore() {

		if (90 < score && score <= 100) {
			this.grade = "A";
		} else if (80 < score && score <= 90) {
			this.grade = "B";
		} else if (70 < score && score <= 80) {
			this.grade = "C";
		} else if (60 < score && score <= 70) {
			this.grade = "D";
		} else {
			this.grade = "F";
		}
		return score;
	}

	public String getSubject() {
		return subName;
	}

	public String getGrade() {
		return grade;
	}

}

public class Classes {

	public static void main(String[] args) {
//		Subject s = new Subject("국어",98);
//		System.out.println(s.getScore());
//		System.out.println(s.getGrade());
//		System.out.println(s.getSubject());
//		s.setScore(88);
//		System.out.println(s.getScore());
//		System.out.println(s.getGrade());
		
		Lotto l= new Lotto();
		l.creatNum();
		l.getNum();
		l.getRound();
		l.creatNum();
		l.getNum();
		l.getRound();
		l.creatNum();
		l.getNum();
		l.getRound();
		
	}

}




