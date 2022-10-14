package kr.co.exam;

import java.util.Arrays;

public class Exam10 {

	public static void main(String[] args) {
		
		/*
		 * 1. 10~99 사이의 랜덤값을 10개 생성하여 정수 배열에 추가한다.
		 * 
		 */
		int arr1[]= new int[10];
		
		for(int i=0;i<10;i++) {
			arr1[i]= (int)(Math.random()*99+1);
		}
		
		
		/*
		 * 2. 1번에서 생성한 정수 값을 짝수와 홀수로 나누어 2차 배열에 추가한다.
		 * 
		 */
		int arr2[][]=new int[2][0];
		int even=0;
		int odd=0;
		
		
		
		for(int i=0;i<10;i++) {
			if(arr1[i]%2==0) {
				arr2[0]=Arrays.copyOf(arr2[0], arr2[0].length+1);
				arr2[0][even] =arr1[i];
				even++;
			}else {
				arr2[1]=Arrays.copyOf(arr2[1], arr2[1].length+1);
				arr2[1][odd] =arr1[i];
				odd++;
			}
		}
		System.out.println(Arrays.deepToString(arr2));
		/*
		 * 3. 2번에서 생성된 2차 배열에 추가로 10~99 사이의 랜덤값을 생성하여
		 * 저장할때 짝수는 짝수배열에 홀수는 홀수배열에 저장되도록 한다.
		 * (여기에서 추가하는 정수는 2차 배열의 중첩된 배열의 크기가 10개가 될때까지
		 * 수행한다.
		 */
		
		
	while(true) {
		if(arr2[0].length==10&&arr2[1].length==10) {
			break;
		}
		int num= (int)(Math.random()*99+1);
		if((num%2==0)&&(arr2[0].length<10)) {
			arr2[0]=Arrays.copyOf(arr2[0], arr2[0].length+1);
			arr2[0][even] =num;
			even++;
		}else if((num%2==1)&&(arr2[1].length<10))
			{
			arr2[1]=Arrays.copyOf(arr2[1], arr2[1].length+1);
			arr2[1][odd] =num;
			odd++;
			
		}
		
	}
	System.out.println(Arrays.deepToString(arr2));
		/*
		 * 4. 3번에서 완성된 2차 배열의 동일한 열(인덱스)의 값의 합을 구하여
		 * 		3번째(2번 인덱스)에 추가할 배열로 만들어 추가하낟.
		 */
	arr2=Arrays.copyOf(arr2, arr2.length+1);
	arr2[2][0]=0;
	for(int i=0;i<10;i++) {
		arr2[2]=Arrays.copyOf(arr2[2], arr2[2].length+1);
		arr2[2][i]=arr2[0][i]+arr2[1][i];
	}
//	int arr3[][]=new int[3][10];
//	for(int i=0;i<2;i++) {
//		for(int j=0;j<10;j++) {
//			arr3[i][j]=arr2[i][j];
//		}
//	}
//	for(int i=0;i<10;i++) {
//		arr3[2][i]=arr2[0][i]+arr2[1][i];
//	}
//	
	System.out.println(Arrays.deepToString(arr2));
	}
	

}
