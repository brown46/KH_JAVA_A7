package kr.co.exam;

import java.util.Arrays;
import java.util.Random;

public class Exam06 {

	public static void main(String[] args) {
		/*
		 * 크기가 0인 배열을 생성후 Random을 사용하여 배열의 값들을 초기화 한다. Random은 0~100 사이의 난수값이 생성되도록 한다.
		 * 배열에는 홀수에 해당하는 값만 5개 저장되도록 한다.
		 */
		int odd[] = new int[0];
		int count = 0;
		Random random = new Random();
		while (true) {
			int temp[] = new int[odd.length + 1];
			for (int j = 0; j < odd.length; j++) {
				temp[j] = odd[j];
			}
			int odd1 = random.nextInt(101);
//			int odd1 = (int)(Math.random()*101);
			if (odd1 % 2 == 1) {
				temp[count] = odd1;
				odd = temp;
				count++;
				
			}
			if (count == 5)
				break;
		}
		System.out.println(Arrays.toString(odd));
		
		
		/*
		 * for(int i=0; i<5;){
		 * 				int odd1 = random.nextInt(101);

			if (odd1 % 2 == 1) {
				int temp[] = new int[odd.length+1];
				for(int j=0 ; j<odd.length;j++){
				tmp[j]=odd[j];
				}
				tmp[tmp.length-1]= odd1;
				odd = temp;
				i++;
			}
		 * }
		 * 
		 */
	}

}
