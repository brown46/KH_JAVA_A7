package kr.co.exam01;

import java.util.Date;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 
		 */
		BirthDay birthDay1 = new BirthDay("19981015");
		BirthDay birthDay2 = new BirthDay("901015");
		BirthDay birthDay3 = new BirthDay(new Date());
		BirthDay birthDay4 = new BirthDay(new Date().getTime());
		BirthDay birthDay5 = new BirthDay(1990,13,15);
		
		
		System.out.println(birthDay1.toString());
		System.out.println(birthDay2.toString());
		System.out.println(birthDay3.toString());
		System.out.println(birthDay4.toString());
		System.out.println(birthDay5.toString());
		System.out.println();
		
		System.out.println(birthDay1.nextBirthDay());
		System.out.println(birthDay2.nextBirthDay());
		System.out.println(birthDay3.nextBirthDay());
		System.out.println(birthDay4.nextBirthDay());
		System.out.println(birthDay5.nextBirthDay());
//		System.out.println(birthDay1.getAge());
//		System.out.println(birthDay1.getAge(false));
	}

}
