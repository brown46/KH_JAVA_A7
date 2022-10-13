package kr.co.exam;

import java.util.*;

public class Exam05 {

	public static void main(String[] args) {
		/*
		 * 크기가 10인 배열을 생성후 Random을 사용하여 배열의 값들을 초기화 한다. Random은 0~100 사이의 난수값이 생성되도록 한다.
		 */
		int arr[] = new int[10];

		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			arr[i] = random.nextInt(101);
		}

		/*
		 * 2. 1번에서 생성한 배열을 그대로 사용하여 배열 안에있는 정수값 중 짝수에 해당하는 값만 분류하여 출력하도록 한다. (짝수값의 수량도
		 * 같이 출력되게 한다.)
		 */
		int count1 = 0;
		for (int i = 0; i < 10; i++) {
			if (arr[i] % 2 == 0) {
				count1++;
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
		System.out.println("짝수는 " + count1 + "개 입니다.");
		/*
		 * 3. 2번에 의해 분류된 짝수들만을 모아두기 위한 새로운 정수 배열을 만들고 저장한다.
		 */

		int count2 = 0;
		int even[] = new int[count1];
		for (int i = 0; i < 10; i++) {
			if (arr[i] % 2 == 0) {

				even[count2] = arr[i];
				count2++;
			}
		}
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < count2; i++) {
			System.out.print(even[i] + " ");
		}

		
	}

}
