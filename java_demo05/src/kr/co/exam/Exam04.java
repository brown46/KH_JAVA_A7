package kr.co.exam;

import java.util.*;

public class Exam04 {

	public static void main(String[] args) {

		// Exam03.java 와 동일한 과정으로 배열을 생성할 때
		// 중복된 값이 없도록 초기화 하게 하세요

		Scanner sc = new Scanner(System.in);
		int size, temp;
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

		loop1: while (true) {
			int i = 0;
			temp = 0;

			while (i < size) {
				System.out.println("초기화 할 " + (i + 1) + "번째 정수를 입력해 주세요 (1~10)");
				temp = sc.nextInt();
				if (1 <= temp && temp <= 10) {
					arr[i] = temp;
				} else {
					System.out.println("다시 입력해 주세요");
				}

				for (int j = 0; j <= i; j++) {
					if (i == j)
						break;
					else if (arr[j] == temp) {
					
						System.out.println("중복이 발생되었습니다. 배열의 처음부터 다시 입력해 주세요");
						continue loop1;
					}
				}
				i++;
			}
			for (int j = 0; j < size; j++) {
				System.out.print(arr[j]+"  ");
			}
			System.out.println();
			break;

		}

	}

}
