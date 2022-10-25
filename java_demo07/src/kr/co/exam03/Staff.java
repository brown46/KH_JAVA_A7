package kr.co.exam03;

public class Staff extends Intern {
	
	public Staff(String name, int age) {
		setName(name);
		setAge(age);
	}
	public Staff() {}
	public void research() {
		System.out.println(toString()+"이(가) 자료조사를 합니다.");
	}
	public void document() {
		System.out.println(toString()+"이(가) 문서작성을 합니다.");
	}
	public void careIntern() {
		System.out.println(toString()+"이(가) 인턴을 봐줍니다.");
	}
	@Override
	public Worker elevate() {
		return new AssistantManager(getName(), getAge());
	}
	
	@Override
	public String toString() {
		return getName();
	}
	@Override
	public void goWork() {
		System.out.println(toString()+"이(가) 출근합니다.");
	}
	@Override
	public void offWork() {
		System.out.println(toString()+"이(가) 퇴근합니다.");
	}@Override
	public void lunch() {
		System.out.println(toString()+"이(가) 점심을 먹습니다.");
	}@Override
	public void overtime() {
		System.out.println(toString()+"이(가) 야근을 합니다.");
	}
}
