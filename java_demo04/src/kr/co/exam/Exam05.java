package kr.co.exam;

import java.util.Scanner;

public class Exam05 {

	public static void main(String[] args) {
		/*
		 다음 형식의 메뉴를 만들고 사용자에게 출력하세요.
		 1. Login
		 2. Sign In
		 3. Id/Password Find
		 
		 위 메뉴 형식에서 사용자가 메뉴 번호에 해당하는 값을 
		 입력하면 각 메뉴에 적합한 출력메세지가 나오게 하세요.
		 
		 Login 을 선택한 경우 "로그인 화면입니다."
		 Sign In 을 선택한 경우 "회원가입 화면입니다."
		 Id/Password Find를 선택한 경우 
		 "아이디/패스워드 찾기 화면입니다."
		 */
	Scanner sc =new Scanner(System.in);
	String input;
	System.out.printf("1. Login\n2. Sign In\n3. Id/Password Find\n");
	String menu=""
	+"1. Login\n"
	+"2. Sign In\n"+
	"3. Id/Password Find";
	System.out.println(menu);
		input =sc.nextLine();
		/*if (input.equalsIgnoreCase("Login")||input.equals("1")) {
			System.out.println("로그인 화면입니다.");
		}else if(input.equalsIgnoreCase("Sign In")||input.equals("2")){
			System.out.println("회원가입 화면입니다.");
		}else if(input.equalsIgnoreCase("Id/Password Find")||input.equals("3")){
			System.out.println("아이디/패스워드 찾기 화면입니다.");
		}else {
			System.out.println("잘못된 메뉴를 입력하셨습니다.");
		}
*/
	switch(input) {
		case "1":
			System.out.println("로그인 화면입니다.");
			break;
		case "2":
			System.out.println("회원가입 화면입니다.");
			break;
		case "3":
			System.out.println("아이디/패스워드 화면입니다.");
			break;
		default:
			System.out.println("잘못된 메뉴를 입력하셨습니다.");
	}
	
	}

}
