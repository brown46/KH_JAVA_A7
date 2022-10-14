package kr.co.demo;

import java.util.Arrays;


public class Demo05 {

	public static void main(String[] args) {
		/*
		 *동적 배열
		 * Arrays.copyOf를 이용한 깊은 복사	 
		 * 만약 동일한 크기의 새로운 배열을 복사하고 싶은 경우
		 * 원본 배열.clone() 하면 됨 
		 */
		
		int arr1[] =new int[3];
		arr1[0]=1; arr1[1]=2 ;arr1[2]=3;
		
		arr1=Arrays.copyOf(arr1,arr1.length+3 ); //
		              //원본   //길이
		for(int i=3; i>0;i--) {
			arr1[arr1.length-i]=4;
		}
		
		

		int arr2[]= arr1.clone();//복제. 기존 배열에 영향이 가지 않는다.(얕은복사가 아님)
		
		System.out.println(Arrays.toString(arr2));


	}

}
