package kr.co.exam;
import java.util.*;
public class Exam01 {

	public static void main(String[] args) {
		
		/*
		 * 사용자 입력과 if문을 활용하여 사용자로부터 정수값을 
		 * 입력 받았을때 1~45사이의 값만 출력하게 하세요.
		 * 
		 */
		Scanner sc =new Scanner(System.in);
		System.out.println("정수를 입력해주세요");
		int number=sc.nextInt();
		
		if(1<=number&&number<=45)
		System.out.printf("사용자가 입력 한 값-> %d",number);
		
	}

}
