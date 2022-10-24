package kr.co.exam01;

public class Triangle extends Figure {
	public Triangle(int width, int length) {
		super(width, length);
	}
	@Override
	public double getArea() {
		double area =super.getArea()/2;
		return area;
	}

}
