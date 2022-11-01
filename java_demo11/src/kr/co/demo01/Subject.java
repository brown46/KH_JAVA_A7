package kr.co.demo01;

public class Subject implements Comparable<Subject> {

	private String name;
	private double score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Subject [name=" + name + ", score=" + score + "]";
	}
	public Subject(String name) {
		super();
		this.name = name;
	}
	public Subject(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}
	@Override
	public int compareTo(Subject o) {
		if (this.score>o.score) return 1; //양수를 반환하면 오름차순, 음수를 반환하면 내름차순
		else if(this.score<o.score) return -1;
		return 0;
	}
	
}
