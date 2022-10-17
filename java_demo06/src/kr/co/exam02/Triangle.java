package kr.co.exam02;

public class Triangle {
	Triangle(double base){
		this.base=base;
		this.height=Math.sqrt(3)/2*base;
		this.round=3*base;
		this.area=Math.sqrt(3)/4*base*base;
	}
	Triangle(double base, double height){
		this.base=base;
		this.height=height;
		this.round= (Math.sqrt((base*base)+(height*height))+base+height);
		this.area=base*height/2;
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
