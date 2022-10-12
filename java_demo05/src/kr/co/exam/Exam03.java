package kr.co.exam;

import java.util.*;

public class Exam03 {

	public static void main(String[] args) {

		/*
		 * Exam03.java 파일을 생성후 다음의 문제를 풀어보세요. 사용자 입력으로 2~5 사이의 정수 값을 입력받아 입력받은 정수값과 동일한
		 * 크기의 배열을 생성하고, 배열의 값을 초기화 하기 위해 다시 사용자 입력을 사용하여 1~10 사이의 값만을 입력 받아 초기화 하세요.
		 */

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
		System.out.println("초기화 할 정수를 입력해 주세요 (1~10)");
		while (true) {
			input2 = sc.nextInt();
			if (1 <= input2 && input2 <= 10) {
				int i = 0;
				while (i < size) {
					arr[i] = input2;
					i++;
				}
				for(int j=0;j<size;j++) {
					System.out.println(arr[j]);
				}
				break;
			}else {
				System.out.println("다시 입력해 주세요");
			}
		}
	}

}
