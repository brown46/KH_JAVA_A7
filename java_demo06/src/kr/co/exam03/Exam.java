package kr.co.exam03;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 다음의 객체를 클래스로 만들 때 멤버 변수/상수, 클래스 변수/상수
		 * 생성자, 메서드를 활용하여 만들어 보세요.
		 * 
		 * 시계 클래스를 만들어 보세요. 해당 클래스는 현재 시간을 시, 분, 초
		 * 단위로 입력하면 이에 적합한 시:분:초 형식의 문자열로 출력할 수 
		 * 있는 getTimeString()메서드를 제공합니다.
		 * 
		 */

//		Clock c= new Clock(3,9,52);
		//System.out.println(c.getTimeString());
//		System.out.println(c.getTimeString());
//		c.getTime();
		
//		Speaker s= new Speaker(0,true,true);
//		Speaker s1= new Speaker(3,true,true);
//		System.out.println(s.getState());
//		s.toggleMute();
//		System.out.println(s.getState());
//		s.upVolumn();
//		System.out.println(s.getState());
//		s.togglePower();
//		System.out.println(s.getState());
//		System.out.println(s1.getState());
//		s1.toggleMute();
//		s1.downVolumn();
//		System.out.println(s1.getState());
		
//		Elevator e= new Elevator(12);
//		Elevator e1= new Elevator(-3,12);
//		e.moveTar(10);
//		e.moveTar(5);
//		e.moveTar(13);
//		e.moveTar(7);
//		e.moveTar(0);
//		e1.moveTar(0);
//		e1.moveTar(-3);
		
		FoodMenu f= new FoodMenu();
		f.addFood("제육", 5000);
		f.addFood("돈까스", 8000);
		f.addFood("라면", 4000);
		f.addFood("얼큰순대국", 7000);
		
	//	f.getMenu();
		System.out.println();
		f.delFood("돈까스");
	
	//	f.getMenu();
		System.out.println();
		f.addFood("피자", 10000);
		f.addFood("치킨", 16000);
		f.addFood("햄버거", 8500);
		//f.getMenu();
		f.delFood("김밥");
		System.out.println();
		f.getMenu();
		
		
		
		
	}

}
