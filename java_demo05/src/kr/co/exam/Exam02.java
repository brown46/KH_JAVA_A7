package kr.co.exam;

import java.util.*;

public class Exam02 {

	public static void main(String[] args) {

		/*
		 * Exam02.java 파일을 생성후 다음의 문제를 풀어보세요. 사용자 입력으로 5~10 사이의 정수 값을 입력받아 입력받은 정수값과 동일한
		 * 크기의 배열을 생성하세요 그리고 배열의 값은 -1로 초기화 하세요
		 */
		Scanner sc = new Scanner(System.in);
		int input;
		int arr[];
		System.out.println("배열의 크기를 입력해주세요 (5~10)");
		while (true) {
			input = sc.nextInt();
			if (5 <= input && input <= 10) {
				arr = new int[input];
				for (int i = 0; i < input; i++) {
					arr[i] = -1;
				}
				break;
			} else {
				System.out.println("다시 입력해 주세요");
			}
		}
		for(int i=0;i<input;i++) {
			System.out.println(arr[i]);
		}

	}

}
