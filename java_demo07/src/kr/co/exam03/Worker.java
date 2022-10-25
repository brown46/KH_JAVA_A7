package kr.co.exam03;

public abstract class Worker {

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
	public abstract void goWork() ;
	public abstract void offWork(); 
	public abstract void lunch(); 
	public abstract void overtime(); 
	
}
