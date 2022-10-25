package kr.co.exam03;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 직원을 관리하기 위한 프로그램을 만들기 위해 다음의 객체 정보가 필요하다.
		 * 		-인턴	 : 출근하여 하는 일은 서류정리 및 자료복사 이다.
		 * 		-사원 : 출근하여 하는 일은 자료조사, 문서작성, 인턴 봐주기 이다.
		 * 		-대리 : 출근하여 하는 일은 자료조사, 문서작성, 업체와의 통화, 사원이 작성한 문서검토 이다. 
		 * 		-과장 : 출근하여 하는 일은 업체미팅, 외부출장 이다.
		 * 
		 * 모든 객체는 이름, 나이 정보를 가지고 있으며 각 객체마다 기본적으로 출근 및 퇴근, 점심, 야근을
		 * 수행한다.
		 * 
		 * 위 관계를 파악하여 클래스의 상속, 오버로딩, 오버라이딩, 다형성을 활용해본다.
		 * 
		 */


		Worker w[]= {new Intern("인턴",24),new Staff("사원",27),
				new AssistantManager("대리",30),new Manager("과장",35)};
//		System.out.println(w[0].getAge());
//		System.out.println(w[1].getAge());
//		System.out.println(w[2].getAge());
//		System.out.println(w[3].getAge());
		
		Intern i= (Intern)w[0];
		Staff s =(Staff)w[1];
		AssistantManager a= (AssistantManager)w[2];
		Manager m = (Manager)w[3];
		i.goWork();
		s.lunch();
		a.overtime();
		m.offWork();
		

		
		for(int j=0; j<w.length;j++) {
			if(w[j] instanceof Manager) {
				((Manager)w[j]).meeting();
				((Manager)w[j]).businessTrip();
				((Manager)w[j]).calling();
			}else if (w[j] instanceof AssistantManager) {
				((AssistantManager)w[j]).research();
				((AssistantManager)w[j]).document();
				((AssistantManager)w[j]).calling();
				((AssistantManager)w[j]).reexamin();
			}else if (w[j] instanceof Staff) {
				((Staff)w[j]).research();
				((Staff)w[j]).document();
				((Staff)w[j]).careIntern();
			}else if(w[j] instanceof Intern) {
				((Intern)w[j]).organizing();
				((Intern)w[j]).copy();
			}
		}
		
		
		System.out.println(i);
		i.elevate();
		System.out.println(i);
		
	}

}
