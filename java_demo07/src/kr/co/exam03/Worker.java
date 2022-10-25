package kr.co.exam03;

public class Worker {

	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name2) {
		this.name = name2;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void goWork() {
		System.out.println("출근합니다");
	}
	public void offWork() {
		System.out.println("퇴근합니다");
	}
	
	public void lunch() {
		System.out.println("점심을 먹습니다");
	}
	public void overtime() {
		System.out.println("야근을 합니다");
	}
	
}
