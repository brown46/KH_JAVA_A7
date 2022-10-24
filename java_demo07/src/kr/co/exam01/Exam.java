package kr.co.exam01;

public class Exam {

	public static void main(String[] args) {
		/*
		 *  도형 클래스를 상속하는 삼각형, 사각형 클래스를 작성
		 *  
		 *  삼각형, 사각형 클래스에는 다음의 멤버변수와 메서드가 필요하다.
		 *  	- 삼각형(Triangle)
		 *  		멤버 변수 : 가로길이, 세로길이
		 *  		멤버 메서드 : 넓이구하기
		 *  
		 *  	- 사각형(Square)
		 *  		멤버 변수 : 가로길이, 세로길이
		 *  		멤버 메서드 :넓이구하기
		 */
		Square s= new Square(10,20);
		Triangle t= new Triangle(20,10);
		
		System.out.println(s.getLength());
		System.out.println(s.getWidth());
		System.out.println(s.getArea());
		System.out.println(t.getLength());
		System.out.println(t.getWidth());
		System.out.println(t.getArea());
		
		
		
	}

}
