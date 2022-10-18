package practice;



import java.util.Arrays;
import java.util.Scanner;

public class bill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 예시로 제시하는 영수증 처럼 물건을 구입 후 전달 받는 영수증을 Eclipse 의 콘솔(Console)에서 출력할 수 있도록 만들어
		 * 보세요.
		 * 
		 * 다음은 이 문제를 풀기 위한 요구조건 입니다.
		 * 
		 * 사용자 입력으로 구입한 물품명, 단가, 수량 정보를 입력 받으세요. 사용자가 물품명을 입력 할 때 추가로 입력할 내용이 없어서 없음 이라고
		 * 입력하면 입력을 중단하세요. 지금까지 입력한 모든 정보를 배열에 저장하여 영수증 출력에 적절히 사용될 수 있도록 하세요. 1차 배열, 2차
		 * 배열 등 다양하게 활용하세요. 최종 출력에는 다음의 정보들이 포함되어야 합니다. 물품명 단가 수량 금액 : 단가에 수량을 곱한 가격
		 * 거래금액 합계 : 모든 금액을 합한 가격 부가세액 : 거래금액 합계에 대한 부가세 10% 가격 거래금액 합계는 부가세가 포함된 금액입니다.
		 * 출력 형태는 자유입니다.
		 */
		String name;
		int cost;
		int quantity;

		String arr[][]=new String[0][] ;
		int i = 0;
		while (true) {

			Scanner sc = new Scanner(System.in);
			System.out.println("상품명을 입력하세요");
			name = sc.nextLine();
			if (name.equals("없음"))
				break;
			System.out.println("단가를 입력하세요");
			cost = sc.nextInt();
			System.out.println("수량을 입력하세요");
			quantity = sc.nextInt();
			arr = Arrays.copyOf(arr, arr.length + 1);
			
			arr[i]= new String[4];
			arr[i][0] = name;
			arr[i][1] = String.valueOf(cost);
			arr[i][2] = String.valueOf(quantity);
			arr[i][3] = String.valueOf(cost * quantity);
			//System.out.println(Arrays.deepToString(arr));
			i++;
		}

//		System.out.println("구매하신 상품 목록");
//		for (int j = 0; j < arr.length; j++) {
//			System.out.print(arr[j][0] + " ");
//		
//		
		System.out.println("상품명\t단가\t수랑\t금액");
		for (int j = 0; j < arr.length; j++) {
System.out.print(arr[j][0]+"\t");
System.out.print(arr[j][1]+"\t");
System.out.print(arr[j][2]+"\t");
System.out.print(arr[j][3]+"\t");
System.out.println();
		}
		System.out.println();
		float sum =0;
		for(int j=0;j<arr.length;j++) {
			sum+=Integer.valueOf(arr[j][3]);
		}
		System.out.printf("부가세액: %.2f\n",sum*0.1);
		System.out.printf("거래금액 합계: %.2f\n",sum*1.1);
		
	}

}
