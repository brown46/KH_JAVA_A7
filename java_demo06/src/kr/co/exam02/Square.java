package kr.co.exam02;

public class Square {
	Square(double base){
		this.base=base;
		this.height=base;
		this.area=base*base;
		this.round=base*4;
	}
	Square(double base, double height){
		this.base=base;
		this.height=height;
		this.area=base*height;
		this.round=(base+height)*2;
	}
	private double base;
	private double height;
	private double area;
	private double round;
	public double getBase() {
		return base;
	}
	public double getHeight() {
		return height;
	}
	public double getArea() {
		return area;
	}
	public double getRound() {
		return round;
	}
}
