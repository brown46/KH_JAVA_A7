package kr.co.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Exam07 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 받아서 다음의 기능을 수행하는 코드를 작성 1. 입력한 횟수 만큼 정수 값을 입력 받아서 배열에 저장 2. 배열에 저장된
		 * 모든 정수의 합과 평균을 구하여 출력 3. -1이 입력되면 더이상 사용자 입력을 받지 않는 것으로 한다.
		 * 
		 * 예제 1번째 정수값 입력: 7 2번째 정수값 입력: 12 3번째 정수값 입력: 24 4번째 정수값 입력: -1
		 * 
		 * 
		 * 총 합: 43 평 균: 14.3
		 */
		Scanner sc = new Scanner(System.in);

		int arr[] = new int[0];
		for (int i = 0;; i++) {
			int temp[] = new int[arr.length + 1];
			for (int j = 0; j < arr.length; j++) {
				temp[j] = arr[j];
			}
			System.out.println((i + 1) + "번째 정수값 입력");
			int input = sc.nextInt();
			if (input == -1)
				break;
			else {
				temp[i] = input;
			}
			arr = temp;

		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("총 합 : " + sum);
		if (arr.length != 0)
			System.out.println("평 균 : " + ((float)sum / arr.length));
		else
			System.out.println("평 균 : 0");

		System.out.println(Arrays.toString(arr));

	}

}
/*
 * 
 * 
 */
