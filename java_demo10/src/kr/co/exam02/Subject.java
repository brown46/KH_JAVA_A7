package kr.co.exam02;
import java.util.Objects;

import pracrtice.Subject;

public class Subject {

	private String name;
	private double score;
	private char grade;
	
	public static Subject parseSubject(String arr) {
		Subject subject = null ;
		String table[] = arr.split(" ");
		for(int i=0; i<table.length;i++) {
			subject.setName(table[0]);
			subject.setScore(Double.valueOf(table[1]));
			subject.setGrade(table[2].charAt(0));
		}
		return subject;
	}
	
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
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Subject [name=" + name + ", score=" + score + ", grade=" + grade + "]";
	}
	public String toString(String delimiter) {
		String string =this.name+delimiter+this.score+delimiter+this.grade;
		return string;
	}
	@Override
	public int hashCode() {
		return Objects.hash(grade, name, score);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return grade == other.grade && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(score) == Double.doubleToLongBits(other.score);
	}
	
}
