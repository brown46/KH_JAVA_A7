package kr.co.demo01;

public class Customer extends Person {
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	private int point;
	
	public Customer(String name) {
		super(name);
	}
	
	
}
