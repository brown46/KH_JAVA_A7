package kr.co.demo;

public class Demo04 {

	public static void main(String[] args) {
		//출력 : Sytem.out.print() 메서드로 변수에 저장된 데이터를
		//		터미널에 출력하기 위해 사용한다.
		// 		출력 메서드는 .print()외에 .printf()/ println()
		//		이 있다.
		
		//.print()는 개행 없이 한 줄에 계속 출력을 할 때 사용
		//.printf()는 .print()기능에 특정 형식을 갖추어 출력할 때 사용
		//.println()은 .print()기능을 수행 후 개행을 추가 할 때 사용
		
		System.out.print("A");
		System.out.print("B");
		System.out.print("C");
		
		System.out.println();
		
		System.out.println("A");
		System.out.println("B");
		System.out.println("C");
		
		int a =10;
		int y =30;
		
		System.out.printf("%d * %d = %d",a,y,a*y);
		
		System.out.println();
		
		String name ="홍길동";
		int age=30;
		
		System.out.println("안녕하세요 제 이름은 "+name+"입니다. 나이는 "+age+"세 입니다.");
		System.out.printf("안녕하세요 제 이름은 %s입니다. 나이는 %d세 입니다.",name, age);
		
		System.out.println();
		
		System.out.println("println()은 문자열 내용이 전부 출력된 후에 줄바꿈이 이루어짐");
		System.out.println("중간중간 원하는 위치에 줄바꿈을");
		System.out.println("하기 위해서는 println()을");
		System.out.println("반복적으로 사용할 수 밖에 없음");
		
		System.out.println("내가 원하는 위치에 \n 줄바꿈을 넣고 싶으면 \n 개행문자인 역슬래쉬+n의");
		System.out.println("조합문자를 사용해야 한다");
		
		String newTitle ="사용하고자 하는 문자열을 넣는다.\"";
		System.out.println(newTitle);
		
		char c='\'';
		
		
	}

}
