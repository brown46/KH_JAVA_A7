package kr.co.exam;

import java.util.Scanner;

public class Exam09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1.다음의 문자열 배열을 생성한다.
		 *    String subjects[] ={"국어", "영어", "수학"}
		 * 2. 사용자로부터 1~5 사이의 정수를 입력받는다.
		 * 3. 1번에서 생성한 배열의 길이와 2번에서 입력한 정수의 값을 사용하여 2차 배열을 생성한다.
		 * 4. 2차 배열에 저장할 값을 사용자 입력을 통해 받는다.
		 * 		국어 점수 입력 :60
		 * 		영어 점수 입력 :70
		 * 		수학 점수 입력 :80
		 * 5. 2차 배열에 저장된 값을 출력하여 확인한다.
		 * 		국어 		영어 		수학		평균		총점
		 * 		60		70		80		70.00	210
		 * 		60		75		82		72.33	217
		 */
		
		Scanner sc = new Scanner(System.in);
		String subjects[]= {"국어", "영어", "수학"};
		System.out.println("학생 수를 입력하세요");
		int student =sc.nextInt();
		float table[][]= new float[student][5];
		
		for(int j=0;j<student;j++) {
			for(int i=0;i<3;i++) {
	
				System.out.println((j+1)+"번째 학생의 "+subjects[i]+ "점수를 입력하세요");
				table[j][i]=sc.nextInt();
			
			}
			table[j][3]= ((table[j][0]+table[j][1]+table[j][2])/(float)3);
			table[j][4]=table[j][0]+table[j][1]+table[j][2];
		}

		System.out.printf("국어\t영어\t수학\t평균\t총점\n");
		
		for(int i=0;i<student;i++) {
			System.out.printf("%.0f\t%.0f\t%.0f\t%.2f\t%.0f\n",table[i][0],table[i][1],table[i][2],table[i][3],table[i][4]);
		}
		
		
		//System.out.println(Arrays.deepToString(table));
	}

}
