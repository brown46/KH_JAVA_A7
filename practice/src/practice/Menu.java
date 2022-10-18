package practice;


import java.util.Arrays;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		String menu;
		String arr[]=new String[4];
		
		arr[0]="제육정식";
		arr[1]="돈까스";
		arr[2]="라면";
		arr[3]="얼큰순대국";
		
		Scanner sc =new Scanner(System.in);
		
		while(true) {
			System.out.println("메뉴추가?");
			menu=sc.nextLine();
			if(menu.equals("없음"))break;
			arr=Arrays.copyOf(arr,arr.length+1);
			arr[arr.length-1]=menu;
		}
		
		int ran =(int)(Math.random()*arr.length);
		
		System.out.println("오늘의 메뉴: "+arr[ran]);
		
	} 

}

