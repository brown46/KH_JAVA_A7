package kr.co.exam;

import java.util.Arrays;

public class Exam10 {

	public static void main(String[] args) {
		
		/*
		 * 1. 10~99 사이의 랜덤값을 10개 생성하여 정수 배열에 추가한다.
		 * 
		 */
//		int arr1[]= new int[10];
//		
//		for(int i=0;i<10;i++) {
//			arr1[i]= (int)(Math.random()*99+1);
//		}
		int arr1[] = new int[0];
		for(;arr1.length<10;) {
			arr1=Arrays.copyOf(arr1, arr1.length+1);
			arr1[arr1.length-1]= (int)(Math.random()*91)+10;
		}
		
		
		/*
		 * 2. 1번에서 생성한 정수 값을 짝수와 홀수로 나누어 2차 배열에 추가한다.
		 * 
		 */
		int arr2[][]=new int[2][0];
//		int even=0;
//		int odd=0;
		
		
		
		for(int i=0;i<10;i++) {
			
			int idx =arr1[i]%2;
			arr2[idx]=Arrays.copyOf(arr2[0], arr2[0].length+1);
			arr2[idx][arr2[idx].length-1]=arr1[i];
//			if(arr1[i]%2==0) {
//				arr2[0]=Arrays.copyOf(arr2[0], arr2[0].length+1);
//				arr2[0][even] =arr1[i];
//				even++;
//				//even을 쓰는대신
//				//arr2[0][arr2[0].length-1]=arr1[i];
//			}else {
//				arr2[1]=Arrays.copyOf(arr2[1], arr2[1].length+1);
//				arr2[1][odd] =arr1[i];
//				odd++;
//			}
		}
		System.out.println(Arrays.deepToString(arr2));
		/*
		 * 3. 2번에서 생성된 2차 배열에 추가로 10~99 사이의 랜덤값을 생성하여
		 * 저장할때 짝수는 짝수배열에 홀수는 홀수배열에 저장되도록 한다.
		 * (여기에서 추가하는 정수는 2차 배열의 중첩된 배열의 크기가 10개가 될때까지
		 * 수행한다.
		 */
		
		
//	while(!(arr2[0].length==10&&arr2[1].length==10)) {
////		if(arr2[0].length==10&&arr2[1].length==10) {
////			break;
////		}
//		
//		int num= (int)(Math.random()*91+10);
//		if((num%2==0)&&(arr2[0].length<10)) {
//			arr2[0]=Arrays.copyOf(arr2[0], arr2[0].length+1);
//			arr2[0][even] =num;
//			even++;
//			//even을 쓰는대신
//			//arr2[0][arr2[0].length-1]=num;
//			
//		}else if((num%2==1)&&(arr2[1].length<10))
//			{
//			arr2[1]=Arrays.copyOf(arr2[1], arr2[1].length+1);
//			arr2[1][odd] =num;
//			odd++;
//			
//		}
//		
//	}
	while(arr2[0].length<10||arr2[1].length<10) {
		int num= (int)(Math.random()*91+10);
		int idx =num%2;
		
		if(arr2[idx].length<10) {
			arr2[idx]=Arrays.copyOf(arr2[idx], arr2[idx].length+1);
			arr2[idx][arr2[idx].length-1]=num;
		}
	}
	System.out.println(Arrays.deepToString(arr2));
		/*
		 * 4. 3번에서 완성된 2차 배열의 동일한 열(인덱스)의 값의 합을 구하여
		 * 		3번째(2번 인덱스)에 추가할 배열로 만들어 추가하낟.
		 */
	arr2=Arrays.copyOf(arr2, arr2.length+1);
	

//	int arr3[]=new int[10];
//	for(int i=0;i<10;i++) {
//		arr3[i]=arr2[0][i]+arr2[1][i];
//	}
//	
//	arr2[2]=arr3;

	
	
arr2=Arrays.copyOf(arr2, arr2.length+1);
	arr2[2]= new int[0];
	for(int i=0;i<10;i++) {
		arr2[2]=Arrays.copyOf(arr2[2], arr2[2].length+1);
		arr2[2][i]=arr2[0][i]+arr2[1][i];
	}
	
//	int arr3[][]=Arrays.copyOf(arr2, arr2.length+1);
//	arr3[2]=new int[0];
//	for(int i=0;i<10;i++) {
//		arr3[2]=Arrays.copyOf(arr3[2], arr3[2].length+1);
//		arr3[2][i]=arr3[0][i]+arr3[1][i];
//	}
	
	
	
	System.out.println(Arrays.toString(arr2[2]));
	
	System.out.println(Arrays.deepToString(arr2));
	}
	

}
