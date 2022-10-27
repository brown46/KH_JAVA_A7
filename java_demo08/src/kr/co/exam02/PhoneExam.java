package kr.co.exam02;

import java.util.Scanner;

public class PhoneExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner(System.in);
		while(true) {
			System.out.println("전화번호 입력");
			String input = sc.nextLine();
			
			Phone phone =Phone.valueOf(input);
			
			if(phone.isValid==false) {
				continue;
			}
			System.out.println(phone.getNumber()) ;
			System.out.println(phone.getNumber(false));
			
			break;
		}
	}

}
