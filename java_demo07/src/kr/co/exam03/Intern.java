package kr.co.exam03;

public class Intern extends Worker {

	public Intern(String name, int age) {
		setName(name);
		setAge(age);
	}
	public Intern() {}
	public void organizing() {
		System.out.println(toString()+"이(가) 서류 정리를 합니다.");
	}
	public void copy() {
		System.out.println(toString()+"이(가) 자료 복사를 합니다.");
	}
	public Worker elevate() {
		return new Staff(getName(), getAge());
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
