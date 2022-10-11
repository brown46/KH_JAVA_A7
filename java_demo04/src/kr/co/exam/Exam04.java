package kr.co.exam;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력과 if문을 활용하여 사용자로부터 문자열을
		 * 2개 입력받아 다음의 문제를 풀어보세요.
		 * 
		 * 아이디와, 패스워드에 해당하는 문자열을 입력받고 미리
		 *  설정한 아이디와 패스워드가 사용자가 입력한 문자열과 일치하는
		 *  경우 "로그인 성공" 메세지를 출력하세요. 아이디 또는 패스워드가
		 *  일치하지 않은 경우 "해당하는 아이디가 없습니다.", "패스워드가 
		 *  잘못되었습니다." 메세지도 출력되게 하세요.
		 *  
		 */
		
		Scanner sc = new Scanner(System.in);
		String id="abcd";
		String pw="efgh";
		String inputid;
		String inputpw;
		
		System.out.println("아이디를 입력하세요");
		inputid = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요");
		inputpw=sc.nextLine();
	/*	if (id.equals(inputid)) {
			if(pw.equals(inputpw)) {
					System.out.println("로그인 성공");
				}else {
					System.out.println("패스워드가 잘못되었습니다.");
				}	
		}else {
				System.out.println("해당하는 아이디가 없습니다.");
			}
		*/
	if(id.equals(inputid)&&pw.equals(inputpw)) {
		System.out.println("로그인 성공");
	}else {
		if(!id.equals(inputid)) {
			System.out.println("해당하는 아이디가 없습니다.");
		}else {
			System.out.println("패스워드가 잘못되었습니다.");
		}
	}
		
	}

}
