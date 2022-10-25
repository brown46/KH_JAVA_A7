package kr.co.exam02;

public class Teacher extends School {
	private String subject;

	public Teacher(int grade, int cls) {
		super(grade, cls);
	}

	public Teacher(int grade, int cls, String subject) {
		super(grade, cls);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	@Override
	public void setSubject(String subject) {
		if (subArr.length == 0) {
			subArr=new String[1];
			subArr[0] = subject;
		}
	}

}
