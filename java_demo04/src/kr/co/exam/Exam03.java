package kr.co.exam;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력과 if문을 활용하여 사용자로부터 정수값
		 * 2개를 입력받아 나누기 계산을 수행하고 그결과를 
		 * 출력하세요. 만약 사용자 입력값 중에 0이 있어
		 * 산술에러가 발생하는 경우 이를 처리하기 위한 if문을
		 * 추가로 작성하세요
		 */
		Scanner sc =new Scanner(System.in);
		int num1, num2;
		double value;
		System.out.println("첫번째 정수를 입력해주세요");
		num1=sc.nextInt();
		while (true) {
		System.out.println("두번째 정수를 입력해주세요");
		num2=sc.nextInt();
		if(num2==0) {
			System.out.println("다시 입력해주세요");
			}else break;
		}
		value=(float)num1/num2;
		if(num1%num2==0) {
			System.out.println("입력한 정수값에 대한 나누기 계산결과-> "+(int)value);
		}else {
		System.out.printf("입력한 정수값에 대한 나누기 계산결과-> %.3f",value);
		}
	}

}
