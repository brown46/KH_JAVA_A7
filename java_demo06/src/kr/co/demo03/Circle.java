package kr.co.demo03;

public class Circle {

	//private final double PI= 3.14;
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
