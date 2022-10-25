package kr.co.exam03;

public class AssistantManager extends Staff {
	public AssistantManager(String name, int age) {
		setName(name);
		setAge(age);
	}
	public AssistantManager() {}
	public void research() {
		System.out.println(toString()+"이(가) 자료조사를 합니다.");
	}
	public void document() {
		System.out.println(toString()+"이(가) 문서작성을 합니다.");
	}
	public void calling() {
		System.out.println(toString()+"이(가) 업체와 통화를 합니다.");
	}
	public void reexamin() {
		System.out.println(toString()+"이(가) 사원이 작성한 문서를 검토합니다.");
	}
	@Override
	public Worker elevate() {
		return new Manager(getName(), getAge());
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
