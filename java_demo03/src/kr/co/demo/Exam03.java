package kr.co.demo;
import java.util.*;
public class Exam03 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 활용하여 다음의 데이터를 입력 받고 출력하시오
		 * 
		 * 카카오의 더치페이와 같이 총 금액과 인원수를 입력 받고
		 * 인원수 당 얼마의 금액을 입금하면 되는지 계산하여 출력 하세요
		 * 
		 * 출력형식
		 * 	총 금액 50000원을 5명이 나누어 인당 10000 원을 다음의
		 * 계좌에 임급해 주세요. 나머지 금액 0원은 제가 부담할께요.
		 * 입금계좌 : 0000-00-000-0000000
		 * */
		int cost, count;
		String bnumber;
		Scanner sc = new Scanner(System.in);
		System.out.print("총 금액을 입력하세요: ");
		cost = sc.nextInt();
		System.out.print("총 인원을 입력하세요: ");
		count = sc.nextInt(); sc.nextLine();
		System.out.print("계좌번호를 입력하세요(-,공백제외): ");
		bnumber = sc.nextLine();
		
		System.out.println("총 금액 "+cost+"원을 "+count+"명이 나누어 인당"+(cost/count)+"원을 다음의 계좌에 입금해 주세요."
				+ "나머지 금액 "+(cost%count)+"원은 제가 부담할게요");
		System.out.println("입금계좌 :"+ bnumber.substring(0,4)+"-"+bnumber.substring(4,6)+"-"
				+bnumber.substring(6,9)+"-"+bnumber.substring(9));
		
	}

}
