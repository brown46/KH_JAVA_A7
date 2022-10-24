package kr.co.demo01;

public class Demo {

	public static void main(String[] args) {
		/*
		 *  상속 (Inherit)
		 *  	- 다른 클래스가 가지고 있는 멤버(필드, 메서드) 들을
		 *  	  새로 작성하는 클래스에서 직접 만들지 않고 상속을 
		 *  	  받아서 자신의 필드, 메서드 처럼 사용할 수 있는 기능
		 *  
		 *  상속을 사용하면 다음의 이점을 가질 수 있다.
		 *  	- 클래스의 재사용성이 높아진다.
		 *  	- 보다 적은 양의 코드로 새로운 클래스 작성
		 *  	- 공통 기능에 대해서는 상속을 통해 관리하기 때문에 관리가 용이해진다.
		 *  	- 코드의 중복을 최소화 할 수 있으며, 프로그램의 생산성/유지보수에 크게 기여함.
		 */

		Student s1 =new Student("홍길동");
		
		s1.setAge(23);
		s1.setGender('M');
		s1.setYear(3);
		s1.setClassRoom(5);
		System.out.println(s1.getName()+"|"+s1.getAge());
		
		Customer c1= new Customer("홍길동");
		c1.setAge(23);
		c1.setGender('M');
		c1.setId(1234);
		c1.setPoint(1000);
		System.out.println(c1.getName()+"|"+c1.getAge()+"|"+ c1.getId());
		
	}

}
