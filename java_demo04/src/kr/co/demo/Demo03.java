package kr.co.demo;

public class Demo03 {

	public static void main(String[] args) {
		/*
		 * switch문	
		 * 		if문과 비슷하게 조건에 따라 특정 코드가 실행 
		 * 		되도록 하는 문장
		 * 
		 * 		if문의 경우 크기 비교 연산등을 활용하여 특정
		 * 		값의 범위에 해당하는 경우를 선택할 수 있으나
		 * 		switch문의 경우 연산 결과에 해당하는 값인
		 * 		경우에만 선택적으로 실행되게 할 수 있다.
		 * 
		 * switch(연산식){
		 * 		case 값1:
		 * 			실행 코드
		 * 			break;
		 * 		case 값2:
		 * 			실행 코드
		 * 			break;
		 *		case 값3:
		 *			실행 코드
		 *			break;
		 *		default:
		 *			실행 코드 
		 *}
		 *switch문에서 default는 생략 가능하며, case에 해당하지 
		 *않는 값이 계산된 경우 실행된다.
		 *
		 *switch문에서 각 case마다 마지막 줄에 break를 사용하지 않으면
		 *다음 case가 동작된다.(break를 사용하여 switch문에 대한 중지를 
		 *할 수 있다.)
		 */

		int value =2;
		
		switch(value) {
			case 1:
				System.out.println("case 1에 해당되어 동작");
				break;
			case 2:
				System.out.println("case 2에 해당되어 동작");
				//break;
			
			case 3:
				System.out.println("case 3에 해당되어 동작");
				break;
			default :System.out.println("어떠한 case에도 해당되지 않아서 동작");
		}
		
	}

}
