package kr.co.exam02;

import java.util.Arrays;

public class Student extends School{
	
	Student(int grade, int cls){
		super(grade, cls);
	}
	Student(int grade, int cls,String subject){
		super(grade, cls);
		subArr=Arrays.copyOf(subArr,subArr.length+1);
		subArr[subArr.length-1]=subject;
	}
	public void addSubject(String subject) {}
	
	public void delSubject(String subject) {}
	
	public void modSubject(String subject1,String subject2) {}
	
	public String getSubject() {
		return null;
	}
	

}
