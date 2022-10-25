package kr.co.exam03;

public class Manager extends AssistantManager {
	public Manager(String name, int age) {
		setName(name);
		setAge(age);
	}
	public Manager() {}
	public void meeting() {
		System.out.println(toString()+"이(가) 업체와 미팅을 갖습니다.");
	}
	public void businessTrip() {
		System.out.println(toString()+"이(가) 외부출장을 나갑니다.");
	}
	public void calling() {
		System.out.println(toString()+"이(가) 업체와 통화를 합니다.");
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
