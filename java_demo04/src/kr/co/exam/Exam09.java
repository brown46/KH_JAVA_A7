package kr.co.exam;
import java.util.*;
public class Exam09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*
	 * 사용자 입력으로 월, 시작 요일, 마지막 일자 정보를 
	 * 입력받아 다음 예시와 같이 출력하세요
	 * 
	 * 예시
	 * 		월 :10
	 * 		시작일자 :토
	 * 		마지막일자 :31
	 * 
	 * 
	 */
	Scanner sc = new Scanner(System.in);
	int month, lastday;
	String firstday;
	System.out.println("월을 입력하세요");
	month= sc.nextInt(); sc.nextLine();
	System.out.println("첫번째 요일을 입력하세요");
	firstday =sc.nextLine();
	System.out.println("마지막날을 입력하세요");
	lastday= sc.nextInt();
			
	System.out.println("월 : "+month);
	System.out.println("시작일자 : "+ firstday);
	System.out.println("마지막일짜 : "+ lastday);
	System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
	int k=0;
	
	switch(firstday) {
	case "일":
		k=0;break;
	case "월":
		k=1;break;
	case "화":
		k=2;break;
	case "수":
		k=3;break;
	case "목":
		k=4;break;
	case "금":
		k=5;break;
	case "토":
		k=6;break;
	}
	/*
	if(firstday.equals("일")) {
		 k=0;
	}else if(firstday.equals("월")) {
		 k=1;
	}else if(firstday.equals("화")) {
		 k=2;
	}else if(firstday.equals("수")) {
		 k=3;
	}else if(firstday.equals("목")) {
		 k=4;
	}else if(firstday.equals("금")) {
		 k=5;
	}else if(firstday.equals("토")) {
		 k=6;
	}
	*/
	
	for(int w=0;w<k;w++) {
		System.out.printf("\t");
	}
	for(int j=1;j<8-k;j++) {
		System.out.printf("%d\t",j);
	}
	System.out.println();
	loop1:	for(int i=0;i<5;i++) {
		for(int j=8-k;j<=7+7-k;j++) {
			
			System.out.printf("%d\t",7*i+j);
			if(7*i+j>=lastday) break loop1;
		}
		System.out.println();
	}
	int dateIndex=0;
	switch(firstday) {

	case "일":
		k=0;dateIndex=0;break;
	case "월":
		k=1;dateIndex=6;break;
	case "화":
		k=2;dateIndex=5;break;
	case "수":
		k=3;dateIndex=4;break;
	case "목":
		k=4;dateIndex=3;break;
	case "금":
		k=5;dateIndex=2;break;
	case "토":
		k=6;dateIndex=1;break;
	}
	
	for(k = k -7+1; k<=lastday; k++) {
		if(k>=1) {
			System.out.printf("%d\t",k);
			if(k% 7== dateIndex) {
				System.out.print("\n");
			}
		}else {
			System.out.print("\t");
		}
	}
	
	
	
	
	
	
	
	
	
	
	}

}
