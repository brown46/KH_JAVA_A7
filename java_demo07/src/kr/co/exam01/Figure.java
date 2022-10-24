package kr.co.exam01;

public class Figure {

	private double width;
	private double length;
	
	public Figure(double width, double length) {
		this.width=width;
		this.length=length;
	}
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}


	public double getArea() {
		return getWidth() * getLength();
	}
}
