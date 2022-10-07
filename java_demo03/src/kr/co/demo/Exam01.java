package kr.co.demo;
import java.util.*;
public class Exam01 {

	public static void main(String[] args) {
	/*
	 * 사용자 입력을 활용하여 다음의 데이터를 입력 받고 출력하시오.
	 *
	 * 키, 몸무게 정보를 입력 받아 각각 tall, weight변수에 저장을 하고
	 * BMI 계산하기
	 *몸무게/키^2 
	 *
	 *당신의 체질량 지수는 23.35 입니다.
	 * */
		double tall, weight, bmi;
		Scanner sc =new Scanner(System.in);
		
		System.out.print("키 입력(단위 m): ");
		
		tall = sc.nextDouble();
		
		System.out.print("몸무게 입력(단위 kg): ");
		
		weight = sc.nextDouble();
		
		bmi = weight/(tall*tall);
		
		System.out.printf("당신의 체질량 지수는 %.2f 입니다.",bmi);
	}

}
