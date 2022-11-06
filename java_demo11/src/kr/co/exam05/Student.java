package kr.co.exam05;

import java.util.Objects;

import scoreMangement.Student;

public class Student {

	private String stname;
	private int years;
	private int cLass;
	private int number;
	
	
	public Student(String stname, int years, int cLass, int number) {
		super();
		this.stname = stname;
		this.years = years;
		this.cLass = cLass;
		this.number = number;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cLass, stname, number, years);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return cLass == other.cLass && Objects.equals(stname, other.stname) && number == other.number
				&& years == other.years;
	}
	@Override
	public String toString() {
		return stname + "," + years + "," + cLass + "," + number+":" ;
	}
	public String getstname() {
		return stname;
	}
	public void setstname(String stname) {
		this.stname = stname;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public int getcLass() {
		return cLass;
	}
	public void setcLass(int cLass) {
		this.cLass = cLass;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}