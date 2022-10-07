package kr.co.demo;
import java.util.*;
public class Exam02 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 활용하여 다음의 데이터를 입력 받고 출려하시오.
		 * 
		 * 시, 분, 초 정보를 입력받아 각각 hour, minute, second
		 * 변수에 저장을 하고 초단위로 환산 후 출력하세요
		 * 
		 * 예시
		 *  
		 *  시:0
		 *  분:10
		 *  초:20
		 *  
		 *  총 620초 입니다.
		 * 
		 * */
		int hour, minute, second;
		Scanner sc = new Scanner(System.in);
		System.out.print("시간을 입력하세요: ");
		hour =sc.nextInt();
		System.out.print("분을 입력하세요: ");
		minute =sc.nextInt();
		System.out.print("초를 입력하세요: ");
		second =sc.nextInt();
		
		System.out.println("시: "+hour);
		System.out.println("분: "+minute);
		System.out.println("초: "+second);
		
		System.out.println("총 "+(hour*3600+minute*60+second)+"초 입니다.");

	}

}
