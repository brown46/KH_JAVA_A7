package kr.co.demo03;

public class Circle {

	//멤버 변수/상수 : final 키워드가 사용되면 상수
	private final double PI1=3.14;
	
	//클래스 변수/상수 : static키워드가 사용되면 클래스 공유자원
	public static final double PI=3.14;
	private double radius;
	
	public Circle(double radius) {
		this.radius=radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return this.radius*this.radius*this.PI;
	}
	
}
