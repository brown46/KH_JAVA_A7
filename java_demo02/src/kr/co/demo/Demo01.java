package kr.co.demo;

public class Demo01 {

	public static void main(String[] args) {
		//변수 : 컴퓨터의 메모리에 값(데이터)를 저장하기 위한 공간
		//		변수 공간에 저장한 값을 쉽게 사용하기 위해 변수에는
		//		이름이 부여돼야 한다.-> 변수명
		
		//변수명에는 작명 규칙이 있어 다음의 규칙을 반드시 지켜서 작성해야 한다
		//1. 영문자, 숫자, 한글들의 문자, 특수문자(_, $) 만 사용할 수 있다.
		//2. 숫자로 시작할 수 없다.
		//3. 공백이 있으면 안된다.
		//4. 예약어는 사용할 수 없다.
		//5. 영문자 대/소문자 구분.
		
		//다음의 규칙은 필수는 아니지만 관습적으로 굳어진 규칙이다.
		//1. 변수명은 소문자로 작성해야 한다.
		//2. 의미있는 단어로 작성해야 한다.
		//3. 2개 이상의 단어로 조합을 하는 경우 
		//		2번째 단어의 첫 번째 문자를 대문자로 작성한다.(Camel case방식)
		
		// 자료형
		// 1. 정수
		//		- 1 바이트 크기정수	-> 	byte
		//		- 2 바이트 크기정수	-> short
		//		- 4 바이트 크기정수	-> int
		//		- 8 바이트 크기정수	-> long
		// 2. 실수
		//		- 4바이트 크기 실수	-> float
		//		- 8바이트 크기 실수	-> double
		// 3. 문자
		//		-2 바이트 크기	-> char
		// 4. 문자열
		//		- 참조형	-> String
		// 5. 불린
		//		- 1바이트 크기	-> boolean
		
		short x=10;
		char y =65;
		System.out.println(x);
		System.out.println(y);
		
		//변수 먼저 선언 후 값 할당
		int x1;
		int y1;
		int z1;
		
		x1=10;
		y1=20;
		z1=30;
		
		//선언과 함께 값 할당
		int x2=10;
		int y2=10;
		int z2=10;
		
		//메모리 낭비 방지차원으로 변수가 선언된후 사용되지 않으면 경고가 뜬다. 
		
		//변수 선언만 하고 할당을 하지 않을 경우
		//int x3;
		//System.out.println(x3);
		
		// 다양한 자료형을 사용하여 변수에 데이터 저장
		
		boolean bool1 =true;
		boolean bool2 =false;
		
		byte bt1 = 0;
		byte bt2 = 127;
		byte bt3 = -128;
		
		short st1=0;
		short st2=32767;
		short st3=-32768;
		
		int it1=0;
		int it2=2147483647;
		int it3=-2147483648;
		
		long lg1 = 0L;
		long lg2 = 9223372036854775807L;
		long lg3 = -9223372036854775808L;
		
		float ft1 =0.0f;
		float ft2 =.0f;
		double db1 =0.0;
		double db2 =0.0;
		
		char ch1 =65;
		char ch2 ='A'; //작은 따옴표로 감싸야 한다.
		
		String st = "ABCDEFG"; //큰 따옴표로 감싸야 한다.
		
		
		
		
	}	

}
