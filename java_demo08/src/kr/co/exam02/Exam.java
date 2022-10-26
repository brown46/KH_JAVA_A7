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
		
	
		String arr[]= new String[10];
		while(true) {
			String input =sc.nextLine();
			arr= input.split("-");
		
			if(arr[0].equals("010")) {
				continue;
			}
			System.out.println(arr[0]);
			String.join("-", arr[0],arr[1],"****");
			System.out.println(Arrays.toString(arr));
			break;
			
		}
	}

}
