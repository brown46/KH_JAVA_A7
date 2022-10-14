package kr.co.exam;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class Exam08 {

	public static void main(String[] args) {
		
		/*
		 * Random클래스를 활용하여 다음의 문제를 풀어보세요.
		 * 		1. Scanner 클래스로 사용자로부터 1~5 사이의 정수를 입력받는다.
		 * 		2. 1~45 까지의 난수 6개를 생성한다.
		 * 		3. 2차 배열을 생성할 때 행의 크기는 사용자 입력값, 열의 크기는 6으로 생성
		 * 		4. 2번에서 생성한 난수를 3번에서 생성한 2차 배열에 전부 저장.
		 * 		5. 2자 배열에 저장된 값 출력하서 확인.
		 */
		Scanner sc = new Scanner(System.in);
		
		int input;
		Random random =new Random();
		while(true) {
			System.out.println("행의 크기를 입력해주세요 (1~5)");
			input= sc.nextInt();
			if(1<=input&&input<=5) {
				break;
			}else {
				System.out.println("다시 입력해주세요");
			}
		}
		int arr[][]= new int[input][];
		
		for(int j=0;j<input;j++) {
			int tmp[]=new int[6];
			for(int i =0; i<6;i++) {
				tmp[i]=random.nextInt(45)+1;
		}
		arr[j]=tmp;
	}

//		int arr[][]= new int[input][6];
//		
//		for(int j=0;j<input;j++) {
//		for(int i =0; i<6;i++) {
//			arr[j][i]=random.nextInt(45)+1;
//		}
//	}

		System.out.println(Arrays.deepToString(arr));

		
		
		

		
		//System.out.println(Arrays.deepToString(arr));
		
		
		
		
		
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
		String subjects[]= {"국어", "영어", "수학"};
		System.out.println("학생 수를 입력하세요");
		int student =sc.nextInt();
		String sub="";
		float table[][]= new float[student][5];
		
		for(int j=0;j<student;j++) {
			for(int i=0;i<3;i++) {
			switch (i) {
			case 0:
				sub="국어";
				break;
			case 1:
				sub="영어";
				break;
			case 2:
				sub="수학";
				break;
			}
				System.out.println((j+1)+"번째 학생의 "+sub+ "점수를 입력하세요");
				table[j][i]=sc.nextInt();
			
			}
			
		}
		for(int j=0;j<student;j++) {
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
