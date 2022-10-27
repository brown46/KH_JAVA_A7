package kr.co.exam02;

import java.util.Arrays;
import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 사용하여 010-xxxx-xxxx 와 같은 형식의 전화번호를 입력받으세요
		 * 1. 전화번호는 반드시 010으로 시갖해야 합니다.
		 * 2. - 으로 구분된 전화번호 형식이 입력되어야 합니다.
		 * 3. 사용자가 입력하는 전화번호는 나중에 출력할 때 숨김 처리 되어 출력되야 합니다.
		 *  	입력: 010-1234-5678
		 *  	출력: 010-1234-****
		 * 
		 * 사용자가 입력한 주민등록번호를 통해 남자인지 여자인지 구분하세요.
		 * 		1. 주민등록번호는 7번째숫자가 1,3이면 남자입니다
		 * 		2. 주민등록번호는 7번째 숫자가 2,4이면 여자입니다.
		 */

		Scanner sc = new Scanner(System.in);
		
	
		String arr[]= new String[0];
loop2:	while(true) {
			System.out.println("전화번호를 입력해 주세요");
			String input =sc.nextLine();
			arr= input.split("-");
//			if(arr[0].equals("010")==false) {
//				System.out.println("010으로 시작해야 합니다.");
//				continue;
//			}
			if(input.startsWith("010")==false) {
				System.out.println("010으로 시작해야 합니다.");
				continue;
			}
			if(arr.length!=3) {
				System.out.println("하이픈으로 구분해주세요");
				continue;
			}
			
			if(input.length()!=13) {
				System.out.println("하이픈을 포함한13자리 번호를 입력해야 합니다.");
				continue;
			}
			for(int i=1; i<arr.length;i++) {
				for(int j=0;j<arr[i].length();j++) {
					if(arr[i].length()!=4) {
						System.out.println("하이픈을 잘못 입력하셨습니다.");
						continue loop2;
					}
				}
			}
//			for(int i=0; i<arr[1].length();i++) {
//				if(arr[1].charAt(i)>'9'||arr[1].charAt(i)<'0') {
//					System.out.println("숫자를 입력주세요");
//					continue loop2;
//				}
//			}
//			for(int i=0; i<arr[2].length();i++) {
//				if(arr[2].charAt(i)>'9'||arr[2].charAt(i)<'0') {
//					System.out.println("숫자를 입력주세요");
//					continue loop2;
//				}
//			}
			for(int i=1; i<arr.length;i++) {
				for(int j=0;j<arr[i].length();j++) {
					if(arr[i].charAt(j)>'9'||arr[i].charAt(j)<'0') {
						System.out.println("숫자를 입력해주세요");
						continue loop2;
					}
				}
			}
			String arr1=String.join("-", arr[0],arr[1],"****");
			System.out.println(arr1);
			break;
			
		}
	loop1:	while(true) {
			System.out.println("주민등록번호를 입력해주세요");
			String input2= sc.nextLine();
			if(input2.length()!=13) {
				System.out.println("하이픈을 포함한 13자리를 입력해주세요");
				continue;
			}
			
			for(int i=0; i<13;i++) {
				if(input2.charAt(i)>'9'||input2.charAt(i)<'0') {
					System.out.println("숫자를 입력주세요");
					continue loop1;
				}
			}
			
			if(input2.charAt(6)=='1'||input2.charAt(6)=='3') {
				System.out.println("남자입니다.");
				break;
			}else if(input2.charAt(6)=='2'||input2.charAt(6)=='4') {
				System.out.println("여자입니다.");
				break;
			}else System.out.println("잘못 입력하셨습니다");
		}
		
	}

}
