package kr.co.demo;
import java.util.Arrays;
import java.util.Random;
public class Demo02 {

	public static void main(String[] args) {
		/*
		 * Random 클래스
		 * 		난수 값을 생성하기 위한 클래스
		 */
		Random random = new Random();
		int num1 = random.nextInt(5); //0~4 까지 5개 중 하나
		int num2 = random.nextInt(5)+1; //1~5 까지 5개 중 하나
		System.out.println(num1);
		System.out.println(num2);
		
		//로또 번호 만들기
		int lotto[] =new int[6];
		
		for(int i=0; i<6;i++) {
			int num= random.nextInt(45)+1;
			lotto[i] =num;
		}
		System.out.println(Arrays.toString(lotto));
	}

}
