package kr.co.demo;

public class Demo05 {

	public static void main(String[] args) {
		
		/*
		 *while 반복문
		 *
		 * while(조건식){
		 * 		실행 코드;
		 * }
		 * 
		 * 조건식의 값이 참일 때 반복을 수행하며, 거짓이 되면 
		 * 반복을 중단한다.
		 * 
		 * break, continue 사용으로 반복문을 제어할 수 있다.
		 * 
		 */
//		int i =1;
//		while(i<=5) {
//			System.out.printf("%d\n",i);
//			i++;
//		}
//		//무한반복
//		while(true) {
//			System.out.printf("%d\n",i);
//			if(i>=10) {
//				break;
//			}
//			i++;
//		}
//		//일정 횟수 반복을 위한 반복문(0부터 시작)
//		int i2=0;
//		while(i2<10) {
//			System.out.println(i2);
//			i2++;
//		}
//		
//		//1 ~ n 까지의 범위에서 m의 배수에 해당하는 값만 출력할때
//		int i3=0;
//		int n=100;
//		int m =7;
//		while(i3<=n) {
//			if (i3%m==0) {
//				System.out.println(i3);
//			}
//			i3++;
//		}
	
		//중첩 반복문 구구단
		int i4=1;
		
		while(i4<=9) {
			int j=2;
			while(j<=9) {
				System.out.printf("%d X %d= %d\t",j,i4,j*i4);
				j++;
			}
			i4++;
			System.out.println();
		}
		/*
		 *  do ~ while
		 *  	일단 1회 반복은 수행한다.
		 *  
		 *  do{
		 *  	반복 실행 코드;
		 *  } while (조건식);
		 *  
		 *  참이면 다시 진행 
		 *  거짓이면 종료
		 */
		
	}

}
