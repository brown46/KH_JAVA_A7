package kr.co.exam;

import java.util.Scanner;

public class Exam06 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력과 if, for문을 활용하여 사용자로부터 정수값을 
		 * 입력 받았을때 1~45사이의 값이 아니면 다시 입력을 받아서 
		 * 1~45사이의 값이 저장될 수 있게한다.(단 3번의 입력 기회만 
		 * 부여하고 3번의 기회를 넘기면 0이 저장되게 한다.)
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("1~45사이의 정수 입력");
		int num=0;
		for(int i=0;i<3;i++) {
			int input =sc.nextInt();
			if (1<=input&&input<=45) {
				System.out.printf("입력하신 값은 %d입니다\n",input);
				num=input;
				break;
			}else if(i==2){
				System.out.println("3회 입력하지 않아서 0으로 저장됩니다.");
				num=input;
			}else {
				System.out.printf("다시 입력해 주세요. 입력 기회 %d번 남음",2-i);
			}	
		}
		
		System.out.println(num);
	}

}
