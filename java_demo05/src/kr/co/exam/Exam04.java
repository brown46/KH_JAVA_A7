package kr.co.exam;

import java.util.*;

public class Exam04 {

	public static void main(String[] args) {

		//Exam03.java 와 동일한 과정으로 배열을 생성할 때 
		//중복된 값이 없도록 초기화 하게 하세요
		
		Scanner sc = new Scanner(System.in);
		int size, input2;
		int arr[];
		System.out.println("배열의 크기를 입력해주세요(2~5)");
		while (true) {
			size = sc.nextInt();
			if (2 <= size && size <= 5) {
				arr = new int[size];

				break;
			} else {
				System.out.println("다시 입력해 주세요");
			}
		}
		
		
		
		
		
	}

}
