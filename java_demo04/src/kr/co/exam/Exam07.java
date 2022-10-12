package kr.co.exam;

public class Exam07 {

	public static void main(String[] args) {
		/*
		 * 다음과 같은 모양의 출력을 만들어 보세요
		 * 
		 * 1	2 	 3	  4  	5
		 * 6	7	 8	  9     10
		 * 11	12	 13   14    15
		 * 16   17   18   19    20
		 * 21   22   23   24    25
		 * 
		 * 숫자 사이의 공백은 Space가 아닌 Tab(\t)로 만드세요
		 */

	
			for(int j=1; j<26;j++) {
				System.out.printf("%d\t",j);
				if(j==5||j==10||j==15||j==20) 
					System.out.println();
			}	
		System.out.println();
		
		
		for(int i=0;i<5;i++) {
			for(int j=1;j<6;j++) {
				System.out.printf("%d\t",5*i+j);
			}
			System.out.println();
		}
		
		System.out.println();
		
		/*
		 * 1~31 까지의 숫자를 달력 형태 처럼 출력하세요
		 */
		
			for(int j=1; j<32;j++) {
				System.out.printf("%d\t",j);
				if(j==7||j==14||j==21||j==28) 
					System.out.println();
			}
			System.out.println();
			loop1:	for(int i=0;i<5;i++) {
				for(int j=1;j<8;j++) {
					System.out.printf("%d\t",7*i+j);
					if(7*i+j>=31) break loop1;
				}
				System.out.println();
			}
			
			
			System.out.printf("\t");
			
			
			
	}

}
