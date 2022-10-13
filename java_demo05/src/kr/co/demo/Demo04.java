package kr.co.demo;

import java.util.Scanner;

public class Demo04 {

	public static void main(String[] args) {
		/*
		 * 동적 배열
		 */
		
		Scanner sc =new Scanner(System.in);
		
		int arr1[] =new int[3];
		arr1[0]=1; arr1[1]=2 ;arr1[2]=3;
		
		int tmp[];
		for(int i=0;i<5;i++) {
			System.out.print("정수값을 입력하세요: ");
			int num =sc.nextInt();
			
			tmp =new int[arr1.length+1];
			System.arraycopy(arr1,0,tmp,0,arr1.length);
			
			tmp[tmp.length-1]=num;
			arr1= tmp;
			
			System.out.printf("arr1 배열의 크기가 %d가 되었습니다.\n",arr1.length);
			
		}
		for(int i=0; i<arr1.length;i++) {
			System.out.printf("%d\t",arr1[i]);
		}
		

	}

}
